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
import com.baidu.tieba.d72;
import com.baidu.tieba.qq2;
import com.baidu.tieba.rs2;
import com.baidu.tieba.v52;
import com.baidu.tieba.y63;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v52 a;
        public final /* synthetic */ q92 b;
        public final /* synthetic */ au1 c;
        public final /* synthetic */ rs2 d;
        public final /* synthetic */ qq2.g e;

        public a(v52 v52Var, q92 q92Var, au1 au1Var, rs2 rs2Var, qq2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v52Var, q92Var, au1Var, rs2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v52Var;
            this.b = q92Var;
            this.c = au1Var;
            this.d = rs2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                v52.g(0);
                fb3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements v52.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q92 a;
        public final /* synthetic */ au1 b;
        public final /* synthetic */ rs2 c;
        public final /* synthetic */ qq2.g d;
        public final /* synthetic */ y63 e;

        public b(q92 q92Var, au1 au1Var, rs2 rs2Var, qq2.g gVar, y63 y63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q92Var, au1Var, rs2Var, gVar, y63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q92Var;
            this.b = au1Var;
            this.c = rs2Var;
            this.d = gVar;
            this.e = y63Var;
        }

        @Override // com.baidu.tieba.v52.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fb3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947758322, "Lcom/baidu/tieba/fb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947758322, "Lcom/baidu/tieba/fb3;");
                return;
            }
        }
        a = eo1.a;
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
            b(nn3.b(e()));
        }
    }

    public static void a(q92 q92Var, au1 au1Var, rs2 rs2Var, qq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, q92Var, au1Var, rs2Var, gVar) == null) {
            HybridUbcFlow o = z03.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            ht2 U = ht2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, rs2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                cd2.c().b(q92Var, au1Var, rs2Var, gVar.b, gVar, false);
                q92Var.attachActivity(activity);
                au1Var.attachActivity(activity);
                d72 V = U.V();
                if (V == null) {
                    return;
                }
                ux2 d2 = ux2.d(d, U.z());
                zd2.o(ol3.a(d2.c, d2.a, d2.b), au1Var);
                g(V, d);
                ne3.E();
                hy2.e(au1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    z03.l(h);
                }
                ne3.F(true, rs2Var.T());
                wm3 V2 = activity.V();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + V2);
                }
                if (V2 != null) {
                    V2.F(1);
                }
                t73 K = t73.K();
                if (K.E() && TextUtils.equals(K.getAppId(), rs2Var.H())) {
                    K.q().J(true);
                }
                w72.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            ht2 U = ht2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                d72 V = U.V();
                if (V == null) {
                    u42.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    u42.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    pn3.a().k();
                    wm3 V2 = activity.V();
                    if (V2 != null) {
                        V2.F(1);
                    }
                    t73 K = t73.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    w72.f(true);
                    return;
                }
            }
            u42.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(ht2 ht2Var, rs2 rs2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ht2Var, rs2Var, swanAppConfigData)) == null) {
            String b2 = ht2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (rs2Var.o0()) {
                    b2 = swanAppConfigData.g(rs2Var.h0());
                } else {
                    b2 = ht2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        rs2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            u73 q = t73.K().q();
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

    public static boolean f(d72 d72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, d72Var)) == null) {
            if (d72Var.k() >= 1 && (d72Var.m() instanceof h72)) {
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

    public static void g(d72 d72Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, d72Var, str) != null) || d72Var == null) {
            return;
        }
        c72.V3(null);
        ht2 U = ht2.U();
        d72.b i = d72Var.i("init");
        int i2 = d72.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", ux2.d(str, U.z()), true).a();
    }

    public static void h(d72 d72Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, d72Var, str) == null) {
            if (d72Var == null) {
                u42.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(d72Var)) {
                u42.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                c72.V3(null);
                d72.b i = d72Var.i("init");
                int i2 = d72.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", ux2.d(str, str), true).a();
                mn3.c().o(d72Var.m());
            }
        }
    }

    public static void i(q92 q92Var, au1 au1Var, rs2 rs2Var, qq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, q92Var, au1Var, rs2Var, gVar) == null) {
            if (!t33.H() && v52.e() != 2) {
                if (t33.D()) {
                    f52.k().q(q92Var, au1Var, rs2Var, gVar);
                    return;
                } else {
                    a(q92Var, au1Var, rs2Var, gVar);
                    return;
                }
            }
            u42.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            v52 v52Var = new v52(br2.c());
            y63.a aVar = new y63.a(t73.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0152);
            aVar.v(R.string.obfuscated_res_0x7f0f0141);
            aVar.n(new cn3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0140, new a(v52Var, q92Var, au1Var, rs2Var, gVar));
            y63 X = aVar.X();
            HybridUbcFlow o = z03.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            v52Var.f(new b(q92Var, au1Var, rs2Var, gVar, X));
            v52Var.h();
        }
    }
}
