package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.a73;
import com.baidu.tieba.q83;
import com.baidu.tieba.q92;
import com.baidu.tieba.u22;
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
/* loaded from: classes3.dex */
public class et1 extends ct1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public a32 f;

    /* loaded from: classes3.dex */
    public class a implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yo2 b;
        public final /* synthetic */ u22 c;
        public final /* synthetic */ lt2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ et1 g;

        public a(et1 et1Var, String str, yo2 yo2Var, u22 u22Var, lt2 lt2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et1Var, str, yo2Var, u22Var, lt2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = et1Var;
            this.a = str;
            this.b = yo2Var;
            this.c = u22Var;
            this.d = lt2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                if (j83.h(o83Var)) {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                } else {
                    this.g.d(this.a, new lv1(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yo2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lt2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ u22 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ et1 g;

        /* loaded from: classes3.dex */
        public class a implements a73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l33 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, l33 l33Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, l33Var, activity};
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
                this.a = l33Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.a73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    rw2.d(this.c.d);
                    l02.i("NavigateToApi", "check pages success");
                    ea3.F(true, this.a.Y().T());
                    this.c.a.o();
                    q92.e f = q92.f(this.b, v92.c(this.c.c.a));
                    List<String> g = u63.g(this.c.e);
                    et1 et1Var = this.c.g;
                    l33 l33Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    u63.m(et1Var, l33Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.a73.e
            public void b(int i, ef3 ef3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ef3Var) == null) {
                    l02.c("NavigateToApi", "check pages failed");
                    ea3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    u63.k(bVar.g, bVar.b);
                    z93.j(this.c.c, ef3Var);
                }
            }
        }

        public b(et1 et1Var, yo2 yo2Var, String str, lt2 lt2Var, String str2, u22 u22Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et1Var, yo2Var, str, lt2Var, str2, u22Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = et1Var;
            this.a = yo2Var;
            this.b = str;
            this.c = lt2Var;
            this.d = str2;
            this.e = u22Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    l33 M = l33.M();
                    if (M == null) {
                        this.g.d(this.b, new lv1(1001, "swan app is null"));
                        z93.i(this.c);
                        return;
                    }
                    this.a.a();
                    a73.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new lv1(1001, "swan activity is null"));
                z93.i(this.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements q92.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q92.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lt2 c;
        public final /* synthetic */ u22 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ et1 f;

        public c(et1 et1Var, q92.e eVar, String str, lt2 lt2Var, u22 u22Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et1Var, eVar, str, lt2Var, u22Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = et1Var;
            this.a = eVar;
            this.b = str;
            this.c = lt2Var;
            this.d = u22Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.q92.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rw2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp1 a;
        public final /* synthetic */ lt2 b;
        public final /* synthetic */ u22 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ et1 f;

        public d(et1 et1Var, rp1 rp1Var, lt2 lt2Var, u22 u22Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et1Var, rp1Var, lt2Var, u22Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = et1Var;
            this.a = rp1Var;
            this.b = lt2Var;
            this.c = u22Var;
            this.d = str;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.D(this.a, this.b, this.c, this.d, this.e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends a32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t22 a;
        public final /* synthetic */ et1 b;

        public e(et1 et1Var, t22 t22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et1Var, t22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = et1Var;
            this.a = t22Var;
        }

        @Override // com.baidu.tieba.a32, com.baidu.tieba.b32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.R2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.a32, com.baidu.tieba.b32
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = h23.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                h23.h(this.a);
            }
        }

        @Override // com.baidu.tieba.a32, com.baidu.tieba.b32
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = h23.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                h23.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947745767, "Lcom/baidu/tieba/et1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947745767, "Lcom/baidu/tieba/et1;");
                return;
            }
        }
        g = sm2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public et1(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(yo2 yo2Var, u22 u22Var, lt2 lt2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{yo2Var, u22Var, lt2Var, str, str2, str3}) == null) {
            fh3.a0(new b(this, yo2Var, str3, lt2Var, str, u22Var, str2));
        }
    }

    public final void D(rp1 rp1Var, lt2 lt2Var, u22 u22Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rp1Var, lt2Var, u22Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(rp1Var, lt2Var, u22Var, str);
            } else {
                G(rp1Var, lt2Var, u22Var, str);
            }
        }
    }

    public final void E(rp1 rp1Var, lt2 lt2Var, u22 u22Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, rp1Var, lt2Var, u22Var, str, str2) == null) {
            if (fh3.O()) {
                D(rp1Var, lt2Var, u22Var, str, str2);
            } else {
                fh3.a0(new d(this, rp1Var, lt2Var, u22Var, str, str2));
            }
        }
    }

    public final void F(rp1 rp1Var, lt2 lt2Var, u22 u22Var, String str) {
        SwanAppActivity activity;
        t22 t22Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, rp1Var, lt2Var, u22Var, str) == null) || (activity = yo2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        u63.e(rp1Var, lt2Var, str);
        rw2.c(9, str);
        t22.S3(fh3.n());
        u22.b k = u22Var.i("showModalPage").k("normal", lt2Var);
        if ((u22Var.m() instanceof t22) && (t22Var = (t22) u22Var.m()) != null) {
            t22Var.D0 = true;
            k.b();
            if (u22Var.k() > 1) {
                t22Var.x3().setBackgroundColor(0);
            } else {
                t22Var.D0 = false;
            }
            t22Var.z2(false);
            a32 a32Var = this.f;
            if (a32Var != null) {
                t22Var.R2(a32Var);
            }
            e eVar = new e(this, t22Var);
            this.f = eVar;
            t22Var.n2(eVar);
            View c2 = h23.c(t22Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            h23.h(t22Var);
            PullToRefreshBaseWebView h0 = rp1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            qw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            rw2.a(str, lt2Var);
        }
    }

    public final void G(rp1 rp1Var, lt2 lt2Var, u22 u22Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, rp1Var, lt2Var, u22Var, str) == null) || (activity = yo2.U().getActivity()) == null || activity.isFinishing()) {
            return;
        }
        u63.e(rp1Var, lt2Var, str);
        rw2.c(0, str);
        if (u22Var.k() < g) {
            t22.S3(fh3.n());
            u22.b i = u22Var.i("navigateTo");
            i.n(u22.g, u22.i);
            i.k("normal", lt2Var).b();
            vf3.c(u22Var, getContext());
            qw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            rw2.a(str, lt2Var);
            return;
        }
        ft1.A(u22Var, lt2Var, str, true);
    }

    public lv1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (lv1) invokeL.objValue;
    }

    public final lv1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            l33 b0 = l33.b0();
            if (b0 == null) {
                return new lv1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            rw2.b(uuid);
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (lv1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = u63.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    l02.c("NavigateToApi", "url is null");
                    return new lv1(202, "url is null");
                }
                yo2 U = yo2.U();
                u22 V = U.V();
                if (V == null) {
                    l02.c("NavigateToApi", "manager is null");
                    return new lv1(1001, "manager is null");
                }
                lt2 d2 = lt2.d(p, U.z());
                d2.e = str2;
                d2.f = uuid;
                z93.g(d2);
                if (!fh3.b(U.s(), d2, false)) {
                    String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                    l02.c("NavigateToApi", str4);
                    z93.i(d2);
                    return new lv1(202, str4);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && l33.M() != null) {
                    l33.M().L0(optString, d2.d);
                }
                String optString2 = jSONObject.optString(FetchLog.START_TIME);
                if (!TextUtils.isEmpty(optString2)) {
                    HybridUbcFlow q = qw2.q("route", uuid);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                    ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                    q.F(ubcFlowEvent);
                }
                String optString3 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString3)) {
                    l02.c("NavigateToApi", "cb is empty");
                    z93.i(d2);
                    return new lv1(202, "cb is empty");
                } else if (y53.b().a(d2)) {
                    y53.b().i(str3, d2);
                    l02.c("NavigateToApi", "access to this page is prohibited");
                    return new lv1(1003, "access to this page is prohibited");
                } else {
                    if (TextUtils.equals("7", str2)) {
                        b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                    } else {
                        C(U, V, d2, uuid, str2, optString3);
                    }
                    return lv1.f();
                }
            }
            return lv1Var;
        }
        return (lv1) invokeLLL.objValue;
    }

    public lv1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (lv1) invokeL.objValue;
    }

    public final void K(q92.e eVar, lt2 lt2Var, u22 u22Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, lt2Var, u22Var, str, str2) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = qw2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            q92.q(eVar, new c(this, eVar, str, lt2Var, u22Var, str2));
        }
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }
}
