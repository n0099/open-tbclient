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
import com.baidu.tieba.mh2;
import com.baidu.tieba.qa2;
import com.baidu.tieba.we3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c12 extends y02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uw2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ h13 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ qa2 e;
        public final /* synthetic */ c12 f;

        /* renamed from: com.baidu.tieba.c12$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0250a implements we3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ hb3 b;
            public final /* synthetic */ a c;

            public C0250a(a aVar, Activity activity, hb3 hb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, hb3Var};
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
                this.b = hb3Var;
            }

            @Override // com.baidu.tieba.we3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    n43.d(this.c.d);
                    h82.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    mh2.e f = mh2.f(this.a, rh2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    qe3.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    rh3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.we3.e
            public void b(int i, an3 an3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, an3Var) == null) {
                    h82.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    qe3.k(aVar.f, aVar.b);
                    vh3.j(this.c.c, an3Var);
                }
            }
        }

        public a(c12 c12Var, uw2 uw2Var, String str, h13 h13Var, String str2, qa2 qa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c12Var, uw2Var, str, h13Var, str2, qa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = c12Var;
            this.a = uw2Var;
            this.b = str;
            this.c = h13Var;
            this.d = str2;
            this.e = qa2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    hb3 M = hb3.M();
                    if (M == null) {
                        this.f.d(this.b, new h32(1001, "swan app is null"));
                        vh3.i(this.c);
                        return;
                    }
                    this.a.a();
                    we3.g(M, this.c, "", new C0250a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new h32(1001, "swan activity is null"));
                vh3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements mh2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ h13 c;
        public final /* synthetic */ qa2 d;

        public b(c12 c12Var, mh2.e eVar, String str, h13 h13Var, qa2 qa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c12Var, eVar, str, h13Var, qa2Var};
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
            this.c = h13Var;
            this.d = qa2Var;
        }

        @Override // com.baidu.tieba.mh2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n43.e(this.a, this.b);
                qe3.e(this.a.a, this.c, this.b);
                c12.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements qa2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.qa2.a
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

        @Override // com.baidu.tieba.qa2.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof pa2)) {
                ((pa2) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c12(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(qa2 qa2Var, h13 h13Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, qa2Var, h13Var, str) == null) {
            if (h13Var != null) {
                h82.i("RelaunchApi", "doReLaunch page=" + h13Var.a + " routePage=" + h13Var.d);
            }
            SwanAppActivity w = gb3.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                n43.c(3, str);
                pa2.U3(bp3.n());
                qa2Var.g(cVar);
                qa2.b i = qa2Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", h13Var).b();
                qa2Var.p(cVar);
                m43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                n43.a(str, h13Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public h32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
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
                h82.c("RelaunchApi", "url is null");
                return new h32(202, "url is null");
            }
            uw2 T2 = uw2.T();
            qa2 U = T2.U();
            if (U == null) {
                h82.c("RelaunchApi", "manager is null");
                return new h32(1001, "manager is null");
            }
            h13 d = h13.d(p, T2.z());
            d.e = "3";
            d.f = uuid;
            vh3.g(d);
            if (!bp3.b(T2.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                h82.c("RelaunchApi", str2);
                vh3.i(d);
                return new h32(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && hb3.M() != null) {
                hb3.M().L0(optString, d.d);
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
                h82.c("RelaunchApi", "cb is null");
                vh3.i(d);
                return new h32(202, "cb is null");
            } else if (ud3.b().a(d)) {
                ud3.b().i("reLaunch", d);
                h82.c("RelaunchApi", "access to this page is prohibited");
                return new h32(1003, "access to this page is prohibited");
            } else {
                bp3.a0(new a(this, T2, optString3, d, uuid, U));
                return h32.f();
            }
        }
        return (h32) invokeL.objValue;
    }

    public final void z(mh2.e eVar, h13 h13Var, qa2 qa2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, h13Var, qa2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = m43.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            mh2.q(eVar, new b(this, eVar, str, h13Var, qa2Var));
        }
    }
}
