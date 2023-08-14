package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.dh2;
import com.baidu.tieba.fa3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class ga2 extends ea2 implements fa3.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean W0;
    public static final int X0;
    public static String Y0;
    public static y03 Z0;
    public static String a1;
    public static String b1;
    public transient /* synthetic */ FieldHolder $fh;
    public eh3 G0;
    public y03 H0;
    public y03 I0;
    public Map<String, ex1> J0;
    public FrameLayout K0;
    public ex1 L0;
    public km3 M0;
    public fa3 N0;
    public View O0;
    public nb3 P0;
    public int Q0;
    public lc2 R0;
    public cw1 S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;

    @Override // com.baidu.tieba.ea2
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class e implements rp3<yf3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga2 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.U0 = false;
                this.a.a.D2(true, false);
            }
        }

        public e(ga2 ga2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yf3Var) == null) && yf3Var != null && !yf3Var.d && yf3Var.j == 1) {
                so3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga2 a;

        public a(ga2 ga2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S0 = fu2.Q();
                cw1 cw1Var = this.a.S0;
                ga2 ga2Var = this.a;
                cw1Var.a(ga2Var.b0, ga2Var.d0, ga2Var.getContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga2 a;

        public b(ga2 ga2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga2Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void onDoubleClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = this.a.L0.a();
                el2 el2Var = new el2();
                el2Var.c = fq3.a(a, "scrollViewBackToTop");
                lw2.T().m(a, el2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga2 a;

        public c(ga2 ga2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.l3();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements dh2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dh2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ga2 f;

        public d(ga2 ga2Var, dh2.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga2Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ga2Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.baidu.tieba.fx1] */
        @Override // com.baidu.tieba.dh2.f
        public void onReady() {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ph2 ph2Var = new ph2();
                ph2Var.i = this.a.a.I();
                if (!TextUtils.isEmpty(this.b)) {
                    e43.e(this.a, this.b);
                }
                String b = qe3.b(this.c);
                ph2Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                ph2Var.b = str;
                if (ya3.b0() != null) {
                    ph2Var.c = ya3.b0().d0(b);
                    ph2Var.f = ya3.b0().X(b);
                }
                ph2Var.k = mh2.c(ya3.M(), ph2Var.b);
                ph2Var.d = lw2.T().f(b).g;
                ph2Var.e = String.valueOf(v72.a());
                if (!ga2.W0 && !lw2.T().M()) {
                    z = false;
                } else {
                    z = true;
                }
                ph2Var.g = z;
                if (x63.H()) {
                    ph2Var.j = b82.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    ph2Var.h = str2;
                    d43.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                fo3.d();
                this.a.a.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.Q(ph2Var.b);
                lw2.T().m(this.a.a.a(), ph2.a(ph2Var));
                if (qh2.b()) {
                    qh2 qh2Var = new qh2();
                    qh2Var.a = this.a.a.a();
                    lw2.T().u(qh2.a(qh2Var));
                }
                ih3.F(this.a.a.a(), ph2Var.b);
                if (ga2.W0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + ph2Var.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements lc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga2 a;

        public f(ga2 ga2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga2Var;
        }

        @Override // com.baidu.tieba.lc2
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIIII(1048576, this, i, i2, i3, i4) != null) {
                return;
            }
            this.a.a4(i2);
        }
    }

    /* loaded from: classes6.dex */
    public class g implements nc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga2 a;

        public g(ga2 ga2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ga2Var;
        }

        @Override // com.baidu.tieba.nc2
        public void a(hx1 hx1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hx1Var) == null) && hx1Var != null) {
                hx1Var.s(this.a.R0);
                hx1Var.W(this.a.A3());
                m13.e().a(hx1Var);
            }
        }

        @Override // com.baidu.tieba.nc2
        public void b(hx1 hx1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hx1Var) == null) && hx1Var != null) {
                hx1Var.S(this.a.R0);
                m13.e().b(hx1Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends jc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ga2 c;

        public h(ga2 ga2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ga2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ga2Var;
        }

        @Override // com.baidu.tieba.jc2, com.baidu.tieba.mc2
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.x2(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-782336564, "Lcom/baidu/tieba/ga2$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-782336564, "Lcom/baidu/tieba/ga2$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    fu2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (ga2.W0) {
                    Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + a);
                }
                return a;
            }
            return invokeV.intValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (a() > 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947787121, "Lcom/baidu/tieba/ga2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947787121, "Lcom/baidu/tieba/ga2;");
                return;
            }
        }
        W0 = ir1.a;
        X0 = po3.g(149.0f);
        Y0 = "-1";
        a1 = "-1";
    }

    public final jc2 A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new h(this);
        }
        return (jc2) invokeV.objValue;
    }

    public final nc2 B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new g(this);
        }
        return (nc2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ea2, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.C0();
        }
    }

    public final void C3() {
        bs2 D0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ex1 q3 = q3();
            if ((q3 instanceof SwanAppWebViewManager) && (D0 = ((SwanAppWebViewManager) q3).D0()) != null) {
                D0.d();
            }
        }
    }

    public boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            km3 km3Var = this.M0;
            if (km3Var == null) {
                return false;
            }
            return km3Var.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            nb3 nb3Var = this.P0;
            if (nb3Var != null && nb3Var.h) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ea2
    public nb3 I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.P0;
        }
        return (nb3) invokeV.objValue;
    }

    public boolean I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            nb3 nb3Var = this.P0;
            if (nb3Var != null) {
                return TextUtils.equals(nb3Var.j, ExceptionHandlerImpl.KEY_CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppConfigData s = lw2.T().s();
            if (s != null && !TextUtils.equals(s.f(), this.H0.e())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b4() {
        z03 z03Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || (z03Var = this.d0) == null) {
            return;
        }
        z03Var.n();
    }

    public PullToRefreshBaseWebView f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            ex1 ex1Var = this.L0;
            if (ex1Var != null) {
                return ex1Var.f0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.G0 = rh3.c("805");
        }
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            xa3.K().q().e0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.P0.j = "default";
            w1();
            P3();
        }
    }

    @NonNull
    public y03 o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.H0;
        }
        return (y03) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ea2, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onPause();
            b1();
        }
    }

    @Override // com.baidu.tieba.ea2, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onResume();
            e1();
            u3(false);
        }
    }

    public ex1 q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.L0;
        }
        return (ex1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ea2
    public void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            super.r2();
            P3();
            if (this.V0) {
                V3();
            }
        }
    }

    public final int r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (f2()) {
                if (L3()) {
                    return 18;
                }
                return 17;
            } else if (L3()) {
                return 12;
            } else {
                return 15;
            }
        }
        return invokeV.intValue;
    }

    @Nullable
    public y03 t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.I0;
        }
        return (y03) invokeV.objValue;
    }

    public String v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            ex1 ex1Var = this.L0;
            if (ex1Var != null) {
                return ex1Var.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public km3 x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.M0;
        }
        return (km3) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            super.z0();
            this.C0.a();
            if (i.b()) {
                so3.q().postAtFrontOfQueue(new c(this));
            } else {
                l3();
            }
        }
    }

    public FrameLayout z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.K0;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public ga2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.H0 = new y03();
        this.J0 = new TreeMap();
        this.Q0 = 0;
        this.T0 = false;
        this.U0 = false;
        this.V0 = false;
    }

    private void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (Z()) {
                pause();
            }
            if (W0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.L0.a())));
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.B0();
            Map<String, ex1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (ex1 ex1Var : this.J0.values()) {
                    if (ex1Var != null) {
                        ex1Var.c0();
                    }
                }
            } else {
                ex1 ex1Var2 = this.L0;
                if (ex1Var2 != null) {
                    ex1Var2.c0();
                }
            }
            C3();
        }
    }

    public final boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SwanAppConfigData s = lw2.T().s();
            boolean z = false;
            if (s == null) {
                return false;
            }
            return !((TextUtils.equals(s.f(), this.H0.a) || s.r(this.H0.a)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    public final boolean K3() {
        InterceptResult invokeV;
        boolean z;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ha2 O1 = O1();
            if (O1 == null) {
                return false;
            }
            nb3 nb3Var = this.P0;
            if (nb3Var != null && nb3Var.k) {
                z = true;
            } else {
                z = false;
            }
            if (z || (s = lw2.T().s()) == null) {
                return false;
            }
            return !J3(O1, s);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ea2
    public boolean g2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        z03 z03Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            lw2 T2 = lw2.T();
            if (T2 == null || (s = T2.s()) == null || !s.n() || (z03Var = this.d0) == null) {
                return false;
            }
            return s.r(z03Var.i());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fa3.a
    public fa3 getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.N0 == null) {
                if (this.O0 == null) {
                    return null;
                }
                this.N0 = new fa3(this, (LinearLayout) this.O0.findViewById(R.id.obfuscated_res_0x7f09018b), L1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070160));
            }
            return this.N0;
        }
        return (fa3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ea2
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            ex1 ex1Var = this.L0;
            if (ex1Var != null) {
                ex1Var.R();
            }
            E3();
            s3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(wh2.n(xa3.K().getAppId()));
            }
            this.g0.u(fu2.M().a(), J1(), this.h0, false);
        }
    }

    public static ga2 O3(z03 z03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, z03Var)) == null) {
            ga2 ga2Var = new ga2();
            if (z03Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", z03Var.m());
                ga2Var.k1(bundle);
            }
            return ga2Var;
        }
        return (ga2) invokeL.objValue;
    }

    public static void W3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            b1 = str;
        }
    }

    public final boolean M3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (this.J0.isEmpty() || this.J0.get(str) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void N3(ci3 ci3Var) {
        eh3 eh3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, ci3Var) == null) && (eh3Var = this.G0) != null) {
            rh3.i(eh3Var, ci3Var);
            this.G0 = null;
        }
    }

    public void T3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void Z3(ex1 ex1Var) {
        lc2 lc2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, ex1Var) != null) || (lc2Var = this.R0) == null || ex1Var == null) {
            return;
        }
        ex1Var.S(lc2Var);
        if (ex1Var.j() != null) {
            ex1Var.S(this.R0);
        }
    }

    public final void f3(ex1 ex1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, ex1Var) != null) || ex1Var == null) {
            return;
        }
        lc2 lc2Var = this.R0;
        if (lc2Var != null) {
            ex1Var.s(lc2Var);
        }
        ex1Var.X(B3());
    }

    @Override // com.baidu.tieba.ea2, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, motionEvent)) == null) {
            if (b2() && this.L0.isSlidable(motionEvent)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void s0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, activity) == null) {
            super.s0(activity);
            if (W0) {
                Log.d("SwanAppFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Override // com.baidu.tieba.ea2
    public boolean v2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i2)) == null) {
            boolean v2 = super.v2(i2);
            P3();
            return v2;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.ea2
    public void x1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            if (!nb3.f(this.P0)) {
                super.x1(i2);
                return;
            }
            boolean z = true;
            if (!I3()) {
                z = true ^ ho3.h(this.c0);
            }
            y1(i2, z);
            P3();
        }
    }

    public String y3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, str)) == null) {
            if (this.J0.containsKey(str)) {
                return this.J0.get(str).a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void U3(y03 y03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, y03Var) == null) {
            try {
                if (W0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + y03Var);
                }
                if (y03Var == null) {
                    Z0 = null;
                } else {
                    Z0 = (y03) y03Var.clone();
                }
            } catch (Exception e2) {
                if (W0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void D3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || I3()) {
            return;
        }
        lw2 T2 = lw2.T();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (T2.f(str).h && this.R0 == null) {
            this.R0 = new f(this);
        }
    }

    @Override // com.baidu.tieba.ea2, com.baidu.swan.support.v4.app.Fragment
    public void n1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048623, this, z) != null) || !l0()) {
            return;
        }
        super.n1(z);
        if (W0) {
            Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
        }
        if (z) {
            resume();
            u3(false);
            return;
        }
        pause();
    }

    public final void s3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048635, this, z) == null) && fu2.K().k(z, 2)) {
            w03.l(getContext(), this.g0, this.f0, ya3.b0().W().f0().paNumber);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            super.v0(bundle);
            Q3();
            if (W0) {
                Log.d("SwanAppFragment", "onCreate() obj: " + this);
            }
            sn3.j(new a(this), "SwanAppPageHistory");
            c43.a("route", "fragment create.");
        }
    }

    private void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (Z()) {
                resume();
            }
            fh4 fh4Var = this.g0;
            if (fh4Var != null && fh4Var.i()) {
                this.g0.B(fu2.M().a());
            }
            if (W0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.L0.a())));
            }
        }
    }

    @DebugTrace
    public void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity != null && this.g0 == null) {
                this.g0 = new fh4(activity, this.f0, r3(), fu2.K(), new hq3());
                new o03(this.g0, this, this.h0).z();
                if (u03.e()) {
                    this.g0.l(50);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ea2
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (getFloatLayer() != null && getFloatLayer().e() && getFloatLayer().f()) {
                return true;
            }
            if ((getFloatLayer() != null && getFloatLayer().c()) || PaymentManager.k()) {
                return true;
            }
            ex1 ex1Var = this.L0;
            if (ex1Var != null) {
                if (xx2.g(ex1Var.a())) {
                    return true;
                }
                return this.L0.H();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ea2
    public void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.L0 == null) {
                if (W0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            hx1 j = this.L0.j();
            if (j != null) {
                hashMap.put("webViewUrl", j.getCurrentPageUrl());
            }
            lw2.T().u(new zk2("sharebtn", hashMap));
        }
    }

    @Override // com.baidu.tieba.ea2
    public void k2() {
        z03 P1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            R1();
            bi3 bi3Var = new bi3();
            bi3Var.e = "gohome";
            bi3Var.c = "bar";
            ga2 H = lw2.T().H();
            if (H == null) {
                P1 = null;
            } else {
                P1 = H.P1();
            }
            if (P1 != null && !TextUtils.isEmpty(P1.i())) {
                bi3Var.a("page", P1.i());
            }
            B1(bi3Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.fx1] */
    @NonNull
    public Pair<Integer, Integer> p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            ex1 ex1Var = this.L0;
            if (ex1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = ex1Var.r().getCurrentWebView();
            if (currentWebView == null) {
                return new Pair<>(0, 0);
            }
            return new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public List<String> w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, ex1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, ex1> entry : this.J0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().a());
                    }
                }
            }
            ex1 ex1Var = this.L0;
            if (ex1Var != null) {
                String a2 = ex1Var.a();
                if (!arrayList.contains(a2)) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean J3(ha2 ha2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, ha2Var, swanAppConfigData)) == null) {
            ea2 j = ha2Var.j(0);
            if (j == null || !(j instanceof ga2)) {
                return false;
            }
            String e2 = ((ga2) j).o3().e();
            if (!swanAppConfigData.r(e2) && !TextUtils.equals(swanAppConfigData.f(), e2)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void P3() {
        int i2;
        nb3 nb3Var;
        fx1 fx1Var;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || this.f0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (I3()) {
            D2(true, this.U0);
            i2 = 0;
        } else if (H3()) {
            D2(false, false);
            ex1 ex1Var = this.L0;
            if (ex1Var != null) {
                if (ex1Var.j() != null) {
                    fx1Var = this.L0.j().r();
                } else {
                    fx1Var = this.L0.r();
                }
                if (fx1Var != null) {
                    i2 = fx1Var.getWebViewScrollY();
                    nb3Var = this.P0;
                    if (nb3Var != null && nb3Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            nb3Var = this.P0;
            if (nb3Var != null) {
                i3 = 0;
            }
        } else {
            D2(false, false);
            i2 = X0 + this.Q0;
            centerTitleView = this.f0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            a4(i2);
            c4(z);
        }
        z = true;
        centerTitleView = this.f0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        a4(i2);
        c4(z);
    }

    public final void V3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "setting immersive portrait fullscreen video");
            }
            fn3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = u93.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f092588).setVisibility(8);
            }
            SwanAppActionBar M1 = M1();
            if (M1 != null) {
                M1.setRightMenuStyle();
                M1.setRightZoneImmersiveStyle();
                M1.setBackgroundColor(0);
            }
            View b0 = b0();
            if (b0 != null) {
                b0.findViewById(R.id.obfuscated_res_0x7f091113).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) b0.findViewById(R.id.obfuscated_res_0x7f09018c);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            Map<String, ex1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (ex1 ex1Var : this.J0.values()) {
                    if (ex1Var != null) {
                        Z3(ex1Var);
                        ex1Var.destroy();
                    }
                }
                this.J0.clear();
            } else {
                ex1 ex1Var2 = this.L0;
                if (ex1Var2 != null) {
                    Z3(ex1Var2);
                    this.L0.destroy();
                }
            }
            this.L0 = null;
            if (W0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (!this.T0) {
                dh2.n(lw2.T().getActivity());
            }
        }
    }

    public void resume() {
        boolean z;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            boolean z2 = false;
            if (this.L0 == null) {
                z = true;
            } else {
                z = false;
            }
            String str = "";
            if (z) {
                a2 = "";
            } else {
                a2 = this.L0.a();
            }
            if (W0) {
                Log.d("SwanAppFragment", "resume() wvID: " + a2);
            }
            if (!z) {
                z2((b2() || G3()) ? true : true);
                this.L0.onResume();
                S3();
                R3("onShow");
                m13.e().i(true);
            }
            y72.i("SwanApp", "onShow");
            xx2.i(a2, true);
            if (y72.f()) {
                t92.b();
            }
            if (ya3.b0() != null) {
                str = ya3.b0().O();
            }
            fu2.H().e(str);
        }
    }

    public final void Q3() {
        Bundle o;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (o = o()) == null) {
            return;
        }
        this.I0 = Z0;
        if (W0) {
            Log.d("SwanAppFragment", "restoreArguments sPrePageParams=" + this.I0);
        }
        z03 g2 = z03.g(o.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            y03 y03Var = this.H0;
            y03Var.a = "";
            y03Var.b = "";
            y03Var.e = "";
            y03Var.f = "";
        } else {
            this.H0.a = g2.i();
            this.H0.b = this.d0.j();
            this.H0.e = this.d0.l();
            this.H0.f = this.d0.k();
        }
        y03 y03Var2 = this.H0;
        y03Var2.d = qe3.b(y03Var2.e());
        nb3 f2 = lw2.T().f(this.H0.g());
        this.P0 = f2;
        if (f2.p) {
            this.P0 = lw2.T().j(this.H0.e());
        }
        if (this.E0) {
            nb3 nb3Var = this.P0;
            nb3Var.f = false;
            nb3Var.h = true;
            nb3Var.p = true;
        }
        this.Q0 = L1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070160);
    }

    public final void S3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (TextUtils.equals(a1, this.L0.a()) && !TextUtils.equals(b1, "switchTab")) {
                return;
            }
            int o = this.M0.o(o3().g());
            cl2 cl2Var = new cl2();
            cl2Var.c = a1;
            cl2Var.d = this.L0.a();
            cl2Var.e = b1;
            cl2Var.f = this.H0.a;
            cl2Var.g = String.valueOf(o);
            b1 = "";
            if (W0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + cl2Var.c + " ,toId: " + cl2Var.d + " ,RouteType: " + cl2Var.e + " page:" + cl2Var.f + ",TabIndex: " + cl2Var.g);
            }
            lw2.T().u(cl2Var);
            a1 = this.L0.a();
        }
    }

    public void pause() {
        boolean z;
        String a2;
        PullToRefreshBaseWebView f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (this.L0 == null) {
                z = true;
            } else {
                z = false;
            }
            String str = "";
            if (z) {
                a2 = "";
            } else {
                a2 = this.L0.a();
            }
            if (W0) {
                Log.d("SwanAppFragment", "pause() wvID: " + a2);
            }
            if (!z) {
                this.L0.onPause();
                R3("onHide");
                m13.e().i(false);
            }
            if (getFloatLayer() != null && !getFloatLayer().c() && (!getFloatLayer().f() || getFloatLayer().j())) {
                getFloatLayer().g();
            }
            y72.i("SwanApp", "onHide");
            xx2.i(a2, false);
            if (!z && (f0 = this.L0.f0()) != null) {
                f0.w(false);
            }
            if (ya3.b0() != null) {
                str = ya3.b0().O();
            }
            fu2.H().f(str);
        }
    }

    public final void R3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            al2 al2Var = new al2(hashMap);
            if (W0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.L0.a());
            }
            lw2.T().u(al2Var);
        }
    }

    public void X3(y03 y03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, y03Var) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + y03Var);
            }
            if (this.M0.o(o3().g()) == this.M0.o(y03Var.g())) {
                y03 y03Var2 = this.H0;
                y03Var2.e = y03Var.e;
                y03Var2.f = y03Var.f;
                return;
            }
            this.M0.E(y03Var.g());
            onPause();
            n3(y03Var, "");
        }
    }

    public final void c4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            int i3 = 0;
            if (z) {
                zp3 zp3Var = this.u0;
                if (zp3Var != null && zp3Var.i()) {
                    i2 = po3.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.K0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.K0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.e0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = L1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070160);
            }
            i2 = 0;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.K0.getLayoutParams();
            layoutParams3.topMargin = i3;
            this.K0.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
            layoutParams22.topMargin = i2;
            this.e0.setLayoutParams(layoutParams22);
        }
    }

    public final void u3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            if (fu2.K().k(z, 1)) {
                w03.k(getContext(), this.f0, ya3.b0().W().f0().paNumber);
            } else if (ya3.b0() == null) {
            } else {
                w03.o(this.f0, ya3.b0().U().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.tieba.ea2
    public void W1(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            super.W1(view2);
            boolean z2 = false;
            if (!b2() && !G3()) {
                z = false;
            } else {
                z = true;
            }
            z2(z);
            if (K3()) {
                h2();
            }
            P3();
            this.f0.setOnDoubleClickListener(new b(this));
            if (!ih3.i()) {
                ih3.d(xa3.K().q().W());
            }
            if (I3() && G3()) {
                z2 = true;
            }
            this.U0 = z2;
            if (z2) {
                h3();
            }
        }
    }

    public final void Y3(String str, y03 y03Var) {
        ex1 ex1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, str, y03Var) == null) && this.L0 != (ex1Var = this.J0.get(str)) && ex1Var != null) {
            nb3 f2 = lw2.T().f(str);
            ex1Var.y(this.K0, f2);
            if (!ex1Var.c()) {
                ex1Var.N(this.K0, f2);
            }
            ex1Var.B(0);
            ex1 ex1Var2 = this.L0;
            if (ex1Var2 != null) {
                ex1Var2.B(8);
            }
            this.L0 = ex1Var;
            y03 y03Var2 = this.H0;
            y03Var2.e = y03Var.e;
            y03Var2.f = y03Var.f;
            ex1Var.g(y03Var2);
        }
    }

    public final void a4(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            float f2 = 1.0f;
            float f3 = (i2 - X0) * 1.0f;
            int i3 = this.Q0;
            if (i3 == 0) {
                i3 = 1;
            }
            float f4 = f3 / i3;
            if (f4 <= 0.0f) {
                f2 = 0.0f;
            } else if (f4 < 1.0f) {
                f2 = f4;
            }
            int i4 = (int) (255.0f * f2);
            if (W0 && i4 != 0 && i4 != 255) {
                Log.d("SwanAppFragment", "update bar transparent degree: " + f2 + ZeusCrashHandler.NAME_SEPERATOR + i4);
            }
            zp3 zp3Var = this.u0;
            if (zp3Var != null && zp3Var.i() && (e2 = this.u0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            nb3 nb3Var = this.P0;
            if (nb3Var != null && nb3Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.i0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public final void j3(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
            c43.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = so3.a(h2, i2, j);
            this.L0 = dh2.h(a2);
            if (W0) {
                StringBuilder sb = new StringBuilder();
                sb.append("pageUrl: ");
                sb.append(a2);
                sb.append(" is load: ");
                if (this.L0 != null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                Log.d("SwanAppFragment", sb.toString());
            }
            if (this.L0 == null) {
                if (W0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
                }
                this.L0 = i3(h2, i2, j, "");
            }
            this.L0.g(this.H0);
            nb3 f2 = lw2.T().f(i2);
            this.L0.y(this.K0, f2);
            this.L0.N(this.K0, f2);
            D3(i2);
            f3(this.L0);
            if (g2()) {
                this.J0.put(i2, this.L0);
                this.M0.f(view2, getContext(), i2);
            }
            c43.a("route", "createSlaveWebView end.");
            g3();
        }
    }

    public final ex1 i3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048615, this, str, str2, str3, str4)) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            dh2.e f2 = dh2.f(getActivity(), ih2.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = d43.q("route", str4);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                if (f2.b) {
                    str5 = "1";
                } else {
                    str5 = "0";
                }
                q.D("preload", str5);
            }
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + f2);
            }
            dh2.q(f2, new d(this, f2, str4, str2, str, str3));
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (ex1) invokeLLLL.objValue;
    }

    public final void k3(y03 y03Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048619, this, y03Var, str) == null) && this.J0.get(y03Var.d) == null) {
            String a2 = so3.a(y03Var.c, y03Var.a, y03Var.b);
            ex1 h2 = dh2.h(a2);
            if (h2 != null) {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.J0.put(y03Var.a, h2);
            } else {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = i3(y03Var.c, y03Var.a, y03Var.b, str);
                this.J0.put(y03Var.a, h2);
            }
            D3(y03Var.a);
            f3(h2);
        }
    }

    public void n3(y03 y03Var, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, y03Var, str) == null) {
            U3(this.H0);
            this.I0 = Z0;
            if (W0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.I0);
            }
            String str3 = y03Var.a;
            String str4 = y03Var.d;
            lw2 T2 = lw2.T();
            String str5 = "";
            if (TextUtils.isEmpty(str4)) {
                str2 = "";
            } else {
                str2 = str4;
            }
            nb3 f2 = T2.f(str2);
            y03 y03Var2 = this.H0;
            y03Var2.a = str3;
            if (y03Var != null) {
                str5 = y03Var.f();
            }
            y03Var2.b = str5;
            this.H0.d = str4;
            this.P0 = f2;
            boolean z = !M3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    e43.c(7, str);
                } else {
                    e43.c(6, str);
                }
            }
            if (!z) {
                Y3(str4, y03Var);
            } else {
                k3(y03Var, str);
                Y3(str3, y03Var);
            }
            if (!TextUtils.isEmpty(str)) {
                d43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                e43.a(str, y03Var);
            }
            x2(f2.b);
            E2(SwanAppConfigData.t(f2.c));
            v2(f2.a);
            P3();
            b4();
            y72.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str3);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048644, this, layoutInflater, viewGroup, bundle)) == null) {
            c43.a("route", "fragment onCreateView.");
            View b2 = i53.a().b(R.layout.obfuscated_res_0x7f0d00aa, viewGroup, false);
            this.K0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f09018c);
            W1(b2);
            V2(b2);
            this.M0 = new km3(this);
            j3(b2);
            if (!u03.e() && !u03.f()) {
                t03.b(this.L0.a(), String.valueOf(u03.d()), String.valueOf(u03.a(u03.b())));
            }
            if (V1()) {
                b2 = Y1(b2);
            }
            this.O0 = F1(b2, this);
            I2(this.L0.z());
            m13.e().m();
            return this.O0;
        }
        return (View) invokeLLL.objValue;
    }
}
