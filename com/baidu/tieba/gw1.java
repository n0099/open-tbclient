package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.tieba.pc2;
import com.baidu.tieba.t52;
import com.baidu.tieba.z93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gw1 extends cw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xr2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kw2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ t52 e;
        public final /* synthetic */ gw1 f;

        /* renamed from: com.baidu.tieba.gw1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0304a implements z93.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ k63 b;
            public final /* synthetic */ a c;

            public C0304a(a aVar, Activity activity, k63 k63Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, k63Var};
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
                this.b = k63Var;
            }

            @Override // com.baidu.tieba.z93.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    qz2.d(this.c.d);
                    k32.i("RelaunchApi", "check pages success");
                    this.c.a.p();
                    pc2.e f = pc2.f(this.a, uc2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    t93.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    uc3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.A(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.z93.e
            public void b(int i, di3 di3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, di3Var) == null) {
                    k32.c("RelaunchApi", "check pages failed");
                    this.c.a.p();
                    a aVar = this.c;
                    t93.k(aVar.f, aVar.b);
                    yc3.j(this.c.c, di3Var);
                }
            }
        }

        public a(gw1 gw1Var, xr2 xr2Var, String str, kw2 kw2Var, String str2, t52 t52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw1Var, xr2Var, str, kw2Var, str2, t52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = gw1Var;
            this.a = xr2Var;
            this.b = str;
            this.c = kw2Var;
            this.d = str2;
            this.e = t52Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    k63 M = k63.M();
                    if (M == null) {
                        this.f.d(this.b, new ly1(1001, "swan app is null"));
                        yc3.i(this.c);
                        return;
                    }
                    this.a.a();
                    z93.g(M, this.c, "", new C0304a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new ly1(1001, "swan activity is null"));
                yc3.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements pc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kw2 c;
        public final /* synthetic */ t52 d;

        public b(gw1 gw1Var, pc2.e eVar, String str, kw2 kw2Var, t52 t52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw1Var, eVar, str, kw2Var, t52Var};
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
            this.c = kw2Var;
            this.d = t52Var;
        }

        @Override // com.baidu.tieba.pc2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qz2.e(this.a, this.b);
                t93.e(this.a.a, this.c, this.b);
                gw1.z(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements t52.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.t52.a
        public void a(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fragment) == null) {
            }
        }

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

        @Override // com.baidu.tieba.t52.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof s52)) {
                ((s52) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gw1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void z(t52 t52Var, kw2 kw2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, t52Var, kw2Var, str) == null) {
            if (kw2Var != null) {
                k32.i("RelaunchApi", "doReLaunch page=" + kw2Var.a + " routePage=" + kw2Var.d);
            }
            SwanAppActivity w = j63.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                qz2.c(3, str);
                s52.Z3(ek3.n());
                t52Var.g(cVar);
                t52.b i = t52Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", kw2Var).b();
                t52Var.p(cVar);
                pz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                qz2.a(str, kw2Var);
            }
        }
    }

    public final void A(pc2.e eVar, kw2 kw2Var, t52 t52Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, kw2Var, t52Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = pz2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            pc2.q(eVar, new b(this, eVar, str, kw2Var, t52Var));
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public ly1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#reLaunch params" + str, false);
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
                k32.c("RelaunchApi", "url is null");
                return new ly1(202, "url is null");
            }
            xr2 V = xr2.V();
            t52 W = V.W();
            if (W == null) {
                k32.c("RelaunchApi", "manager is null");
                return new ly1(1001, "manager is null");
            }
            kw2 d = kw2.d(p, V.A());
            d.e = "3";
            d.f = uuid;
            yc3.g(d);
            if (!ek3.b(V.t(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                k32.c("RelaunchApi", str2);
                yc3.i(d);
                return new ly1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && k63.M() != null) {
                k63.M().M0(optString, d.d);
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
                k32.c("RelaunchApi", "cb is null");
                yc3.i(d);
                return new ly1(202, "cb is null");
            } else if (x83.b().a(d)) {
                x83.b().i("reLaunch", d);
                k32.c("RelaunchApi", "access to this page is prohibited");
                return new ly1(1003, "access to this page is prohibited");
            } else {
                ek3.a0(new a(this, V, optString3, d, uuid, W));
                return ly1.f();
            }
        }
        return (ly1) invokeL.objValue;
    }
}
