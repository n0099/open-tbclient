package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.baidu.tieba.e92;
import com.baidu.tieba.i92;
import com.baidu.tieba.k92;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g92 implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static int i;
    public transient /* synthetic */ FieldHolder $fh;
    public InputStream a;
    public OutputStream b;
    public k92 c;
    public LinkedBlockingQueue<String> d;
    public InspectorNativeClient e;
    public li2 f;
    public e92.b g;

    /* loaded from: classes6.dex */
    public class a implements k92.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g92 a;

        /* renamed from: com.baidu.tieba.g92$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0308a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0308a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String str = (String) this.a.a.d.poll();
                    while (str != null) {
                        this.a.a.e.dispatchProtocolMessage(str);
                        this.a.d(str);
                        str = (String) this.a.a.d.poll();
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.g.onConnected();
                    this.a.a.g = null;
                    int unused = g92.i = 2;
                }
            }
        }

        public a(g92 g92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g92Var;
        }

        @Override // com.baidu.tieba.k92.a
        public void a(WebSocketFrame webSocketFrame) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, webSocketFrame) == null) {
                this.a.d.offer(webSocketFrame.g());
                this.a.f.postOnJSThread(new RunnableC0308a(this));
            }
        }

        @Override // com.baidu.tieba.k92.a
        public void b(IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) {
                d82.d("ClientHandler", "V8 inspector exception", iOException);
                this.a.l();
            }
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !TextUtils.isEmpty(str) && this.a.g != null && g92.i != 2) {
                try {
                    if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                        cb3 K = cb3.K();
                        SwanAppActivity w = cb3.K().w();
                        if (K.E() && w != null) {
                            w.runOnUiThread(new b(this));
                        }
                    }
                } catch (JSONException e) {
                    if (g92.h) {
                        Log.e("ClientHandler", "message is not a Json object", e);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.k92.a
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                d82.i("ClientHandler", "V8 inspector closed");
                this.a.l();
            }
        }

        @Override // com.baidu.tieba.k92.a
        public void onOpen() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                d82.i("ClientHandler", "V8 inspector opened");
                zc2 W = xh2.U().W();
                if (W instanceof dd2) {
                    this.a.f = (li2) W.d();
                }
                if (this.a.f == null) {
                    d82.i("ClientHandler", "inner error, V8 mEngine is null");
                    this.a.l();
                    return;
                }
                if (this.a.e != null) {
                    this.a.e.destroy();
                }
                g92 g92Var = this.a;
                g92Var.e = g92Var.f.q0(new b(this.a));
                int unused = g92.i = 1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends InspectorNativeChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g92 a;

        public b(g92 g92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g92Var;
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                try {
                    this.a.c.j(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
                } catch (Exception unused) {
                    if (g92.h) {
                        Log.d("ClientHandler", "V8 send message fail, try to check if websocket has opened");
                    }
                }
            }
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (g92.h) {
                    Log.d("ClientHandler", "getInspectorMessage");
                }
                try {
                    return (String) this.a.d.take();
                } catch (InterruptedException e) {
                    if (g92.h) {
                        Log.e("ClientHandler", "awaitMessage on Debugger", e);
                        return "";
                    }
                    return "";
                }
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748681, "Lcom/baidu/tieba/g92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748681, "Lcom/baidu/tieba/g92;");
                return;
            }
        }
        h = nr1.a;
    }

    public g92(InputStream inputStream, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, outputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new LinkedBlockingQueue<>();
        this.a = inputStream;
        this.b = outputStream;
    }

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            try {
                return URLDecoder.decode(str, StringUtils.UTF8);
            } catch (UnsupportedEncodingException unused) {
                if (h) {
                    Log.d("ClientHandler", "Encoding not supported, ignored");
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public void o(e92.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) && i == 0) {
            this.g = bVar;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinkedBlockingQueue<String> linkedBlockingQueue = this.d;
            if (linkedBlockingQueue != null) {
                linkedBlockingQueue.clear();
                this.d = null;
            }
            InspectorNativeClient inspectorNativeClient = this.e;
            if (inspectorNativeClient != null) {
                inspectorNativeClient.destroy();
                this.e = null;
            }
            InputStream inputStream = this.a;
            if (inputStream != null) {
                hr4.d(inputStream);
                this.a = null;
            }
            OutputStream outputStream = this.b;
            if (outputStream != null) {
                hr4.d(outputStream);
                this.b = null;
            }
            this.c = null;
            this.f = null;
            i = 3;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void m(BufferedReader bufferedReader, i92.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bufferedReader, aVar) == null) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.b = stringTokenizer.nextToken();
                    if (stringTokenizer.hasMoreTokens()) {
                        aVar.c = n(stringTokenizer.nextToken());
                        if (stringTokenizer.hasMoreTokens()) {
                            aVar.d = stringTokenizer.nextToken();
                        } else {
                            aVar.d = "HTTP/1.1";
                            if (h) {
                                Log.d("ClientHandler", "no protocol version specified, Assuming HTTP/1.1.");
                            }
                        }
                        String readLine2 = bufferedReader.readLine();
                        while (readLine2 != null && !readLine2.trim().isEmpty()) {
                            if (h) {
                                Log.d("ClientHandler", "Http header :" + readLine2);
                            }
                            int indexOf = readLine2.indexOf(58);
                            if (indexOf >= 0) {
                                aVar.a.put(readLine2.substring(0, indexOf).trim().toLowerCase(), readLine2.substring(indexOf + 1).trim());
                            }
                            readLine2 = bufferedReader.readLine();
                        }
                        return;
                    }
                    throw new RuntimeException("BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                }
                throw new RuntimeException("BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            } catch (IOException e) {
                if (h) {
                    Log.e("ClientHandler", "Decode header exception", e);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a));
                    i92.a aVar = new i92.a();
                    m(bufferedReader, aVar);
                    j92.a(aVar).e(this.b);
                    if (aVar.e) {
                        if (i != 0 && i != 3) {
                            va3.f(ku2.c(), R.string.obfuscated_res_0x7f0f0167).G();
                            return;
                        }
                        k92 k92Var = new k92();
                        this.c = k92Var;
                        k92Var.k(new a(this));
                        this.c.h(this.a, this.b);
                    }
                } catch (RuntimeException e) {
                    if (h) {
                        Log.e("ClientHandler", "Request parse fail", e);
                    }
                }
            } finally {
                hr4.d(this.a);
                hr4.d(this.b);
            }
        }
    }
}
