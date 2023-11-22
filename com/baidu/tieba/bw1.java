package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.lc2;
import com.baidu.tieba.p52;
import com.baidu.tieba.v93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bw1 extends yv1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ku1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tr2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gw2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ p52 e;
        public final /* synthetic */ bw1 f;

        /* renamed from: com.baidu.tieba.bw1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0243a implements v93.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g63 a;
            public final /* synthetic */ a b;

            public C0243a(a aVar, g63 g63Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, g63Var};
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
                this.a = g63Var;
            }

            @Override // com.baidu.tieba.v93.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    mz2.d(this.b.d);
                    g32.i("RedirectToApi", "check pages success");
                    this.b.a.p();
                    lc2.e f = lc2.f(this.b.a.getActivity(), qc2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    p93.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.D(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.v93.e
            public void b(int i, zh3 zh3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zh3Var) == null) {
                    g32.c("RedirectToApi", "check pages failed");
                    this.b.a.p();
                    a aVar = this.b;
                    p93.k(aVar.f, aVar.b);
                    uc3.j(this.b.c, zh3Var);
                }
            }
        }

        public a(bw1 bw1Var, tr2 tr2Var, String str, gw2 gw2Var, String str2, p52 p52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw1Var, tr2Var, str, gw2Var, str2, p52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = bw1Var;
            this.a = tr2Var;
            this.b = str;
            this.c = gw2Var;
            this.d = str2;
            this.e = p52Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    g63 M = g63.M();
                    if (M == null) {
                        this.f.d(this.b, new hy1(1001, "swan app is null"));
                        uc3.i(this.c);
                        return;
                    }
                    this.a.a();
                    v93.g(M, this.c, "", new C0243a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new hy1(1001, "swan activity is null"));
                uc3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc2.e a;
        public final /* synthetic */ gw2 b;
        public final /* synthetic */ p52 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ bw1 e;

        public b(bw1 bw1Var, lc2.e eVar, gw2 gw2Var, p52 p52Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw1Var, eVar, gw2Var, p52Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = bw1Var;
            this.a = eVar;
            this.b = gw2Var;
            this.c = p52Var;
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
    public class c implements lc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gw2 c;
        public final /* synthetic */ p52 d;

        public c(bw1 bw1Var, lc2.e eVar, String str, gw2 gw2Var, p52 p52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw1Var, eVar, str, gw2Var, p52Var};
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
            this.c = gw2Var;
            this.d = p52Var;
        }

        @Override // com.baidu.tieba.lc2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mz2.e(this.a, this.b);
                p93.e(this.a.a, this.c, this.b);
                bw1.B(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw1(@NonNull iu1 iu1Var) {
        super(iu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iu1) newInitContext.callArgs[0]);
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
            g63 c0 = g63.c0();
            if (c0 == null || (w = c0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void B(p52 p52Var, gw2 gw2Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{p52Var, gw2Var, str, Boolean.valueOf(z)}) == null) && !A() && (w = f63.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            mz2.c(i, str);
            o52.Z3(ak3.n());
            p52.b i2 = p52Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            p52.b k = i2.k("normal", gw2Var);
            if (!z) {
                i3 = p52Var.k() - 2;
            }
            k.m(i3);
            k.b();
            lz2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            mz2.a(str, gw2Var);
        }
    }

    public final void C(lc2.e eVar, gw2 gw2Var, p52 p52Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, gw2Var, p52Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = lz2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            lc2.q(eVar, new c(this, eVar, str, gw2Var, p52Var));
        }
    }

    public final void D(lc2.e eVar, gw2 gw2Var, p52 p52Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, gw2Var, p52Var, str) == null) {
            if (ak3.O()) {
                C(eVar, gw2Var, p52Var, str);
            } else {
                ak3.a0(new b(this, eVar, gw2Var, p52Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public hy1 E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            mz2.b(uuid);
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                return hy1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String p = p93.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                g32.c("RedirectToApi", "url is null");
                return new hy1(202, "url is null");
            }
            tr2 V = tr2.V();
            p52 W = V.W();
            if (W == null) {
                g32.c("RedirectToApi", "manager is null");
                return new hy1(1001, "manager is null");
            }
            gw2 d = gw2.d(p, V.A());
            d.e = "2";
            d.f = uuid;
            uc3.g(d);
            if (!ak3.b(V.t(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                g32.c("RedirectToApi", str2);
                uc3.i(d);
                return new hy1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && g63.M() != null) {
                g63.M().M0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = lz2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                g32.c("RedirectToApi", "cb is empty");
                uc3.i(d);
                return new hy1(202, "cb is empty");
            } else if (t83.b().a(d)) {
                t83.b().i("redirectTo", d);
                g32.c("RedirectToApi", "access to this page is prohibited");
                return new hy1(1003, "access to this page is prohibited");
            } else {
                ak3.a0(new a(this, V, optString3, d, uuid, W));
                return hy1.f();
            }
        }
        return (hy1) invokeL.objValue;
    }
}
