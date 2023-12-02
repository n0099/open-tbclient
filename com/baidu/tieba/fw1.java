package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
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
public class fw1 extends cw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
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
        public final /* synthetic */ fw1 f;

        /* renamed from: com.baidu.tieba.fw1$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0291a implements z93.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k63 a;
            public final /* synthetic */ a b;

            public C0291a(a aVar, k63 k63Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, k63Var};
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
                this.a = k63Var;
            }

            @Override // com.baidu.tieba.z93.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    qz2.d(this.b.d);
                    k32.i("RedirectToApi", "check pages success");
                    this.b.a.p();
                    pc2.e f = pc2.f(this.b.a.getActivity(), uc2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    t93.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.D(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.z93.e
            public void b(int i, di3 di3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, di3Var) == null) {
                    k32.c("RedirectToApi", "check pages failed");
                    this.b.a.p();
                    a aVar = this.b;
                    t93.k(aVar.f, aVar.b);
                    yc3.j(this.b.c, di3Var);
                }
            }
        }

        public a(fw1 fw1Var, xr2 xr2Var, String str, kw2 kw2Var, String str2, t52 t52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw1Var, xr2Var, str, kw2Var, str2, t52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = fw1Var;
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
                    z93.g(M, this.c, "", new C0291a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new ly1(1001, "swan activity is null"));
                yc3.i(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pc2.e a;
        public final /* synthetic */ kw2 b;
        public final /* synthetic */ t52 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ fw1 e;

        public b(fw1 fw1Var, pc2.e eVar, kw2 kw2Var, t52 t52Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw1Var, eVar, kw2Var, t52Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = fw1Var;
            this.a = eVar;
            this.b = kw2Var;
            this.c = t52Var;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.e.C(this.a, this.b, this.c, this.d);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements pc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kw2 c;
        public final /* synthetic */ t52 d;

        public c(fw1 fw1Var, pc2.e eVar, String str, kw2 kw2Var, t52 t52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw1Var, eVar, str, kw2Var, t52Var};
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
                fw1.B(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fw1(@NonNull mu1 mu1Var) {
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

    public static boolean A() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null || (w = c0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void B(t52 t52Var, kw2 kw2Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{t52Var, kw2Var, str, Boolean.valueOf(z)}) == null) && !A() && (w = j63.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            qz2.c(i, str);
            s52.Z3(ek3.n());
            t52.b i2 = t52Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            t52.b k = i2.k("normal", kw2Var);
            if (!z) {
                i3 = t52Var.k() - 2;
            }
            k.m(i3);
            k.b();
            pz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            qz2.a(str, kw2Var);
        }
    }

    public final void C(pc2.e eVar, kw2 kw2Var, t52 t52Var, String str) {
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
            pc2.q(eVar, new c(this, eVar, str, kw2Var, t52Var));
        }
    }

    public final void D(pc2.e eVar, kw2 kw2Var, t52 t52Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, kw2Var, t52Var, str) == null) {
            if (ek3.O()) {
                C(eVar, kw2Var, t52Var, str);
            } else {
                ek3.a0(new b(this, eVar, kw2Var, t52Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public ly1 E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#redirectTo params=" + str, false);
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
                k32.c("RedirectToApi", "url is null");
                return new ly1(202, "url is null");
            }
            xr2 V = xr2.V();
            t52 W = V.W();
            if (W == null) {
                k32.c("RedirectToApi", "manager is null");
                return new ly1(1001, "manager is null");
            }
            kw2 d = kw2.d(p, V.A());
            d.e = "2";
            d.f = uuid;
            yc3.g(d);
            if (!ek3.b(V.t(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                k32.c("RedirectToApi", str2);
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
                k32.c("RedirectToApi", "cb is empty");
                yc3.i(d);
                return new ly1(202, "cb is empty");
            } else if (x83.b().a(d)) {
                x83.b().i("redirectTo", d);
                k32.c("RedirectToApi", "access to this page is prohibited");
                return new ly1(1003, "access to this page is prohibited");
            } else {
                ek3.a0(new a(this, V, optString3, d, uuid, W));
                return ly1.f();
            }
        }
        return (ly1) invokeL.objValue;
    }
}
