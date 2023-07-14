package com.baidu.tieba;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ru2;
import com.baidu.tieba.sw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile g92 g;
    public transient /* synthetic */ FieldHolder $fh;
    public qd2 a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;

    /* loaded from: classes6.dex */
    public class a implements nj2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw2 a;
        public final /* synthetic */ rd2 b;
        public final /* synthetic */ by1 c;
        public final /* synthetic */ ru2.g d;
        public final /* synthetic */ g92 e;

        public a(g92 g92Var, sw2 sw2Var, rd2 rd2Var, by1 by1Var, ru2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var, sw2Var, rd2Var, by1Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = g92Var;
            this.a = sw2Var;
            this.b = rd2Var;
            this.c = by1Var;
            this.d = gVar;
        }

        @Override // com.baidu.tieba.nj2
        public void a(dj2 dj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dj2Var) == null) {
                this.e.d = true;
                e92.e().f("loaddebug");
                v82.k("LocalDebugger", "prepareDaemon finish.");
                wl2 j = this.e.j(this.a);
                this.e.t(j);
                if (g92.f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.s().toString());
                }
                this.e.n(this.b, this.c, this.a, this.d);
                this.e.p(this.b, this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd2 a;
        public final /* synthetic */ by1 b;
        public final /* synthetic */ sw2 c;
        public final /* synthetic */ ru2.g d;
        public final /* synthetic */ g92 e;

        public b(g92 g92Var, rd2 rd2Var, by1 by1Var, sw2 sw2Var, ru2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var, rd2Var, by1Var, sw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = g92Var;
            this.a = rd2Var;
            this.b = by1Var;
            this.c = sw2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (g92.f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.e.b = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public c(g92 g92Var, rd2 rd2Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var, rd2Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd2Var;
            this.b = str;
            this.c = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(g92 g92Var) {
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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && g92.f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ by1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public e(g92 g92Var, by1 by1Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var, by1Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = by1Var;
            this.b = str;
            this.c = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.cy1] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd2 a;
        public final /* synthetic */ by1 b;
        public final /* synthetic */ sw2 c;
        public final /* synthetic */ ru2.g d;
        public final /* synthetic */ g92 e;

        public f(g92 g92Var, rd2 rd2Var, by1 by1Var, sw2 sw2Var, ru2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var, rd2Var, by1Var, sw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = g92Var;
            this.a = rd2Var;
            this.b = by1Var;
            this.c = sw2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (g92.f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.e.c = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd2 a;
        public final /* synthetic */ by1 b;
        public final /* synthetic */ sw2 c;
        public final /* synthetic */ ru2.g d;

        public g(g92 g92Var, rd2 rd2Var, by1 by1Var, sw2 sw2Var, ru2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g92Var, rd2Var, by1Var, sw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rd2Var;
            this.b = by1Var;
            this.c = sw2Var;
            this.d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gf3.a(this.a, this.b, this.c, this.d);
            }
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
        f = fs1.a;
    }

    public g92() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
    }

    public static g92 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (g92.class) {
                    if (g == null) {
                        g = new g92();
                    }
                }
            }
            return g;
        }
        return (g92) invokeV.objValue;
    }

    public dj2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            qd2 qd2Var = this.a;
            if (qd2Var != null) {
                return qd2Var.a();
            }
            return null;
        }
        return (dj2) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            v82.k("LocalDebugger", "releaseLocalDebugger");
            qd2 qd2Var = this.a;
            if (qd2Var != null) {
                qd2Var.b();
                this.a = null;
            }
            g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            v82.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.e = true;
            this.b = false;
            this.c = false;
        }
    }

    public final wl2 j(@NonNull sw2<sw2.a> sw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sw2Var)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", sw2Var.X());
                jSONObject.put("wsServerPort", sw2Var.Y());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new wl2("message", hashMap);
        }
        return (wl2) invokeL.objValue;
    }

    public final void n(rd2 rd2Var, by1<?> by1Var, sw2<sw2.a> sw2Var, ru2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, rd2Var, by1Var, sw2Var, gVar) == null) {
            if (rd2Var != null && rd2Var.d() != null) {
                pp3.a0(new c(this, rd2Var, zr4.E(new File(c92.e())), new b(this, rd2Var, by1Var, sw2Var, gVar)));
            } else {
                v82.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(by1<?> by1Var, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, by1Var, valueCallback) == null) {
            if (by1Var != null && by1Var.r() != null) {
                String E = zr4.E(new File(c92.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                pp3.a0(new e(this, by1Var, E, valueCallback));
                return;
            }
            v82.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(rd2 rd2Var, by1<?> by1Var, sw2<sw2.a> sw2Var, ru2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, rd2Var, by1Var, sw2Var, gVar) == null) {
            o(by1Var, new f(this, rd2Var, by1Var, sw2Var, gVar));
        }
    }

    public final synchronized void u(rd2 rd2Var, by1<?> by1Var, sw2<sw2.a> sw2Var, ru2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, rd2Var, by1Var, sw2Var, gVar) == null) {
            synchronized (this) {
                if (this.b && this.c) {
                    v82.k("LocalDebugger", "startFirstPage");
                    pp3.a0(new g(this, rd2Var, by1Var, sw2Var, gVar));
                }
            }
        }
    }

    public void q(rd2 rd2Var, by1<?> by1Var, sw2<sw2.a> sw2Var, ru2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048582, this, rd2Var, by1Var, sw2Var, gVar) != null) || !pi2.U().q0()) {
            return;
        }
        v82.k("LocalDebugger", "prepareDaemon start.");
        if (this.e && this.d && this.a != null) {
            n(rd2Var, by1Var, sw2Var, gVar);
            p(rd2Var, by1Var, sw2Var, gVar);
            return;
        }
        qd2 d2 = pi2.U().f0().d();
        this.a = d2;
        d2.c(new a(this, sw2Var, rd2Var, by1Var, gVar));
    }

    public final void t(vl2 vl2Var) {
        qd2 qd2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, vl2Var) == null) && (qd2Var = this.a) != null) {
            rl2.a(qd2Var.a(), vl2Var);
        }
    }
}
