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
import com.baidu.tieba.oa2;
import com.baidu.tieba.s32;
import com.baidu.tieba.y73;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class eu1 extends au1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ms1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "RelaunchApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ju2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ s32 e;
        public final /* synthetic */ eu1 f;

        /* renamed from: com.baidu.tieba.eu1$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0264a implements y73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ j43 b;
            public final /* synthetic */ a c;

            public C0264a(a aVar, Activity activity, j43 j43Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, activity, j43Var};
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
                this.b = j43Var;
            }

            @Override // com.baidu.tieba.y73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    px2.d(this.c.d);
                    j12.i("RelaunchApi", "check pages success");
                    this.c.a.o();
                    oa2.e f = oa2.f(this.a, ta2.c(this.c.c.a));
                    String a = f.a.a();
                    a aVar = this.c;
                    s73.m(aVar.f, this.b, a, aVar.c.a, null, aVar.b);
                    ta3.t(a);
                    a aVar2 = this.c;
                    aVar2.f.z(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.y73.e
            public void b(int i, cg3 cg3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cg3Var) == null) {
                    j12.c("RelaunchApi", "check pages failed");
                    this.c.a.o();
                    a aVar = this.c;
                    s73.k(aVar.f, aVar.b);
                    xa3.j(this.c.c, cg3Var);
                }
            }
        }

        public a(eu1 eu1Var, wp2 wp2Var, String str, ju2 ju2Var, String str2, s32 s32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu1Var, wp2Var, str, ju2Var, str2, s32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = eu1Var;
            this.a = wp2Var;
            this.b = str;
            this.c = ju2Var;
            this.d = str2;
            this.e = s32Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    j43 M = j43.M();
                    if (M == null) {
                        this.f.d(this.b, new jw1(1001, "swan app is null"));
                        xa3.i(this.c);
                        return;
                    }
                    this.a.a();
                    y73.g(M, this.c, "", new C0264a(this, activity, M), this.d);
                    return;
                }
                this.f.d(this.b, new jw1(1001, "swan activity is null"));
                xa3.i(this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements oa2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oa2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ju2 c;
        public final /* synthetic */ s32 d;

        public b(eu1 eu1Var, oa2.e eVar, String str, ju2 ju2Var, s32 s32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eu1Var, eVar, str, ju2Var, s32Var};
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
            this.c = ju2Var;
            this.d = s32Var;
        }

        @Override // com.baidu.tieba.oa2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                px2.e(this.a, this.b);
                s73.e(this.a.a, this.c, this.b);
                eu1.y(this.d, this.c, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements s32.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.s32.a
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

        @Override // com.baidu.tieba.s32.a
        public void b(@NonNull Fragment fragment) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragment) == null) && (fragment instanceof r32)) {
                ((r32) fragment).S0 = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eu1(@NonNull ks1 ks1Var) {
        super(ks1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ks1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ks1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y(s32 s32Var, ju2 ju2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, s32Var, ju2Var, str) == null) {
            if (ju2Var != null) {
                j12.i("RelaunchApi", "doReLaunch page=" + ju2Var.a + " routePage=" + ju2Var.d);
            }
            SwanAppActivity w = i43.K().w();
            if (w != null && !w.isFinishing() && !w.isDestroyed()) {
                c cVar = new c();
                px2.c(3, str);
                r32.S3(di3.n());
                s32Var.g(cVar);
                s32.b i = s32Var.i("reLaunch");
                i.n(0, 0);
                i.f();
                i.k("normal", ju2Var).b();
                s32Var.p(cVar);
                ox2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                px2.a(str, ju2Var);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public jw1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#reLaunch params" + str, false);
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
                j12.c("RelaunchApi", "url is null");
                return new jw1(202, "url is null");
            }
            wp2 U = wp2.U();
            s32 V = U.V();
            if (V == null) {
                j12.c("RelaunchApi", "manager is null");
                return new jw1(1001, "manager is null");
            }
            ju2 d = ju2.d(p, U.z());
            d.e = "3";
            d.f = uuid;
            xa3.g(d);
            if (!di3.b(U.s(), d, true)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                j12.c("RelaunchApi", str2);
                xa3.i(d);
                return new jw1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && j43.M() != null) {
                j43.M().L0(optString, d.d);
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
                j12.c("RelaunchApi", "cb is null");
                xa3.i(d);
                return new jw1(202, "cb is null");
            } else if (w63.b().a(d)) {
                w63.b().i("reLaunch", d);
                j12.c("RelaunchApi", "access to this page is prohibited");
                return new jw1(1003, "access to this page is prohibited");
            } else {
                di3.a0(new a(this, U, optString3, d, uuid, V));
                return jw1.f();
            }
        }
        return (jw1) invokeL.objValue;
    }

    public final void z(oa2.e eVar, ju2 ju2Var, s32 s32Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, ju2Var, s32Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = ox2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            oa2.q(eVar, new b(this, eVar, str, ju2Var, s32Var));
        }
    }
}
