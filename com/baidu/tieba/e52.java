package com.baidu.tieba;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pq2;
import com.baidu.tieba.qs2;
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
/* loaded from: classes4.dex */
public class e52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile e52 g;
    public transient /* synthetic */ FieldHolder $fh;
    public o92 a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;

    /* loaded from: classes4.dex */
    public class a implements lf2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs2 a;
        public final /* synthetic */ p92 b;
        public final /* synthetic */ zt1 c;
        public final /* synthetic */ pq2.g d;
        public final /* synthetic */ e52 e;

        public a(e52 e52Var, qs2 qs2Var, p92 p92Var, zt1 zt1Var, pq2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e52Var, qs2Var, p92Var, zt1Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = e52Var;
            this.a = qs2Var;
            this.b = p92Var;
            this.c = zt1Var;
            this.d = gVar;
        }

        @Override // com.baidu.tieba.lf2
        public void a(bf2 bf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bf2Var) == null) {
                this.e.d = true;
                c52.e().f("loaddebug");
                t42.k("LocalDebugger", "prepareDaemon finish.");
                uh2 j = this.e.j(this.a);
                this.e.t(j);
                if (e52.f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.s().toString());
                }
                this.e.n(this.b, this.c, this.a, this.d);
                this.e.p(this.b, this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p92 a;
        public final /* synthetic */ zt1 b;
        public final /* synthetic */ qs2 c;
        public final /* synthetic */ pq2.g d;
        public final /* synthetic */ e52 e;

        public b(e52 e52Var, p92 p92Var, zt1 zt1Var, qs2 qs2Var, pq2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e52Var, p92Var, zt1Var, qs2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = e52Var;
            this.a = p92Var;
            this.b = zt1Var;
            this.c = qs2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (e52.f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.e.b = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p92 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public c(e52 e52Var, p92 p92Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e52Var, p92Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p92Var;
            this.b = str;
            this.c = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(e52 e52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e52Var};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && e52.f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public e(e52 e52Var, zt1 zt1Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e52Var, zt1Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt1Var;
            this.b = str;
            this.c = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.au1] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p92 a;
        public final /* synthetic */ zt1 b;
        public final /* synthetic */ qs2 c;
        public final /* synthetic */ pq2.g d;
        public final /* synthetic */ e52 e;

        public f(e52 e52Var, p92 p92Var, zt1 zt1Var, qs2 qs2Var, pq2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e52Var, p92Var, zt1Var, qs2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = e52Var;
            this.a = p92Var;
            this.b = zt1Var;
            this.c = qs2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (e52.f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.e.c = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p92 a;
        public final /* synthetic */ zt1 b;
        public final /* synthetic */ qs2 c;
        public final /* synthetic */ pq2.g d;

        public g(e52 e52Var, p92 p92Var, zt1 zt1Var, qs2 qs2Var, pq2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e52Var, p92Var, zt1Var, qs2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p92Var;
            this.b = zt1Var;
            this.c = qs2Var;
            this.d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                eb3.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947685255, "Lcom/baidu/tieba/e52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947685255, "Lcom/baidu/tieba/e52;");
                return;
            }
        }
        f = do1.a;
    }

    public e52() {
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

    public static e52 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (e52.class) {
                    if (g == null) {
                        g = new e52();
                    }
                }
            }
            return g;
        }
        return (e52) invokeV.objValue;
    }

    public bf2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            o92 o92Var = this.a;
            if (o92Var != null) {
                return o92Var.a();
            }
            return null;
        }
        return (bf2) invokeV.objValue;
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
            t42.k("LocalDebugger", "releaseLocalDebugger");
            o92 o92Var = this.a;
            if (o92Var != null) {
                o92Var.b();
                this.a = null;
            }
            g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            t42.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.e = true;
            this.b = false;
            this.c = false;
        }
    }

    public final uh2 j(@NonNull qs2<qs2.a> qs2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qs2Var)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", qs2Var.X());
                jSONObject.put("wsServerPort", qs2Var.Y());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new uh2("message", hashMap);
        }
        return (uh2) invokeL.objValue;
    }

    public final void n(p92 p92Var, zt1<?> zt1Var, qs2<qs2.a> qs2Var, pq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, p92Var, zt1Var, qs2Var, gVar) == null) {
            if (p92Var != null && p92Var.f() != null) {
                nl3.a0(new c(this, p92Var, xn4.E(new File(a52.e())), new b(this, p92Var, zt1Var, qs2Var, gVar)));
            } else {
                t42.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public final synchronized void u(p92 p92Var, zt1<?> zt1Var, qs2<qs2.a> qs2Var, pq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, p92Var, zt1Var, qs2Var, gVar) == null) {
            synchronized (this) {
                if (this.b && this.c) {
                    t42.k("LocalDebugger", "startFirstPage");
                    nl3.a0(new g(this, p92Var, zt1Var, qs2Var, gVar));
                }
            }
        }
    }

    public void o(zt1<?> zt1Var, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, zt1Var, valueCallback) == null) {
            if (zt1Var != null && zt1Var.r() != null) {
                String E = xn4.E(new File(a52.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                nl3.a0(new e(this, zt1Var, E, valueCallback));
                return;
            }
            t42.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(p92 p92Var, zt1<?> zt1Var, qs2<qs2.a> qs2Var, pq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, p92Var, zt1Var, qs2Var, gVar) == null) {
            o(zt1Var, new f(this, p92Var, zt1Var, qs2Var, gVar));
        }
    }

    public void q(p92 p92Var, zt1<?> zt1Var, qs2<qs2.a> qs2Var, pq2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048582, this, p92Var, zt1Var, qs2Var, gVar) != null) || !ne2.U().q0()) {
            return;
        }
        t42.k("LocalDebugger", "prepareDaemon start.");
        if (this.e && this.d && this.a != null) {
            n(p92Var, zt1Var, qs2Var, gVar);
            p(p92Var, zt1Var, qs2Var, gVar);
            return;
        }
        o92 d2 = ne2.U().f0().d();
        this.a = d2;
        d2.c(new a(this, qs2Var, p92Var, zt1Var, gVar));
    }

    public final void t(th2 th2Var) {
        o92 o92Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, th2Var) == null) && (o92Var = this.a) != null) {
            ph2.a(o92Var.a(), th2Var);
        }
    }
}
