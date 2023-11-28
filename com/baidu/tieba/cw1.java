package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
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
public class cw1 extends zv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.lu1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
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
        public final /* synthetic */ cw1 f;

        /* renamed from: com.baidu.tieba.cw1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0259a implements w93.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h63 a;
            public final /* synthetic */ a b;

            public C0259a(a aVar, h63 h63Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, h63Var};
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
                this.a = h63Var;
            }

            @Override // com.baidu.tieba.w93.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    nz2.d(this.b.d);
                    h32.i("RedirectToApi", "check pages success");
                    this.b.a.p();
                    mc2.e f = mc2.f(this.b.a.getActivity(), rc2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    q93.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.D(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.w93.e
            public void b(int i, ai3 ai3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ai3Var) == null) {
                    h32.c("RedirectToApi", "check pages failed");
                    this.b.a.p();
                    a aVar = this.b;
                    q93.k(aVar.f, aVar.b);
                    vc3.j(this.b.c, ai3Var);
                }
            }
        }

        public a(cw1 cw1Var, ur2 ur2Var, String str, hw2 hw2Var, String str2, q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cw1Var, ur2Var, str, hw2Var, str2, q52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = cw1Var;
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
                    w93.g(M, this.c, "", new C0259a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new iy1(1001, "swan activity is null"));
                vc3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc2.e a;
        public final /* synthetic */ hw2 b;
        public final /* synthetic */ q52 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ cw1 e;

        public b(cw1 cw1Var, mc2.e eVar, hw2 hw2Var, q52 q52Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cw1Var, eVar, hw2Var, q52Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cw1Var;
            this.a = eVar;
            this.b = hw2Var;
            this.c = q52Var;
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

    /* loaded from: classes5.dex */
    public class c implements mc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ hw2 c;
        public final /* synthetic */ q52 d;

        public c(cw1 cw1Var, mc2.e eVar, String str, hw2 hw2Var, q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cw1Var, eVar, str, hw2Var, q52Var};
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
                cw1.B(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cw1(@NonNull ju1 ju1Var) {
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

    public static boolean A() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            h63 c0 = h63.c0();
            if (c0 == null || (w = c0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void B(q52 q52Var, hw2 hw2Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{q52Var, hw2Var, str, Boolean.valueOf(z)}) == null) && !A() && (w = g63.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            nz2.c(i, str);
            p52.Z3(bk3.n());
            q52.b i2 = q52Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            q52.b k = i2.k("normal", hw2Var);
            if (!z) {
                i3 = q52Var.k() - 2;
            }
            k.m(i3);
            k.b();
            mz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            nz2.a(str, hw2Var);
        }
    }

    public final void C(mc2.e eVar, hw2 hw2Var, q52 q52Var, String str) {
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
            mc2.q(eVar, new c(this, eVar, str, hw2Var, q52Var));
        }
    }

    public final void D(mc2.e eVar, hw2 hw2Var, q52 q52Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, hw2Var, q52Var, str) == null) {
            if (bk3.O()) {
                C(eVar, hw2Var, q52Var, str);
            } else {
                bk3.a0(new b(this, eVar, hw2Var, q52Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public iy1 E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#redirectTo params=" + str, false);
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
                h32.c("RedirectToApi", "url is null");
                return new iy1(202, "url is null");
            }
            ur2 V = ur2.V();
            q52 W = V.W();
            if (W == null) {
                h32.c("RedirectToApi", "manager is null");
                return new iy1(1001, "manager is null");
            }
            hw2 d = hw2.d(p, V.A());
            d.e = "2";
            d.f = uuid;
            vc3.g(d);
            if (!bk3.b(V.t(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                h32.c("RedirectToApi", str2);
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
                h32.c("RedirectToApi", "cb is empty");
                vc3.i(d);
                return new iy1(202, "cb is empty");
            } else if (u83.b().a(d)) {
                u83.b().i("redirectTo", d);
                h32.c("RedirectToApi", "access to this page is prohibited");
                return new iy1(1003, "access to this page is prohibited");
            } else {
                bk3.a0(new a(this, V, optString3, d, uuid, W));
                return iy1.f();
            }
        }
        return (iy1) invokeL.objValue;
    }
}
