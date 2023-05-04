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
import com.baidu.tieba.b73;
import com.baidu.tieba.g72;
import com.baidu.tieba.tq2;
import com.baidu.tieba.us2;
import com.baidu.tieba.y52;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ib3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y52 a;
        public final /* synthetic */ t92 b;
        public final /* synthetic */ du1 c;
        public final /* synthetic */ us2 d;
        public final /* synthetic */ tq2.g e;

        public a(y52 y52Var, t92 t92Var, du1 du1Var, us2 us2Var, tq2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y52Var, t92Var, du1Var, us2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y52Var;
            this.b = t92Var;
            this.c = du1Var;
            this.d = us2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                y52.g(0);
                ib3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements y52.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t92 a;
        public final /* synthetic */ du1 b;
        public final /* synthetic */ us2 c;
        public final /* synthetic */ tq2.g d;
        public final /* synthetic */ b73 e;

        public b(t92 t92Var, du1 du1Var, us2 us2Var, tq2.g gVar, b73 b73Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t92Var, du1Var, us2Var, gVar, b73Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t92Var;
            this.b = du1Var;
            this.c = us2Var;
            this.d = gVar;
            this.e = b73Var;
        }

        @Override // com.baidu.tieba.y52.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ib3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947847695, "Lcom/baidu/tieba/ib3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947847695, "Lcom/baidu/tieba/ib3;");
                return;
            }
        }
        a = ho1.a;
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
            b(qn3.b(e()));
        }
    }

    public static void a(t92 t92Var, du1 du1Var, us2 us2Var, tq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, t92Var, du1Var, us2Var, gVar) == null) {
            HybridUbcFlow o = c13.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            kt2 U = kt2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, us2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                fd2.c().b(t92Var, du1Var, us2Var, gVar.b, gVar, false);
                t92Var.attachActivity(activity);
                du1Var.attachActivity(activity);
                g72 V = U.V();
                if (V == null) {
                    return;
                }
                xx2 d2 = xx2.d(d, U.z());
                ce2.o(rl3.a(d2.c, d2.a, d2.b), du1Var);
                g(V, d);
                qe3.E();
                ky2.e(du1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    c13.l(h);
                }
                qe3.F(true, us2Var.T());
                zm3 V2 = activity.V();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + V2);
                }
                if (V2 != null) {
                    V2.F(1);
                }
                w73 K = w73.K();
                if (K.E() && TextUtils.equals(K.getAppId(), us2Var.H())) {
                    K.q().J(true);
                }
                z72.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            kt2 U = kt2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                g72 V = U.V();
                if (V == null) {
                    x42.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    x42.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    sn3.a().k();
                    zm3 V2 = activity.V();
                    if (V2 != null) {
                        V2.F(1);
                    }
                    w73 K = w73.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    z72.f(true);
                    return;
                }
            }
            x42.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(kt2 kt2Var, us2 us2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, kt2Var, us2Var, swanAppConfigData)) == null) {
            String b2 = kt2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (us2Var.o0()) {
                    b2 = swanAppConfigData.g(us2Var.h0());
                } else {
                    b2 = kt2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        us2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            x73 q = w73.K().q();
            if (q == null || (W = q.W()) == null || (f0 = W.f0()) == null) {
                return null;
            }
            String str = f0.webUrl;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static boolean f(g72 g72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, g72Var)) == null) {
            if (g72Var.k() >= 1 && (g72Var.m() instanceof k72)) {
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

    public static void g(g72 g72Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, g72Var, str) != null) || g72Var == null) {
            return;
        }
        f72.V3(null);
        kt2 U = kt2.U();
        g72.b i = g72Var.i("init");
        int i2 = g72.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", xx2.d(str, U.z()), true).a();
    }

    public static void h(g72 g72Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, g72Var, str) == null) {
            if (g72Var == null) {
                x42.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(g72Var)) {
                x42.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                f72.V3(null);
                g72.b i = g72Var.i("init");
                int i2 = g72.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", xx2.d(str, str), true).a();
                pn3.c().o(g72Var.m());
            }
        }
    }

    public static void i(t92 t92Var, du1 du1Var, us2 us2Var, tq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, t92Var, du1Var, us2Var, gVar) == null) {
            if (!w33.H() && y52.e() != 2) {
                if (w33.D()) {
                    i52.k().q(t92Var, du1Var, us2Var, gVar);
                    return;
                } else {
                    a(t92Var, du1Var, us2Var, gVar);
                    return;
                }
            }
            x42.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            y52 y52Var = new y52(er2.c());
            b73.a aVar = new b73.a(w73.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0150);
            aVar.v(R.string.obfuscated_res_0x7f0f013f);
            aVar.n(new fn3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f013e, new a(y52Var, t92Var, du1Var, us2Var, gVar));
            b73 X = aVar.X();
            HybridUbcFlow o = c13.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            y52Var.f(new b(t92Var, du1Var, us2Var, gVar, X));
            y52Var.h();
        }
    }
}
