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
import com.baidu.tieba.bd3;
import com.baidu.tieba.rf2;
import com.baidu.tieba.v82;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gz1 extends dz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.px1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zu2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mz2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ v82 e;
        public final /* synthetic */ gz1 f;

        /* renamed from: com.baidu.tieba.gz1$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0272a implements bd3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m93 a;
            public final /* synthetic */ a b;

            public C0272a(a aVar, m93 m93Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, m93Var};
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
                this.a = m93Var;
            }

            @Override // com.baidu.tieba.bd3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    s23.d(this.b.d);
                    m62.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    rf2.e f = rf2.f(this.b.a.getActivity(), wf2.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    vc3.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.bd3.e
            public void b(int i, fl3 fl3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, fl3Var) == null) {
                    m62.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    vc3.k(aVar.f, aVar.b);
                    ag3.j(this.b.c, fl3Var);
                }
            }
        }

        public a(gz1 gz1Var, zu2 zu2Var, String str, mz2 mz2Var, String str2, v82 v82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz1Var, zu2Var, str, mz2Var, str2, v82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = gz1Var;
            this.a = zu2Var;
            this.b = str;
            this.c = mz2Var;
            this.d = str2;
            this.e = v82Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    m93 M = m93.M();
                    if (M == null) {
                        this.f.d(this.b, new m12(1001, "swan app is null"));
                        ag3.i(this.c);
                        return;
                    }
                    this.a.a();
                    bd3.g(M, this.c, "", new C0272a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new m12(1001, "swan activity is null"));
                ag3.i(this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rf2.e a;
        public final /* synthetic */ mz2 b;
        public final /* synthetic */ v82 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ gz1 e;

        public b(gz1 gz1Var, rf2.e eVar, mz2 mz2Var, v82 v82Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz1Var, eVar, mz2Var, v82Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = gz1Var;
            this.a = eVar;
            this.b = mz2Var;
            this.c = v82Var;
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
    public class c implements rf2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rf2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mz2 c;
        public final /* synthetic */ v82 d;

        public c(gz1 gz1Var, rf2.e eVar, String str, mz2 mz2Var, v82 v82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz1Var, eVar, str, mz2Var, v82Var};
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
            this.c = mz2Var;
            this.d = v82Var;
        }

        @Override // com.baidu.tieba.rf2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s23.e(this.a, this.b);
                vc3.e(this.a.a, this.c, this.b);
                gz1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gz1(@NonNull nx1 nx1Var) {
        super(nx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nx1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nx1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(v82 v82Var, mz2 mz2Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{v82Var, mz2Var, str, Boolean.valueOf(z)}) == null) && !z() && (w = l93.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            s23.c(i, str);
            u82.S3(gn3.n());
            v82.b i2 = v82Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            v82.b k = i2.k("normal", mz2Var);
            if (!z) {
                i3 = v82Var.k() - 2;
            }
            k.m(i3);
            k.b();
            r23.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            s23.a(str, mz2Var);
        }
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            m93 b0 = m93.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B(rf2.e eVar, mz2 mz2Var, v82 v82Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, mz2Var, v82Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = r23.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            rf2.q(eVar, new c(this, eVar, str, mz2Var, v82Var));
        }
    }

    public final void C(rf2.e eVar, mz2 mz2Var, v82 v82Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, mz2Var, v82Var, str) == null) {
            if (gn3.O()) {
                B(eVar, mz2Var, v82Var, str);
            } else {
                gn3.a0(new b(this, eVar, mz2Var, v82Var, str));
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public m12 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            s23.b(uuid);
            Pair<m12, JSONObject> s = s(str);
            m12 m12Var = (m12) s.first;
            if (!m12Var.isSuccess()) {
                return m12Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = vc3.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                m62.c("RedirectToApi", "url is null");
                return new m12(202, "url is null");
            }
            zu2 U = zu2.U();
            v82 V = U.V();
            if (V == null) {
                m62.c("RedirectToApi", "manager is null");
                return new m12(1001, "manager is null");
            }
            mz2 d = mz2.d(p, U.z());
            d.e = "2";
            d.f = uuid;
            ag3.g(d);
            if (!gn3.b(U.s(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                m62.c("RedirectToApi", str2);
                ag3.i(d);
                return new m12(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && m93.M() != null) {
                m93.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString("startTime");
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = r23.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                m62.c("RedirectToApi", "cb is empty");
                ag3.i(d);
                return new m12(202, "cb is empty");
            } else if (zb3.b().a(d)) {
                zb3.b().i("redirectTo", d);
                m62.c("RedirectToApi", "access to this page is prohibited");
                return new m12(1003, "access to this page is prohibited");
            } else {
                gn3.a0(new a(this, U, optString3, d, uuid, V));
                return m12.f();
            }
        }
        return (m12) invokeL.objValue;
    }
}
