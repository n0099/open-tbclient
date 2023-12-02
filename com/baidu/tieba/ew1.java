package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.pb3;
import com.baidu.tieba.pc2;
import com.baidu.tieba.t52;
import com.baidu.tieba.z93;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ew1 extends cw1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public z52 f;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xr2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kw2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ t52 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ew1 g;

        /* loaded from: classes5.dex */
        public class a implements z93.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k63 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, k63 k63Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, k63Var, activity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = k63Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.z93.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    qz2.d(this.c.d);
                    k32.i("NavigateToApi", "check pages success");
                    dd3.F(true, this.a.Z().U());
                    this.c.a.p();
                    pc2.e f = pc2.f(this.b, uc2.c(this.c.c.a));
                    List<String> g = t93.g(this.c.e);
                    ew1 ew1Var = this.c.g;
                    k63 k63Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    t93.m(ew1Var, k63Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.L(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.z93.e
            public void b(int i, di3 di3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, di3Var) == null) {
                    k32.c("NavigateToApi", "check pages failed");
                    dd3.F(false, this.a.Z().U());
                    this.c.a.p();
                    b bVar = this.c;
                    t93.k(bVar.g, bVar.b);
                    yc3.j(this.c.c, di3Var);
                }
            }
        }

        public b(ew1 ew1Var, xr2 xr2Var, String str, kw2 kw2Var, String str2, t52 t52Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew1Var, xr2Var, str, kw2Var, str2, t52Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ew1Var;
            this.a = xr2Var;
            this.b = str;
            this.c = kw2Var;
            this.d = str2;
            this.e = t52Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    k63 M = k63.M();
                    if (M == null) {
                        this.g.d(this.b, new ly1(1001, "swan app is null"));
                        yc3.i(this.c);
                        return;
                    }
                    this.a.a();
                    z93.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new ly1(1001, "swan activity is null"));
                yc3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xr2 b;
        public final /* synthetic */ t52 c;
        public final /* synthetic */ kw2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ew1 g;

        public a(ew1 ew1Var, String str, xr2 xr2Var, t52 t52Var, kw2 kw2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew1Var, str, xr2Var, t52Var, kw2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ew1Var;
            this.a = str;
            this.b = xr2Var;
            this.c = t52Var;
            this.d = kw2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (!ib3.h(nb3Var)) {
                    this.g.d(this.a, new ly1(10005, "system deny"));
                } else {
                    this.g.D(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements pc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kw2 c;
        public final /* synthetic */ t52 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ew1 f;

        public c(ew1 ew1Var, pc2.e eVar, String str, kw2 kw2Var, t52 t52Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew1Var, eVar, str, kw2Var, t52Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ew1Var;
            this.a = eVar;
            this.b = str;
            this.c = kw2Var;
            this.d = t52Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.pc2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qz2.e(this.a, this.b);
                this.f.F(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs1 a;
        public final /* synthetic */ kw2 b;
        public final /* synthetic */ t52 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ew1 f;

        public d(ew1 ew1Var, rs1 rs1Var, kw2 kw2Var, t52 t52Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew1Var, rs1Var, kw2Var, t52Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ew1Var;
            this.a = rs1Var;
            this.b = kw2Var;
            this.c = t52Var;
            this.d = str;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.f.E(this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* loaded from: classes5.dex */
    public class e extends z52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s52 a;
        public final /* synthetic */ ew1 b;

        public e(ew1 ew1Var, s52 s52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew1Var, s52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ew1Var;
            this.a = s52Var;
        }

        @Override // com.baidu.tieba.z52, com.baidu.tieba.a62
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.Y2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.z52, com.baidu.tieba.a62
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = g53.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                g53.h(this.a);
            }
        }

        @Override // com.baidu.tieba.z52, com.baidu.tieba.a62
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = g53.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                g53.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748650, "Lcom/baidu/tieba/ew1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748650, "Lcom/baidu/tieba/ew1;");
                return;
            }
        }
        g = rp2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ew1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public ly1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            r("#navigateTo params=" + str, false);
            return J(str, "0", "navigateTo");
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            r("#showModalPage params" + str, false);
            return J(str, "7", "showModalPage");
        }
        return (ly1) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void D(xr2 xr2Var, t52 t52Var, kw2 kw2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{xr2Var, t52Var, kw2Var, str, str2, str3}) == null) {
            ek3.a0(new b(this, xr2Var, str3, kw2Var, str, t52Var, str2));
        }
    }

    public final void E(rs1 rs1Var, kw2 kw2Var, t52 t52Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rs1Var, kw2Var, t52Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                G(rs1Var, kw2Var, t52Var, str);
            } else {
                H(rs1Var, kw2Var, t52Var, str);
            }
        }
    }

    public final void F(rs1 rs1Var, kw2 kw2Var, t52 t52Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, rs1Var, kw2Var, t52Var, str, str2) == null) {
            if (ek3.O()) {
                E(rs1Var, kw2Var, t52Var, str, str2);
            } else {
                ek3.a0(new d(this, rs1Var, kw2Var, t52Var, str, str2));
            }
        }
    }

    public final void G(rs1 rs1Var, kw2 kw2Var, t52 t52Var, String str) {
        SwanAppActivity activity;
        s52 s52Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, rs1Var, kw2Var, t52Var, str) == null) && (activity = xr2.V().getActivity()) != null && !activity.isFinishing()) {
            t93.e(rs1Var, kw2Var, str);
            qz2.c(9, str);
            s52.Z3(ek3.n());
            t52.b k = t52Var.i("showModalPage").k("normal", kw2Var);
            if (!(t52Var.m() instanceof s52) || (s52Var = (s52) t52Var.m()) == null) {
                return;
            }
            s52Var.E0 = true;
            k.b();
            if (t52Var.k() > 1) {
                s52Var.E3().setBackgroundColor(0);
            } else {
                s52Var.E0 = false;
            }
            s52Var.G2(false);
            z52 z52Var = this.f;
            if (z52Var != null) {
                s52Var.Y2(z52Var);
            }
            e eVar = new e(this, s52Var);
            this.f = eVar;
            s52Var.t2(eVar);
            View c2 = g53.c(s52Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            g53.h(s52Var);
            PullToRefreshBaseWebView e0 = rs1Var.e0();
            if (e0 != null) {
                e0.setIsPreventPullToRefresh(true);
            }
            pz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            qz2.a(str, kw2Var);
        }
    }

    public final void H(rs1 rs1Var, kw2 kw2Var, t52 t52Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, rs1Var, kw2Var, t52Var, str) == null) && (activity = xr2.V().getActivity()) != null && !activity.isFinishing()) {
            t93.e(rs1Var, kw2Var, str);
            qz2.c(0, str);
            if (t52Var.k() < g) {
                s52.Z3(ek3.n());
                t52.b i = t52Var.i("navigateTo");
                i.n(t52.g, t52.i);
                i.k("normal", kw2Var).b();
                ui3.c(t52Var, i());
                pz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                qz2.a(str, kw2Var);
                return;
            }
            fw1.B(t52Var, kw2Var, str, true);
        }
    }

    public final ly1 J(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                return new ly1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            qz2.b(uuid);
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String p = t93.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                k32.c("NavigateToApi", "url is null");
                return new ly1(202, "url is null");
            }
            xr2 V = xr2.V();
            t52 W = V.W();
            if (W == null) {
                k32.c("NavigateToApi", "manager is null");
                return new ly1(1001, "manager is null");
            }
            kw2 d2 = kw2.d(p, V.A());
            d2.e = str2;
            d2.f = uuid;
            yc3.g(d2);
            if (!ek3.b(V.t(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                k32.c("NavigateToApi", str4);
                yc3.i(d2);
                return new ly1(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && k63.M() != null) {
                k63.M().M0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = pz2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                k32.c("NavigateToApi", "cb is empty");
                yc3.i(d2);
                return new ly1(202, "cb is empty");
            } else if (x83.b().a(d2)) {
                x83.b().i(str3, d2);
                k32.c("NavigateToApi", "access to this page is prohibited");
                return new ly1(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    c0.f0().g(i(), "mapp_show_modal_page", new a(this, optString3, V, W, d2, uuid, str2));
                } else {
                    D(V, W, d2, uuid, str2, optString3);
                }
                return ly1.f();
            }
        }
        return (ly1) invokeLLL.objValue;
    }

    public final void L(pc2.e eVar, kw2 kw2Var, t52 t52Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, kw2Var, t52Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = pz2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            pc2.q(eVar, new c(this, eVar, str, kw2Var, t52Var, str2));
        }
    }
}
