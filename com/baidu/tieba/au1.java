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
import com.baidu.tieba.ka2;
import com.baidu.tieba.o32;
import com.baidu.tieba.u73;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class au1 extends wt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.is1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sp2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fu2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ o32 e;
        public final /* synthetic */ au1 f;

        /* renamed from: com.baidu.tieba.au1$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0210a implements u73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ f43 b;
            public final /* synthetic */ a c;

            public C0210a(a aVar, Activity activity, f43 f43Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, f43Var};
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
                this.b = f43Var;
            }

            @Override // com.baidu.tieba.u73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    lx2.d(this.c.d);
                    f12.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    ka2.e f = ka2.f(this.a, pa2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    o73.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    pa3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.u73.e
            public void b(int i, yf3 yf3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, yf3Var) == null) {
                    f12.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    o73.k(aVar.f, aVar.b);
                    ta3.j(this.c.c, yf3Var);
                }
            }
        }

        public a(au1 au1Var, sp2 sp2Var, String str, fu2 fu2Var, String str2, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au1Var, sp2Var, str, fu2Var, str2, o32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = au1Var;
            this.a = sp2Var;
            this.b = str;
            this.c = fu2Var;
            this.d = str2;
            this.e = o32Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    f43 M = f43.M();
                    if (M == null) {
                        this.f.d(this.b, new fw1(1001, "swan app is null"));
                        ta3.i(this.c);
                        return;
                    }
                    this.a.a();
                    u73.g(M, this.c, "", new C0210a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new fw1(1001, "swan activity is null"));
                ta3.i(this.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ka2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ fu2 c;
        public final /* synthetic */ o32 d;

        public b(au1 au1Var, ka2.e eVar, String str, fu2 fu2Var, o32 o32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au1Var, eVar, str, fu2Var, o32Var};
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
            this.c = fu2Var;
            this.d = o32Var;
        }

        @Override // com.baidu.tieba.ka2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lx2.e(this.a, this.b);
                o73.e(this.a.a, this.c, this.b);
                au1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements o32.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.o32.a
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

        @Override // com.baidu.tieba.o32.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof n32)) {
                ((n32) fragment).S0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au1(@NonNull gs1 gs1Var) {
        super(gs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(o32 o32Var, fu2 fu2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, o32Var, fu2Var, str) == null) {
            if (fu2Var != null) {
                f12.i("RelaunchApi", "doReLaunch page=" + fu2Var.a + " routePage=" + fu2Var.d);
            }
            SwanAppActivity w = e43.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                lx2.c(3, str);
                n32.S3(zh3.n());
                o32Var.g(cVar);
                o32.b i = o32Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", fu2Var).b();
                o32Var.p(cVar);
                kx2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                lx2.a(str, fu2Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public fw1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
            String uuid = UUID.randomUUID().toString();
            lx2.b(uuid);
            Pair<fw1, JSONObject> s = s(str);
            fw1 fw1Var = (fw1) s.first;
            if (!fw1Var.isSuccess()) {
                return fw1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = o73.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                f12.c("RelaunchApi", "url is null");
                return new fw1(202, "url is null");
            }
            sp2 U = sp2.U();
            o32 V = U.V();
            if (V == null) {
                f12.c("RelaunchApi", "manager is null");
                return new fw1(1001, "manager is null");
            }
            fu2 d = fu2.d(p, U.z());
            d.e = "3";
            d.f = uuid;
            ta3.g(d);
            if (!zh3.b(U.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                f12.c("RelaunchApi", str2);
                ta3.i(d);
                return new fw1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && f43.M() != null) {
                f43.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString(FetchLog.START_TIME);
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = kx2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                f12.c("RelaunchApi", "cb is null");
                ta3.i(d);
                return new fw1(202, "cb is null");
            } else if (s63.b().a(d)) {
                s63.b().i("reLaunch", d);
                f12.c("RelaunchApi", "access to this page is prohibited");
                return new fw1(1003, "access to this page is prohibited");
            } else {
                zh3.a0(new a(this, U, optString3, d, uuid, V));
                return fw1.f();
            }
        }
        return (fw1) invokeL.objValue;
    }

    public final void z(ka2.e eVar, fu2 fu2Var, o32 o32Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, fu2Var, o32Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = kx2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            ka2.q(eVar, new b(this, eVar, str, fu2Var, o32Var));
        }
    }
}
