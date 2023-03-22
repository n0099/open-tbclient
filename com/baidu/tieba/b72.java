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
import com.baidu.tieba.a73;
import com.baidu.tieba.yd2;
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
/* loaded from: classes3.dex */
public class b72 extends z62 implements a73.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean W0;
    public static final int X0;
    public static String Y0;
    public static tx2 Z0;
    public static String a1;
    public static String b1;
    public transient /* synthetic */ FieldHolder $fh;
    public zd3 G0;
    public tx2 H0;
    public tx2 I0;
    public Map<String, zt1> J0;
    public FrameLayout K0;
    public zt1 L0;
    public fj3 M0;
    public a73 N0;
    public View O0;
    public i83 P0;
    public int Q0;
    public g92 R0;
    public xs1 S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;

    @Override // com.baidu.tieba.z62
    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class e implements mm3<tc3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b72 a;

        /* loaded from: classes3.dex */
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

        public e(b72 b72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tc3Var) == null) && tc3Var != null && !tc3Var.d && tc3Var.j == 1) {
                nl3.e0(new a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b72 a;

        public a(b72 b72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b72Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S0 = ar2.Q();
                xs1 xs1Var = this.a.S0;
                b72 b72Var = this.a;
                xs1Var.a(b72Var.b0, b72Var.d0, b72Var.getContext());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b72 a;

        public b(b72 b72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b72Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = this.a.L0.a();
                zh2 zh2Var = new zh2();
                zh2Var.c = an3.a(a, "scrollViewBackToTop");
                gt2.U().m(a, zh2Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b72 a;

        public c(b72 b72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b72Var;
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

    /* loaded from: classes3.dex */
    public class d implements yd2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ b72 f;

        public d(b72 b72Var, yd2.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b72Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = b72Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.baidu.tieba.au1] */
        @Override // com.baidu.tieba.yd2.f
        public void onReady() {
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ke2 ke2Var = new ke2();
                ke2Var.i = this.a.a.J();
                if (!TextUtils.isEmpty(this.b)) {
                    z03.e(this.a, this.b);
                }
                String b = lb3.b(this.c);
                ke2Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                ke2Var.b = str;
                if (t73.b0() != null) {
                    ke2Var.c = t73.b0().d0(b);
                    ke2Var.f = t73.b0().X(b);
                }
                ke2Var.k = he2.c(t73.M(), ke2Var.b);
                ke2Var.d = gt2.U().f(b).g;
                ke2Var.e = String.valueOf(q42.a());
                if (!b72.W0 && !gt2.U().N()) {
                    z = false;
                } else {
                    z = true;
                }
                ke2Var.g = z;
                if (s33.H()) {
                    ke2Var.j = w42.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    ke2Var.h = str2;
                    y03.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                al3.d();
                this.a.a.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.R(ke2Var.b);
                gt2.U().m(this.a.a.a(), ke2.a(ke2Var));
                if (le2.b()) {
                    le2 le2Var = new le2();
                    le2Var.a = this.a.a.a();
                    gt2.U().u(le2.a(le2Var));
                }
                de3.F(this.a.a.a(), ke2Var.b);
                if (b72.W0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + ke2Var.toString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements g92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b72 a;

        public f(b72 b72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b72Var;
        }

        @Override // com.baidu.tieba.g92
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIIII(1048576, this, i, i2, i3, i4) != null) {
                return;
            }
            this.a.b4(i2);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements i92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b72 a;

        public g(b72 b72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b72Var;
        }

        @Override // com.baidu.tieba.i92
        public void a(cu1 cu1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, cu1Var) == null) && cu1Var != null) {
                cu1Var.t(this.a.R0);
                cu1Var.Y(this.a.B3());
                hy2.e().a(cu1Var);
            }
        }

        @Override // com.baidu.tieba.i92
        public void b(cu1 cu1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cu1Var) == null) && cu1Var != null) {
                cu1Var.U(this.a.R0);
                hy2.e().b(cu1Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends e92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b72 c;

        public h(b72 b72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = b72Var;
        }

        @Override // com.baidu.tieba.e92, com.baidu.tieba.h92
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.y2(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-964270201, "Lcom/baidu/tieba/b72$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-964270201, "Lcom/baidu/tieba/b72$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    ar2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (b72.W0) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947597804, "Lcom/baidu/tieba/b72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947597804, "Lcom/baidu/tieba/b72;");
                return;
            }
        }
        W0 = do1.a;
        X0 = kl3.g(149.0f);
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
                nl3.q().postAtFrontOfQueue(new c(this));
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

    public final e92 B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new h(this);
        }
        return (e92) invokeV.objValue;
    }

    public final i92 C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new g(this);
        }
        return (i92) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z62, com.baidu.swan.support.v4.app.Fragment
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.D0();
        }
    }

    public final void D3() {
        wo2 F0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            zt1 r3 = r3();
            if ((r3 instanceof SwanAppWebViewManager) && (F0 = ((SwanAppWebViewManager) r3).F0()) != null) {
                F0.d();
            }
        }
    }

    public boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            fj3 fj3Var = this.M0;
            if (fj3Var == null) {
                return false;
            }
            return fj3Var.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            i83 i83Var = this.P0;
            if (i83Var != null && i83Var.h) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z62
    public i83 J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.P0;
        }
        return (i83) invokeV.objValue;
    }

    public boolean J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            i83 i83Var = this.P0;
            if (i83Var != null) {
                return TextUtils.equals(i83Var.j, ExceptionHandlerImpl.KEY_CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            SwanAppConfigData s = gt2.U().s();
            if (s != null && !TextUtils.equals(s.f(), this.H0.e())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c4() {
        ux2 ux2Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048608, this) != null) || (ux2Var = this.d0) == null) {
            return;
        }
        ux2Var.n();
    }

    public PullToRefreshBaseWebView h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            zt1 zt1Var = this.L0;
            if (zt1Var != null) {
                return zt1Var.h0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.G0 = me3.c("805");
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            s73.K().q().e0().e("mapp_i_custom_navigation_bar", new e(this));
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

    @Override // com.baidu.tieba.z62, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            d1();
        }
    }

    @Override // com.baidu.tieba.z62, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            g1();
            v3(false);
        }
    }

    @NonNull
    public tx2 p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.H0;
        }
        return (tx2) invokeV.objValue;
    }

    public zt1 r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.L0;
        }
        return (zt1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z62
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
    public tx2 u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.I0;
        }
        return (tx2) invokeV.objValue;
    }

    public String w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            zt1 zt1Var = this.L0;
            if (zt1Var != null) {
                return zt1Var.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public fj3 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.M0;
        }
        return (fj3) invokeV.objValue;
    }

    public b72() {
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
        this.H0 = new tx2();
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
            Map<String, zt1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (zt1 zt1Var : this.J0.values()) {
                    if (zt1Var != null) {
                        zt1Var.e0();
                    }
                }
            } else {
                zt1 zt1Var2 = this.L0;
                if (zt1Var2 != null) {
                    zt1Var2.e0();
                }
            }
            D3();
        }
    }

    public final boolean H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SwanAppConfigData s = gt2.U().s();
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
            c72 P1 = P1();
            if (P1 == null) {
                return false;
            }
            i83 i83Var = this.P0;
            if (i83Var != null && i83Var.k) {
                z = true;
            } else {
                z = false;
            }
            if (z || (s = gt2.U().s()) == null) {
                return false;
            }
            return !K3(P1, s);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a73.a
    public a73 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.N0 == null) {
                if (this.O0 == null) {
                    return null;
                }
                this.N0 = new a73(this, (LinearLayout) this.O0.findViewById(R.id.obfuscated_res_0x7f090180), M1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070159));
            }
            return this.N0;
        }
        return (a73) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z62
    public boolean h2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        ux2 ux2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            gt2 U = gt2.U();
            if (U == null || (s = U.s()) == null || !s.n() || (ux2Var = this.d0) == null) {
                return false;
            }
            return s.r(ux2Var.i());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z62
    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            zt1 zt1Var = this.L0;
            if (zt1Var != null) {
                zt1Var.T();
            }
            F3();
            t3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(re2.n(s73.K().getAppId()));
            }
            this.g0.u(ar2.M().a(), K1(), this.h0, false);
        }
    }

    public static b72 P3(ux2 ux2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ux2Var)) == null) {
            b72 b72Var = new b72();
            if (ux2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", ux2Var.m());
                b72Var.l1(bundle);
            }
            return b72Var;
        }
        return (b72) invokeL.objValue;
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

    public void O3(xe3 xe3Var) {
        zd3 zd3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, xe3Var) == null) && (zd3Var = this.G0) != null) {
            me3.i(zd3Var, xe3Var);
            this.G0 = null;
        }
    }

    public void U3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.V0 = z;
        }
    }

    public final void a4(zt1 zt1Var) {
        g92 g92Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, zt1Var) != null) || (g92Var = this.R0) == null || zt1Var == null) {
            return;
        }
        zt1Var.U(g92Var);
        if (zt1Var.k() != null) {
            zt1Var.U(this.R0);
        }
    }

    public final void g3(zt1 zt1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048612, this, zt1Var) != null) || zt1Var == null) {
            return;
        }
        g92 g92Var = this.R0;
        if (g92Var != null) {
            zt1Var.t(g92Var);
        }
        zt1Var.Z(C3());
    }

    @Override // com.baidu.tieba.z62, com.baidu.searchbox.widget.SlideInterceptor
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

    @Override // com.baidu.tieba.z62
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

    @Override // com.baidu.tieba.z62
    public void z1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i2) == null) {
            if (!i83.f(this.P0)) {
                super.z1(i2);
                return;
            }
            boolean z = true;
            if (!J3()) {
                z = true ^ cl3.h(this.c0);
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

    public static void V3(tx2 tx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, tx2Var) == null) {
            try {
                if (W0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + tx2Var);
                }
                if (tx2Var == null) {
                    Z0 = null;
                } else {
                    Z0 = (tx2) tx2Var.clone();
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
        gt2 U = gt2.U();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (U.f(str).h && this.R0 == null) {
            this.R0 = new f(this);
        }
    }

    @Override // com.baidu.tieba.z62, com.baidu.swan.support.v4.app.Fragment
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
        if ((interceptable == null || interceptable.invokeZ(1048637, this, z) == null) && ar2.K().k(z, 2)) {
            rx2.l(getContext(), this.g0, this.f0, t73.b0().W().f0().paNumber);
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
            nk3.j(new a(this), "SwanAppPageHistory");
            x03.a("route", "fragment create.");
        }
    }

    private void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (a0()) {
                resume();
            }
            ae4 ae4Var = this.g0;
            if (ae4Var != null && ae4Var.i()) {
                this.g0.B(ar2.M().a());
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
                this.g0 = new ae4(activity, this.f0, s3(), ar2.K(), new cn3());
                new jx2(this.g0, this, this.h0).z();
                if (px2.e()) {
                    this.g0.l(50);
                }
            }
        }
    }

    @Override // com.baidu.tieba.z62
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
            zt1 zt1Var = this.L0;
            if (zt1Var != null) {
                if (su2.g(zt1Var.a())) {
                    return true;
                }
                return this.L0.I();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z62
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
            cu1 k = this.L0.k();
            if (k != null) {
                hashMap.put("webViewUrl", k.getCurrentPageUrl());
            }
            gt2.U().u(new uh2("sharebtn", hashMap));
        }
    }

    @Override // com.baidu.tieba.z62
    public void l2() {
        ux2 Q1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            S1();
            we3 we3Var = new we3();
            we3Var.e = "gohome";
            we3Var.c = "bar";
            b72 H = gt2.U().H();
            if (H == null) {
                Q1 = null;
            } else {
                Q1 = H.Q1();
            }
            if (Q1 != null && !TextUtils.isEmpty(Q1.i())) {
                we3Var.a("page", Q1.i());
            }
            D1(we3Var);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.au1] */
    @NonNull
    public Pair<Integer, Integer> q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            zt1 zt1Var = this.L0;
            if (zt1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = zt1Var.r().getCurrentWebView();
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
            Map<String, zt1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, zt1> entry : this.J0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().a());
                    }
                }
            }
            zt1 zt1Var = this.L0;
            if (zt1Var != null) {
                String a2 = zt1Var.a();
                if (!arrayList.contains(a2)) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean K3(c72 c72Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, c72Var, swanAppConfigData)) == null) {
            z62 j = c72Var.j(0);
            if (j == null || !(j instanceof b72)) {
                return false;
            }
            String e2 = ((b72) j).p3().e();
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
        i83 i83Var;
        au1 au1Var;
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
            zt1 zt1Var = this.L0;
            if (zt1Var != null) {
                if (zt1Var.k() != null) {
                    au1Var = this.L0.k().r();
                } else {
                    au1Var = this.L0.r();
                }
                if (au1Var != null) {
                    i2 = au1Var.getWebViewScrollY();
                    i83Var = this.P0;
                    if (i83Var != null && i83Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            i83Var = this.P0;
            if (i83Var != null) {
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
            ak3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = p63.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f092426).setVisibility(8);
            }
            SwanAppActionBar N1 = N1();
            if (N1 != null) {
                N1.setRightMenuStyle();
                N1.setRightZoneImmersiveStyle();
                N1.setBackgroundColor(0);
            }
            View b0 = b0();
            if (b0 != null) {
                b0.findViewById(R.id.obfuscated_res_0x7f09107b).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) b0.findViewById(R.id.obfuscated_res_0x7f090181);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            Map<String, zt1> map = this.J0;
            if (map != null && !map.isEmpty()) {
                for (zt1 zt1Var : this.J0.values()) {
                    if (zt1Var != null) {
                        a4(zt1Var);
                        zt1Var.destroy();
                    }
                }
                this.J0.clear();
            } else {
                zt1 zt1Var2 = this.L0;
                if (zt1Var2 != null) {
                    a4(zt1Var2);
                    this.L0.destroy();
                }
            }
            this.L0 = null;
            if (W0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (!this.T0) {
                yd2.n(gt2.U().getActivity());
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
                hy2.e().i(true);
            }
            t42.i("SwanApp", "onShow");
            su2.i(a2, true);
            if (t42.f()) {
                o62.b();
            }
            if (t73.b0() != null) {
                str = t73.b0().O();
            }
            ar2.H().e(str);
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
        ux2 g2 = ux2.g(p.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            tx2 tx2Var = this.H0;
            tx2Var.a = "";
            tx2Var.b = "";
            tx2Var.e = "";
            tx2Var.f = "";
        } else {
            this.H0.a = g2.i();
            this.H0.b = this.d0.j();
            this.H0.e = this.d0.l();
            this.H0.f = this.d0.k();
        }
        tx2 tx2Var2 = this.H0;
        tx2Var2.d = lb3.b(tx2Var2.e());
        i83 f2 = gt2.U().f(this.H0.g());
        this.P0 = f2;
        if (f2.p) {
            this.P0 = gt2.U().j(this.H0.e());
        }
        if (this.E0) {
            i83 i83Var = this.P0;
            i83Var.f = false;
            i83Var.h = true;
            i83Var.p = true;
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
            xh2 xh2Var = new xh2();
            xh2Var.c = a1;
            xh2Var.d = this.L0.a();
            xh2Var.e = b1;
            xh2Var.f = this.H0.a;
            xh2Var.g = String.valueOf(o);
            b1 = "";
            if (W0) {
                Log.d("SwanAppFragment", "sendRouteMessage fromId: " + xh2Var.c + " ,toId: " + xh2Var.d + " ,RouteType: " + xh2Var.e + " page:" + xh2Var.f + ",TabIndex: " + xh2Var.g);
            }
            gt2.U().u(xh2Var);
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
                hy2.e().i(false);
            }
            if (d() != null && !d().c() && (!d().f() || d().j())) {
                d().g();
            }
            t42.i("SwanApp", "onHide");
            su2.i(a2, false);
            if (!z && (h0 = this.L0.h0()) != null) {
                h0.w(false);
            }
            if (t73.b0() != null) {
                str = t73.b0().O();
            }
            ar2.H().f(str);
        }
    }

    public final void S3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.L0.a());
            vh2 vh2Var = new vh2(hashMap);
            if (W0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.L0.a());
            }
            gt2.U().u(vh2Var);
        }
    }

    public void Y3(tx2 tx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, tx2Var) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + tx2Var);
            }
            if (this.M0.o(p3().g()) == this.M0.o(tx2Var.g())) {
                tx2 tx2Var2 = this.H0;
                tx2Var2.e = tx2Var.e;
                tx2Var2.f = tx2Var.f;
                return;
            }
            this.M0.E(tx2Var.g());
            onPause();
            o3(tx2Var, "");
        }
    }

    public final void d4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            int i3 = 0;
            if (z) {
                um3 um3Var = this.u0;
                if (um3Var != null && um3Var.i()) {
                    i2 = kl3.t();
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
            if (ar2.K().k(z, 1)) {
                rx2.k(getContext(), this.f0, t73.b0().W().f0().paNumber);
            } else if (t73.b0() == null) {
            } else {
                rx2.o(this.f0, t73.b0().U().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.tieba.z62
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
            if (!de3.i()) {
                de3.d(s73.K().q().W());
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

    public final void Z3(String str, tx2 tx2Var) {
        zt1 zt1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, str, tx2Var) == null) && this.L0 != (zt1Var = this.J0.get(str)) && zt1Var != null) {
            i83 f2 = gt2.U().f(str);
            zt1Var.z(this.K0, f2);
            if (!zt1Var.c()) {
                zt1Var.O(this.K0, f2);
            }
            zt1Var.C(0);
            zt1 zt1Var2 = this.L0;
            if (zt1Var2 != null) {
                zt1Var2.C(8);
            }
            this.L0 = zt1Var;
            tx2 tx2Var2 = this.H0;
            tx2Var2.e = tx2Var.e;
            tx2Var2.f = tx2Var.f;
            zt1Var.h(tx2Var2);
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
            um3 um3Var = this.u0;
            if (um3Var != null && um3Var.i() && (e2 = this.u0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            i83 i83Var = this.P0;
            if (i83Var != null && i83Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
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
            x03.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = nl3.a(h2, i2, j);
            this.L0 = yd2.h(a2);
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
            i83 f2 = gt2.U().f(i2);
            this.L0.z(this.K0, f2);
            this.L0.O(this.K0, f2);
            E3(i2);
            g3(this.L0);
            if (h2()) {
                this.J0.put(i2, this.L0);
                this.M0.f(view2, getContext(), i2);
            }
            x03.a("route", "createSlaveWebView end.");
            h3();
        }
    }

    public final zt1 j3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048618, this, str, str2, str3, str4)) == null) {
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            yd2.e f2 = yd2.f(getActivity(), de2.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = y03.q("route", str4);
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
            yd2.q(f2, new d(this, f2, str4, str2, str, str3));
            if (W0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (zt1) invokeLLLL.objValue;
    }

    public final void l3(tx2 tx2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048621, this, tx2Var, str) == null) && this.J0.get(tx2Var.d) == null) {
            String a2 = nl3.a(tx2Var.c, tx2Var.a, tx2Var.b);
            zt1 h2 = yd2.h(a2);
            if (h2 != null) {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.J0.put(tx2Var.a, h2);
            } else {
                if (W0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = j3(tx2Var.c, tx2Var.a, tx2Var.b, str);
                this.J0.put(tx2Var.a, h2);
            }
            E3(tx2Var.a);
            g3(h2);
        }
    }

    public void o3(tx2 tx2Var, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, tx2Var, str) == null) {
            V3(this.H0);
            this.I0 = Z0;
            if (W0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.I0);
            }
            String str3 = tx2Var.a;
            String str4 = tx2Var.d;
            gt2 U = gt2.U();
            String str5 = "";
            if (TextUtils.isEmpty(str4)) {
                str2 = "";
            } else {
                str2 = str4;
            }
            i83 f2 = U.f(str2);
            tx2 tx2Var2 = this.H0;
            tx2Var2.a = str3;
            if (tx2Var != null) {
                str5 = tx2Var.f();
            }
            tx2Var2.b = str5;
            this.H0.d = str4;
            this.P0 = f2;
            boolean z = !N3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    z03.c(7, str);
                } else {
                    z03.c(6, str);
                }
            }
            if (!z) {
                Z3(str4, tx2Var);
            } else {
                l3(tx2Var, str);
                Z3(str3, tx2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                y03.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                z03.a(str, tx2Var);
            }
            y2(f2.b);
            F2(SwanAppConfigData.t(f2.c));
            w2(f2.a);
            Q3();
            c4();
            t42.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str3);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048645, this, layoutInflater, viewGroup, bundle)) == null) {
            x03.a("route", "fragment onCreateView.");
            View b2 = d23.a().b(R.layout.obfuscated_res_0x7f0d00a9, viewGroup, false);
            this.K0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f090181);
            X1(b2);
            W2(b2);
            this.M0 = new fj3(this);
            k3(b2);
            if (!px2.e() && !px2.f()) {
                ox2.b(this.L0.a(), String.valueOf(px2.d()), String.valueOf(px2.a(px2.b())));
            }
            if (W1()) {
                b2 = Z1(b2);
            }
            this.O0 = G1(b2, this);
            J2(this.L0.A());
            hy2.e().m();
            return this.O0;
        }
        return (View) invokeLLL.objValue;
    }
}
