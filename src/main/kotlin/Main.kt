import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.*


@Composable
fun FirstScreen (onNavigate: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF6200EE)), contentAlignment = Alignment.Center) {
        Button(
            onClick = onNavigate,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text("Перейти к оплате <3", color = Color.Black)
        }
    }
}

@Composable
fun SecondScreen(onNavigate: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFFFC0CB)), contentAlignment = Alignment.Center) {
        Button(onClick = onNavigate) {
            Text("Вернуться назад <3", color = Color.White)
        }
    }
}


@Composable
@Preview
fun App() {

    var currentScreen by remember { mutableStateOf("first_screen") }

    MaterialTheme {
        when (currentScreen) {
            "first_screen" -> FirstScreen(onNavigate = { currentScreen = "second_screen" })
            "second_screen" -> SecondScreen(onNavigate = { currentScreen = "first_screen" })
        }
    }

}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Rest in Peace") {
        App()
    }
}
