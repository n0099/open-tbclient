package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.games.network.websocket.WebSocketEventTarget;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ga4 extends WebSocketEventTarget {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public fa4 d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-782277230, "Lcom/baidu/tieba/ga4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-782277230, "Lcom/baidu/tieba/ga4$a;");
                    return;
                }
            }
            int[] iArr = new int[WebSocketEventTarget.SocketTaskState.values().length];
            a = iArr;
            try {
                iArr[WebSocketEventTarget.SocketTaskState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[WebSocketEventTarget.SocketTaskState.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ga4(fa4 fa4Var, ri2 ri2Var) {
        super(ri2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fa4Var, ri2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = fa4Var;
    }

    public final boolean B(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (g73.q()) {
                return true;
            }
            if (!str.startsWith("wss://") || yb3.c(Logger.SOCKET_TYPE, str, str2) != 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public ga4 A(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsObject)) == null) {
            o32 C = C(jsObject);
            this.c = String.format(Locale.CHINA, "WebSocketTask-%d", Long.valueOf(System.currentTimeMillis()));
            int type = C.getType("url");
            if (type != 7) {
                y(C, "connectSocket", String.format("parameter error: parameter.url should be %s instead of %s", rc4.f(7), rc4.f(type)));
                return this;
            }
            String B = C.B("url");
            String B2 = C.B("__plugin__");
            if (!this.d.a()) {
                y(C, "connectSocket", "up to max connect count");
                return this;
            } else if (!B(B, B2)) {
                y(C, "connectSocket", String.format("invalid url \"%s\"", B));
                return this;
            } else {
                WebSocketRequest x = x(B, C);
                D(jsObject);
                try {
                    WebSocketTask connect = WebSocketManager.INSTANCE.connect(x, this);
                    this.c = connect.getTaskId();
                    this.d.b(connect);
                    td4.call(C, true, new ka4(this.c, String.format("%s:ok", "connectSocket")));
                    return this;
                } catch (Exception e) {
                    y(C, "connectSocket", e.getMessage());
                    return this;
                }
            }
        }
        return (ga4) invokeL.objValue;
    }

    @NonNull
    public final o32 C(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject)) == null) {
            o32 F = o32.F(jsObject);
            if (F == null) {
                return new o32();
            }
            return F;
        }
        return (o32) invokeL.objValue;
    }

    public final void D(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) && jsObject != null) {
            jsObject.release();
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onClose(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            super.onClose(jSONObject);
            if (this.d != null && jSONObject != null) {
                this.d.c(jSONObject.optString("taskID"));
            }
        }
    }

    @JavascriptInterface
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            close(null);
        }
    }

    @JavascriptInterface
    public void close(JsObject jsObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            o32 C = C(jsObject);
            if (this.a == WebSocketEventTarget.SocketTaskState.CLOSE) {
                y(C, "SocketTask.close", "SocketTask.readyState is CLOSED");
                return;
            }
            int r = C.r("code", 1000);
            String B = C.B("reason");
            if (r != 1000 && (r < 3000 || r > 4999)) {
                z = false;
            } else {
                z = true;
            }
            try {
                if (!z) {
                    y(C, "SocketTask.close", ha4.a);
                    return;
                }
                try {
                    WebSocketManager.INSTANCE.close(this.c, r, B);
                    z(C, "SocketTask.close");
                } catch (Exception e) {
                    y(C, "SocketTask.close", e.getMessage());
                }
            } finally {
                this.d.c(this.c);
            }
        }
    }

    @JavascriptInterface
    public void send(JsObject jsObject) {
        JsArrayBuffer jsArrayBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) {
            o32 C = C(jsObject);
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    int type = C.getType("data");
                    String str = null;
                    if (type != 7) {
                        if (type != 10) {
                            y(C, "SocketTask.send", "invalid data type");
                            return;
                        }
                        jsArrayBuffer = C.t("data", null);
                    } else {
                        str = C.C("data", null);
                        jsArrayBuffer = null;
                    }
                    if (str == null && jsArrayBuffer == null) {
                        y(C, "SocketTask.send", "invalid data type");
                        return;
                    }
                    try {
                        if (str != null) {
                            WebSocketManager.INSTANCE.send(this.c, str);
                        } else if (jsArrayBuffer != null) {
                            WebSocketManager.INSTANCE.send(this.c, ByteBuffer.wrap(jsArrayBuffer.buffer()));
                        }
                        z(C, "SocketTask.send");
                        return;
                    } catch (Exception e) {
                        y(C, "SocketTask.send", e.getMessage());
                        return;
                    }
                }
                y(C, "SocketTask.send", "SocketTask.readyState is CLOSED");
                return;
            }
            y(C, "SocketTask.send", "SocketTask.readyState is not OPEN");
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, th, jSONObject) == null) {
            super.onError(th, jSONObject);
            if (this.d != null && jSONObject != null) {
                this.d.c(jSONObject.optString("taskID"));
            }
        }
    }

    public final void z(o32 o32Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, o32Var, str) == null) {
            String format = String.format("%s:ok", str);
            if (WebSocketEventTarget.b) {
                Log.i("WebSocket", format);
            }
            td4.call(o32Var, true, new ja4(format));
        }
    }

    public final WebSocketRequest x(String str, @NonNull o32 o32Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, o32Var)) == null) {
            WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
            builder.setUrl(str);
            builder.setMethod(o32Var.B("method"));
            o32 w = o32Var.w("header");
            if (w != null) {
                for (String str2 : w.j()) {
                    if (!TextUtils.isEmpty(str2) && !j23.d.contains(str2.toUpperCase(Locale.US))) {
                        builder.addHeader(str2, w.H(str2));
                    }
                }
            }
            String[] D = o32Var.D(WebSocketRequest.PARAM_KEY_PROTOCOLS);
            ArrayList arrayList = new ArrayList();
            if (D != null && D.length != 0) {
                arrayList.addAll(Arrays.asList(D));
            } else {
                arrayList.add("");
            }
            builder.setProtocols(arrayList);
            builder.setConnectionLostTimeout(0);
            return builder.build();
        }
        return (WebSocketRequest) invokeLL.objValue;
    }

    public final void y(o32 o32Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, o32Var, str, str2) == null) {
            String format = String.format("%s:fail %s", str, str2);
            if (WebSocketEventTarget.b) {
                Log.i("WebSocket", format);
            }
            td4.call(o32Var, false, new ja4(format));
        }
    }
}
