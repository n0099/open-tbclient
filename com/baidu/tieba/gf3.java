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
import com.baidu.tieba.eb2;
import com.baidu.tieba.ru2;
import com.baidu.tieba.sw2;
import com.baidu.tieba.w92;
import com.baidu.tieba.za3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gf3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w92 a;
        public final /* synthetic */ rd2 b;
        public final /* synthetic */ by1 c;
        public final /* synthetic */ sw2 d;
        public final /* synthetic */ ru2.g e;

        public a(w92 w92Var, rd2 rd2Var, by1 by1Var, sw2 sw2Var, ru2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w92Var, rd2Var, by1Var, sw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w92Var;
            this.b = rd2Var;
            this.c = by1Var;
            this.d = sw2Var;
            this.e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.i();
                w92.g(0);
                gf3.a(this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements w92.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rd2 a;
        public final /* synthetic */ by1 b;
        public final /* synthetic */ sw2 c;
        public final /* synthetic */ ru2.g d;
        public final /* synthetic */ za3 e;

        public b(rd2 rd2Var, by1 by1Var, sw2 sw2Var, ru2.g gVar, za3 za3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rd2Var, by1Var, sw2Var, gVar, za3Var};
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
            this.e = za3Var;
        }

        @Override // com.baidu.tieba.w92.b
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gf3.a(this.a, this.b, this.c, this.d);
                this.e.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947791957, "Lcom/baidu/tieba/gf3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947791957, "Lcom/baidu/tieba/gf3;");
                return;
            }
        }
        a = fs1.a;
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
            b(or3.b(e()));
        }
    }

    public static void a(rd2 rd2Var, by1 by1Var, sw2 sw2Var, ru2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, rd2Var, by1Var, sw2Var, gVar) == null) {
            HybridUbcFlow o = a53.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_dostart");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            ix2 T2 = ix2.T();
            SwanAppConfigData swanAppConfigData = gVar.b;
            if (swanAppConfigData == null) {
                if (a) {
                    Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                    return;
                }
                return;
            }
            String d = d(T2, sw2Var, swanAppConfigData);
            String h = gVar.b.h(d);
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                dh2.c().b(rd2Var, by1Var, sw2Var, gVar.b, gVar, false);
                rd2Var.attachActivity(activity);
                by1Var.attachActivity(activity);
                eb2 U = T2.U();
                if (U == null) {
                    return;
                }
                v13 d2 = v13.d(d, T2.z());
                ai2.o(pp3.a(d2.c, d2.a, d2.b), by1Var);
                g(U, d);
                oi3.E();
                i23.e(by1Var.a());
                if (!TextUtils.isEmpty(h)) {
                    a53.l(h);
                }
                oi3.F(true, sw2Var.T());
                xq3 U2 = activity.U();
                if (a) {
                    Log.i("FirstPageAction", "startFirstPage:: loadingView=" + U2);
                }
                if (U2 != null) {
                    U2.F(1);
                }
                ub3 K = ub3.K();
                if (K.E() && TextUtils.equals(K.getAppId(), sw2Var.H())) {
                    K.q().J(true);
                }
                xb2.f(true);
            } else if (a) {
                Log.w("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            ix2 T2 = ix2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                eb2 U = T2.U();
                if (U == null) {
                    v82.i("FirstPageAction", "doWebModeStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(str)) {
                    v82.i("FirstPageAction", "doWebModeStart: web url is null.");
                    return;
                } else {
                    h(U, str);
                    qr3.a().k();
                    xq3 U2 = activity.U();
                    if (U2 != null) {
                        U2.F(1);
                    }
                    ub3 K = ub3.K();
                    if (K.E()) {
                        K.q().J(true);
                    }
                    xb2.f(true);
                    return;
                }
            }
            v82.i("FirstPageAction", "activity is invalid.");
        }
    }

    public static String d(ix2 ix2Var, sw2 sw2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ix2Var, sw2Var, swanAppConfigData)) == null) {
            String b2 = ix2Var.b();
            if (TextUtils.isEmpty(b2)) {
                if (sw2Var.o0()) {
                    b2 = swanAppConfigData.g(sw2Var.h0());
                } else {
                    b2 = ix2Var.g();
                }
            }
            b = b2;
            return b2;
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        sw2.a W;
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            vb3 q = ub3.K().q();
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

    public static boolean f(eb2 eb2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, eb2Var)) == null) {
            if (eb2Var.k() >= 1 && (eb2Var.m() instanceof ib2)) {
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

    public static void g(eb2 eb2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, eb2Var, str) != null) || eb2Var == null) {
            return;
        }
        db2.U3(null);
        ix2 T2 = ix2.T();
        eb2.b i = eb2Var.i("init");
        int i2 = eb2.i;
        i.n(i2, i2);
        i.f();
        i.l("normal", v13.d(str, T2.z()), true).a();
    }

    public static void h(eb2 eb2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, eb2Var, str) == null) {
            if (eb2Var == null) {
                v82.i("FirstPageAction", "pushWebModeFragment: fragment manager is null.");
            } else if (f(eb2Var)) {
                v82.i("FirstPageAction", "pushWebModeFragment: has already push the web fragment.");
            } else {
                db2.U3(null);
                eb2.b i = eb2Var.i("init");
                int i2 = eb2.i;
                i.n(i2, i2);
                i.f();
                i.l("web_mode", v13.d(str, str), true).a();
                nr3.c().o(eb2Var.m());
            }
        }
    }

    public static void i(rd2 rd2Var, by1 by1Var, sw2 sw2Var, ru2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, rd2Var, by1Var, sw2Var, gVar) == null) {
            if (!u73.H() && w92.e() != 2) {
                if (u73.D()) {
                    g92.k().q(rd2Var, by1Var, sw2Var, gVar);
                    return;
                } else {
                    a(rd2Var, by1Var, sw2Var, gVar);
                    return;
                }
            }
            v82.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            w92 w92Var = new w92(cv2.c());
            za3.a aVar = new za3.a(ub3.K().w());
            aVar.U(R.string.obfuscated_res_0x7f0f017c);
            aVar.v(R.string.obfuscated_res_0x7f0f016b);
            aVar.n(new dr3());
            aVar.m(false);
            aVar.O(R.string.obfuscated_res_0x7f0f016a, new a(w92Var, rd2Var, by1Var, sw2Var, gVar));
            za3 X = aVar.X();
            HybridUbcFlow o = a53.o();
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fist_page_action_reg_callback");
            ubcFlowEvent.a(true);
            o.F(ubcFlowEvent);
            w92Var.f(new b(rd2Var, by1Var, sw2Var, gVar, X));
            w92Var.h();
        }
    }
}
