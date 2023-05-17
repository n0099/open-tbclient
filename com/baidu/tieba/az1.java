package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.lf2;
import com.baidu.tieba.p82;
import com.baidu.tieba.vc3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class az1 extends xy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jx1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tu2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gz2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ p82 e;
        public final /* synthetic */ az1 f;

        /* renamed from: com.baidu.tieba.az1$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0228a implements vc3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g93 a;
            public final /* synthetic */ a b;

            public C0228a(a aVar, g93 g93Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, g93Var};
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
                this.a = g93Var;
            }

            @Override // com.baidu.tieba.vc3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    m23.d(this.b.d);
                    g62.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    lf2.e f = lf2.f(this.b.a.getActivity(), qf2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    pc3.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.vc3.e
            public void b(int i, zk3 zk3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zk3Var) == null) {
                    g62.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    pc3.k(aVar.f, aVar.b);
                    uf3.j(this.b.c, zk3Var);
                }
            }
        }

        public a(az1 az1Var, tu2 tu2Var, String str, gz2 gz2Var, String str2, p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var, tu2Var, str, gz2Var, str2, p82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = az1Var;
            this.a = tu2Var;
            this.b = str;
            this.c = gz2Var;
            this.d = str2;
            this.e = p82Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    g93 M = g93.M();
                    if (M == null) {
                        this.f.d(this.b, new g12(1001, "swan app is null"));
                        uf3.i(this.c);
                        return;
                    }
                    this.a.a();
                    vc3.g(M, this.c, "", new C0228a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new g12(1001, "swan activity is null"));
                uf3.i(this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf2.e a;
        public final /* synthetic */ gz2 b;
        public final /* synthetic */ p82 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ az1 e;

        public b(az1 az1Var, lf2.e eVar, gz2 gz2Var, p82 p82Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var, eVar, gz2Var, p82Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = az1Var;
            this.a = eVar;
            this.b = gz2Var;
            this.c = p82Var;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.e.B(this.a, this.b, this.c, this.d);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements lf2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ gz2 c;
        public final /* synthetic */ p82 d;

        public c(az1 az1Var, lf2.e eVar, String str, gz2 gz2Var, p82 p82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az1Var, eVar, str, gz2Var, p82Var};
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
            this.c = gz2Var;
            this.d = p82Var;
        }

        @Override // com.baidu.tieba.lf2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m23.e(this.a, this.b);
                pc3.e(this.a.a, this.c, this.b);
                az1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az1(@NonNull hx1 hx1Var) {
        super(hx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hx1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((hx1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(p82 p82Var, gz2 gz2Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{p82Var, gz2Var, str, Boolean.valueOf(z)}) == null) && !z() && (w = f93.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            m23.c(i, str);
            o82.V3(an3.n());
            p82.b i2 = p82Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            p82.b k = i2.k("normal", gz2Var);
            if (!z) {
                i3 = p82Var.k() - 2;
            }
            k.m(i3);
            k.b();
            l23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            m23.a(str, gz2Var);
        }
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            g93 b0 = g93.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B(lf2.e eVar, gz2 gz2Var, p82 p82Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, gz2Var, p82Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = l23.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            lf2.q(eVar, new c(this, eVar, str, gz2Var, p82Var));
        }
    }

    public final void C(lf2.e eVar, gz2 gz2Var, p82 p82Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, gz2Var, p82Var, str) == null) {
            if (an3.O()) {
                B(eVar, gz2Var, p82Var, str);
            } else {
                an3.a0(new b(this, eVar, gz2Var, p82Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public g12 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            m23.b(uuid);
            Pair<g12, JSONObject> s = s(str);
            g12 g12Var = (g12) s.first;
            if (!g12Var.isSuccess()) {
                return g12Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = pc3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                g62.c("RedirectToApi", "url is null");
                return new g12(202, "url is null");
            }
            tu2 U = tu2.U();
            p82 V = U.V();
            if (V == null) {
                g62.c("RedirectToApi", "manager is null");
                return new g12(1001, "manager is null");
            }
            gz2 d = gz2.d(p, U.z());
            d.e = "2";
            d.f = uuid;
            uf3.g(d);
            if (!an3.b(U.s(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                g62.c("RedirectToApi", str2);
                uf3.i(d);
                return new g12(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && g93.M() != null) {
                g93.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = l23.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                g62.c("RedirectToApi", "cb is empty");
                uf3.i(d);
                return new g12(202, "cb is empty");
            } else if (tb3.b().a(d)) {
                tb3.b().i("redirectTo", d);
                g62.c("RedirectToApi", "access to this page is prohibited");
                return new g12(1003, "access to this page is prohibited");
            } else {
                an3.a0(new a(this, U, optString3, d, uuid, V));
                return g12.f();
            }
        }
        return (g12) invokeL.objValue;
    }
}
