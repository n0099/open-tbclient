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
import com.baidu.tieba.lb3;
import com.baidu.tieba.lc2;
import com.baidu.tieba.p52;
import com.baidu.tieba.v93;
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
public class aw1 extends yv1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public v52 f;

    @Override // com.baidu.tieba.ku1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tr2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gw2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ p52 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ aw1 g;

        /* loaded from: classes5.dex */
        public class a implements v93.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g63 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, g63 g63Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, g63Var, activity};
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
                this.a = g63Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.v93.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    mz2.d(this.c.d);
                    g32.i("NavigateToApi", "check pages success");
                    zc3.F(true, this.a.Z().U());
                    this.c.a.p();
                    lc2.e f = lc2.f(this.b, qc2.c(this.c.c.a));
                    List<String> g = p93.g(this.c.e);
                    aw1 aw1Var = this.c.g;
                    g63 g63Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    p93.m(aw1Var, g63Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.L(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.v93.e
            public void b(int i, zh3 zh3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zh3Var) == null) {
                    g32.c("NavigateToApi", "check pages failed");
                    zc3.F(false, this.a.Z().U());
                    this.c.a.p();
                    b bVar = this.c;
                    p93.k(bVar.g, bVar.b);
                    uc3.j(this.c.c, zh3Var);
                }
            }
        }

        public b(aw1 aw1Var, tr2 tr2Var, String str, gw2 gw2Var, String str2, p52 p52Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw1Var, tr2Var, str, gw2Var, str2, p52Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = aw1Var;
            this.a = tr2Var;
            this.b = str;
            this.c = gw2Var;
            this.d = str2;
            this.e = p52Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    g63 M = g63.M();
                    if (M == null) {
                        this.g.d(this.b, new hy1(1001, "swan app is null"));
                        uc3.i(this.c);
                        return;
                    }
                    this.a.a();
                    v93.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new hy1(1001, "swan activity is null"));
                uc3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements zk3<jb3<lb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tr2 b;
        public final /* synthetic */ p52 c;
        public final /* synthetic */ gw2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ aw1 g;

        public a(aw1 aw1Var, String str, tr2 tr2Var, p52 p52Var, gw2 gw2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw1Var, str, tr2Var, p52Var, gw2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = aw1Var;
            this.a = str;
            this.b = tr2Var;
            this.c = p52Var;
            this.d = gw2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(jb3<lb3.e> jb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jb3Var) == null) {
                if (!eb3.h(jb3Var)) {
                    this.g.d(this.a, new hy1(10005, "system deny"));
                } else {
                    this.g.D(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements lc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gw2 c;
        public final /* synthetic */ p52 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ aw1 f;

        public c(aw1 aw1Var, lc2.e eVar, String str, gw2 gw2Var, p52 p52Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw1Var, eVar, str, gw2Var, p52Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = aw1Var;
            this.a = eVar;
            this.b = str;
            this.c = gw2Var;
            this.d = p52Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.lc2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mz2.e(this.a, this.b);
                this.f.F(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ns1 a;
        public final /* synthetic */ gw2 b;
        public final /* synthetic */ p52 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ aw1 f;

        public d(aw1 aw1Var, ns1 ns1Var, gw2 gw2Var, p52 p52Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw1Var, ns1Var, gw2Var, p52Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = aw1Var;
            this.a = ns1Var;
            this.b = gw2Var;
            this.c = p52Var;
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
    public class e extends v52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o52 a;
        public final /* synthetic */ aw1 b;

        public e(aw1 aw1Var, o52 o52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw1Var, o52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aw1Var;
            this.a = o52Var;
        }

        @Override // com.baidu.tieba.v52, com.baidu.tieba.w52
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.Y2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.v52, com.baidu.tieba.w52
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = c53.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                c53.h(this.a);
            }
        }

        @Override // com.baidu.tieba.v52, com.baidu.tieba.w52
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = c53.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                c53.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947629486, "Lcom/baidu/tieba/aw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947629486, "Lcom/baidu/tieba/aw1;");
                return;
            }
        }
        g = np2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw1(@NonNull iu1 iu1Var) {
        super(iu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public hy1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            r("#navigateTo params=" + str, false);
            return J(str, "0", "navigateTo");
        }
        return (hy1) invokeL.objValue;
    }

    public hy1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            r("#showModalPage params" + str, false);
            return J(str, "7", "showModalPage");
        }
        return (hy1) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void D(tr2 tr2Var, p52 p52Var, gw2 gw2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tr2Var, p52Var, gw2Var, str, str2, str3}) == null) {
            ak3.a0(new b(this, tr2Var, str3, gw2Var, str, p52Var, str2));
        }
    }

    public final void E(ns1 ns1Var, gw2 gw2Var, p52 p52Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ns1Var, gw2Var, p52Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                G(ns1Var, gw2Var, p52Var, str);
            } else {
                H(ns1Var, gw2Var, p52Var, str);
            }
        }
    }

    public final void F(ns1 ns1Var, gw2 gw2Var, p52 p52Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, ns1Var, gw2Var, p52Var, str, str2) == null) {
            if (ak3.O()) {
                E(ns1Var, gw2Var, p52Var, str, str2);
            } else {
                ak3.a0(new d(this, ns1Var, gw2Var, p52Var, str, str2));
            }
        }
    }

    public final void G(ns1 ns1Var, gw2 gw2Var, p52 p52Var, String str) {
        SwanAppActivity activity;
        o52 o52Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, ns1Var, gw2Var, p52Var, str) == null) && (activity = tr2.V().getActivity()) != null && !activity.isFinishing()) {
            p93.e(ns1Var, gw2Var, str);
            mz2.c(9, str);
            o52.Z3(ak3.n());
            p52.b k = p52Var.i("showModalPage").k("normal", gw2Var);
            if (!(p52Var.m() instanceof o52) || (o52Var = (o52) p52Var.m()) == null) {
                return;
            }
            o52Var.E0 = true;
            k.b();
            if (p52Var.k() > 1) {
                o52Var.E3().setBackgroundColor(0);
            } else {
                o52Var.E0 = false;
            }
            o52Var.G2(false);
            v52 v52Var = this.f;
            if (v52Var != null) {
                o52Var.Y2(v52Var);
            }
            e eVar = new e(this, o52Var);
            this.f = eVar;
            o52Var.u2(eVar);
            View c2 = c53.c(o52Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            c53.h(o52Var);
            PullToRefreshBaseWebView e0 = ns1Var.e0();
            if (e0 != null) {
                e0.setIsPreventPullToRefresh(true);
            }
            lz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            mz2.a(str, gw2Var);
        }
    }

    public final void H(ns1 ns1Var, gw2 gw2Var, p52 p52Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, ns1Var, gw2Var, p52Var, str) == null) && (activity = tr2.V().getActivity()) != null && !activity.isFinishing()) {
            p93.e(ns1Var, gw2Var, str);
            mz2.c(0, str);
            if (p52Var.k() < g) {
                o52.Z3(ak3.n());
                p52.b i = p52Var.i("navigateTo");
                i.n(p52.g, p52.i);
                i.k("normal", gw2Var).b();
                qi3.c(p52Var, i());
                lz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                mz2.a(str, gw2Var);
                return;
            }
            bw1.B(p52Var, gw2Var, str, true);
        }
    }

    public final hy1 J(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            g63 c0 = g63.c0();
            if (c0 == null) {
                return new hy1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            mz2.b(uuid);
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                return hy1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String p = p93.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                g32.c("NavigateToApi", "url is null");
                return new hy1(202, "url is null");
            }
            tr2 V = tr2.V();
            p52 W = V.W();
            if (W == null) {
                g32.c("NavigateToApi", "manager is null");
                return new hy1(1001, "manager is null");
            }
            gw2 d2 = gw2.d(p, V.A());
            d2.e = str2;
            d2.f = uuid;
            uc3.g(d2);
            if (!ak3.b(V.t(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                g32.c("NavigateToApi", str4);
                uc3.i(d2);
                return new hy1(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && g63.M() != null) {
                g63.M().M0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = lz2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                g32.c("NavigateToApi", "cb is empty");
                uc3.i(d2);
                return new hy1(202, "cb is empty");
            } else if (t83.b().a(d2)) {
                t83.b().i(str3, d2);
                g32.c("NavigateToApi", "access to this page is prohibited");
                return new hy1(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    c0.f0().g(i(), "mapp_show_modal_page", new a(this, optString3, V, W, d2, uuid, str2));
                } else {
                    D(V, W, d2, uuid, str2, optString3);
                }
                return hy1.f();
            }
        }
        return (hy1) invokeLLL.objValue;
    }

    public final void L(lc2.e eVar, gw2 gw2Var, p52 p52Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, gw2Var, p52Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = lz2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            lc2.q(eVar, new c(this, eVar, str, gw2Var, p52Var, str2));
        }
    }
}
