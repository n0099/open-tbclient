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
import com.baidu.tieba.mc2;
import com.baidu.tieba.q52;
import com.baidu.tieba.w93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dw1 extends zv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.lu1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hw2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ q52 e;
        public final /* synthetic */ dw1 f;

        /* renamed from: com.baidu.tieba.dw1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0282a implements w93.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ h63 b;
            public final /* synthetic */ a c;

            public C0282a(a aVar, Activity activity, h63 h63Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, h63Var};
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
                this.b = h63Var;
            }

            @Override // com.baidu.tieba.w93.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    nz2.d(this.c.d);
                    h32.i("RelaunchApi", "check pages success");
                    this.c.a.p();
                    mc2.e f = mc2.f(this.a, rc2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    q93.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    rc3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.A(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.w93.e
            public void b(int i, ai3 ai3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ai3Var) == null) {
                    h32.c("RelaunchApi", "check pages failed");
                    this.c.a.p();
                    a aVar = this.c;
                    q93.k(aVar.f, aVar.b);
                    vc3.j(this.c.c, ai3Var);
                }
            }
        }

        public a(dw1 dw1Var, ur2 ur2Var, String str, hw2 hw2Var, String str2, q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dw1Var, ur2Var, str, hw2Var, str2, q52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = dw1Var;
            this.a = ur2Var;
            this.b = str;
            this.c = hw2Var;
            this.d = str2;
            this.e = q52Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    h63 M = h63.M();
                    if (M == null) {
                        this.f.d(this.b, new iy1(1001, "swan app is null"));
                        vc3.i(this.c);
                        return;
                    }
                    this.a.a();
                    w93.g(M, this.c, "", new C0282a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new iy1(1001, "swan activity is null"));
                vc3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements mc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hw2 c;
        public final /* synthetic */ q52 d;

        public b(dw1 dw1Var, mc2.e eVar, String str, hw2 hw2Var, q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dw1Var, eVar, str, hw2Var, q52Var};
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
            this.c = hw2Var;
            this.d = q52Var;
        }

        @Override // com.baidu.tieba.mc2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nz2.e(this.a, this.b);
                q93.e(this.a.a, this.c, this.b);
                dw1.z(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements q52.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.q52.a
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

        @Override // com.baidu.tieba.q52.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof p52)) {
                ((p52) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dw1(@NonNull ju1 ju1Var) {
        super(ju1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ju1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ju1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void z(q52 q52Var, hw2 hw2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, q52Var, hw2Var, str) == null) {
            if (hw2Var != null) {
                h32.i("RelaunchApi", "doReLaunch page=" + hw2Var.a + " routePage=" + hw2Var.d);
            }
            SwanAppActivity w = g63.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                nz2.c(3, str);
                p52.Z3(bk3.n());
                q52Var.g(cVar);
                q52.b i = q52Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", hw2Var).b();
                q52Var.p(cVar);
                mz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                nz2.a(str, hw2Var);
            }
        }
    }

    public final void A(mc2.e eVar, hw2 hw2Var, q52 q52Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, hw2Var, q52Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = mz2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            mc2.q(eVar, new b(this, eVar, str, hw2Var, q52Var));
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public iy1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#reLaunch params" + str, false);
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
                h32.c("RelaunchApi", "url is null");
                return new iy1(202, "url is null");
            }
            ur2 V = ur2.V();
            q52 W = V.W();
            if (W == null) {
                h32.c("RelaunchApi", "manager is null");
                return new iy1(1001, "manager is null");
            }
            hw2 d = hw2.d(p, V.A());
            d.e = "3";
            d.f = uuid;
            vc3.g(d);
            if (!bk3.b(V.t(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                h32.c("RelaunchApi", str2);
                vc3.i(d);
                return new iy1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && h63.M() != null) {
                h63.M().M0(optString, d.d);
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
                h32.c("RelaunchApi", "cb is null");
                vc3.i(d);
                return new iy1(202, "cb is null");
            } else if (u83.b().a(d)) {
                u83.b().i("reLaunch", d);
                h32.c("RelaunchApi", "access to this page is prohibited");
                return new iy1(1003, "access to this page is prohibited");
            } else {
                bk3.a0(new a(this, V, optString3, d, uuid, W));
                return iy1.f();
            }
        }
        return (iy1) invokeL.objValue;
    }
}
