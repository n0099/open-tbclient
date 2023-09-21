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
import com.baidu.tieba.lh2;
import com.baidu.tieba.pa2;
import com.baidu.tieba.ve3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b12 extends x02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tw2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ g13 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ pa2 e;
        public final /* synthetic */ b12 f;

        /* renamed from: com.baidu.tieba.b12$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0240a implements ve3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ gb3 b;
            public final /* synthetic */ a c;

            public C0240a(a aVar, Activity activity, gb3 gb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, gb3Var};
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
                this.b = gb3Var;
            }

            @Override // com.baidu.tieba.ve3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    m43.d(this.c.d);
                    g82.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    lh2.e f = lh2.f(this.a, qh2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    pe3.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    qh3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.ve3.e
            public void b(int i, zm3 zm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zm3Var) == null) {
                    g82.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    pe3.k(aVar.f, aVar.b);
                    uh3.j(this.c.c, zm3Var);
                }
            }
        }

        public a(b12 b12Var, tw2 tw2Var, String str, g13 g13Var, String str2, pa2 pa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b12Var, tw2Var, str, g13Var, str2, pa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = b12Var;
            this.a = tw2Var;
            this.b = str;
            this.c = g13Var;
            this.d = str2;
            this.e = pa2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    gb3 M = gb3.M();
                    if (M == null) {
                        this.f.d(this.b, new g32(1001, "swan app is null"));
                        uh3.i(this.c);
                        return;
                    }
                    this.a.a();
                    ve3.g(M, this.c, "", new C0240a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new g32(1001, "swan activity is null"));
                uh3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements lh2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ g13 c;
        public final /* synthetic */ pa2 d;

        public b(b12 b12Var, lh2.e eVar, String str, g13 g13Var, pa2 pa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b12Var, eVar, str, g13Var, pa2Var};
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
            this.c = g13Var;
            this.d = pa2Var;
        }

        @Override // com.baidu.tieba.lh2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m43.e(this.a, this.b);
                pe3.e(this.a.a, this.c, this.b);
                b12.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements pa2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.pa2.a
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

        @Override // com.baidu.tieba.pa2.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof oa2)) {
                ((oa2) fragment).T0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b12(@NonNull hz1 hz1Var) {
        super(hz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((hz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(pa2 pa2Var, g13 g13Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, pa2Var, g13Var, str) == null) {
            if (g13Var != null) {
                g82.i("RelaunchApi", "doReLaunch page=" + g13Var.a + " routePage=" + g13Var.d);
            }
            SwanAppActivity w = fb3.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                m43.c(3, str);
                oa2.U3(ap3.n());
                pa2Var.g(cVar);
                pa2.b i = pa2Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", g13Var).b();
                pa2Var.p(cVar);
                l43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                m43.a(str, g13Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public g32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            m43.b(uuid);
            Pair<g32, JSONObject> s = s(str);
            g32 g32Var = (g32) s.first;
            if (!g32Var.isSuccess()) {
                return g32Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = pe3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                g82.c("RelaunchApi", "url is null");
                return new g32(202, "url is null");
            }
            tw2 T2 = tw2.T();
            pa2 U = T2.U();
            if (U == null) {
                g82.c("RelaunchApi", "manager is null");
                return new g32(1001, "manager is null");
            }
            g13 d = g13.d(p, T2.z());
            d.e = "3";
            d.f = uuid;
            uh3.g(d);
            if (!ap3.b(T2.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                g82.c("RelaunchApi", str2);
                uh3.i(d);
                return new g32(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && gb3.M() != null) {
                gb3.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = l43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                g82.c("RelaunchApi", "cb is null");
                uh3.i(d);
                return new g32(202, "cb is null");
            } else if (td3.b().a(d)) {
                td3.b().i("reLaunch", d);
                g82.c("RelaunchApi", "access to this page is prohibited");
                return new g32(1003, "access to this page is prohibited");
            } else {
                ap3.a0(new a(this, T2, optString3, d, uuid, U));
                return g32.f();
            }
        }
        return (g32) invokeL.objValue;
    }

    public final void z(lh2.e eVar, g13 g13Var, pa2 pa2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, g13Var, pa2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = l43.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            lh2.q(eVar, new b(this, eVar, str, g13Var, pa2Var));
        }
    }
}
