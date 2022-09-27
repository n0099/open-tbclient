package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
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
public class ft1 extends ct1 {
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
        public final /* synthetic */ ft1 f;

        /* renamed from: com.baidu.tieba.ft1$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0264a implements a73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l33 a;
            public final /* synthetic */ a b;

            public C0264a(a aVar, l33 l33Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, l33Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = l33Var;
            }

            @Override // com.baidu.tieba.a73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    rw2.d(this.b.d);
                    l02.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    q92.e f = q92.f(this.b.a.getActivity(), v92.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    u63.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.a73.e
            public void b(int i, ef3 ef3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ef3Var) == null) {
                    l02.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    u63.k(aVar.f, aVar.b);
                    z93.j(this.b.c, ef3Var);
                }
            }
        }

        public a(ft1 ft1Var, yo2 yo2Var, String str, lt2 lt2Var, String str2, u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft1Var, yo2Var, str, lt2Var, str2, u22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ft1Var;
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
                    a73.g(M, this.c, "", new C0264a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new lv1(1001, "swan activity is null"));
                z93.i(this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q92.e a;
        public final /* synthetic */ lt2 b;
        public final /* synthetic */ u22 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ft1 e;

        public b(ft1 ft1Var, q92.e eVar, lt2 lt2Var, u22 u22Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft1Var, eVar, lt2Var, u22Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ft1Var;
            this.a = eVar;
            this.b = lt2Var;
            this.c = u22Var;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.B(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements q92.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q92.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lt2 c;
        public final /* synthetic */ u22 d;

        public c(ft1 ft1Var, q92.e eVar, String str, lt2 lt2Var, u22 u22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft1Var, eVar, str, lt2Var, u22Var};
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
                ft1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ft1(@NonNull mr1 mr1Var) {
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

    public static void A(u22 u22Var, lt2 lt2Var, String str, boolean z) {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{u22Var, lt2Var, str, Boolean.valueOf(z)}) == null) || z() || (w = k33.K().w()) == null || w.isFinishing() || w.isDestroyed()) {
            return;
        }
        rw2.c(z ? 8 : 2, str);
        t22.S3(fh3.n());
        u22.b i = u22Var.i("redirectTo");
        i.n(0, 0);
        u22.b k = i.k("normal", lt2Var);
        k.m(z ? 0 : u22Var.k() - 2);
        k.b();
        qw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
        rw2.a(str, lt2Var);
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            l33 b0 = l33.b0();
            return b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed();
        }
        return invokeV.booleanValue;
    }

    public final void B(q92.e eVar, lt2 lt2Var, u22 u22Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, lt2Var, u22Var, str) == null) {
            boolean z = eVar != null && eVar.b;
            HybridUbcFlow q = qw2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            q.D("preload", z ? "1" : "0");
            q92.q(eVar, new c(this, eVar, str, lt2Var, u22Var));
        }
    }

    public final void C(q92.e eVar, lt2 lt2Var, u22 u22Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, lt2Var, u22Var, str) == null) {
            if (fh3.O()) {
                B(eVar, lt2Var, u22Var, str);
            } else {
                fh3.a0(new b(this, eVar, lt2Var, u22Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public lv1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            rw2.b(uuid);
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (lv1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String p = u63.p(jSONObject);
                if (TextUtils.isEmpty(p)) {
                    l02.c("RedirectToApi", "url is null");
                    return new lv1(202, "url is null");
                }
                yo2 U = yo2.U();
                u22 V = U.V();
                if (V == null) {
                    l02.c("RedirectToApi", "manager is null");
                    return new lv1(1001, "manager is null");
                }
                lt2 d = lt2.d(p, U.z());
                d.e = "2";
                d.f = uuid;
                z93.g(d);
                if (!fh3.b(U.s(), d, false)) {
                    String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                    l02.c("RedirectToApi", str2);
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
                    l02.c("RedirectToApi", "cb is empty");
                    z93.i(d);
                    return new lv1(202, "cb is empty");
                } else if (y53.b().a(d)) {
                    y53.b().i("redirectTo", d);
                    l02.c("RedirectToApi", "access to this page is prohibited");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }
}
