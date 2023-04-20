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
import com.baidu.tieba.ae2;
import com.baidu.tieba.c73;
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
public class d72 extends b72 implements c73.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean W0;
    public static final int X0;
    public static String Y0;
    public static vx2 Z0;
    public static String a1;
    public static String b1;
    public transient /* synthetic */ FieldHolder $fh;
    public be3 G0;
    public vx2 H0;
    public vx2 I0;
    public Map<String, bu1> J0;
    public FrameLayout K0;
    public bu1 L0;
    public hj3 M0;
    public c73 N0;
    public View O0;
    public k83 P0;
    public int Q0;
    public i92 R0;
    public zs1 S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;

    @Override // com.baidu.tieba.b72
    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class e implements om3<vc3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

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

        public e(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(vc3 vc3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vc3Var) == null) && vc3Var != null && !vc3Var.d && vc3Var.j == 1) {
                pl3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public a(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S0 = cr2.Q();
                zs1 zs1Var = this.a.S0;
                d72 d72Var = this.a;
                zs1Var.a(d72Var.b0, d72Var.d0, d72Var.getContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public b(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = this.a.L0.a();
                bi2 bi2Var = new bi2();
                bi2Var.c = cn3.a(a, "scrollViewBackToTop");
                it2.U().m(a, bi2Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public c(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
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
    public class d implements ae2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ d72 f;

        public d(d72 d72Var, ae2.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = d72Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.baidu.tieba.cu1] */
        @Override // com.baidu.tieba.ae2.f
        public void onReady() {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                me2 me2Var = new me2();
                me2Var.i = this.a.a.J();
                if (!TextUtils.isEmpty(this.b)) {
                    b13.e(this.a, this.b);
                }
                String b = nb3.b(this.c);
                me2Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                me2Var.b = str;
                if (v73.b0() != null) {
                    me2Var.c = v73.b0().d0(b);
                    me2Var.f = v73.b0().X(b);
                }
                me2Var.k = je2.c(v73.M(), me2Var.b);
                me2Var.d = it2.U().f(b).g;
                me2Var.e = String.valueOf(s42.a());
                if (!d72.W0 && !it2.U().N()) {
                    z = false;
                } else {
                    z = true;
                }
                me2Var.g = z;
                if (u33.H()) {
                    me2Var.j = y42.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    me2Var.h = str2;
                    a13.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                cl3.d();
                this.a.a.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.R(me2Var.b);
                it2.U().m(this.a.a.a(), me2.a(me2Var));
                if (ne2.b()) {
                    ne2 ne2Var = new ne2();
                    ne2Var.a = this.a.a.a();
                    it2.U().u(ne2.a(ne2Var));
                }
                fe3.F(this.a.a.a(), me2Var.b);
                if (d72.W0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + me2Var.toString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements i92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public f(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        @Override // com.baidu.tieba.i92
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIIII(1048576, this, i, i2, i3, i4) != null) {
                return;
            }
            this.a.b4(i2);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements k92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;

        public g(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d72Var;
        }

        @Override // com.baidu.tieba.k92
        public void a(eu1 eu1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, eu1Var) == null) && eu1Var != null) {
                eu1Var.t(this.a.R0);
                eu1Var.Y(this.a.B3());
                jy2.e().a(eu1Var);
            }
        }

        @Override // com.baidu.tieba.k92
        public void b(eu1 eu1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eu1Var) == null) && eu1Var != null) {
                eu1Var.U(this.a.R0);
                jy2.e().b(eu1Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends g92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 c;

        public h(d72 d72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = d72Var;
        }

        @Override // com.baidu.tieba.g92, com.baidu.tieba.j92
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
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-907011899, "Lcom/baidu/tieba/d72$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-907011899, "Lcom/baidu/tieba/d72$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    cr2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (d72.W0) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947657386, "Lcom/baidu/tieba/d72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947657386, "Lcom/baidu/tieba/d72;");
                return;
            }
        }
        W0 = fo1.a;
        X0 = ml3.g(149.0f);
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
                pl3.q().postAtFrontOfQueue(new c(this));
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

    public final g92 B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new h(this);
        }
        return (g92) invokeV.objValue;
    }

    public final k92 C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new g(this);
        }
        return (k92) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b72, com.baidu.swan.support.v4.app.Fragment
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.D0();
        }
    }

    public final void D3() {
        yo2 F0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            bu1 r3 = r3();
            if ((r3 instanceof SwanAppWebViewManager) && (F0 = ((SwanAppWebViewManager) r3).F0()) != null) {
                F0.d();
            }
        }
    }

    public boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            hj3 hj3Var = this.M0;
            if (hj3Var == null) {
                return false;
            }
            return hj3Var.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            k83 k83Var = this.P0;
            if (k83Var != null && k83Var.h) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.b72
    public k83 J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.P0;
        }
        return (k83) invokeV.objValue;
    }

    public boolean J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            k83 k83Var = this.P0;
            if (k83Var != null) {
                return TextUtils.equals(k83Var.j, ExceptionHandlerImpl.KEY_CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            SwanAppConfigData s = it2.U().s();
            if (s != null && !TextUtils.equals(s.f(), this.H0.e())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c4() {
        wx2 wx2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048608, this) != null) || (wx2Var = this.d0) == null) {
            return;
        }
        wx2Var.n();
    }

    public PullToRefreshBaseWebView h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            bu1 bu1Var = this.L0;
            if (bu1Var != null) {
                return bu1Var.h0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.G0 = oe3.c("805");
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            u73.K().q().e0().e("mapp_i_custom_navigation_bar", new e(this));
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

    @Override // com.baidu.tieba.b72, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            d1();
        }
    }

    @Override // com.baidu.tieba.b72, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            g1();
            v3(false);
        }
    }

    @NonNull
    public vx2 p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.H0;
        }
        return (vx2) invokeV.objValue;
    }

    public bu1 r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.L0;
        }
        return (bu1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b72
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
    public vx2 u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.I0;
        }
        return (vx2) invokeV.objValue;
    }

    public String w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            bu1 bu1Var = this.L0;
            if (bu1Var != null) {
                return bu1Var.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public hj3 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.M0;
        }
        return (hj3) invokeV.objValue;
    }

    public d72() {
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
        this.H0 = new vx2();
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
            Map<String, bu1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (bu1 bu1Var : this.J0.values()) {
                    if (bu1Var != null) {
                        bu1Var.e0();
                    }
                }
            } else {
                bu1 bu1Var2 = this.L0;
                if (bu1Var2 != null) {
                    bu1Var2.e0();
                }
            }
            D3();
        }
    }

    public final boolean H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SwanAppConfigData s = it2.U().s();
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
            e72 P1 = P1();
            if (P1 == null) {
                return false;
            }
            k83 k83Var = this.P0;
            if (k83Var != null && k83Var.k) {
                z = true;
            } else {
                z = false;
            }
            if (z || (s = it2.U().s()) == null) {
                return false;
            }
            return !K3(P1, s);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c73.a
    public c73 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.N0 == null) {
                if (this.O0 == null) {
                    return null;
                }
                this.N0 = new c73(this, (LinearLayout) this.O0.findViewById(R.id.obfuscated_res_0x7f09017e), M1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070159));
            }
            return this.N0;
        }
        return (c73) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b72
    public boolean h2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        wx2 wx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            it2 U = it2.U();
            if (U == null || (s = U.s()) == null || !s.n() || (wx2Var = this.d0) == null) {
                return false;
            }
            return s.r(wx2Var.i());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.b72
    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            bu1 bu1Var = this.L0;
            if (bu1Var != null) {
                bu1Var.T();
            }
            F3();
            t3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(te2.n(u73.K().getAppId()));
            }
            this.g0.u(cr2.M().a(), K1(), this.h0, false);
        }
    }

    public static d72 P3(wx2 wx2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, wx2Var)) == null) {
            d72 d72Var = new d72();
            if (wx2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", wx2Var.m());
                d72Var.l1(bundle);
            }
            return d72Var;
        }
        return (d72) invokeL.objValue;
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

    public void O3(ze3 ze3Var) {
        be3 be3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, ze3Var) == null) && (be3Var = this.G0) != null) {
            oe3.i(be3Var, ze3Var);
            this.G0 = null;
        }
    }

    public void U3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void a4(bu1 bu1Var) {
        i92 i92Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, bu1Var) != null) || (i92Var = this.R0) == null || bu1Var == null) {
            return;
        }
        bu1Var.U(i92Var);
        if (bu1Var.k() != null) {
            bu1Var.U(this.R0);
        }
    }

    public final void g3(bu1 bu1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, bu1Var) != null) || bu1Var == null) {
            return;
        }
        i92 i92Var = this.R0;
        if (i92Var != null) {
            bu1Var.t(i92Var);
        }
        bu1Var.Z(C3());
    }

    @Override // com.baidu.tieba.b72, com.baidu.searchbox.widget.SlideInterceptor
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

    @Override // com.baidu.tieba.b72
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

    @Override // com.baidu.tieba.b72
    public void z1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i2) == null) {
            if (!k83.f(this.P0)) {
                super.z1(i2);
                return;
            }
            boolean z = true;
            if (!J3()) {
                z = true ^ el3.h(this.c0);
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

    public static void V3(vx2 vx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, vx2Var) == null) {
            try {
                if (W0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + vx2Var);
                }
                if (vx2Var == null) {
                    Z0 = null;
                } else {
                    Z0 = (vx2) vx2Var.clone();
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
        it2 U = it2.U();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (U.f(str).h && this.R0 == null) {
            this.R0 = new f(this);
        }
    }

    @Override // com.baidu.tieba.b72, com.baidu.swan.support.v4.app.Fragment
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
        if ((interceptable == null || interceptable.invokeZ(1048637, this, z) == null) && cr2.K().k(z, 2)) {
            tx2.l(getContext(), this.g0, this.f0, v73.b0().W().f0().paNumber);
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
            pk3.j(new a(this), "SwanAppPageHistory");
            z03.a("route", "fragment create.");
        }
    }

    private void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (a0()) {
                resume();
            }
            ce4 ce4Var = this.g0;
            if (ce4Var != null && ce4Var.i()) {
                this.g0.B(cr2.M().a());
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
                this.g0 = new ce4(activity, this.f0, s3(), cr2.K(), new en3());
                new lx2(this.g0, this, this.h0).z();
                if (rx2.e()) {
                    this.g0.l(50);
                }
            }
        }
    }

    @Override // com.baidu.tieba.b72
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
            bu1 bu1Var = this.L0;
            if (bu1Var != null) {
                if (uu2.g(bu1Var.a())) {
                    return true;
                }
                return this.L0.I();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.b72
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
            eu1 k = this.L0.k();
            if (k != null) {
                hashMap.put("webViewUrl", k.getCurrentPageUrl());
            }
            it2.U().u(new wh2("sharebtn", hashMap));
        }
    }

    @Override // com.baidu.tieba.b72
    public void l2() {
        wx2 Q1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            S1();
            ye3 ye3Var = new ye3();
            ye3Var.e = "gohome";
            ye3Var.c = "bar";
            d72 H = it2.U().H();
            if (H == null) {
                Q1 = null;
            } else {
                Q1 = H.Q1();
            }
            if (Q1 != null && !TextUtils.isEmpty(Q1.i())) {
                ye3Var.a("page", Q1.i());
            }
            D1(ye3Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.cu1] */
    @NonNull
    public Pair<Integer, Integer> q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            bu1 bu1Var = this.L0;
            if (bu1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = bu1Var.r().getCurrentWebView();
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
            Map<String, bu1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, bu1> entry : this.J0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().a());
                    }
                }
            }
            bu1 bu1Var = this.L0;
            if (bu1Var != null) {
                String a2 = bu1Var.a();
                if (!arrayList.contains(a2)) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean K3(e72 e72Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, e72Var, swanAppConfigData)) == null) {
            b72 j = e72Var.j(0);
            if (j == null || !(j instanceof d72)) {
                return false;
            }
            String e2 = ((d72) j).p3().e();
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
        k83 k83Var;
        cu1 cu1Var;
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
            bu1 bu1Var = this.L0;
            if (bu1Var != null) {
                if (bu1Var.k() != null) {
                    cu1Var = this.L0.k().r();
                } else {
                    cu1Var = this.L0.r();
                }
                if (cu1Var != null) {
                    i2 = cu1Var.getWebViewScrollY();
                    k83Var = this.P0;
                    if (k83Var != null && k83Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            k83Var = this.P0;
            if (k83Var != null) {
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
            ck3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = r63.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f092419).setVisibility(8);
            }
            SwanAppActionBar N1 = N1();
            if (N1 != null) {
                N1.setRightMenuStyle();
                N1.setRightZoneImmersiveStyle();
                N1.setBackgroundColor(0);
            }
            View b0 = b0();
            if (b0 != null) {
                b0.findViewById(R.id.obfuscated_res_0x7f091080).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) b0.findViewById(R.id.obfuscated_res_0x7f09017f);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            Map<String, bu1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (bu1 bu1Var : this.J0.values()) {
                    if (bu1Var != null) {
                        a4(bu1Var);
                        bu1Var.destroy();
                    }
                }
                this.J0.clear();
            } else {
                bu1 bu1Var2 = this.L0;
                if (bu1Var2 != null) {
                    a4(bu1Var2);
                    this.L0.destroy();
                }
            }
            this.L0 = null;
            if (W0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (!this.T0) {
                ae2.n(it2.U().getActivity());
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
                jy2.e().i(true);
            }
            v42.i("SwanApp", "onShow");
            uu2.i(a2, true);
            if (v42.f()) {
                q62.b();
            }
            if (v73.b0() != null) {
                str = v73.b0().O();
            }
            cr2.H().e(str);
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
        wx2 g2 = wx2.g(p.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            vx2 vx2Var = this.H0;
            vx2Var.a = "";
            vx2Var.b = "";
            vx2Var.e = "";
            vx2Var.f = "";
        } else {
            this.H0.a = g2.i();
            this.H0.b = this.d0.j();
            this.H0.e = this.d0.l();
            this.H0.f = this.d0.k();
        }
        vx2 vx2Var2 = this.H0;
        vx2Var2.d = nb3.b(vx2Var2.e());
        k83 f2 = it2.U().f(this.H0.g());
        this.P0 = f2;
        if (f2.p) {
            this.P0 = it2.U().j(this.H0.e());
        }
        if (this.E0) {
            k83 k83Var = this.P0;
            k83Var.f = false;
            k83Var.h = true;
            k83Var.p = true;
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
            zh2 zh2Var = new zh2();
            zh2Var.c = a1;
            zh2Var.d = this.L0.a();
            zh2Var.e = b1;
            zh2Var.f = this.H0.a;
            zh2Var.g = String.valueOf(o);
            b1 = "";
            if (W0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + zh2Var.c + " ,toId: " + zh2Var.d + " ,RouteType: " + zh2Var.e + " page:" + zh2Var.f + ",TabIndex: " + zh2Var.g);
            }
            it2.U().u(zh2Var);
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
                jy2.e().i(false);
            }
            if (d() != null && !d().c() && (!d().f() || d().j())) {
                d().g();
            }
            v42.i("SwanApp", "onHide");
            uu2.i(a2, false);
            if (!z && (h0 = this.L0.h0()) != null) {
                h0.w(false);
            }
            if (v73.b0() != null) {
                str = v73.b0().O();
            }
            cr2.H().f(str);
        }
    }

    public final void S3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            xh2 xh2Var = new xh2(hashMap);
            if (W0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.L0.a());
            }
            it2.U().u(xh2Var);
        }
    }

    public void Y3(vx2 vx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, vx2Var) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + vx2Var);
            }
            if (this.M0.o(p3().g()) == this.M0.o(vx2Var.g())) {
                vx2 vx2Var2 = this.H0;
                vx2Var2.e = vx2Var.e;
                vx2Var2.f = vx2Var.f;
                return;
            }
            this.M0.E(vx2Var.g());
            onPause();
            o3(vx2Var, "");
        }
    }

    public final void d4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            int i3 = 0;
            if (z) {
                wm3 wm3Var = this.u0;
                if (wm3Var != null && wm3Var.i()) {
                    i2 = ml3.t();
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
            if (cr2.K().k(z, 1)) {
                tx2.k(getContext(), this.f0, v73.b0().W().f0().paNumber);
            } else if (v73.b0() == null) {
            } else {
                tx2.o(this.f0, v73.b0().U().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.tieba.b72
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
            if (!fe3.i()) {
                fe3.d(u73.K().q().W());
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

    public final void Z3(String str, vx2 vx2Var) {
        bu1 bu1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, str, vx2Var) == null) && this.L0 != (bu1Var = this.J0.get(str)) && bu1Var != null) {
            k83 f2 = it2.U().f(str);
            bu1Var.z(this.K0, f2);
            if (!bu1Var.c()) {
                bu1Var.O(this.K0, f2);
            }
            bu1Var.C(0);
            bu1 bu1Var2 = this.L0;
            if (bu1Var2 != null) {
                bu1Var2.C(8);
            }
            this.L0 = bu1Var;
            vx2 vx2Var2 = this.H0;
            vx2Var2.e = vx2Var.e;
            vx2Var2.f = vx2Var.f;
            bu1Var.h(vx2Var2);
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
            wm3 wm3Var = this.u0;
            if (wm3Var != null && wm3Var.i() && (e2 = this.u0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            k83 k83Var = this.P0;
            if (k83Var != null && k83Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
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
            z03.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = pl3.a(h2, i2, j);
            this.L0 = ae2.h(a2);
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
            k83 f2 = it2.U().f(i2);
            this.L0.z(this.K0, f2);
            this.L0.O(this.K0, f2);
            E3(i2);
            g3(this.L0);
            if (h2()) {
                this.J0.put(i2, this.L0);
                this.M0.f(view2, getContext(), i2);
            }
            z03.a("route", "createSlaveWebView end.");
            h3();
        }
    }

    public final bu1 j3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048618, this, str, str2, str3, str4)) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            ae2.e f2 = ae2.f(getActivity(), fe2.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = a13.q("route", str4);
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
            ae2.q(f2, new d(this, f2, str4, str2, str, str3));
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (bu1) invokeLLLL.objValue;
    }

    public final void l3(vx2 vx2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048621, this, vx2Var, str) == null) && this.J0.get(vx2Var.d) == null) {
            String a2 = pl3.a(vx2Var.c, vx2Var.a, vx2Var.b);
            bu1 h2 = ae2.h(a2);
            if (h2 != null) {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.J0.put(vx2Var.a, h2);
            } else {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = j3(vx2Var.c, vx2Var.a, vx2Var.b, str);
                this.J0.put(vx2Var.a, h2);
            }
            E3(vx2Var.a);
            g3(h2);
        }
    }

    public void o3(vx2 vx2Var, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, vx2Var, str) == null) {
            V3(this.H0);
            this.I0 = Z0;
            if (W0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.I0);
            }
            String str3 = vx2Var.a;
            String str4 = vx2Var.d;
            it2 U = it2.U();
            String str5 = "";
            if (TextUtils.isEmpty(str4)) {
                str2 = "";
            } else {
                str2 = str4;
            }
            k83 f2 = U.f(str2);
            vx2 vx2Var2 = this.H0;
            vx2Var2.a = str3;
            if (vx2Var != null) {
                str5 = vx2Var.f();
            }
            vx2Var2.b = str5;
            this.H0.d = str4;
            this.P0 = f2;
            boolean z = !N3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    b13.c(7, str);
                } else {
                    b13.c(6, str);
                }
            }
            if (!z) {
                Z3(str4, vx2Var);
            } else {
                l3(vx2Var, str);
                Z3(str3, vx2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                a13.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                b13.a(str, vx2Var);
            }
            y2(f2.b);
            F2(SwanAppConfigData.t(f2.c));
            w2(f2.a);
            Q3();
            c4();
            v42.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str3);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048645, this, layoutInflater, viewGroup, bundle)) == null) {
            z03.a("route", "fragment onCreateView.");
            View b2 = f23.a().b(R.layout.obfuscated_res_0x7f0d00a8, viewGroup, false);
            this.K0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f09017f);
            X1(b2);
            W2(b2);
            this.M0 = new hj3(this);
            k3(b2);
            if (!rx2.e() && !rx2.f()) {
                qx2.b(this.L0.a(), String.valueOf(rx2.d()), String.valueOf(rx2.a(rx2.b())));
            }
            if (W1()) {
                b2 = Z1(b2);
            }
            this.O0 = G1(b2, this);
            J2(this.L0.A());
            jy2.e().m();
            return this.O0;
        }
        return (View) invokeLLL.objValue;
    }
}
