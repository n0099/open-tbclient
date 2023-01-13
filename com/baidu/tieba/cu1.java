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
import com.baidu.tieba.o93;
import com.baidu.tieba.oa2;
import com.baidu.tieba.s32;
import com.baidu.tieba.y73;
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
public class cu1 extends au1 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public y32 f;

    @Override // com.baidu.tieba.ms1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "NavigateToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ju2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ s32 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ cu1 g;

        /* loaded from: classes4.dex */
        public class a implements y73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j43 a;
            public final /* synthetic */ Activity b;
            public final /* synthetic */ b c;

            public a(b bVar, j43 j43Var, Activity activity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, j43Var, activity};
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
                this.a = j43Var;
                this.b = activity;
            }

            @Override // com.baidu.tieba.y73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    px2.d(this.c.d);
                    j12.i("NavigateToApi", "check pages success");
                    cb3.F(true, this.a.Y().T());
                    this.c.a.o();
                    oa2.e f = oa2.f(this.b, ta2.c(this.c.c.a));
                    List<String> g = s73.g(this.c.e);
                    cu1 cu1Var = this.c.g;
                    j43 j43Var = this.a;
                    String a = f.a.a();
                    b bVar = this.c;
                    s73.m(cu1Var, j43Var, a, bVar.c.a, g, bVar.b);
                    b bVar2 = this.c;
                    bVar2.g.K(f, bVar2.c, bVar2.e, bVar2.d, bVar2.f);
                }
            }

            @Override // com.baidu.tieba.y73.e
            public void b(int i, cg3 cg3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cg3Var) == null) {
                    j12.c("NavigateToApi", "check pages failed");
                    cb3.F(false, this.a.Y().T());
                    this.c.a.o();
                    b bVar = this.c;
                    s73.k(bVar.g, bVar.b);
                    xa3.j(this.c.c, cg3Var);
                }
            }
        }

        public b(cu1 cu1Var, wp2 wp2Var, String str, ju2 ju2Var, String str2, s32 s32Var, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu1Var, wp2Var, str, ju2Var, str2, s32Var, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = cu1Var;
            this.a = wp2Var;
            this.b = str;
            this.c = ju2Var;
            this.d = str2;
            this.e = s32Var;
            this.f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    j43 M = j43.M();
                    if (M == null) {
                        this.g.d(this.b, new jw1(1001, "swan app is null"));
                        xa3.i(this.c);
                        return;
                    }
                    this.a.a();
                    y73.g(M, this.c, "", new a(this, M, activity), this.d);
                    return;
                }
                this.g.d(this.b, new jw1(1001, "swan activity is null"));
                xa3.i(this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements cj3<m93<o93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wp2 b;
        public final /* synthetic */ s32 c;
        public final /* synthetic */ ju2 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ cu1 g;

        public a(cu1 cu1Var, String str, wp2 wp2Var, s32 s32Var, ju2 ju2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu1Var, str, wp2Var, s32Var, ju2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = cu1Var;
            this.a = str;
            this.b = wp2Var;
            this.c = s32Var;
            this.d = ju2Var;
            this.e = str2;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(m93<o93.e> m93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m93Var) == null) {
                if (!h93.h(m93Var)) {
                    this.g.d(this.a, new jw1(10005, "system deny"));
                } else {
                    this.g.C(this.b, this.c, this.d, this.e, this.f, this.a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements oa2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oa2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ju2 c;
        public final /* synthetic */ s32 d;
        public final /* synthetic */ String e;
        public final /* synthetic */ cu1 f;

        public c(cu1 cu1Var, oa2.e eVar, String str, ju2 ju2Var, s32 s32Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu1Var, eVar, str, ju2Var, s32Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = cu1Var;
            this.a = eVar;
            this.b = str;
            this.c = ju2Var;
            this.d = s32Var;
            this.e = str2;
        }

        @Override // com.baidu.tieba.oa2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                px2.e(this.a, this.b);
                this.f.E(this.a.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pq1 a;
        public final /* synthetic */ ju2 b;
        public final /* synthetic */ s32 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ cu1 f;

        public d(cu1 cu1Var, pq1 pq1Var, ju2 ju2Var, s32 s32Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu1Var, pq1Var, ju2Var, s32Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = cu1Var;
            this.a = pq1Var;
            this.b = ju2Var;
            this.c = s32Var;
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
    public class e extends y32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r32 a;
        public final /* synthetic */ cu1 b;

        public e(cu1 cu1Var, r32 r32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu1Var, r32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cu1Var;
            this.a = r32Var;
        }

        @Override // com.baidu.tieba.y32, com.baidu.tieba.z32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.a();
                if (this.b.f != null) {
                    this.a.R2(this.b.f);
                }
            }
        }

        @Override // com.baidu.tieba.y32, com.baidu.tieba.z32
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.b();
                View c = f33.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                f33.h(this.a);
            }
        }

        @Override // com.baidu.tieba.y32, com.baidu.tieba.z32
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.c();
                View c = f33.c(this.a);
                if (c != null) {
                    c.setVisibility(8);
                }
                f33.h(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947687146, "Lcom/baidu/tieba/cu1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947687146, "Lcom/baidu/tieba/cu1;");
                return;
            }
        }
        g = qn2.g0().q();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu1(@NonNull ks1 ks1Var) {
        super(ks1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ks1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ks1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public jw1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#navigateTo params=" + str, false);
            return I(str, "0", "navigateTo");
        }
        return (jw1) invokeL.objValue;
    }

    public jw1 J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#showModalPage params" + str, false);
            return I(str, "7", "showModalPage");
        }
        return (jw1) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void C(wp2 wp2Var, s32 s32Var, ju2 ju2Var, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{wp2Var, s32Var, ju2Var, str, str2, str3}) == null) {
            di3.a0(new b(this, wp2Var, str3, ju2Var, str, s32Var, str2));
        }
    }

    public final void D(pq1 pq1Var, ju2 ju2Var, s32 s32Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pq1Var, ju2Var, s32Var, str, str2) == null) {
            if (TextUtils.equals(str2, "7")) {
                F(pq1Var, ju2Var, s32Var, str);
            } else {
                G(pq1Var, ju2Var, s32Var, str);
            }
        }
    }

    public final void E(pq1 pq1Var, ju2 ju2Var, s32 s32Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, pq1Var, ju2Var, s32Var, str, str2) == null) {
            if (di3.O()) {
                D(pq1Var, ju2Var, s32Var, str, str2);
            } else {
                di3.a0(new d(this, pq1Var, ju2Var, s32Var, str, str2));
            }
        }
    }

    public final void F(pq1 pq1Var, ju2 ju2Var, s32 s32Var, String str) {
        SwanAppActivity activity;
        r32 r32Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, pq1Var, ju2Var, s32Var, str) == null) && (activity = wp2.U().getActivity()) != null && !activity.isFinishing()) {
            s73.e(pq1Var, ju2Var, str);
            px2.c(9, str);
            r32.S3(di3.n());
            s32.b k = s32Var.i("showModalPage").k("normal", ju2Var);
            if (!(s32Var.m() instanceof r32) || (r32Var = (r32) s32Var.m()) == null) {
                return;
            }
            r32Var.D0 = true;
            k.b();
            if (s32Var.k() > 1) {
                r32Var.x3().setBackgroundColor(0);
            } else {
                r32Var.D0 = false;
            }
            r32Var.z2(false);
            y32 y32Var = this.f;
            if (y32Var != null) {
                r32Var.R2(y32Var);
            }
            e eVar = new e(this, r32Var);
            this.f = eVar;
            r32Var.n2(eVar);
            View c2 = f33.c(r32Var);
            if (c2 != null) {
                c2.setVisibility(8);
            }
            f33.h(r32Var);
            PullToRefreshBaseWebView h0 = pq1Var.h0();
            if (h0 != null) {
                h0.setIsPreventPullToRefresh(true);
            }
            ox2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            px2.a(str, ju2Var);
        }
    }

    public final void G(pq1 pq1Var, ju2 ju2Var, s32 s32Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, pq1Var, ju2Var, s32Var, str) == null) && (activity = wp2.U().getActivity()) != null && !activity.isFinishing()) {
            s73.e(pq1Var, ju2Var, str);
            px2.c(0, str);
            if (s32Var.k() < g) {
                r32.S3(di3.n());
                s32.b i = s32Var.i("navigateTo");
                i.n(s32.g, s32.i);
                i.k("normal", ju2Var).b();
                tg3.c(s32Var, getContext());
                ox2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                px2.a(str, ju2Var);
                return;
            }
            du1.A(s32Var, ju2Var, str, true);
        }
    }

    public final jw1 I(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
            j43 b0 = j43.b0();
            if (b0 == null) {
                return new jw1(1001, "swan app is null");
            }
            String uuid = UUID.randomUUID().toString();
            px2.b(uuid);
            Pair<jw1, JSONObject> s = s(str);
            jw1 jw1Var = (jw1) s.first;
            if (!jw1Var.isSuccess()) {
                return jw1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = s73.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                j12.c("NavigateToApi", "url is null");
                return new jw1(202, "url is null");
            }
            wp2 U = wp2.U();
            s32 V = U.V();
            if (V == null) {
                j12.c("NavigateToApi", "manager is null");
                return new jw1(1001, "manager is null");
            }
            ju2 d2 = ju2.d(p, U.z());
            d2.e = str2;
            d2.f = uuid;
            xa3.g(d2);
            if (!di3.b(U.s(), d2, false)) {
                String str4 = "page params error : path=" + d2.a + " ; routePath=" + d2.d;
                j12.c("NavigateToApi", str4);
                xa3.i(d2);
                return new jw1(202, str4);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d2.d) && j43.M() != null) {
                j43.M().L0(optString, d2.d);
            }
            String optString2 = jSONObject.optString(FetchLog.START_TIME);
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = ox2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                j12.c("NavigateToApi", "cb is empty");
                xa3.i(d2);
                return new jw1(202, "cb is empty");
            } else if (w63.b().a(d2)) {
                w63.b().i(str3, d2);
                j12.c("NavigateToApi", "access to this page is prohibited");
                return new jw1(1003, "access to this page is prohibited");
            } else {
                if (TextUtils.equals("7", str2)) {
                    b0.e0().g(getContext(), "mapp_show_modal_page", new a(this, optString3, U, V, d2, uuid, str2));
                } else {
                    C(U, V, d2, uuid, str2, optString3);
                }
                return jw1.f();
            }
        }
        return (jw1) invokeLLL.objValue;
    }

    public final void K(oa2.e eVar, ju2 ju2Var, s32 s32Var, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, ju2Var, s32Var, str, str2) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = ox2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            q.D("preload", str3);
            oa2.q(eVar, new c(this, eVar, str, ju2Var, s32Var, str2));
        }
    }
}
