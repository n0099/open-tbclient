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
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.d92;
import com.baidu.tieba.f23;
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
public class g22 extends e22 implements f23.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean V0;
    public static final int W0;
    public static String X0;
    public static ys2 Y0;
    public static String Z0;
    public static String a1;
    public transient /* synthetic */ FieldHolder $fh;
    public e93 F0;
    public ys2 G0;
    public ys2 H0;
    public Map<String, ep1> I0;
    public FrameLayout J0;
    public ep1 K0;
    public ke3 L0;
    public f23 M0;
    public View N0;
    public n33 O0;
    public int P0;
    public l42 Q0;
    public co1 R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g22 a;

        public a(g22 g22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R0 = fm2.Q();
                co1 co1Var = this.a.R0;
                g22 g22Var = this.a;
                co1Var.a(g22Var.b0, g22Var.d0, g22Var.getContext());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g22 a;

        public b(g22 g22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g22Var;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String a = this.a.K0.a();
                ed2 ed2Var = new ed2();
                ed2Var.c = fi3.a(a, "scrollViewBackToTop");
                lo2.U().m(a, ed2Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g22 a;

        public c(g22 g22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j3();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d92.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d92.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ g22 f;

        public d(g22 g22Var, d92.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g22Var, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = g22Var;
            this.a = eVar;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [com.baidu.tieba.fp1] */
        @Override // com.baidu.tieba.d92.f
        public void onReady() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p92 p92Var = new p92();
                p92Var.i = this.a.a.K();
                if (!TextUtils.isEmpty(this.b)) {
                    ew2.e(this.a, this.b);
                }
                String b = q63.b(this.c);
                p92Var.a = this.d;
                if (TextUtils.isEmpty(this.e)) {
                    str = this.c;
                } else {
                    str = this.c + "?" + this.e;
                }
                p92Var.b = str;
                if (y23.b0() != null) {
                    p92Var.c = y23.b0().d0(b);
                    p92Var.f = y23.b0().X(b);
                }
                p92Var.k = m92.c(y23.M(), p92Var.b);
                p92Var.d = lo2.U().f(b).g;
                p92Var.e = String.valueOf(vz1.a());
                p92Var.g = g22.V0 || lo2.U().N();
                if (xy2.H()) {
                    p92Var.j = b02.d();
                }
                if (!TextUtils.isEmpty(this.b)) {
                    String str2 = this.b;
                    p92Var.h = str2;
                    dw2.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                fg3.d();
                this.a.a.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.c);
                this.a.a.R(p92Var.b);
                lo2.U().m(this.a.a.a(), p92.a(p92Var));
                if (q92.b()) {
                    q92 q92Var = new q92();
                    q92Var.a = this.a.a.a();
                    lo2.U().u(q92.a(q92Var));
                }
                i93.F(this.a.a.a(), p92Var.b);
                if (g22.V0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + p92Var.toString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements rh3<y73> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g22 a;

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
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.T0 = false;
                    this.a.a.B2(true, false);
                }
            }
        }

        public e(g22 g22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g22Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(y73 y73Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y73Var) == null) || y73Var == null || y73Var.d || y73Var.j != 1) {
                return;
            }
            sg3.e0(new a(this));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements l42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g22 a;

        public f(g22 g22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g22Var;
        }

        @Override // com.baidu.tieba.l42
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                this.a.Y3(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements n42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g22 a;

        public g(g22 g22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g22Var;
        }

        @Override // com.baidu.tieba.n42
        public void a(hp1 hp1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hp1Var) == null) || hp1Var == null) {
                return;
            }
            hp1Var.t(this.a.Q0);
            hp1Var.Y(this.a.y3());
            mt2.e().a(hp1Var);
        }

        @Override // com.baidu.tieba.n42
        public void b(hp1 hp1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hp1Var) == null) || hp1Var == null) {
                return;
            }
            hp1Var.U(this.a.Q0);
            mt2.e().b(hp1Var);
        }
    }

    /* loaded from: classes4.dex */
    public class h extends j42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g22 c;

        public h(g22 g22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g22Var;
        }

        @Override // com.baidu.tieba.j42, com.baidu.tieba.m42
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.v2(str);
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
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-825742051, "Lcom/baidu/tieba/g22$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-825742051, "Lcom/baidu/tieba/g22$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    fm2.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (g22.V0) {
                    Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + a);
                }
                return a;
            }
            return invokeV.intValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a() > 0 : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947741954, "Lcom/baidu/tieba/g22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947741954, "Lcom/baidu/tieba/g22;");
                return;
            }
        }
        V0 = ij1.a;
        W0 = pg3.g(149.0f);
        X0 = "-1";
        Z0 = "-1";
    }

    public g22() {
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
        this.G0 = new ys2();
        this.I0 = new TreeMap();
        this.P0 = 0;
        this.S0 = false;
        this.T0 = false;
        this.U0 = false;
    }

    public static g22 M3(zs2 zs2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zs2Var)) == null) {
            g22 g22Var = new g22();
            if (zs2Var != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", zs2Var.m());
                g22Var.j1(bundle);
            }
            return g22Var;
        }
        return (g22) invokeL.objValue;
    }

    public static void S3(ys2 ys2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ys2Var) == null) {
            try {
                if (V0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + ys2Var);
                }
                if (ys2Var == null) {
                    Y0 = null;
                } else {
                    Y0 = (ys2) ys2Var.clone();
                }
            } catch (Exception e2) {
                if (V0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void U3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            a1 = str;
        }
    }

    private void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (U()) {
                pause();
            }
            if (V0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.K0.a())));
            }
        }
    }

    private void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (U()) {
                resume();
            }
            f94 f94Var = this.g0;
            if (f94Var != null && f94Var.i()) {
                this.g0.B(fm2.M().a());
            }
            if (V0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.K0.a())));
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A0();
            Map<String, ep1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (ep1 ep1Var : this.I0.values()) {
                    if (ep1Var != null) {
                        ep1Var.e0();
                    }
                }
            } else {
                ep1 ep1Var2 = this.K0;
                if (ep1Var2 != null) {
                    ep1Var2.e0();
                }
            }
            A3();
        }
    }

    public final void A3() {
        bk2 F0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ep1 o3 = o3();
            if (!(o3 instanceof SwanAppWebViewManager) || (F0 = ((SwanAppWebViewManager) o3).F0()) == null) {
                return;
            }
            F0.d();
        }
    }

    @Override // com.baidu.tieba.e22, com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.B0();
        }
    }

    public final void B3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || G3()) {
            return;
        }
        lo2 U = lo2.U();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (U.f(str).h && this.Q0 == null) {
            this.Q0 = new f(this);
        }
    }

    @DebugTrace
    public void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity == null || this.g0 != null) {
                return;
            }
            this.g0 = new f94(activity, this.f0, p3(), fm2.K(), new hi3());
            new os2(this.g0, this, this.h0).z();
            if (us2.e()) {
                this.g0.l(50);
            }
        }
    }

    public boolean D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ke3 ke3Var = this.L0;
            if (ke3Var == null) {
                return false;
            }
            return ke3Var.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SwanAppConfigData s = lo2.U().s();
            boolean z = false;
            if (s == null) {
                return false;
            }
            return !((TextUtils.equals(s.f(), this.G0.a) || s.r(this.G0.a)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    public final boolean F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            n33 n33Var = this.O0;
            return n33Var != null && n33Var.h;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.e22
    public n33 G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.O0 : (n33) invokeV.objValue;
    }

    public boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            n33 n33Var = this.O0;
            if (n33Var != null) {
                return TextUtils.equals(n33Var.j, "custom");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean H3(h22 h22Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, h22Var, swanAppConfigData)) == null) {
            e22 j = h22Var.j(0);
            if (j == null || !(j instanceof g22)) {
                return false;
            }
            String e2 = ((g22) j).m3().e();
            return swanAppConfigData.r(e2) || TextUtils.equals(swanAppConfigData.f(), e2);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.e22
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (d() != null && d().e() && d().f()) {
                return true;
            }
            if ((d() == null || !d().c()) && !PaymentManager.k()) {
                ep1 ep1Var = this.K0;
                if (ep1Var != null) {
                    if (xp2.g(ep1Var.a())) {
                        return true;
                    }
                    return this.K0.I();
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean I3() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            h22 M1 = M1();
            if (M1 == null) {
                return false;
            }
            n33 n33Var = this.O0;
            if ((n33Var != null && n33Var.k) || (s = lo2.U().s()) == null) {
                return false;
            }
            return !H3(M1, s);
        }
        return invokeV.booleanValue;
    }

    public final boolean J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            SwanAppConfigData s = lo2.U().s();
            return (s == null || TextUtils.equals(s.f(), this.G0.e())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean K3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? (this.I0.isEmpty() || this.I0.get(str) == null) ? false : true : invokeL.booleanValue;
    }

    public void L3(ca3 ca3Var) {
        e93 e93Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, ca3Var) == null) || (e93Var = this.F0) == null) {
            return;
        }
        r93.i(e93Var, ca3Var);
        this.F0 = null;
    }

    @Override // com.baidu.tieba.e22
    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.K0 == null) {
                if (V0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.a());
            hp1 k = this.K0.k();
            if (k != null) {
                hashMap.put("webViewUrl", k.getCurrentPageUrl());
            }
            lo2.U().u(new zc2("sharebtn", hashMap));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N3() {
        int i2;
        n33 n33Var;
        fp1 fp1Var;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.f0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (G3()) {
            B2(true, this.T0);
            i2 = 0;
        } else if (F3()) {
            B2(false, false);
            ep1 ep1Var = this.K0;
            if (ep1Var != null) {
                if (ep1Var.k() != null) {
                    fp1Var = this.K0.k().r();
                } else {
                    fp1Var = this.K0.r();
                }
                if (fp1Var != null) {
                    i2 = fp1Var.getWebViewScrollY();
                    n33Var = this.O0;
                    if (n33Var != null && n33Var.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            n33Var = this.O0;
            if (n33Var != null) {
                i3 = 0;
            }
        } else {
            B2(false, false);
            i2 = W0 + this.P0;
            centerTitleView = this.f0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            Y3(i2);
            a4(z);
        }
        z = true;
        centerTitleView = this.f0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        Y3(i2);
        a4(z);
    }

    public final void O3() {
        Bundle p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (p = p()) == null) {
            return;
        }
        this.H0 = Y0;
        if (V0) {
            Log.d("SwanAppFragment", "restoreArguments sPrePageParams=" + this.H0);
        }
        zs2 g2 = zs2.g(p.getString("ai_apps_param"));
        this.d0 = g2;
        if (g2 == null) {
            ys2 ys2Var = this.G0;
            ys2Var.a = "";
            ys2Var.b = "";
            ys2Var.e = "";
            ys2Var.f = "";
        } else {
            this.G0.a = g2.i();
            this.G0.b = this.d0.j();
            this.G0.e = this.d0.l();
            this.G0.f = this.d0.k();
        }
        ys2 ys2Var2 = this.G0;
        ys2Var2.d = q63.b(ys2Var2.e());
        n33 f2 = lo2.U().f(this.G0.g());
        this.O0 = f2;
        if (f2.p) {
            this.O0 = lo2.U().j(this.G0.e());
        }
        if (this.D0) {
            n33 n33Var = this.O0;
            n33Var.f = false;
            n33Var.h = true;
            n33Var.p = true;
        }
        this.P0 = J1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070159);
    }

    public final void P3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.a());
            ad2 ad2Var = new ad2(hashMap);
            if (V0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.K0.a());
            }
            lo2.U().u(ad2Var);
        }
    }

    public final void Q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!TextUtils.equals(Z0, this.K0.a()) || TextUtils.equals(a1, "switchTab")) {
                int o = this.L0.o(m3().g());
                cd2 cd2Var = new cd2();
                cd2Var.c = Z0;
                cd2Var.d = this.K0.a();
                cd2Var.e = a1;
                cd2Var.f = this.G0.a;
                cd2Var.g = String.valueOf(o);
                a1 = "";
                if (V0) {
                    Log.d("SwanAppFragment", "sendRouteMessage fromId: " + cd2Var.c + " ,toId: " + cd2Var.d + " ,RouteType: " + cd2Var.e + " page:" + cd2Var.f + ",TabIndex: " + cd2Var.g);
                }
                lo2.U().u(cd2Var);
                Z0 = this.K0.a();
            }
        }
    }

    public void R3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.U0 = z;
        }
    }

    public final void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "setting immersive portrait fullscreen video");
            }
            ff3.h();
            if (this.c0.getWindow() != null) {
                this.c0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = u13.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f09223e).setVisibility(8);
            }
            SwanAppActionBar K1 = K1();
            if (K1 != null) {
                K1.setRightMenuStyle();
                K1.setRightZoneImmersiveStyle();
                K1.setBackgroundColor(0);
            }
            View V = V();
            if (V != null) {
                V.findViewById(R.id.obfuscated_res_0x7f090f19).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) V.findViewById(R.id.obfuscated_res_0x7f09017d);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.baidu.tieba.e22
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            super.U1(view2);
            boolean z = false;
            x2(Z1() || E3());
            if (I3()) {
                f2();
            }
            N3();
            this.f0.setOnDoubleClickListener(new b(this));
            if (!i93.i()) {
                i93.d(x23.K().q().W());
            }
            if (G3() && E3()) {
                z = true;
            }
            this.T0 = z;
            if (z) {
                f3();
            }
        }
    }

    public void V3(ys2 ys2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ys2Var) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + ys2Var);
            }
            if (this.L0.o(m3().g()) == this.L0.o(ys2Var.g())) {
                ys2 ys2Var2 = this.G0;
                ys2Var2.e = ys2Var.e;
                ys2Var2.f = ys2Var.f;
                return;
            }
            this.L0.E(ys2Var.g());
            onPause();
            l3(ys2Var, "");
        }
    }

    public final void W3(String str, ys2 ys2Var) {
        ep1 ep1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, str, ys2Var) == null) || this.K0 == (ep1Var = this.I0.get(str)) || ep1Var == null) {
            return;
        }
        n33 f2 = lo2.U().f(str);
        ep1Var.z(this.J0, f2);
        if (!ep1Var.c()) {
            ep1Var.O(this.J0, f2);
        }
        ep1Var.C(0);
        ep1 ep1Var2 = this.K0;
        if (ep1Var2 != null) {
            ep1Var2.C(8);
        }
        this.K0 = ep1Var;
        ys2 ys2Var2 = this.G0;
        ys2Var2.e = ys2Var.e;
        ys2Var2.f = ys2Var.f;
        ep1Var.h(ys2Var2);
    }

    public final void X3(ep1 ep1Var) {
        l42 l42Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, ep1Var) == null) || (l42Var = this.Q0) == null || ep1Var == null) {
            return;
        }
        ep1Var.U(l42Var);
        if (ep1Var.k() != null) {
            ep1Var.U(this.Q0);
        }
    }

    public final void Y3(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            float f2 = 1.0f;
            float f3 = (i2 - W0) * 1.0f;
            int i3 = this.P0;
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
            if (V0 && i4 != 0 && i4 != 255) {
                Log.d("SwanAppFragment", "update bar transparent degree: " + f2 + ZeusCrashHandler.NAME_SEPERATOR + i4);
            }
            zh3 zh3Var = this.t0;
            if (zh3Var != null && zh3Var.i() && (e2 = this.t0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.f0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            n33 n33Var = this.O0;
            if (n33Var != null && n33Var.i && (centerTitleView = this.f0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.i0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public void Z3() {
        zs2 zs2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (zs2Var = this.d0) == null) {
            return;
        }
        zs2Var.n();
    }

    public final void a4(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            int i3 = 0;
            if (z) {
                zh3 zh3Var = this.t0;
                if (zh3Var != null && zh3Var.i()) {
                    i2 = pg3.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.J0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.J0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.e0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = J1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070159);
            }
            i2 = 0;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.J0.getLayoutParams();
            layoutParams3.topMargin = i3;
            this.J0.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.e0.getLayoutParams();
            layoutParams22.topMargin = i2;
            this.e0.setLayoutParams(layoutParams22);
        }
    }

    @Override // com.baidu.tieba.e22
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f23.a
    public f23 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.M0 == null) {
                if (this.N0 == null) {
                    return null;
                }
                this.M0 = new f23(this, (LinearLayout) this.N0.findViewById(R.id.obfuscated_res_0x7f09017c), J1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070159));
            }
            return this.M0;
        }
        return (f23) invokeV.objValue;
    }

    public final void d3(ep1 ep1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, ep1Var) == null) || ep1Var == null) {
            return;
        }
        l42 l42Var = this.Q0;
        if (l42Var != null) {
            ep1Var.t(l42Var);
        }
        ep1Var.a0(z3());
    }

    @Override // com.baidu.tieba.e22
    public boolean e2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        zs2 zs2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            lo2 U = lo2.U();
            if (U == null || (s = U.s()) == null || !s.n() || (zs2Var = this.d0) == null) {
                return false;
            }
            return s.r(zs2Var.i());
        }
        return invokeV.booleanValue;
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.F0 = r93.c("805");
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            x23.K().q().e0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public final ep1 g3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048612, this, str, str2, str3, str4)) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            d92.e f2 = d92.f(getActivity(), i92.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = dw2.q("route", str4);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.b ? "1" : "0");
            }
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + f2);
            }
            d92.q(f2, new d(this, f2, str4, str2, str, str3));
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (ep1) invokeLLLL.objValue;
    }

    public PullToRefreshBaseWebView h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            ep1 ep1Var = this.K0;
            if (ep1Var != null) {
                return ep1Var.h0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public final void h3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view2) == null) {
            cw2.a("route", "createSlaveWebView start.");
            String h2 = this.d0.h();
            String j = this.d0.j();
            String i2 = this.d0.i();
            String a2 = sg3.a(h2, i2, j);
            this.K0 = d92.h(a2);
            if (V0) {
                StringBuilder sb = new StringBuilder();
                sb.append("pageUrl: ");
                sb.append(a2);
                sb.append(" is load: ");
                sb.append(this.K0 != null);
                Log.d("SwanAppFragment", sb.toString());
            }
            if (this.K0 == null) {
                if (V0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
                }
                this.K0 = g3(h2, i2, j, "");
            }
            this.K0.h(this.G0);
            n33 f2 = lo2.U().f(i2);
            this.K0.z(this.J0, f2);
            this.K0.O(this.J0, f2);
            B3(i2);
            d3(this.K0);
            if (e2()) {
                this.I0.put(i2, this.K0);
                this.L0.f(view2, getContext(), i2);
            }
            cw2.a("route", "createSlaveWebView end.");
            e3();
        }
    }

    @Override // com.baidu.tieba.e22
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            P1();
            ba3 ba3Var = new ba3();
            ba3Var.e = "gohome";
            ba3Var.c = "bar";
            g22 H = lo2.U().H();
            zs2 N1 = H == null ? null : H.N1();
            if (N1 != null && !TextUtils.isEmpty(N1.i())) {
                ba3Var.a("page", N1.i());
            }
            A1(ba3Var);
        }
    }

    public final void i3(ys2 ys2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048616, this, ys2Var, str) == null) && this.I0.get(ys2Var.d) == null) {
            String a2 = sg3.a(ys2Var.c, ys2Var.a, ys2Var.b);
            ep1 h2 = d92.h(a2);
            if (h2 != null) {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.I0.put(ys2Var.a, h2);
            } else {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = g3(ys2Var.c, ys2Var.a, ys2Var.b, str);
                this.I0.put(ys2Var.a, h2);
            }
            B3(ys2Var.a);
            d3(h2);
        }
    }

    @Override // com.baidu.tieba.e22, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, motionEvent)) == null) ? Z1() && this.K0.isSlidable(motionEvent) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.e22
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            ep1 ep1Var = this.K0;
            if (ep1Var != null) {
                ep1Var.T();
            }
            C3();
            q3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(w92.n(x23.K().getAppId()));
            }
            this.g0.u(fm2.M().a(), H1(), this.h0, false);
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            Map<String, ep1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (ep1 ep1Var : this.I0.values()) {
                    if (ep1Var != null) {
                        X3(ep1Var);
                        ep1Var.destroy();
                    }
                }
                this.I0.clear();
            } else {
                ep1 ep1Var2 = this.K0;
                if (ep1Var2 != null) {
                    X3(ep1Var2);
                    this.K0.destroy();
                }
            }
            this.K0 = null;
            if (V0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (this.S0) {
                return;
            }
            d92.n(lo2.U().getActivity());
        }
    }

    public void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.O0.j = "default";
            v1();
            N3();
        }
    }

    public void l3(ys2 ys2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, ys2Var, str) == null) {
            S3(this.G0);
            this.H0 = Y0;
            if (V0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.H0);
            }
            String str2 = ys2Var.a;
            String str3 = ys2Var.d;
            n33 f2 = lo2.U().f(TextUtils.isEmpty(str3) ? "" : str3);
            ys2 ys2Var2 = this.G0;
            ys2Var2.a = str2;
            ys2Var2.b = ys2Var != null ? ys2Var.f() : "";
            this.G0.d = str3;
            this.O0 = f2;
            boolean z = !K3(str3);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    ew2.c(7, str);
                } else {
                    ew2.c(6, str);
                }
            }
            if (!z) {
                W3(str3, ys2Var);
            } else {
                i3(ys2Var, str);
                W3(str2, ys2Var);
            }
            if (!TextUtils.isEmpty(str)) {
                dw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                ew2.a(str, ys2Var);
            }
            v2(f2.b);
            C2(SwanAppConfigData.t(f2.c));
            t2(f2.a);
            N3();
            Z3();
            yz1.i("SwanAppFragment", "switch tab title: " + f2.b + " page:" + str2);
        }
    }

    @Override // com.baidu.tieba.e22, com.baidu.swan.support.v4.app.Fragment
    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && k0()) {
            super.m1(z);
            if (V0) {
                Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (z) {
                resume();
                s3(false);
                return;
            }
            pause();
        }
    }

    @NonNull
    public ys2 m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.G0 : (ys2) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.fp1] */
    @NonNull
    public Pair<Integer, Integer> n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            ep1 ep1Var = this.K0;
            if (ep1Var == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = ep1Var.r().getCurrentWebView();
            return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public ep1 o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.K0 : (ep1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e22, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onPause();
            b1();
        }
    }

    @Override // com.baidu.tieba.e22, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onResume();
            e1();
            s3(false);
        }
    }

    @Override // com.baidu.tieba.e22
    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.p2();
            N3();
            if (this.U0) {
                T3();
            }
        }
    }

    public final int p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? d2() ? J3() ? 18 : 17 : J3() ? 12 : 15 : invokeV.intValue;
    }

    public void pause() {
        PullToRefreshBaseWebView h0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            boolean z = this.K0 == null;
            String a2 = z ? "" : this.K0.a();
            if (V0) {
                Log.d("SwanAppFragment", "pause() wvID: " + a2);
            }
            if (!z) {
                this.K0.onPause();
                P3("onHide");
                mt2.e().i(false);
            }
            if (d() != null && !d().c() && (!d().f() || d().j())) {
                d().g();
            }
            yz1.i("SwanApp", "onHide");
            xp2.i(a2, false);
            if (!z && (h0 = this.K0.h0()) != null) {
                h0.w(false);
            }
            fm2.H().f(y23.b0() != null ? y23.b0().O() : "");
        }
    }

    public final void q3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048631, this, z) == null) && fm2.K().k(z, 2)) {
            ws2.l(getContext(), this.g0, this.f0, y23.b0().W().f0().paNumber);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, activity) == null) {
            super.r0(activity);
            if (V0) {
                Log.d("SwanAppFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Nullable
    public ys2 r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.H0 : (ys2) invokeV.objValue;
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            boolean z = false;
            boolean z2 = this.K0 == null;
            String a2 = z2 ? "" : this.K0.a();
            if (V0) {
                Log.d("SwanAppFragment", "resume() wvID: " + a2);
            }
            if (!z2) {
                x2((Z1() || E3()) ? true : true);
                this.K0.onResume();
                Q3();
                P3("onShow");
                mt2.e().i(true);
            }
            yz1.i("SwanApp", "onShow");
            xp2.i(a2, true);
            if (yz1.f()) {
                t12.b();
            }
            fm2.H().e(y23.b0() != null ? y23.b0().O() : "");
        }
    }

    public final void s3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (fm2.K().k(z, 1)) {
                ws2.k(getContext(), this.f0, y23.b0().W().f0().paNumber);
            } else if (y23.b0() == null) {
            } else {
                ws2.o(this.f0, y23.b0().U().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.tieba.e22
    public boolean t2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i2)) == null) {
            boolean t2 = super.t2(i2);
            N3();
            return t2;
        }
        return invokeI.booleanValue;
    }

    public String t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            ep1 ep1Var = this.K0;
            return ep1Var != null ? ep1Var.a() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            super.u0(bundle);
            O3();
            if (V0) {
                Log.d("SwanAppFragment", "onCreate() obj: " + this);
            }
            sf3.j(new a(this), "SwanAppPageHistory");
            cw2.a("route", "fragment create.");
        }
    }

    public List<String> u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, ep1> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, ep1> entry : this.I0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().a());
                    }
                }
            }
            ep1 ep1Var = this.K0;
            if (ep1Var != null) {
                String a2 = ep1Var.a();
                if (!arrayList.contains(a2)) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public ke3 v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.L0 : (ke3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e22
    public void w1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            if (!n33.f(this.O0)) {
                super.w1(i2);
                return;
            }
            x1(i2, G3() ? true : true ^ hg3.h(this.c0));
            N3();
        }
    }

    public String w3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, str)) == null) {
            if (this.I0.containsKey(str)) {
                return this.I0.get(str).a();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048643, this, layoutInflater, viewGroup, bundle)) == null) {
            cw2.a("route", "fragment onCreateView.");
            View b2 = ix2.a().b(R.layout.obfuscated_res_0x7f0d00a6, viewGroup, false);
            this.J0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f09017d);
            U1(b2);
            T2(b2);
            this.L0 = new ke3(this);
            h3(b2);
            if (!us2.e() && !us2.f()) {
                ts2.b(this.K0.a(), String.valueOf(us2.d()), String.valueOf(us2.a(us2.b())));
            }
            if (T1()) {
                b2 = W1(b2);
            }
            this.N0 = D1(b2, this);
            G2(this.K0.A());
            mt2.e().m();
            return this.N0;
        }
        return (View) invokeLLL.objValue;
    }

    public FrameLayout x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.J0 : (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            super.y0();
            this.B0.a();
            if (i.b()) {
                sg3.q().postAtFrontOfQueue(new c(this));
            } else {
                j3();
            }
        }
    }

    public final j42 y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? new h(this) : (j42) invokeV.objValue;
    }

    public final n42 z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? new g(this) : (n42) invokeV.objValue;
    }
}
