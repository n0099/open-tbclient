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
import com.baidu.tieba.e72;
import com.baidu.tieba.rq2;
import com.baidu.tieba.ss2;
import com.baidu.tieba.w52;
import com.baidu.tieba.z63;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w52 a;
        public final /* synthetic */ r92 b;
        public final /* synthetic */ bu1 c;
        public final /* synthetic */ ss2 d;
        public final /* synthetic */ rq2.g e;

        public a(w52 w52Var, r92 r92Var, bu1 bu1Var, ss2 ss2Var, rq2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w52Var, r92Var, bu1Var, ss2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w52Var;
            this.b = r92Var;
            this.c = bu1Var;
            this.d = ss2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                w52.g(0);
                gb3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements w52.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r92 a;
        public final /* synthetic */ bu1 b;
        public final /* synthetic */ ss2 c;
        public final /* synthetic */ rq2.g d;
        public final /* synthetic */ z63 e;

        public b(r92 r92Var, bu1 bu1Var, ss2 ss2Var, rq2.g gVar, z63 z63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r92Var, bu1Var, ss2Var, gVar, z63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r92Var;
            this.b = bu1Var;
            this.c = ss2Var;
            this.d = gVar;
            this.e = z63Var;
        }

        @Override // com.baidu.tieba.w52.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gb3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947788113, "Lcom/baidu/tieba/gb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947788113, "Lcom/baidu/tieba/gb3;");
                return;
            }
        }
        a = fo1.a;
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
            b(on3.b(e()));
        }
    }

    public static void a(r92 r92Var, bu1 bu1Var, ss2 ss2Var, rq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, r92Var, bu1Var, ss2Var, gVar) == null) {
            HybridUbcFlow o = a13.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            it2 U = it2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, ss2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                dd2.c().b(r92Var, bu1Var, ss2Var, gVar.b, gVar, false);
                r92Var.attachActivity(activity);
                bu1Var.attachActivity(activity);
                e72 V = U.V();
                if (V == null) {
                    return;
                }
                vx2 d2 = vx2.d(d, U.z());
                ae2.o(pl3.a(d2.c, d2.a, d2.b), bu1Var);
                g(V, d);
                oe3.E();
                iy2.e(bu1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    a13.l(h);
                }
                oe3.F(true, ss2Var.T());
                xm3 V2 = activity.V();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + V2);
                }
                if (V2 != null) {
                    V2.F(1);
                }
                u73 K = u73.K();
                if (K.E() && TextUtils.equals(K.getAppId(), ss2Var.H())) {
                    K.q().J(true);
                }
                x72.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            it2 U = it2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                e72 V = U.V();
                if (V == null) {
                    v42.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    v42.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    qn3.a().k();
                    xm3 V2 = activity.V();
                    if (V2 != null) {
                        V2.F(1);
                    }
                    u73 K = u73.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    x72.f(true);
                    return;
                }
            }
            v42.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(it2 it2Var, ss2 ss2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, it2Var, ss2Var, swanAppConfigData)) == null) {
            String b2 = it2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (ss2Var.o0()) {
                    b2 = swanAppConfigData.g(ss2Var.h0());
                } else {
                    b2 = it2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        ss2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            v73 q = u73.K().q();
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

    public static boolean f(e72 e72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, e72Var)) == null) {
            if (e72Var.k() >= 1 && (e72Var.m() instanceof i72)) {
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

    public static void g(e72 e72Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, e72Var, str) != null) || e72Var == null) {
            return;
        }
        d72.V3(null);
        it2 U = it2.U();
        e72.b i = e72Var.i("init");
        int i2 = e72.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", vx2.d(str, U.z()), true).a();
    }

    public static void h(e72 e72Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, e72Var, str) == null) {
            if (e72Var == null) {
                v42.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(e72Var)) {
                v42.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                d72.V3(null);
                e72.b i = e72Var.i("init");
                int i2 = e72.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", vx2.d(str, str), true).a();
                nn3.c().o(e72Var.m());
            }
        }
    }

    public static void i(r92 r92Var, bu1 bu1Var, ss2 ss2Var, rq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, r92Var, bu1Var, ss2Var, gVar) == null) {
            if (!u33.H() && w52.e() != 2) {
                if (u33.D()) {
                    g52.k().q(r92Var, bu1Var, ss2Var, gVar);
                    return;
                } else {
                    a(r92Var, bu1Var, ss2Var, gVar);
                    return;
                }
            }
            v42.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            w52 w52Var = new w52(cr2.c());
            z63.a aVar = new z63.a(u73.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0152);
            aVar.v(R.string.obfuscated_res_0x7f0f0141);
            aVar.n(new dn3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0140, new a(w52Var, r92Var, bu1Var, ss2Var, gVar));
            z63 X = aVar.X();
            HybridUbcFlow o = a13.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            w52Var.f(new b(r92Var, bu1Var, ss2Var, gVar, X));
            w52Var.h();
        }
    }
}
