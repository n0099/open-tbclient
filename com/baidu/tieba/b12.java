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
public class b12 extends y02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
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
        public final /* synthetic */ b12 f;

        /* renamed from: com.baidu.tieba.b12$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0235a implements we3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hb3 a;
            public final /* synthetic */ a b;

            public C0235a(a aVar, hb3 hb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, hb3Var};
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
                this.a = hb3Var;
            }

            @Override // com.baidu.tieba.we3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    n43.d(this.b.d);
                    h82.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    mh2.e f = mh2.f(this.b.a.getActivity(), rh2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    qe3.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.we3.e
            public void b(int i, an3 an3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, an3Var) == null) {
                    h82.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    qe3.k(aVar.f, aVar.b);
                    vh3.j(this.b.c, an3Var);
                }
            }
        }

        public a(b12 b12Var, uw2 uw2Var, String str, h13 h13Var, String str2, qa2 qa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b12Var, uw2Var, str, h13Var, str2, qa2Var};
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
                    we3.g(M, this.c, "", new C0235a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new h32(1001, "swan activity is null"));
                vh3.i(this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh2.e a;
        public final /* synthetic */ h13 b;
        public final /* synthetic */ qa2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ b12 e;

        public b(b12 b12Var, mh2.e eVar, h13 h13Var, qa2 qa2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b12Var, eVar, h13Var, qa2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = b12Var;
            this.a = eVar;
            this.b = h13Var;
            this.c = qa2Var;
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

    /* loaded from: classes5.dex */
    public class c implements mh2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ h13 c;
        public final /* synthetic */ qa2 d;

        public c(b12 b12Var, mh2.e eVar, String str, h13 h13Var, qa2 qa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b12Var, eVar, str, h13Var, qa2Var};
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
                b12.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b12(@NonNull iz1 iz1Var) {
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

    public static void A(qa2 qa2Var, h13 h13Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{qa2Var, h13Var, str, Boolean.valueOf(z)}) == null) && !z() && (w = gb3.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            n43.c(i, str);
            pa2.U3(bp3.n());
            qa2.b i2 = qa2Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            qa2.b k = i2.k("normal", h13Var);
            if (!z) {
                i3 = qa2Var.k() - 2;
            }
            k.m(i3);
            k.b();
            m43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            n43.a(str, h13Var);
        }
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            hb3 b0 = hb3.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B(mh2.e eVar, h13 h13Var, qa2 qa2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, h13Var, qa2Var, str) == null) {
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
            mh2.q(eVar, new c(this, eVar, str, h13Var, qa2Var));
        }
    }

    public final void C(mh2.e eVar, h13 h13Var, qa2 qa2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, h13Var, qa2Var, str) == null) {
            if (bp3.O()) {
                B(eVar, h13Var, qa2Var, str);
            } else {
                bp3.a0(new b(this, eVar, h13Var, qa2Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public h32 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
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
                h82.c("RedirectToApi", "url is null");
                return new h32(202, "url is null");
            }
            uw2 T2 = uw2.T();
            qa2 U = T2.U();
            if (U == null) {
                h82.c("RedirectToApi", "manager is null");
                return new h32(1001, "manager is null");
            }
            h13 d = h13.d(p, T2.z());
            d.e = "2";
            d.f = uuid;
            vh3.g(d);
            if (!bp3.b(T2.s(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                h82.c("RedirectToApi", str2);
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
                h82.c("RedirectToApi", "cb is empty");
                vh3.i(d);
                return new h32(202, "cb is empty");
            } else if (ud3.b().a(d)) {
                ud3.b().i("redirectTo", d);
                h82.c("RedirectToApi", "access to this page is prohibited");
                return new h32(1003, "access to this page is prohibited");
            } else {
                bp3.a0(new a(this, T2, optString3, d, uuid, U));
                return h32.f();
            }
        }
        return (h32) invokeL.objValue;
    }
}
