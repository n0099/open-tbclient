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
import com.baidu.tieba.a83;
import com.baidu.tieba.f82;
import com.baidu.tieba.sr2;
import com.baidu.tieba.tt2;
import com.baidu.tieba.x62;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x62 a;
        public final /* synthetic */ sa2 b;
        public final /* synthetic */ cv1 c;
        public final /* synthetic */ tt2 d;
        public final /* synthetic */ sr2.g e;

        public a(x62 x62Var, sa2 sa2Var, cv1 cv1Var, tt2 tt2Var, sr2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x62Var, sa2Var, cv1Var, tt2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x62Var;
            this.b = sa2Var;
            this.c = cv1Var;
            this.d = tt2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                x62.g(0);
                hc3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements x62.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa2 a;
        public final /* synthetic */ cv1 b;
        public final /* synthetic */ tt2 c;
        public final /* synthetic */ sr2.g d;
        public final /* synthetic */ a83 e;

        public b(sa2 sa2Var, cv1 cv1Var, tt2 tt2Var, sr2.g gVar, a83 a83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa2Var, cv1Var, tt2Var, gVar, a83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sa2Var;
            this.b = cv1Var;
            this.c = tt2Var;
            this.d = gVar;
            this.e = a83Var;
        }

        @Override // com.baidu.tieba.x62.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hc3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947818865, "Lcom/baidu/tieba/hc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947818865, "Lcom/baidu/tieba/hc3;");
                return;
            }
        }
        a = gp1.a;
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
            b(po3.b(e()));
        }
    }

    public static void a(sa2 sa2Var, cv1 cv1Var, tt2 tt2Var, sr2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, sa2Var, cv1Var, tt2Var, gVar) == null) {
            HybridUbcFlow o = b23.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            ju2 U = ju2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, tt2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                ee2.c().b(sa2Var, cv1Var, tt2Var, gVar.b, gVar, false);
                sa2Var.attachActivity(activity);
                cv1Var.attachActivity(activity);
                f82 V = U.V();
                if (V == null) {
                    return;
                }
                wy2 d2 = wy2.d(d, U.z());
                bf2.o(qm3.a(d2.c, d2.a, d2.b), cv1Var);
                g(V, d);
                pf3.E();
                jz2.e(cv1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    b23.l(h);
                }
                pf3.F(true, tt2Var.T());
                yn3 T = activity.T();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + T);
                }
                if (T != null) {
                    T.F(1);
                }
                v83 K = v83.K();
                if (K.E() && TextUtils.equals(K.getAppId(), tt2Var.H())) {
                    K.q().J(true);
                }
                y82.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            ju2 U = ju2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                f82 V = U.V();
                if (V == null) {
                    w52.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    w52.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    ro3.a().k();
                    yn3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    v83 K = v83.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    y82.f(true);
                    return;
                }
            }
            w52.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(ju2 ju2Var, tt2 tt2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ju2Var, tt2Var, swanAppConfigData)) == null) {
            String b2 = ju2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (tt2Var.o0()) {
                    b2 = swanAppConfigData.g(tt2Var.h0());
                } else {
                    b2 = ju2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        tt2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            w83 q = v83.K().q();
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

    public static boolean f(f82 f82Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, f82Var)) == null) {
            if (f82Var.k() >= 1 && (f82Var.m() instanceof j82)) {
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

    public static void g(f82 f82Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, f82Var, str) != null) || f82Var == null) {
            return;
        }
        e82.S3(null);
        ju2 U = ju2.U();
        f82.b i = f82Var.i("init");
        int i2 = f82.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", wy2.d(str, U.z()), true).a();
    }

    public static void h(f82 f82Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, f82Var, str) == null) {
            if (f82Var == null) {
                w52.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(f82Var)) {
                w52.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                e82.S3(null);
                f82.b i = f82Var.i("init");
                int i2 = f82.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", wy2.d(str, str), true).a();
                oo3.c().o(f82Var.m());
            }
        }
    }

    public static void i(sa2 sa2Var, cv1 cv1Var, tt2 tt2Var, sr2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, sa2Var, cv1Var, tt2Var, gVar) == null) {
            if (!v43.H() && x62.e() != 2) {
                if (v43.D()) {
                    h62.k().q(sa2Var, cv1Var, tt2Var, gVar);
                    return;
                } else {
                    a(sa2Var, cv1Var, tt2Var, gVar);
                    return;
                }
            }
            w52.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            x62 x62Var = new x62(ds2.c());
            a83.a aVar = new a83.a(v83.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0152);
            aVar.v(R.string.obfuscated_res_0x7f0f0141);
            aVar.n(new eo3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0140, new a(x62Var, sa2Var, cv1Var, tt2Var, gVar));
            a83 X = aVar.X();
            HybridUbcFlow o = b23.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            x62Var.f(new b(sa2Var, cv1Var, tt2Var, gVar, X));
            x62Var.h();
        }
    }
}
