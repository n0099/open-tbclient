package com.baidu.tieba;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.lo2;
import com.baidu.tieba.mq2;
import com.baidu.tieba.q32;
import com.baidu.tieba.t43;
import com.baidu.tieba.y42;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q32 a;
        public final /* synthetic */ l72 b;
        public final /* synthetic */ wr1 c;
        public final /* synthetic */ mq2 d;
        public final /* synthetic */ lo2.g e;

        public a(q32 q32Var, l72 l72Var, wr1 wr1Var, mq2 mq2Var, lo2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q32Var, l72Var, wr1Var, mq2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q32Var;
            this.b = l72Var;
            this.c = wr1Var;
            this.d = mq2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                q32.g(0);
                a93.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements q32.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l72 a;
        public final /* synthetic */ wr1 b;
        public final /* synthetic */ mq2 c;
        public final /* synthetic */ lo2.g d;
        public final /* synthetic */ t43 e;

        public b(l72 l72Var, wr1 wr1Var, mq2 mq2Var, lo2.g gVar, t43 t43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l72Var, wr1Var, mq2Var, gVar, t43Var};
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
            this.e = t43Var;
        }

        @Override // com.baidu.tieba.q32.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a93.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947569966, "Lcom/baidu/tieba/a93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947569966, "Lcom/baidu/tieba/a93;");
                return;
            }
        }
        a = am1.a;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b;
        }
        return (String) invokeV.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            b(il3.b(e()));
        }
    }

    public static void a(l72 l72Var, wr1 wr1Var, mq2 mq2Var, lo2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, l72Var, wr1Var, mq2Var, gVar) == null) {
            HybridUbcFlow o = uy2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            cr2 V = cr2.V();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(V, mq2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                xa2.c().b(l72Var, wr1Var, mq2Var, gVar.b, gVar, false);
                l72Var.attachActivity(activity);
                wr1Var.attachActivity(activity);
                y42 W = V.W();
                if (W == null) {
                    return;
                }
                pv2 d2 = pv2.d(d, V.A());
                ub2.o(jj3.a(d2.c, d2.a, d2.b), wr1Var);
                g(W, d);
                ic3.E();
                cw2.e(wr1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    uy2.l(h);
                }
                ic3.F(true, mq2Var.U());
                rk3 T2 = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T2);
                }
                if (T2 != null) {
                    T2.F(1);
                }
                o53 K = o53.K();
                if (K.E() && TextUtils.equals(K.getAppId(), mq2Var.I())) {
                    K.q().J(true);
                }
                r52.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            cr2 V = cr2.V();
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                y42 W = V.W();
                if (W == null) {
                    p22.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    p22.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(W, str);
                    kl3.a().k();
                    rk3 T2 = activity.T();
                    if (T2 != null) {
                        T2.F(1);
                    }
                    o53 K = o53.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    r52.f(true);
                    return;
                }
            }
            p22.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(cr2 cr2Var, mq2 mq2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cr2Var, mq2Var, swanAppConfigData)) == null) {
            String b2 = cr2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (mq2Var.p0()) {
                    b2 = swanAppConfigData.g(mq2Var.i0());
                } else {
                    b2 = cr2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        mq2.a X;
        PMSAppInfo g0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            p53 q = o53.K().q();
            if (q == null || (X = q.X()) == null || (g0 = X.g0()) == null) {
                return null;
            }
            String str = g0.webUrl;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static boolean f(y42 y42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, y42Var)) == null) {
            if (y42Var.k() >= 1 && (y42Var.m() instanceof c52)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            b(str);
        }
    }

    public static void g(y42 y42Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, y42Var, str) != null) || y42Var == null) {
            return;
        }
        x42.Z3(null);
        cr2 V = cr2.V();
        y42.b i = y42Var.i("init");
        int i2 = y42.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", pv2.d(str, V.A()), true).a();
    }

    public static void h(y42 y42Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, y42Var, str) == null) {
            if (y42Var == null) {
                p22.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(y42Var)) {
                p22.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                x42.Z3(null);
                y42.b i = y42Var.i("init");
                int i2 = y42.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", pv2.d(str, str), true).a();
                hl3.c().o(y42Var.m());
            }
        }
    }

    public static void i(l72 l72Var, wr1 wr1Var, mq2 mq2Var, lo2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, l72Var, wr1Var, mq2Var, gVar) == null) {
            if (!o13.H() && q32.e() != 2) {
                if (o13.D()) {
                    a32.k().q(l72Var, wr1Var, mq2Var, gVar);
                    return;
                } else {
                    a(l72Var, wr1Var, mq2Var, gVar);
                    return;
                }
            }
            p22.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            q32 q32Var = new q32(wo2.c());
            t43.a aVar = new t43.a(o53.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f017f);
            aVar.v(R.string.obfuscated_res_0x7f0f016e);
            aVar.n(new xk3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f016d, new a(q32Var, l72Var, wr1Var, mq2Var, gVar));
            t43 X = aVar.X();
            HybridUbcFlow o = uy2.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            q32Var.f(new b(l72Var, wr1Var, mq2Var, gVar, X));
            q32Var.h();
        }
    }
}
