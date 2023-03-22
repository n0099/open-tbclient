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
import com.baidu.tieba.c72;
import com.baidu.tieba.pq2;
import com.baidu.tieba.qs2;
import com.baidu.tieba.u52;
import com.baidu.tieba.x63;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class eb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u52 a;
        public final /* synthetic */ p92 b;
        public final /* synthetic */ zt1 c;
        public final /* synthetic */ qs2 d;
        public final /* synthetic */ pq2.g e;

        public a(u52 u52Var, p92 p92Var, zt1 zt1Var, qs2 qs2Var, pq2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u52Var, p92Var, zt1Var, qs2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u52Var;
            this.b = p92Var;
            this.c = zt1Var;
            this.d = qs2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                u52.g(0);
                eb3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements u52.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p92 a;
        public final /* synthetic */ zt1 b;
        public final /* synthetic */ qs2 c;
        public final /* synthetic */ pq2.g d;
        public final /* synthetic */ x63 e;

        public b(p92 p92Var, zt1 zt1Var, qs2 qs2Var, pq2.g gVar, x63 x63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p92Var, zt1Var, qs2Var, gVar, x63Var};
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
            this.e = x63Var;
        }

        @Override // com.baidu.tieba.u52.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                eb3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947728531, "Lcom/baidu/tieba/eb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947728531, "Lcom/baidu/tieba/eb3;");
                return;
            }
        }
        a = do1.a;
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
            b(mn3.b(e()));
        }
    }

    public static void a(p92 p92Var, zt1 zt1Var, qs2 qs2Var, pq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, p92Var, zt1Var, qs2Var, gVar) == null) {
            HybridUbcFlow o = y03.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            gt2 U = gt2.U();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(U, qs2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                bd2.c().b(p92Var, zt1Var, qs2Var, gVar.b, gVar, false);
                p92Var.attachActivity(activity);
                zt1Var.attachActivity(activity);
                c72 V = U.V();
                if (V == null) {
                    return;
                }
                tx2 d2 = tx2.d(d, U.z());
                yd2.o(nl3.a(d2.c, d2.a, d2.b), zt1Var);
                g(V, d);
                me3.E();
                gy2.e(zt1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    y03.l(h);
                }
                me3.F(true, qs2Var.T());
                vm3 V2 = activity.V();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + V2);
                }
                if (V2 != null) {
                    V2.F(1);
                }
                s73 K = s73.K();
                if (K.E() && TextUtils.equals(K.getAppId(), qs2Var.H())) {
                    K.q().J(true);
                }
                v72.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            gt2 U = gt2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                c72 V = U.V();
                if (V == null) {
                    t42.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    t42.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(V, str);
                    on3.a().k();
                    vm3 V2 = activity.V();
                    if (V2 != null) {
                        V2.F(1);
                    }
                    s73 K = s73.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    v72.f(true);
                    return;
                }
            }
            t42.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(gt2 gt2Var, qs2 qs2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, gt2Var, qs2Var, swanAppConfigData)) == null) {
            String b2 = gt2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (qs2Var.o0()) {
                    b2 = swanAppConfigData.g(qs2Var.h0());
                } else {
                    b2 = gt2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        qs2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            t73 q = s73.K().q();
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

    public static boolean f(c72 c72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, c72Var)) == null) {
            if (c72Var.k() >= 1 && (c72Var.m() instanceof g72)) {
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

    public static void g(c72 c72Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, c72Var, str) != null) || c72Var == null) {
            return;
        }
        b72.V3(null);
        gt2 U = gt2.U();
        c72.b i = c72Var.i("init");
        int i2 = c72.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", tx2.d(str, U.z()), true).a();
    }

    public static void h(c72 c72Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, c72Var, str) == null) {
            if (c72Var == null) {
                t42.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(c72Var)) {
                t42.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                b72.V3(null);
                c72.b i = c72Var.i("init");
                int i2 = c72.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", tx2.d(str, str), true).a();
                ln3.c().o(c72Var.m());
            }
        }
    }

    public static void i(p92 p92Var, zt1 zt1Var, qs2 qs2Var, pq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, p92Var, zt1Var, qs2Var, gVar) == null) {
            if (!s33.H() && u52.e() != 2) {
                if (s33.D()) {
                    e52.k().q(p92Var, zt1Var, qs2Var, gVar);
                    return;
                } else {
                    a(p92Var, zt1Var, qs2Var, gVar);
                    return;
                }
            }
            t42.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            u52 u52Var = new u52(ar2.c());
            x63.a aVar = new x63.a(s73.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f0152);
            aVar.v(R.string.obfuscated_res_0x7f0f0141);
            aVar.n(new bn3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f0140, new a(u52Var, p92Var, zt1Var, qs2Var, gVar));
            x63 X = aVar.X();
            HybridUbcFlow o = y03.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            u52Var.f(new b(p92Var, zt1Var, qs2Var, gVar, X));
            u52Var.h();
        }
    }
}
