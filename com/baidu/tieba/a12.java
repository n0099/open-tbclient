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
import com.baidu.tieba.mg3;
import com.baidu.tieba.mh2;
import com.baidu.tieba.qa2;
import com.baidu.tieba.we3;
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
public class a12 extends y02 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public wa2 f;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uw2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ h13 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ qa2 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ a12 g;

        /* loaded from: classes5.dex */
        public class a implements we3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hb3 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, hb3 hb3Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, hb3Var, activity};
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
                this.a = hb3Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.we3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    n43.d(this.c.d);
                    h82.i("NavigateToApi", "check pages success");
                    ai3.F(true, this.a.Y().T());
                    this.c.a.o();
                    mh2.e f = mh2.f(this.b, rh2.c(this.c.c.a));
                    List<String> g = qe3.g(this.c.e);
                    a12 a12Var = this.c.g;
                    hb3 hb3Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    qe3.m(a12Var, hb3Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.we3.e
            public void b(int i, an3 an3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, an3Var) == null) {
                    h82.c("NavigateToApi", "check pages failed");
                    ai3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    qe3.k(bVar.g, bVar.b);
                    vh3.j(this.c.c, an3Var);
                }
            }
        }

        public b(a12 a12Var, uw2 uw2Var, String str, h13 h13Var, String str2, qa2 qa2Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a12Var, uw2Var, str, h13Var, str2, qa2Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = a12Var;
            this.a = uw2Var;
            this.b = str;
            this.c = h13Var;
            this.d = str2;
            this.e = qa2Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    hb3 M = hb3.M();
                    if (M == null) {
                        this.g.d(this.b, new h32(1001, "swan app is null"));
                        vh3.i(this.c);
                        return;
                    }
                    this.a.a();
                    we3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new h32(1001, "swan activity is null"));
                vh3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ uw2 b;
        public final /* synthetic */ qa2 c;
        public final /* synthetic */ h13 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ a12 g;

        public a(a12 a12Var, String str, uw2 uw2Var, qa2 qa2Var, h13 h13Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a12Var, str, uw2Var, qa2Var, h13Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = a12Var;
            this.a = str;
            this.b = uw2Var;
            this.c = qa2Var;
            this.d = h13Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (!fg3.h(kg3Var)) {
                    this.g.d(this.a, new h32(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements mh2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ h13 c;
        public final /* synthetic */ qa2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ a12 f;

        public c(a12 a12Var, mh2.e eVar, String str, h13 h13Var, qa2 qa2Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a12Var, eVar, str, h13Var, qa2Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = a12Var;
            this.a = eVar;
            this.b = str;
            this.c = h13Var;
            this.d = qa2Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.mh2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n43.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx1 a;
        public final /* synthetic */ h13 b;
        public final /* synthetic */ qa2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ a12 f;

        public d(a12 a12Var, nx1 nx1Var, h13 h13Var, qa2 qa2Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a12Var, nx1Var, h13Var, qa2Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = a12Var;
            this.a = nx1Var;
            this.b = h13Var;
            this.c = qa2Var;
            this.d = str;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.f.D(this.a, this.b, this.c, this.d, this.e);
        }
    }

    /* loaded from: classes5.dex */
    public class e extends wa2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa2 a;
        public final /* synthetic */ a12 b;

        public e(a12 a12Var, pa2 pa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a12Var, pa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a12Var;
            this.a = pa2Var;
        }

        @Override // com.baidu.tieba.wa2, com.baidu.tieba.xa2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.T2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.wa2, com.baidu.tieba.xa2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = da3.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                da3.h(this.a);
            }
        }

        @Override // com.baidu.tieba.wa2, com.baidu.tieba.xa2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = da3.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                da3.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947562247, "Lcom/baidu/tieba/a12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947562247, "Lcom/baidu/tieba/a12;");
                return;
            }
        }
        g = ou2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a12(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public h32 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (h32) invokeL.objValue;
    }

    public h32 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (h32) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(uw2 uw2Var, qa2 qa2Var, h13 h13Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{uw2Var, qa2Var, h13Var, str, str2, str3}) == null) {
            bp3.a0(new b(this, uw2Var, str3, h13Var, str, qa2Var, str2));
        }
    }

    public final void D(nx1 nx1Var, h13 h13Var, qa2 qa2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nx1Var, h13Var, qa2Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(nx1Var, h13Var, qa2Var, str);
            } else {
                G(nx1Var, h13Var, qa2Var, str);
            }
        }
    }

    public final void E(nx1 nx1Var, h13 h13Var, qa2 qa2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, nx1Var, h13Var, qa2Var, str, str2) == null) {
            if (bp3.O()) {
                D(nx1Var, h13Var, qa2Var, str, str2);
            } else {
                bp3.a0(new d(this, nx1Var, h13Var, qa2Var, str, str2));
            }
        }
    }

    public final void F(nx1 nx1Var, h13 h13Var, qa2 qa2Var, String str) {
        SwanAppActivity activity;
        pa2 pa2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, nx1Var, h13Var, qa2Var, str) == null) && (activity = uw2.T().getActivity()) != null && !activity.isFinishing()) {
            qe3.e(nx1Var, h13Var, str);
            n43.c(9, str);
            pa2.U3(bp3.n());
            qa2.b k = qa2Var.i("showModalPage").k("normal", h13Var);
            if (!(qa2Var.m() instanceof pa2) || (pa2Var = (pa2) qa2Var.m()) == null) {
                return;
            }
            pa2Var.E0 = true;
            k.b();
            if (qa2Var.k() > 1) {
                pa2Var.z3().setBackgroundColor(0);
            } else {
                pa2Var.E0 = false;
            }
            pa2Var.B2(false);
            wa2 wa2Var = this.f;
            if (wa2Var != null) {
                pa2Var.T2(wa2Var);
            }
            e eVar = new e(this, pa2Var);
            this.f = eVar;
            pa2Var.p2(eVar);
            View c2 = da3.c(pa2Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            da3.h(pa2Var);
            PullToRefreshBaseWebView f0 = nx1Var.f0();
            if (f0 != null) {
                f0.setIsPreventPullToRefresh(true);
            }
            m43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            n43.a(str, h13Var);
        }
    }

    public final void G(nx1 nx1Var, h13 h13Var, qa2 qa2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, nx1Var, h13Var, qa2Var, str) == null) && (activity = uw2.T().getActivity()) != null && !activity.isFinishing()) {
            qe3.e(nx1Var, h13Var, str);
            n43.c(0, str);
            if (qa2Var.k() < g) {
                pa2.U3(bp3.n());
                qa2.b i = qa2Var.i("navigateTo");
                i.n(qa2.g, qa2.i);
                i.k("normal", h13Var).b();
                rn3.c(qa2Var, getContext());
                m43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                n43.a(str, h13Var);
                return;
            }
            b12.A(qa2Var, h13Var, str, true);
        }
    }

    public final h32 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                return new h32(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            n43.b(uuid);
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = qe3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                h82.c("NavigateToApi", "url is null");
                return new h32(202, "url is null");
            }
            uw2 T2 = uw2.T();
            qa2 U = T2.U();
            if (U == null) {
                h82.c("NavigateToApi", "manager is null");
                return new h32(1001, "manager is null");
            }
            h13 d2 = h13.d(p, T2.z());
            d2.e = str2;
            d2.f = uuid;
            vh3.g(d2);
            if (!bp3.b(T2.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                h82.c("NavigateToApi", str4);
                vh3.i(d2);
                return new h32(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && hb3.M() != null) {
                hb3.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = m43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                h82.c("NavigateToApi", "cb is empty");
                vh3.i(d2);
                return new h32(202, "cb is empty");
            } else if (ud3.b().a(d2)) {
                ud3.b().i(str3, d2);
                h82.c("NavigateToApi", "access to this page is prohibited");
                return new h32(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, T2, U, d2, uuid, str2));
                } else {
                    C(T2, U, d2, uuid, str2, optString3);
                }
                return h32.f();
            }
        }
        return (h32) invokeLLL.objValue;
    }

    public final void K(mh2.e eVar, h13 h13Var, qa2 qa2Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, h13Var, qa2Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = m43.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            mh2.q(eVar, new c(this, eVar, str, h13Var, qa2Var, str2));
        }
    }
}
