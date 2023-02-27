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
import com.baidu.tieba.bd3;
import com.baidu.tieba.rf2;
import com.baidu.tieba.v82;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class hz1 extends dz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.px1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zu2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mz2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ v82 e;
        public final /* synthetic */ hz1 f;

        /* renamed from: com.baidu.tieba.hz1$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0283a implements bd3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ m93 b;
            public final /* synthetic */ a c;

            public C0283a(a aVar, Activity activity, m93 m93Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, m93Var};
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
                this.b = m93Var;
            }

            @Override // com.baidu.tieba.bd3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    s23.d(this.c.d);
                    m62.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    rf2.e f = rf2.f(this.a, wf2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    vc3.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    wf3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.bd3.e
            public void b(int i, fl3 fl3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, fl3Var) == null) {
                    m62.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    vc3.k(aVar.f, aVar.b);
                    ag3.j(this.c.c, fl3Var);
                }
            }
        }

        public a(hz1 hz1Var, zu2 zu2Var, String str, mz2 mz2Var, String str2, v82 v82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz1Var, zu2Var, str, mz2Var, str2, v82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = hz1Var;
            this.a = zu2Var;
            this.b = str;
            this.c = mz2Var;
            this.d = str2;
            this.e = v82Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    m93 M = m93.M();
                    if (M == null) {
                        this.f.d(this.b, new m12(1001, "swan app is null"));
                        ag3.i(this.c);
                        return;
                    }
                    this.a.a();
                    bd3.g(M, this.c, "", new C0283a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new m12(1001, "swan activity is null"));
                ag3.i(this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements rf2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rf2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mz2 c;
        public final /* synthetic */ v82 d;

        public b(hz1 hz1Var, rf2.e eVar, String str, mz2 mz2Var, v82 v82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz1Var, eVar, str, mz2Var, v82Var};
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
            this.c = mz2Var;
            this.d = v82Var;
        }

        @Override // com.baidu.tieba.rf2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s23.e(this.a, this.b);
                vc3.e(this.a.a, this.c, this.b);
                hz1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements v82.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.v82.a
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

        @Override // com.baidu.tieba.v82.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof u82)) {
                ((u82) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hz1(@NonNull nx1 nx1Var) {
        super(nx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nx1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nx1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(v82 v82Var, mz2 mz2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, v82Var, mz2Var, str) == null) {
            if (mz2Var != null) {
                m62.i("RelaunchApi", "doReLaunch page=" + mz2Var.a + " routePage=" + mz2Var.d);
            }
            SwanAppActivity w = l93.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                s23.c(3, str);
                u82.S3(gn3.n());
                v82Var.g(cVar);
                v82.b i = v82Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", mz2Var).b();
                v82Var.p(cVar);
                r23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                s23.a(str, mz2Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public m12 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
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
                m62.c("RelaunchApi", "url is null");
                return new m12(202, "url is null");
            }
            zu2 U = zu2.U();
            v82 V = U.V();
            if (V == null) {
                m62.c("RelaunchApi", "manager is null");
                return new m12(1001, "manager is null");
            }
            mz2 d = mz2.d(p, U.z());
            d.e = "3";
            d.f = uuid;
            ag3.g(d);
            if (!gn3.b(U.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                m62.c("RelaunchApi", str2);
                ag3.i(d);
                return new m12(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && m93.M() != null) {
                m93.M().L0(optString, d.d);
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
                m62.c("RelaunchApi", "cb is null");
                ag3.i(d);
                return new m12(202, "cb is null");
            } else if (zb3.b().a(d)) {
                zb3.b().i("reLaunch", d);
                m62.c("RelaunchApi", "access to this page is prohibited");
                return new m12(1003, "access to this page is prohibited");
            } else {
                gn3.a0(new a(this, U, optString3, d, uuid, V));
                return m12.f();
            }
        }
        return (m12) invokeL.objValue;
    }

    public final void z(rf2.e eVar, mz2 mz2Var, v82 v82Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, mz2Var, v82Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = r23.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            rf2.q(eVar, new b(this, eVar, str, mz2Var, v82Var));
        }
    }
}
