package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tieba.a73;
import com.baidu.tieba.q92;
import com.baidu.tieba.u22;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gt1 extends ct1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yo2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lt2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ u22 e;
        public final /* synthetic */ gt1 f;

        /* renamed from: com.baidu.tieba.gt1$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0270a implements a73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ l33 b;
            public final /* synthetic */ a c;

            public C0270a(a aVar, Activity activity, l33 l33Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, l33Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = activity;
                this.b = l33Var;
            }

            @Override // com.baidu.tieba.a73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    rw2.d(this.c.d);
                    l02.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    q92.e f = q92.f(this.a, v92.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    u63.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    v93.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.a73.e
            public void b(int i, ef3 ef3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ef3Var) == null) {
                    l02.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    u63.k(aVar.f, aVar.b);
                    z93.j(this.c.c, ef3Var);
                }
            }
        }

        public a(gt1 gt1Var, yo2 yo2Var, String str, lt2 lt2Var, String str2, u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt1Var, yo2Var, str, lt2Var, str2, u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = gt1Var;
            this.a = yo2Var;
            this.b = str;
            this.c = lt2Var;
            this.d = str2;
            this.e = u22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    l33 M = l33.M();
                    if (M == null) {
                        this.f.d(this.b, new lv1(1001, "swan app is null"));
                        z93.i(this.c);
                        return;
                    }
                    this.a.a();
                    a73.g(M, this.c, "", new C0270a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new lv1(1001, "swan activity is null"));
                z93.i(this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements q92.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q92.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lt2 c;
        public final /* synthetic */ u22 d;

        public b(gt1 gt1Var, q92.e eVar, String str, lt2 lt2Var, u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt1Var, eVar, str, lt2Var, u22Var};
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
            this.b = str;
            this.c = lt2Var;
            this.d = u22Var;
        }

        @Override // com.baidu.tieba.q92.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rw2.e(this.a, this.b);
                u63.e(this.a.a, this.c, this.b);
                gt1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements u22.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.u22.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

        @Override // com.baidu.tieba.u22.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof t22)) {
                ((t22) fragment).S0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gt1(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(u22 u22Var, lt2 lt2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, u22Var, lt2Var, str) == null) {
            if (lt2Var != null) {
                l02.i("RelaunchApi", "doReLaunch page=" + lt2Var.a + " routePage=" + lt2Var.d);
            }
            SwanAppActivity w = k33.K().w();
            if (w == null || w.isFinishing() || w.isDestroyed()) {
                return;
            }
            c cVar = new c();
            rw2.c(3, str);
            t22.S3(fh3.n());
            u22Var.g(cVar);
            u22.b i = u22Var.i("reLaunch");
            i.n(0, 0);
            i.f();
            i.k("normal", lt2Var).b();
            u22Var.p(cVar);
            qw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            rw2.a(str, lt2Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public lv1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            rw2.b(uuid);
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (lv1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = u63.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    l02.c("RelaunchApi", "url is null");
                    return new lv1(202, "url is null");
                }
                yo2 U = yo2.U();
                u22 V = U.V();
                if (V == null) {
                    l02.c("RelaunchApi", "manager is null");
                    return new lv1(1001, "manager is null");
                }
                lt2 d = lt2.d(p, U.z());
                d.e = "3";
                d.f = uuid;
                z93.g(d);
                if (!fh3.b(U.s(), d, true)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    l02.c("RelaunchApi", str2);
                    z93.i(d);
                    return new lv1(202, str2);
                }
                String optString = jSONObject.optString("initData");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && l33.M() != null) {
                    l33.M().L0(optString, d.d);
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
                    l02.c("RelaunchApi", "cb is null");
                    z93.i(d);
                    return new lv1(202, "cb is null");
                } else if (y53.b().a(d)) {
                    y53.b().i("reLaunch", d);
                    l02.c("RelaunchApi", "access to this page is prohibited");
                    return new lv1(1003, "access to this page is prohibited");
                } else {
                    fh3.a0(new a(this, U, optString3, d, uuid, V));
                    return lv1.f();
                }
            }
            return lv1Var;
        }
        return (lv1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    public final void z(q92.e eVar, lt2 lt2Var, u22 u22Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, lt2Var, u22Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = qw2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            q92.q(eVar, new b(this, eVar, str, lt2Var, u22Var));
        }
    }
}
