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
import com.baidu.tieba.mb3;
import com.baidu.tieba.mc2;
import com.baidu.tieba.q52;
import com.baidu.tieba.w93;
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
public class bw1 extends zv1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public w52 f;

    @Override // com.baidu.tieba.lu1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hw2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ q52 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ bw1 g;

        /* loaded from: classes5.dex */
        public class a implements w93.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h63 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, h63 h63Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, h63Var, activity};
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
                this.a = h63Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.w93.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    nz2.d(this.c.d);
                    h32.i("NavigateToApi", "check pages success");
                    ad3.F(true, this.a.Z().U());
                    this.c.a.p();
                    mc2.e f = mc2.f(this.b, rc2.c(this.c.c.a));
                    List<String> g = q93.g(this.c.e);
                    bw1 bw1Var = this.c.g;
                    h63 h63Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    q93.m(bw1Var, h63Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.L(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.w93.e
            public void b(int i, ai3 ai3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ai3Var) == null) {
                    h32.c("NavigateToApi", "check pages failed");
                    ad3.F(false, this.a.Z().U());
                    this.c.a.p();
                    b bVar = this.c;
                    q93.k(bVar.g, bVar.b);
                    vc3.j(this.c.c, ai3Var);
                }
            }
        }

        public b(bw1 bw1Var, ur2 ur2Var, String str, hw2 hw2Var, String str2, q52 q52Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw1Var, ur2Var, str, hw2Var, str2, q52Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = bw1Var;
            this.a = ur2Var;
            this.b = str;
            this.c = hw2Var;
            this.d = str2;
            this.e = q52Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    h63 M = h63.M();
                    if (M == null) {
                        this.g.d(this.b, new iy1(1001, "swan app is null"));
                        vc3.i(this.c);
                        return;
                    }
                    this.a.a();
                    w93.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new iy1(1001, "swan activity is null"));
                vc3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements al3<kb3<mb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ur2 b;
        public final /* synthetic */ q52 c;
        public final /* synthetic */ hw2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ bw1 g;

        public a(bw1 bw1Var, String str, ur2 ur2Var, q52 q52Var, hw2 hw2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw1Var, str, ur2Var, q52Var, hw2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = bw1Var;
            this.a = str;
            this.b = ur2Var;
            this.c = q52Var;
            this.d = hw2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(kb3<mb3.e> kb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kb3Var) == null) {
                if (!fb3.h(kb3Var)) {
                    this.g.d(this.a, new iy1(10005, "system deny"));
                } else {
                    this.g.D(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements mc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hw2 c;
        public final /* synthetic */ q52 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ bw1 f;

        public c(bw1 bw1Var, mc2.e eVar, String str, hw2 hw2Var, q52 q52Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw1Var, eVar, str, hw2Var, q52Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = bw1Var;
            this.a = eVar;
            this.b = str;
            this.c = hw2Var;
            this.d = q52Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.mc2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nz2.e(this.a, this.b);
                this.f.F(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ os1 a;
        public final /* synthetic */ hw2 b;
        public final /* synthetic */ q52 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ bw1 f;

        public d(bw1 bw1Var, os1 os1Var, hw2 hw2Var, q52 q52Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw1Var, os1Var, hw2Var, q52Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = bw1Var;
            this.a = os1Var;
            this.b = hw2Var;
            this.c = q52Var;
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
    public class e extends w52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p52 a;
        public final /* synthetic */ bw1 b;

        public e(bw1 bw1Var, p52 p52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw1Var, p52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bw1Var;
            this.a = p52Var;
        }

        @Override // com.baidu.tieba.w52, com.baidu.tieba.x52
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.Y2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.w52, com.baidu.tieba.x52
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = d53.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                d53.h(this.a);
            }
        }

        @Override // com.baidu.tieba.w52, com.baidu.tieba.x52
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = d53.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                d53.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947659277, "Lcom/baidu/tieba/bw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947659277, "Lcom/baidu/tieba/bw1;");
                return;
            }
        }
        g = op2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw1(@NonNull ju1 ju1Var) {
        super(ju1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ju1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ju1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public iy1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            r("#navigateTo params=" + str, false);
            return J(str, "0", "navigateTo");
        }
        return (iy1) invokeL.objValue;
    }

    public iy1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            r("#showModalPage params" + str, false);
            return J(str, "7", "showModalPage");
        }
        return (iy1) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void D(ur2 ur2Var, q52 q52Var, hw2 hw2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{ur2Var, q52Var, hw2Var, str, str2, str3}) == null) {
            bk3.a0(new b(this, ur2Var, str3, hw2Var, str, q52Var, str2));
        }
    }

    public final void E(os1 os1Var, hw2 hw2Var, q52 q52Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, os1Var, hw2Var, q52Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                G(os1Var, hw2Var, q52Var, str);
            } else {
                H(os1Var, hw2Var, q52Var, str);
            }
        }
    }

    public final void F(os1 os1Var, hw2 hw2Var, q52 q52Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, os1Var, hw2Var, q52Var, str, str2) == null) {
            if (bk3.O()) {
                E(os1Var, hw2Var, q52Var, str, str2);
            } else {
                bk3.a0(new d(this, os1Var, hw2Var, q52Var, str, str2));
            }
        }
    }

    public final void G(os1 os1Var, hw2 hw2Var, q52 q52Var, String str) {
        SwanAppActivity activity;
        p52 p52Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, os1Var, hw2Var, q52Var, str) == null) && (activity = ur2.V().getActivity()) != null && !activity.isFinishing()) {
            q93.e(os1Var, hw2Var, str);
            nz2.c(9, str);
            p52.Z3(bk3.n());
            q52.b k = q52Var.i("showModalPage").k("normal", hw2Var);
            if (!(q52Var.m() instanceof p52) || (p52Var = (p52) q52Var.m()) == null) {
                return;
            }
            p52Var.E0 = true;
            k.b();
            if (q52Var.k() > 1) {
                p52Var.E3().setBackgroundColor(0);
            } else {
                p52Var.E0 = false;
            }
            p52Var.G2(false);
            w52 w52Var = this.f;
            if (w52Var != null) {
                p52Var.Y2(w52Var);
            }
            e eVar = new e(this, p52Var);
            this.f = eVar;
            p52Var.t2(eVar);
            View c2 = d53.c(p52Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            d53.h(p52Var);
            PullToRefreshBaseWebView e0 = os1Var.e0();
            if (e0 != null) {
                e0.setIsPreventPullToRefresh(true);
            }
            mz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            nz2.a(str, hw2Var);
        }
    }

    public final void H(os1 os1Var, hw2 hw2Var, q52 q52Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, os1Var, hw2Var, q52Var, str) == null) && (activity = ur2.V().getActivity()) != null && !activity.isFinishing()) {
            q93.e(os1Var, hw2Var, str);
            nz2.c(0, str);
            if (q52Var.k() < g) {
                p52.Z3(bk3.n());
                q52.b i = q52Var.i("navigateTo");
                i.n(q52.g, q52.i);
                i.k("normal", hw2Var).b();
                ri3.c(q52Var, i());
                mz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                nz2.a(str, hw2Var);
                return;
            }
            cw1.B(q52Var, hw2Var, str, true);
        }
    }

    public final iy1 J(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            h63 c0 = h63.c0();
            if (c0 == null) {
                return new iy1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            nz2.b(uuid);
            Pair<iy1, JSONObject> t = t(str);
            iy1 iy1Var = (iy1) t.first;
            if (!iy1Var.isSuccess()) {
                return iy1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String p = q93.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                h32.c("NavigateToApi", "url is null");
                return new iy1(202, "url is null");
            }
            ur2 V = ur2.V();
            q52 W = V.W();
            if (W == null) {
                h32.c("NavigateToApi", "manager is null");
                return new iy1(1001, "manager is null");
            }
            hw2 d2 = hw2.d(p, V.A());
            d2.e = str2;
            d2.f = uuid;
            vc3.g(d2);
            if (!bk3.b(V.t(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                h32.c("NavigateToApi", str4);
                vc3.i(d2);
                return new iy1(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && h63.M() != null) {
                h63.M().M0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = mz2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                h32.c("NavigateToApi", "cb is empty");
                vc3.i(d2);
                return new iy1(202, "cb is empty");
            } else if (u83.b().a(d2)) {
                u83.b().i(str3, d2);
                h32.c("NavigateToApi", "access to this page is prohibited");
                return new iy1(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    c0.f0().g(i(), "mapp_show_modal_page", new a(this, optString3, V, W, d2, uuid, str2));
                } else {
                    D(V, W, d2, uuid, str2, optString3);
                }
                return iy1.f();
            }
        }
        return (iy1) invokeLLL.objValue;
    }

    public final void L(mc2.e eVar, hw2 hw2Var, q52 q52Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, hw2Var, q52Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = mz2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            mc2.q(eVar, new c(this, eVar, str, hw2Var, q52Var, str2));
        }
    }
}
