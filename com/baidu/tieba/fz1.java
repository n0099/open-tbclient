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
import com.baidu.tieba.bd3;
import com.baidu.tieba.re3;
import com.baidu.tieba.rf2;
import com.baidu.tieba.v82;
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
public class fz1 extends dz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public b92 f;

    @Override // com.baidu.tieba.px1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zu2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mz2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ v82 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ fz1 g;

        /* loaded from: classes4.dex */
        public class a implements bd3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m93 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, m93 m93Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, m93Var, activity};
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
                this.a = m93Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.bd3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    s23.d(this.c.d);
                    m62.i("NavigateToApi", "check pages success");
                    fg3.F(true, this.a.Y().T());
                    this.c.a.o();
                    rf2.e f = rf2.f(this.b, wf2.c(this.c.c.a));
                    List<String> g = vc3.g(this.c.e);
                    fz1 fz1Var = this.c.g;
                    m93 m93Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    vc3.m(fz1Var, m93Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.bd3.e
            public void b(int i, fl3 fl3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, fl3Var) == null) {
                    m62.c("NavigateToApi", "check pages failed");
                    fg3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    vc3.k(bVar.g, bVar.b);
                    ag3.j(this.c.c, fl3Var);
                }
            }
        }

        public b(fz1 fz1Var, zu2 zu2Var, String str, mz2 mz2Var, String str2, v82 v82Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz1Var, zu2Var, str, mz2Var, str2, v82Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = fz1Var;
            this.a = zu2Var;
            this.b = str;
            this.c = mz2Var;
            this.d = str2;
            this.e = v82Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    m93 M = m93.M();
                    if (M == null) {
                        this.g.d(this.b, new m12(1001, "swan app is null"));
                        ag3.i(this.c);
                        return;
                    }
                    this.a.a();
                    bd3.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new m12(1001, "swan activity is null"));
                ag3.i(this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements fo3<pe3<re3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ zu2 b;
        public final /* synthetic */ v82 c;
        public final /* synthetic */ mz2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ fz1 g;

        public a(fz1 fz1Var, String str, zu2 zu2Var, v82 v82Var, mz2 mz2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz1Var, str, zu2Var, v82Var, mz2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = fz1Var;
            this.a = str;
            this.b = zu2Var;
            this.c = v82Var;
            this.d = mz2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(pe3<re3.e> pe3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pe3Var) == null) {
                if (!ke3.h(pe3Var)) {
                    this.g.d(this.a, new m12(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements rf2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rf2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mz2 c;
        public final /* synthetic */ v82 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ fz1 f;

        public c(fz1 fz1Var, rf2.e eVar, String str, mz2 mz2Var, v82 v82Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz1Var, eVar, str, mz2Var, v82Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = fz1Var;
            this.a = eVar;
            this.b = str;
            this.c = mz2Var;
            this.d = v82Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.rf2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s23.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv1 a;
        public final /* synthetic */ mz2 b;
        public final /* synthetic */ v82 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ fz1 f;

        public d(fz1 fz1Var, sv1 sv1Var, mz2 mz2Var, v82 v82Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz1Var, sv1Var, mz2Var, v82Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = fz1Var;
            this.a = sv1Var;
            this.b = mz2Var;
            this.c = v82Var;
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
    public class e extends b92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u82 a;
        public final /* synthetic */ fz1 b;

        public e(fz1 fz1Var, u82 u82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz1Var, u82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fz1Var;
            this.a = u82Var;
        }

        @Override // com.baidu.tieba.b92, com.baidu.tieba.c92
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.R2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.b92, com.baidu.tieba.c92
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = i83.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                i83.h(this.a);
            }
        }

        @Override // com.baidu.tieba.b92, com.baidu.tieba.c92
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = i83.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                i83.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947781324, "Lcom/baidu/tieba/fz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947781324, "Lcom/baidu/tieba/fz1;");
                return;
            }
        }
        g = ts2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fz1(@NonNull nx1 nx1Var) {
        super(nx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nx1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nx1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public m12 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (m12) invokeL.objValue;
    }

    public m12 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (m12) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(zu2 zu2Var, v82 v82Var, mz2 mz2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{zu2Var, v82Var, mz2Var, str, str2, str3}) == null) {
            gn3.a0(new b(this, zu2Var, str3, mz2Var, str, v82Var, str2));
        }
    }

    public final void D(sv1 sv1Var, mz2 mz2Var, v82 v82Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sv1Var, mz2Var, v82Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(sv1Var, mz2Var, v82Var, str);
            } else {
                G(sv1Var, mz2Var, v82Var, str);
            }
        }
    }

    public final void E(sv1 sv1Var, mz2 mz2Var, v82 v82Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, sv1Var, mz2Var, v82Var, str, str2) == null) {
            if (gn3.O()) {
                D(sv1Var, mz2Var, v82Var, str, str2);
            } else {
                gn3.a0(new d(this, sv1Var, mz2Var, v82Var, str, str2));
            }
        }
    }

    public final void F(sv1 sv1Var, mz2 mz2Var, v82 v82Var, String str) {
        SwanAppActivity activity;
        u82 u82Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, sv1Var, mz2Var, v82Var, str) == null) && (activity = zu2.U().getActivity()) != null && !activity.isFinishing()) {
            vc3.e(sv1Var, mz2Var, str);
            s23.c(9, str);
            u82.S3(gn3.n());
            v82.b k = v82Var.i("showModalPage").k("normal", mz2Var);
            if (!(v82Var.m() instanceof u82) || (u82Var = (u82) v82Var.m()) == null) {
                return;
            }
            u82Var.E0 = true;
            k.b();
            if (v82Var.k() > 1) {
                u82Var.x3().setBackgroundColor(0);
            } else {
                u82Var.E0 = false;
            }
            u82Var.z2(false);
            b92 b92Var = this.f;
            if (b92Var != null) {
                u82Var.R2(b92Var);
            }
            e eVar = new e(this, u82Var);
            this.f = eVar;
            u82Var.n2(eVar);
            View c2 = i83.c(u82Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            i83.h(u82Var);
            PullToRefreshBaseWebView h0 = sv1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            r23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            s23.a(str, mz2Var);
        }
    }

    public final void G(sv1 sv1Var, mz2 mz2Var, v82 v82Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, sv1Var, mz2Var, v82Var, str) == null) && (activity = zu2.U().getActivity()) != null && !activity.isFinishing()) {
            vc3.e(sv1Var, mz2Var, str);
            s23.c(0, str);
            if (v82Var.k() < g) {
                u82.S3(gn3.n());
                v82.b i = v82Var.i("navigateTo");
                i.n(v82.g, v82.i);
                i.k("normal", mz2Var).b();
                wl3.c(v82Var, getContext());
                r23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                s23.a(str, mz2Var);
                return;
            }
            gz1.A(v82Var, mz2Var, str, true);
        }
    }

    public final m12 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            m93 b0 = m93.b0();
            if (b0 == null) {
                return new m12(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            s23.b(uuid);
            Pair<m12, JSONObject> s = s(str);
            m12 m12Var = (m12) s.first;
            if (!m12Var.isSuccess()) {
                return m12Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = vc3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                m62.c("NavigateToApi", "url is null");
                return new m12(202, "url is null");
            }
            zu2 U = zu2.U();
            v82 V = U.V();
            if (V == null) {
                m62.c("NavigateToApi", "manager is null");
                return new m12(1001, "manager is null");
            }
            mz2 d2 = mz2.d(p, U.z());
            d2.e = str2;
            d2.f = uuid;
            ag3.g(d2);
            if (!gn3.b(U.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                m62.c("NavigateToApi", str4);
                ag3.i(d2);
                return new m12(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && m93.M() != null) {
                m93.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = r23.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                m62.c("NavigateToApi", "cb is empty");
                ag3.i(d2);
                return new m12(202, "cb is empty");
            } else if (zb3.b().a(d2)) {
                zb3.b().i(str3, d2);
                m62.c("NavigateToApi", "access to this page is prohibited");
                return new m12(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                } else {
                    C(U, V, d2, uuid, str2, optString3);
                }
                return m12.f();
            }
        }
        return (m12) invokeLLL.objValue;
    }

    public final void K(rf2.e eVar, mz2 mz2Var, v82 v82Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, mz2Var, v82Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = r23.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            rf2.q(eVar, new c(this, eVar, str, mz2Var, v82Var, str2));
        }
    }
}
