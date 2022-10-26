package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.b73;
import com.baidu.tieba.r92;
import com.baidu.tieba.v22;
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
/* loaded from: classes4.dex */
public class ft1 extends dt1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public b32 f;

    @Override // com.baidu.tieba.pr1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mt2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ v22 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ft1 g;

        /* loaded from: classes4.dex */
        public class a implements b73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m33 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, m33 m33Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, m33Var, activity};
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
                this.a = m33Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.b73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    sw2.d(this.c.d);
                    m02.i("NavigateToApi", "check pages success");
                    fa3.F(true, this.a.Y().T());
                    this.c.a.o();
                    r92.e f = r92.f(this.b, w92.c(this.c.c.a));
                    List g = v63.g(this.c.e);
                    ft1 ft1Var = this.c.g;
                    m33 m33Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    v63.m(ft1Var, m33Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.b73.e
            public void b(int i, ff3 ff3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ff3Var) == null) {
                    m02.c("NavigateToApi", "check pages failed");
                    fa3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    v63.k(bVar.g, bVar.b);
                    aa3.j(this.c.c, ff3Var);
                }
            }
        }

        public b(ft1 ft1Var, zo2 zo2Var, String str, mt2 mt2Var, String str2, v22 v22Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft1Var, zo2Var, str, mt2Var, str2, v22Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ft1Var;
            this.a = zo2Var;
            this.b = str;
            this.c = mt2Var;
            this.d = str2;
            this.e = v22Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    m33 M = m33.M();
                    if (M == null) {
                        this.g.d(this.b, new mv1(1001, "swan app is null"));
                        aa3.i(this.c);
                        return;
                    }
                    this.a.a();
                    b73.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new mv1(1001, "swan activity is null"));
                aa3.i(this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ zo2 b;
        public final /* synthetic */ v22 c;
        public final /* synthetic */ mt2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ft1 g;

        public a(ft1 ft1Var, String str, zo2 zo2Var, v22 v22Var, mt2 mt2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft1Var, str, zo2Var, v22Var, mt2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ft1Var;
            this.a = str;
            this.b = zo2Var;
            this.c = v22Var;
            this.d = mt2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(p83 p83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p83Var) == null) {
                if (!k83.h(p83Var)) {
                    this.g.d(this.a, new mv1(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements r92.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r92.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mt2 c;
        public final /* synthetic */ v22 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ft1 f;

        public c(ft1 ft1Var, r92.e eVar, String str, mt2 mt2Var, v22 v22Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft1Var, eVar, str, mt2Var, v22Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ft1Var;
            this.a = eVar;
            this.b = str;
            this.c = mt2Var;
            this.d = v22Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.r92.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sw2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp1 a;
        public final /* synthetic */ mt2 b;
        public final /* synthetic */ v22 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ft1 f;

        public d(ft1 ft1Var, sp1 sp1Var, mt2 mt2Var, v22 v22Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft1Var, sp1Var, mt2Var, v22Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ft1Var;
            this.a = sp1Var;
            this.b = mt2Var;
            this.c = v22Var;
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

    /* loaded from: classes4.dex */
    public class e extends b32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 a;
        public final /* synthetic */ ft1 b;

        public e(ft1 ft1Var, u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft1Var, u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ft1Var;
            this.a = u22Var;
        }

        @Override // com.baidu.tieba.b32, com.baidu.tieba.c32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.R2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.b32, com.baidu.tieba.c32
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = i23.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                i23.h(this.a);
            }
        }

        @Override // com.baidu.tieba.b32, com.baidu.tieba.c32
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = i23.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                i23.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947775558, "Lcom/baidu/tieba/ft1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947775558, "Lcom/baidu/tieba/ft1;");
                return;
            }
        }
        g = tm2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ft1(nr1 nr1Var) {
        super(nr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public mv1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (mv1) invokeL.objValue;
    }

    public mv1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (mv1) invokeL.objValue;
    }

    public final void C(zo2 zo2Var, v22 v22Var, mt2 mt2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{zo2Var, v22Var, mt2Var, str, str2, str3}) == null) {
            gh3.a0(new b(this, zo2Var, str3, mt2Var, str, v22Var, str2));
        }
    }

    public final void D(sp1 sp1Var, mt2 mt2Var, v22 v22Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sp1Var, mt2Var, v22Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(sp1Var, mt2Var, v22Var, str);
            } else {
                G(sp1Var, mt2Var, v22Var, str);
            }
        }
    }

    public final void E(sp1 sp1Var, mt2 mt2Var, v22 v22Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, sp1Var, mt2Var, v22Var, str, str2) == null) {
            if (gh3.O()) {
                D(sp1Var, mt2Var, v22Var, str, str2);
            } else {
                gh3.a0(new d(this, sp1Var, mt2Var, v22Var, str, str2));
            }
        }
    }

    public final void F(sp1 sp1Var, mt2 mt2Var, v22 v22Var, String str) {
        SwanAppActivity activity;
        u22 u22Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, sp1Var, mt2Var, v22Var, str) == null) && (activity = zo2.U().getActivity()) != null && !activity.isFinishing()) {
            v63.e(sp1Var, mt2Var, str);
            sw2.c(9, str);
            u22.S3(gh3.n());
            v22.b k = v22Var.i("showModalPage").k("normal", mt2Var);
            if (!(v22Var.m() instanceof u22) || (u22Var = (u22) v22Var.m()) == null) {
                return;
            }
            u22Var.D0 = true;
            k.b();
            if (v22Var.k() > 1) {
                u22Var.x3().setBackgroundColor(0);
            } else {
                u22Var.D0 = false;
            }
            u22Var.z2(false);
            b32 b32Var = this.f;
            if (b32Var != null) {
                u22Var.R2(b32Var);
            }
            e eVar = new e(this, u22Var);
            this.f = eVar;
            u22Var.n2(eVar);
            View c2 = i23.c(u22Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            i23.h(u22Var);
            PullToRefreshBaseWebView h0 = sp1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            rw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            sw2.a(str, mt2Var);
        }
    }

    public final void G(sp1 sp1Var, mt2 mt2Var, v22 v22Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, sp1Var, mt2Var, v22Var, str) == null) && (activity = zo2.U().getActivity()) != null && !activity.isFinishing()) {
            v63.e(sp1Var, mt2Var, str);
            sw2.c(0, str);
            if (v22Var.k() < g) {
                u22.S3(gh3.n());
                v22.b i = v22Var.i("navigateTo");
                i.n(v22.g, v22.i);
                i.k("normal", mt2Var).b();
                wf3.c(v22Var, getContext());
                rw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                sw2.a(str, mt2Var);
                return;
            }
            gt1.A(v22Var, mt2Var, str, true);
        }
    }

    public final mv1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            m33 b0 = m33.b0();
            if (b0 == null) {
                return new mv1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            sw2.b(uuid);
            Pair s = s(str);
            mv1 mv1Var = (mv1) s.first;
            if (!mv1Var.isSuccess()) {
                return mv1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = v63.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                m02.c("NavigateToApi", "url is null");
                return new mv1(202, "url is null");
            }
            zo2 U = zo2.U();
            v22 V = U.V();
            if (V == null) {
                m02.c("NavigateToApi", "manager is null");
                return new mv1(1001, "manager is null");
            }
            mt2 d2 = mt2.d(p, U.z());
            d2.e = str2;
            d2.f = uuid;
            aa3.g(d2);
            if (!gh3.b(U.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                m02.c("NavigateToApi", str4);
                aa3.i(d2);
                return new mv1(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && m33.M() != null) {
                m33.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString(FetchLog.START_TIME);
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = rw2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                m02.c("NavigateToApi", "cb is empty");
                aa3.i(d2);
                return new mv1(202, "cb is empty");
            } else if (z53.b().a(d2)) {
                z53.b().i(str3, d2);
                m02.c("NavigateToApi", "access to this page is prohibited");
                return new mv1(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                } else {
                    C(U, V, d2, uuid, str2, optString3);
                }
                return mv1.f();
            }
        }
        return (mv1) invokeLLL.objValue;
    }

    public final void K(r92.e eVar, mt2 mt2Var, v22 v22Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, mt2Var, v22Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = rw2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            r92.q(eVar, new c(this, eVar, str, mt2Var, v22Var, str2));
        }
    }
}
