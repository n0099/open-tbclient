package com.baidu.tieba;

import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lo2;
import com.baidu.tieba.mq2;
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
/* loaded from: classes5.dex */
public class a32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile a32 g;
    public transient /* synthetic */ FieldHolder $fh;
    public k72 a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;

    /* loaded from: classes5.dex */
    public class a implements hd2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq2 a;
        public final /* synthetic */ l72 b;
        public final /* synthetic */ wr1 c;
        public final /* synthetic */ lo2.g d;
        public final /* synthetic */ a32 e;

        public a(a32 a32Var, mq2 mq2Var, l72 l72Var, wr1 wr1Var, lo2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a32Var, mq2Var, l72Var, wr1Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = a32Var;
            this.a = mq2Var;
            this.b = l72Var;
            this.c = wr1Var;
            this.d = gVar;
        }

        @Override // com.baidu.tieba.hd2
        public void a(xc2 xc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xc2Var) == null) {
                this.e.d = true;
                y22.e().f("loaddebug");
                p22.k("LocalDebugger", "prepareDaemon finish.");
                qf2 j = this.e.j(this.a);
                this.e.t(j);
                if (a32.f) {
                    Log.d("LocalDebugger", "debugInitMsg - " + j.s().toString());
                }
                this.e.n(this.b, this.c, this.a, this.d);
                this.e.p(this.b, this.c, this.a, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l72 a;
        public final /* synthetic */ wr1 b;
        public final /* synthetic */ mq2 c;
        public final /* synthetic */ lo2.g d;
        public final /* synthetic */ a32 e;

        public b(a32 a32Var, l72 l72Var, wr1 wr1Var, mq2 mq2Var, lo2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a32Var, l72Var, wr1Var, mq2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = a32Var;
            this.a = l72Var;
            this.b = wr1Var;
            this.c = mq2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a32.f) {
                    Log.d("LocalDebugger", "master onReceiveValue: " + str);
                }
                this.e.b = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l72 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public c(a32 a32Var, l72 l72Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a32Var, l72Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l72Var;
            this.b = str;
            this.c = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(a32 a32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a32Var};
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && a32.f) {
                Log.d("LocalDebugger", "slave onReceiveValue: " + str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ValueCallback c;

        public e(a32 a32Var, wr1 wr1Var, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a32Var, wr1Var, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr1Var;
            this.b = str;
            this.c = valueCallback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.xr1] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getWebView().evaluateJavascript(this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l72 a;
        public final /* synthetic */ wr1 b;
        public final /* synthetic */ mq2 c;
        public final /* synthetic */ lo2.g d;
        public final /* synthetic */ a32 e;

        public f(a32 a32Var, l72 l72Var, wr1 wr1Var, mq2 mq2Var, lo2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a32Var, l72Var, wr1Var, mq2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = a32Var;
            this.a = l72Var;
            this.b = wr1Var;
            this.c = mq2Var;
            this.d = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a32.f) {
                    Log.d("LocalDebugger", "slave onReceiveValue: " + str);
                }
                this.e.c = true;
                this.e.u(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l72 a;
        public final /* synthetic */ wr1 b;
        public final /* synthetic */ mq2 c;
        public final /* synthetic */ lo2.g d;

        public g(a32 a32Var, l72 l72Var, wr1 wr1Var, mq2 mq2Var, lo2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a32Var, l72Var, wr1Var, mq2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l72Var;
            this.b = wr1Var;
            this.c = mq2Var;
            this.d = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a93.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947564169, "Lcom/baidu/tieba/a32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947564169, "Lcom/baidu/tieba/a32;");
                return;
            }
        }
        f = am1.a;
    }

    public a32() {
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

    public static a32 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (g == null) {
                synchronized (a32.class) {
                    if (g == null) {
                        g = new a32();
                    }
                }
            }
            return g;
        }
        return (a32) invokeV.objValue;
    }

    public xc2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            k72 k72Var = this.a;
            if (k72Var != null) {
                return k72Var.a();
            }
            return null;
        }
        return (xc2) invokeV.objValue;
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
            p22.k("LocalDebugger", "releaseLocalDebugger");
            k72 k72Var = this.a;
            if (k72Var != null) {
                k72Var.b();
                this.a = null;
            }
            g = null;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            p22.k("LocalDebugger", "resetMasterAndSlaveStatus");
            this.e = true;
            this.b = false;
            this.c = false;
        }
    }

    public final qf2 j(@NonNull mq2<mq2.a> mq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mq2Var)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "debugInit");
                jSONObject.put("host", mq2Var.Y());
                jSONObject.put("wsServerPort", mq2Var.Z());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap.put("message", jSONObject.toString());
            return new qf2("message", hashMap);
        }
        return (qf2) invokeL.objValue;
    }

    public final void n(l72 l72Var, wr1<?> wr1Var, mq2<mq2.a> mq2Var, lo2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, l72Var, wr1Var, mq2Var, gVar) == null) {
            if (l72Var != null && l72Var.e() != null) {
                jj3.a0(new c(this, l72Var, sl4.E(new File(w22.e())), new b(this, l72Var, wr1Var, mq2Var, gVar)));
            } else {
                p22.k("LocalDebugger", "loadMasterDebugJs - master or js container is null");
            }
        }
    }

    public void o(wr1<?> wr1Var, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, wr1Var, valueCallback) == null) {
            if (wr1Var != null && wr1Var.getWebView() != null) {
                String E = sl4.E(new File(w22.f()));
                if (valueCallback == null) {
                    valueCallback = new d(this);
                }
                jj3.a0(new e(this, wr1Var, E, valueCallback));
                return;
            }
            p22.k("LocalDebugger", "loadSlaveDebugJs - slave or WebView is null");
        }
    }

    public final void p(l72 l72Var, wr1<?> wr1Var, mq2<mq2.a> mq2Var, lo2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, l72Var, wr1Var, mq2Var, gVar) == null) {
            o(wr1Var, new f(this, l72Var, wr1Var, mq2Var, gVar));
        }
    }

    public final synchronized void u(l72 l72Var, wr1<?> wr1Var, mq2<mq2.a> mq2Var, lo2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, l72Var, wr1Var, mq2Var, gVar) == null) {
            synchronized (this) {
                if (this.b && this.c) {
                    p22.k("LocalDebugger", "startFirstPage");
                    jj3.a0(new g(this, l72Var, wr1Var, mq2Var, gVar));
                }
            }
        }
    }

    public void q(l72 l72Var, wr1<?> wr1Var, mq2<mq2.a> mq2Var, lo2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048582, this, l72Var, wr1Var, mq2Var, gVar) != null) || !jc2.V().r0()) {
            return;
        }
        p22.k("LocalDebugger", "prepareDaemon start.");
        if (this.e && this.d && this.a != null) {
            n(l72Var, wr1Var, mq2Var, gVar);
            p(l72Var, wr1Var, mq2Var, gVar);
            return;
        }
        k72 d2 = jc2.V().g0().d();
        this.a = d2;
        d2.c(new a(this, mq2Var, l72Var, wr1Var, gVar));
    }

    public final void t(pf2 pf2Var) {
        k72 k72Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, pf2Var) == null) && (k72Var = this.a) != null) {
            lf2.a(k72Var.a(), pf2Var);
        }
    }
}
