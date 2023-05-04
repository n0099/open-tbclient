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
import com.baidu.tieba.ce2;
import com.baidu.tieba.e73;
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
/* loaded from: classes4.dex */
public class f72 extends d72 implements e73.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean W0;
    public static final int X0;
    public static String Y0;
    public static xx2 Z0;
    public static String a1;
    public static String b1;
    public transient /* synthetic */ FieldHolder $fh;
    public de3 G0;
    public xx2 H0;
    public xx2 I0;
    public Map<String, du1> J0;
    public FrameLayout K0;
    public du1 L0;
    public jj3 M0;
    public e73 N0;
    public View O0;
    public m83 P0;
    public int Q0;
    public k92 R0;
    public bt1 S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;

    @Override // com.baidu.tieba.d72
    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class e implements qm3<xc3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        /* loaded from: classes4.dex */
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
                this.a.a.E2(true, false);
            }
        }

        public e(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(xc3 xc3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xc3Var) == null) && xc3Var != null && !xc3Var.d && xc3Var.j == 1) {
                rl3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        public a(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S0 = er2.Q();
                bt1 bt1Var = this.a.S0;
                f72 f72Var = this.a;
                bt1Var.a(f72Var.b0, f72Var.d0, f72Var.getContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        public b(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = this.a.L0.a();
                di2 di2Var = new di2();
                di2Var.c = en3.a(a, "scrollViewBackToTop");
                kt2.U().m(a, di2Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        public c(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.m3();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ce2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ f72 f;

        public d(f72 f72Var, ce2.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = f72Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.baidu.tieba.eu1] */
        @Override // com.baidu.tieba.ce2.f
        public void onReady() {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oe2 oe2Var = new oe2();
                oe2Var.i = this.a.a.J();
                if (!TextUtils.isEmpty(this.b)) {
                    d13.e(this.a, this.b);
                }
                String b = pb3.b(this.c);
                oe2Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                oe2Var.b = str;
                if (x73.b0() != null) {
                    oe2Var.c = x73.b0().d0(b);
                    oe2Var.f = x73.b0().X(b);
                }
                oe2Var.k = le2.c(x73.M(), oe2Var.b);
                oe2Var.d = kt2.U().f(b).g;
                oe2Var.e = String.valueOf(u42.a());
                if (!f72.W0 && !kt2.U().N()) {
                    z = false;
                } else {
                    z = true;
                }
                oe2Var.g = z;
                if (w33.H()) {
                    oe2Var.j = a52.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    oe2Var.h = str2;
                    c13.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                el3.d();
                this.a.a.s().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.R(oe2Var.b);
                kt2.U().m(this.a.a.a(), oe2.a(oe2Var));
                if (pe2.b()) {
                    pe2 pe2Var = new pe2();
                    pe2Var.a = this.a.a.a();
                    kt2.U().u(pe2.a(pe2Var));
                }
                he3.F(this.a.a.a(), oe2Var.b);
                if (f72.W0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + oe2Var.toString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements k92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        public f(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        @Override // com.baidu.tieba.k92
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIIII(1048576, this, i, i2, i3, i4) != null) {
                return;
            }
            this.a.b4(i2);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements m92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 a;

        public g(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f72Var;
        }

        @Override // com.baidu.tieba.m92
        public void a(gu1 gu1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, gu1Var) == null) && gu1Var != null) {
                gu1Var.t(this.a.R0);
                gu1Var.Y(this.a.B3());
                ly2.e().a(gu1Var);
            }
        }

        @Override // com.baidu.tieba.m92
        public void b(gu1 gu1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gu1Var) == null) && gu1Var != null) {
                gu1Var.U(this.a.R0);
                ly2.e().b(gu1Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends i92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f72 c;

        public h(f72 f72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = f72Var;
        }

        @Override // com.baidu.tieba.i92, com.baidu.tieba.l92
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.y2(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-849753597, "Lcom/baidu/tieba/f72$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-849753597, "Lcom/baidu/tieba/f72$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    er2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (f72.W0) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947716968, "Lcom/baidu/tieba/f72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947716968, "Lcom/baidu/tieba/f72;");
                return;
            }
        }
        W0 = ho1.a;
        X0 = ol3.g(149.0f);
        Y0 = "-1";
        a1 = "-1";
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A0();
            this.C0.a();
            if (i.b()) {
                rl3.q().postAtFrontOfQueue(new c(this));
            } else {
                m3();
            }
        }
    }

    public FrameLayout A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.K0;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public final i92 B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new h(this);
        }
        return (i92) invokeV.objValue;
    }

    public final m92 C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new g(this);
        }
        return (m92) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d72, com.baidu.swan.support.v4.app.Fragment
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.D0();
        }
    }

    public final void D3() {
        ap2 F0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            du1 r3 = r3();
            if ((r3 instanceof SwanAppWebViewManager) && (F0 = ((SwanAppWebViewManager) r3).F0()) != null) {
                F0.d();
            }
        }
    }

    public boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            jj3 jj3Var = this.M0;
            if (jj3Var == null) {
                return false;
            }
            return jj3Var.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            m83 m83Var = this.P0;
            if (m83Var != null && m83Var.h) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.d72
    public m83 J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.P0;
        }
        return (m83) invokeV.objValue;
    }

    public boolean J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            m83 m83Var = this.P0;
            if (m83Var != null) {
                return TextUtils.equals(m83Var.j, ExceptionHandlerImpl.KEY_CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            SwanAppConfigData s = kt2.U().s();
            if (s != null && !TextUtils.equals(s.f(), this.H0.e())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c4() {
        yx2 yx2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048608, this) != null) || (yx2Var = this.d0) == null) {
            return;
        }
        yx2Var.n();
    }

    public PullToRefreshBaseWebView h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            du1 du1Var = this.L0;
            if (du1Var != null) {
                return du1Var.h0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.G0 = qe3.c("805");
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            w73.K().q().e0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.P0.j = "default";
            x1();
            Q3();
        }
    }

    @Override // com.baidu.tieba.d72, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            d1();
        }
    }

    @Override // com.baidu.tieba.d72, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            g1();
            v3(false);
        }
    }

    @NonNull
    public xx2 p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.H0;
        }
        return (xx2) invokeV.objValue;
    }

    public du1 r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.L0;
        }
        return (du1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d72
    public void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            super.s2();
            Q3();
            if (this.V0) {
                W3();
            }
        }
    }

    public final int s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (g2()) {
                if (M3()) {
                    return 18;
                }
                return 17;
            } else if (M3()) {
                return 12;
            } else {
                return 15;
            }
        }
        return invokeV.intValue;
    }

    @Nullable
    public xx2 u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.I0;
        }
        return (xx2) invokeV.objValue;
    }

    public String w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            du1 du1Var = this.L0;
            if (du1Var != null) {
                return du1Var.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public jj3 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.M0;
        }
        return (jj3) invokeV.objValue;
    }

    public f72() {
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
        this.H0 = new xx2();
        this.J0 = new TreeMap();
        this.Q0 = 0;
        this.T0 = false;
        this.U0 = false;
        this.V0 = false;
    }

    private void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (a0()) {
                pause();
            }
            if (W0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.L0.a())));
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.C0();
            Map<String, du1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (du1 du1Var : this.J0.values()) {
                    if (du1Var != null) {
                        du1Var.e0();
                    }
                }
            } else {
                du1 du1Var2 = this.L0;
                if (du1Var2 != null) {
                    du1Var2.e0();
                }
            }
            D3();
        }
    }

    public final boolean H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SwanAppConfigData s = kt2.U().s();
            boolean z = false;
            if (s == null) {
                return false;
            }
            return !((TextUtils.equals(s.f(), this.H0.a) || s.r(this.H0.a)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    public final boolean L3() {
        InterceptResult invokeV;
        boolean z;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            g72 P1 = P1();
            if (P1 == null) {
                return false;
            }
            m83 m83Var = this.P0;
            if (m83Var != null && m83Var.k) {
                z = true;
            } else {
                z = false;
            }
            if (z || (s = kt2.U().s()) == null) {
                return false;
            }
            return !K3(P1, s);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.e73.a
    public e73 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.N0 == null) {
                if (this.O0 == null) {
                    return null;
                }
                this.N0 = new e73(this, (LinearLayout) this.O0.findViewById(R.id.obfuscated_res_0x7f09017d), M1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070159));
            }
            return this.N0;
        }
        return (e73) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d72
    public boolean h2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        yx2 yx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            kt2 U = kt2.U();
            if (U == null || (s = U.s()) == null || !s.n() || (yx2Var = this.d0) == null) {
                return false;
            }
            return s.r(yx2Var.i());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.d72
    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            du1 du1Var = this.L0;
            if (du1Var != null) {
                du1Var.T();
            }
            F3();
            t3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(ve2.n(w73.K().getAppId()));
            }
            this.g0.u(er2.M().a(), K1(), this.h0, false);
        }
    }

    public static f72 P3(yx2 yx2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, yx2Var)) == null) {
            f72 f72Var = new f72();
            if (yx2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", yx2Var.m());
                f72Var.l1(bundle);
            }
            return f72Var;
        }
        return (f72) invokeL.objValue;
    }

    public static void X3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            b1 = str;
        }
    }

    public final boolean N3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (this.J0.isEmpty() || this.J0.get(str) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void O3(bf3 bf3Var) {
        de3 de3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, bf3Var) == null) && (de3Var = this.G0) != null) {
            qe3.i(de3Var, bf3Var);
            this.G0 = null;
        }
    }

    public void U3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void a4(du1 du1Var) {
        k92 k92Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, du1Var) != null) || (k92Var = this.R0) == null || du1Var == null) {
            return;
        }
        du1Var.U(k92Var);
        if (du1Var.k() != null) {
            du1Var.U(this.R0);
        }
    }

    public final void g3(du1 du1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, du1Var) != null) || du1Var == null) {
            return;
        }
        k92 k92Var = this.R0;
        if (k92Var != null) {
            du1Var.t(k92Var);
        }
        du1Var.Z(C3());
    }

    @Override // com.baidu.tieba.d72, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, motionEvent)) == null) {
            if (c2() && this.L0.isSlidable(motionEvent)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void t0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, activity) == null) {
            super.t0(activity);
            if (W0) {
                Log.d("SwanAppFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Override // com.baidu.tieba.d72
    public boolean w2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i2)) == null) {
            boolean w2 = super.w2(i2);
            Q3();
            return w2;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.d72
    public void y1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            if (!m83.f(this.P0)) {
                super.y1(i2);
                return;
            }
            boolean z = true;
            if (!J3()) {
                z = true ^ gl3.h(this.c0);
            }
            A1(i2, z);
            Q3();
        }
    }

    public String z3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, str)) == null) {
            if (this.J0.containsKey(str)) {
                return this.J0.get(str).a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void V3(xx2 xx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, xx2Var) == null) {
            try {
                if (W0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + xx2Var);
                }
                if (xx2Var == null) {
                    Z0 = null;
                } else {
                    Z0 = (xx2) xx2Var.clone();
                }
            } catch (Exception e2) {
                if (W0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void E3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || J3()) {
            return;
        }
        kt2 U = kt2.U();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (U.f(str).h && this.R0 == null) {
            this.R0 = new f(this);
        }
    }

    @Override // com.baidu.tieba.d72, com.baidu.swan.support.v4.app.Fragment
    public void o1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048625, this, z) != null) || !m0()) {
            return;
        }
        super.o1(z);
        if (W0) {
            Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
        }
        if (z) {
            resume();
            v3(false);
            return;
        }
        pause();
    }

    public final void t3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048637, this, z) == null) && er2.K().k(z, 2)) {
            vx2.l(getContext(), this.g0, this.f0, x73.b0().W().f0().paNumber);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void w0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, bundle) == null) {
            super.w0(bundle);
            R3();
            if (W0) {
                Log.d("SwanAppFragment", "onCreate() obj: " + this);
            }
            rk3.j(new a(this), "SwanAppPageHistory");
            b13.a("route", "fragment create.");
        }
    }

    private void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (a0()) {
                resume();
            }
            ee4 ee4Var = this.g0;
            if (ee4Var != null && ee4Var.i()) {
                this.g0.B(er2.M().a());
            }
            if (W0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.L0.a())));
            }
        }
    }

    @DebugTrace
    public void F3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity != null && this.g0 == null) {
                this.g0 = new ee4(activity, this.f0, s3(), er2.K(), new gn3());
                new nx2(this.g0, this, this.h0).z();
                if (tx2.e()) {
                    this.g0.l(50);
                }
            }
        }
    }

    @Override // com.baidu.tieba.d72
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (d() != null && d().e() && d().f()) {
                return true;
            }
            if ((d() != null && d().c()) || PaymentManager.k()) {
                return true;
            }
            du1 du1Var = this.L0;
            if (du1Var != null) {
                if (wu2.g(du1Var.a())) {
                    return true;
                }
                return this.L0.I();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.d72
    public void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.L0 == null) {
                if (W0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            gu1 k = this.L0.k();
            if (k != null) {
                hashMap.put("webViewUrl", k.getCurrentPageUrl());
            }
            kt2.U().u(new yh2("sharebtn", hashMap));
        }
    }

    @Override // com.baidu.tieba.d72
    public void l2() {
        yx2 Q1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            S1();
            af3 af3Var = new af3();
            af3Var.e = "gohome";
            af3Var.c = "bar";
            f72 H = kt2.U().H();
            if (H == null) {
                Q1 = null;
            } else {
                Q1 = H.Q1();
            }
            if (Q1 != null && !TextUtils.isEmpty(Q1.i())) {
                af3Var.a("page", Q1.i());
            }
            D1(af3Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.eu1] */
    @NonNull
    public Pair<Integer, Integer> q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            du1 du1Var = this.L0;
            if (du1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = du1Var.s().getCurrentWebView();
            if (currentWebView == null) {
                return new Pair<>(0, 0);
            }
            return new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public List<String> x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, du1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, du1> entry : this.J0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().a());
                    }
                }
            }
            du1 du1Var = this.L0;
            if (du1Var != null) {
                String a2 = du1Var.a();
                if (!arrayList.contains(a2)) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean K3(g72 g72Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, g72Var, swanAppConfigData)) == null) {
            d72 j = g72Var.j(0);
            if (j == null || !(j instanceof f72)) {
                return false;
            }
            String e2 = ((f72) j).p3().e();
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
    public final void Q3() {
        int i2;
        m83 m83Var;
        eu1 eu1Var;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || this.f0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (J3()) {
            E2(true, this.U0);
            i2 = 0;
        } else if (I3()) {
            E2(false, false);
            du1 du1Var = this.L0;
            if (du1Var != null) {
                if (du1Var.k() != null) {
                    eu1Var = this.L0.k().s();
                } else {
                    eu1Var = this.L0.s();
                }
                if (eu1Var != null) {
                    i2 = eu1Var.getWebViewScrollY();
                    m83Var = this.P0;
                    if (m83Var != null && m83Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            m83Var = this.P0;
            if (m83Var != null) {
                i3 = 0;
            }
        } else {
            E2(false, false);
            i2 = X0 + this.Q0;
            centerTitleView = this.f0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            b4(i2);
            d4(z);
        }
        z = true;
        centerTitleView = this.f0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        b4(i2);
        d4(z);
    }

    public final void W3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "setting immersive portrait fullscreen video");
            }
            ek3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = t63.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f092432).setVisibility(8);
            }
            SwanAppActionBar N1 = N1();
            if (N1 != null) {
                N1.setRightMenuStyle();
                N1.setRightZoneImmersiveStyle();
                N1.setBackgroundColor(0);
            }
            View b0 = b0();
            if (b0 != null) {
                b0.findViewById(R.id.obfuscated_res_0x7f09108f).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) b0.findViewById(R.id.obfuscated_res_0x7f09017e);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            Map<String, du1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (du1 du1Var : this.J0.values()) {
                    if (du1Var != null) {
                        a4(du1Var);
                        du1Var.destroy();
                    }
                }
                this.J0.clear();
            } else {
                du1 du1Var2 = this.L0;
                if (du1Var2 != null) {
                    a4(du1Var2);
                    this.L0.destroy();
                }
            }
            this.L0 = null;
            if (W0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (!this.T0) {
                ce2.n(kt2.U().getActivity());
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
                A2((c2() || H3()) ? true : true);
                this.L0.onResume();
                T3();
                S3("onShow");
                ly2.e().i(true);
            }
            x42.i("SwanApp", "onShow");
            wu2.i(a2, true);
            if (x42.f()) {
                s62.b();
            }
            if (x73.b0() != null) {
                str = x73.b0().O();
            }
            er2.H().e(str);
        }
    }

    public final void R3() {
        Bundle p;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (p = p()) == null) {
            return;
        }
        this.I0 = Z0;
        if (W0) {
            Log.d("SwanAppFragment", "restoreArguments sPrePageParams=" + this.I0);
        }
        yx2 g2 = yx2.g(p.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            xx2 xx2Var = this.H0;
            xx2Var.a = "";
            xx2Var.b = "";
            xx2Var.e = "";
            xx2Var.f = "";
        } else {
            this.H0.a = g2.i();
            this.H0.b = this.d0.j();
            this.H0.e = this.d0.l();
            this.H0.f = this.d0.k();
        }
        xx2 xx2Var2 = this.H0;
        xx2Var2.d = pb3.b(xx2Var2.e());
        m83 f2 = kt2.U().f(this.H0.g());
        this.P0 = f2;
        if (f2.p) {
            this.P0 = kt2.U().j(this.H0.e());
        }
        if (this.E0) {
            m83 m83Var = this.P0;
            m83Var.f = false;
            m83Var.h = true;
            m83Var.p = true;
        }
        this.Q0 = M1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070159);
    }

    public final void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (TextUtils.equals(a1, this.L0.a()) && !TextUtils.equals(b1, "switchTab")) {
                return;
            }
            int o = this.M0.o(p3().g());
            bi2 bi2Var = new bi2();
            bi2Var.c = a1;
            bi2Var.d = this.L0.a();
            bi2Var.e = b1;
            bi2Var.f = this.H0.a;
            bi2Var.g = String.valueOf(o);
            b1 = "";
            if (W0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + bi2Var.c + " ,toId: " + bi2Var.d + " ,RouteType: " + bi2Var.e + " page:" + bi2Var.f + ",TabIndex: " + bi2Var.g);
            }
            kt2.U().u(bi2Var);
            a1 = this.L0.a();
        }
    }

    public void pause() {
        boolean z;
        String a2;
        PullToRefreshBaseWebView h0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
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
                S3("onHide");
                ly2.e().i(false);
            }
            if (d() != null && !d().c() && (!d().f() || d().j())) {
                d().g();
            }
            x42.i("SwanApp", "onHide");
            wu2.i(a2, false);
            if (!z && (h0 = this.L0.h0()) != null) {
                h0.w(false);
            }
            if (x73.b0() != null) {
                str = x73.b0().O();
            }
            er2.H().f(str);
        }
    }

    public final void S3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            zh2 zh2Var = new zh2(hashMap);
            if (W0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.L0.a());
            }
            kt2.U().u(zh2Var);
        }
    }

    public void Y3(xx2 xx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, xx2Var) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + xx2Var);
            }
            if (this.M0.o(p3().g()) == this.M0.o(xx2Var.g())) {
                xx2 xx2Var2 = this.H0;
                xx2Var2.e = xx2Var.e;
                xx2Var2.f = xx2Var.f;
                return;
            }
            this.M0.E(xx2Var.g());
            onPause();
            o3(xx2Var, "");
        }
    }

    public final void d4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            int i3 = 0;
            if (z) {
                ym3 ym3Var = this.u0;
                if (ym3Var != null && ym3Var.i()) {
                    i2 = ol3.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.K0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.K0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.e0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = M1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070159);
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

    public final void v3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            if (er2.K().k(z, 1)) {
                vx2.k(getContext(), this.f0, x73.b0().W().f0().paNumber);
            } else if (x73.b0() == null) {
            } else {
                vx2.o(this.f0, x73.b0().U().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.tieba.d72
    public void X1(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view2) == null) {
            super.X1(view2);
            boolean z2 = false;
            if (!c2() && !H3()) {
                z = false;
            } else {
                z = true;
            }
            A2(z);
            if (L3()) {
                i2();
            }
            Q3();
            this.f0.setOnDoubleClickListener(new b(this));
            if (!he3.i()) {
                he3.d(w73.K().q().W());
            }
            if (J3() && H3()) {
                z2 = true;
            }
            this.U0 = z2;
            if (z2) {
                i3();
            }
        }
    }

    public final void Z3(String str, xx2 xx2Var) {
        du1 du1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, str, xx2Var) == null) && this.L0 != (du1Var = this.J0.get(str)) && du1Var != null) {
            m83 f2 = kt2.U().f(str);
            du1Var.z(this.K0, f2);
            if (!du1Var.c()) {
                du1Var.O(this.K0, f2);
            }
            du1Var.C(0);
            du1 du1Var2 = this.L0;
            if (du1Var2 != null) {
                du1Var2.C(8);
            }
            this.L0 = du1Var;
            xx2 xx2Var2 = this.H0;
            xx2Var2.e = xx2Var.e;
            xx2Var2.f = xx2Var.f;
            du1Var.h(xx2Var2);
        }
    }

    public final void b4(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
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
            ym3 ym3Var = this.u0;
            if (ym3Var != null && ym3Var.i() && (e2 = this.u0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            m83 m83Var = this.P0;
            if (m83Var != null && m83Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.i0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public final void k3(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, view2) == null) {
            b13.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = rl3.a(h2, i2, j);
            this.L0 = ce2.h(a2);
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
                this.L0 = j3(h2, i2, j, "");
            }
            this.L0.h(this.H0);
            m83 f2 = kt2.U().f(i2);
            this.L0.z(this.K0, f2);
            this.L0.O(this.K0, f2);
            E3(i2);
            g3(this.L0);
            if (h2()) {
                this.J0.put(i2, this.L0);
                this.M0.f(view2, getContext(), i2);
            }
            b13.a("route", "createSlaveWebView end.");
            h3();
        }
    }

    public final du1 j3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048618, this, str, str2, str3, str4)) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            ce2.e f2 = ce2.f(getActivity(), he2.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = c13.q("route", str4);
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
            ce2.q(f2, new d(this, f2, str4, str2, str, str3));
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (du1) invokeLLLL.objValue;
    }

    public final void l3(xx2 xx2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048621, this, xx2Var, str) == null) && this.J0.get(xx2Var.d) == null) {
            String a2 = rl3.a(xx2Var.c, xx2Var.a, xx2Var.b);
            du1 h2 = ce2.h(a2);
            if (h2 != null) {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.J0.put(xx2Var.a, h2);
            } else {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = j3(xx2Var.c, xx2Var.a, xx2Var.b, str);
                this.J0.put(xx2Var.a, h2);
            }
            E3(xx2Var.a);
            g3(h2);
        }
    }

    public void o3(xx2 xx2Var, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, xx2Var, str) == null) {
            V3(this.H0);
            this.I0 = Z0;
            if (W0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.I0);
            }
            String str3 = xx2Var.a;
            String str4 = xx2Var.d;
            kt2 U = kt2.U();
            String str5 = "";
            if (TextUtils.isEmpty(str4)) {
                str2 = "";
            } else {
                str2 = str4;
            }
            m83 f2 = U.f(str2);
            xx2 xx2Var2 = this.H0;
            xx2Var2.a = str3;
            if (xx2Var != null) {
                str5 = xx2Var.f();
            }
            xx2Var2.b = str5;
            this.H0.d = str4;
            this.P0 = f2;
            boolean z = !N3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    d13.c(7, str);
                } else {
                    d13.c(6, str);
                }
            }
            if (!z) {
                Z3(str4, xx2Var);
            } else {
                l3(xx2Var, str);
                Z3(str3, xx2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                c13.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                d13.a(str, xx2Var);
            }
            y2(f2.b);
            F2(SwanAppConfigData.t(f2.c));
            w2(f2.a);
            Q3();
            c4();
            x42.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str3);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048646, this, layoutInflater, viewGroup, bundle)) == null) {
            b13.a("route", "fragment onCreateView.");
            View b2 = h23.a().b(R.layout.obfuscated_res_0x7f0d00a9, viewGroup, false);
            this.K0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f09017e);
            X1(b2);
            W2(b2);
            this.M0 = new jj3(this);
            k3(b2);
            if (!tx2.e() && !tx2.f()) {
                sx2.b(this.L0.a(), String.valueOf(tx2.d()), String.valueOf(tx2.a(tx2.b())));
            }
            if (W1()) {
                b2 = Z1(b2);
            }
            this.O0 = G1(b2, this);
            J2(this.L0.A());
            ly2.e().m();
            return this.O0;
        }
        return (View) invokeLLL.objValue;
    }
}
