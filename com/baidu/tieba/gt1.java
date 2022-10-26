package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.b73;
import com.baidu.tieba.r92;
import com.baidu.tieba.v22;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gt1 extends dt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.pr1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "RedirectToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mt2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ v22 e;
        public final /* synthetic */ gt1 f;

        /* renamed from: com.baidu.tieba.gt1$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0257a implements b73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m33 a;
            public final /* synthetic */ a b;

            public C0257a(a aVar, m33 m33Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, m33Var};
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
                this.a = m33Var;
            }

            @Override // com.baidu.tieba.b73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    sw2.d(this.b.d);
                    m02.i("RedirectToApi", "check pages success");
                    this.b.a.o();
                    r92.e f = r92.f(this.b.a.getActivity(), w92.c(this.b.c.a));
                    String a = f.a.a();
                    a aVar = this.b;
                    v63.m(aVar.f, this.a, a, aVar.c.a, null, aVar.b);
                    a aVar2 = this.b;
                    aVar2.f.C(f, aVar2.c, aVar2.e, aVar2.d);
                }
            }

            @Override // com.baidu.tieba.b73.e
            public void b(int i, ff3 ff3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ff3Var) == null) {
                    m02.c("RedirectToApi", "check pages failed");
                    this.b.a.o();
                    a aVar = this.b;
                    v63.k(aVar.f, aVar.b);
                    aa3.j(this.b.c, ff3Var);
                }
            }
        }

        public a(gt1 gt1Var, zo2 zo2Var, String str, mt2 mt2Var, String str2, v22 v22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt1Var, zo2Var, str, mt2Var, str2, v22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = gt1Var;
            this.a = zo2Var;
            this.b = str;
            this.c = mt2Var;
            this.d = str2;
            this.e = v22Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SwanAppActivity activity = this.a.getActivity();
                if (activity != null && !activity.isFinishing()) {
                    m33 M = m33.M();
                    if (M == null) {
                        this.f.d(this.b, new mv1(1001, "swan app is null"));
                        aa3.i(this.c);
                        return;
                    }
                    this.a.a();
                    b73.g(M, this.c, "", new C0257a(this, M), this.d);
                    return;
                }
                this.f.d(this.b, new mv1(1001, "swan activity is null"));
                aa3.i(this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r92.e a;
        public final /* synthetic */ mt2 b;
        public final /* synthetic */ v22 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ gt1 e;

        public b(gt1 gt1Var, r92.e eVar, mt2 mt2Var, v22 v22Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt1Var, eVar, mt2Var, v22Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = gt1Var;
            this.a = eVar;
            this.b = mt2Var;
            this.c = v22Var;
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
    public class c implements r92.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r92.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mt2 c;
        public final /* synthetic */ v22 d;

        public c(gt1 gt1Var, r92.e eVar, String str, mt2 mt2Var, v22 v22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt1Var, eVar, str, mt2Var, v22Var};
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
            this.c = mt2Var;
            this.d = v22Var;
        }

        @Override // com.baidu.tieba.r92.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sw2.e(this.a, this.b);
                v63.e(this.a.a, this.c, this.b);
                gt1.A(this.d, this.c, this.b, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gt1(nr1 nr1Var) {
        super(nr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((nr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void A(v22 v22Var, mt2 mt2Var, String str, boolean z) {
        SwanAppActivity w;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{v22Var, mt2Var, str, Boolean.valueOf(z)}) == null) && !z() && (w = l33.K().w()) != null && !w.isFinishing() && !w.isDestroyed()) {
            if (z) {
                i = 8;
            } else {
                i = 2;
            }
            sw2.c(i, str);
            u22.S3(gh3.n());
            v22.b i2 = v22Var.i("redirectTo");
            int i3 = 0;
            i2.n(0, 0);
            v22.b k = i2.k("normal", mt2Var);
            if (!z) {
                i3 = v22Var.k() - 2;
            }
            k.m(i3);
            k.b();
            rw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            sw2.a(str, mt2Var);
        }
    }

    public static boolean z() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            m33 b0 = m33.b0();
            if (b0 == null || (w = b0.w()) == null || w.isFinishing() || w.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void B(r92.e eVar, mt2 mt2Var, v22 v22Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, eVar, mt2Var, v22Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = rw2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            r92.q(eVar, new c(this, eVar, str, mt2Var, v22Var));
        }
    }

    public final void C(r92.e eVar, mt2 mt2Var, v22 v22Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, mt2Var, v22Var, str) == null) {
            if (gh3.O()) {
                B(eVar, mt2Var, v22Var, str);
            } else {
                gh3.a0(new b(this, eVar, mt2Var, v22Var, str));
            }
        }
    }

    public mv1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#redirectTo params=" + str, false);
            String uuid = UUID.randomUUID().toString();
            sw2.b(uuid);
            Pair s = s(str);
            mv1 mv1Var = (mv1) s.first;
            if (!mv1Var.isSuccess()) {
                return mv1Var;
            }
            JSONObject jSONObject = (JSONObject) s.second;
            String p = v63.p(jSONObject);
            if (TextUtils.isEmpty(p)) {
                m02.c("RedirectToApi", "url is null");
                return new mv1(202, "url is null");
            }
            zo2 U = zo2.U();
            v22 V = U.V();
            if (V == null) {
                m02.c("RedirectToApi", "manager is null");
                return new mv1(1001, "manager is null");
            }
            mt2 d = mt2.d(p, U.z());
            d.e = "2";
            d.f = uuid;
            aa3.g(d);
            if (!gh3.b(U.s(), d, false)) {
                String str2 = "page params error : path=" + d.a + " ; routePath=" + d.d;
                m02.c("RedirectToApi", str2);
                aa3.i(d);
                return new mv1(202, str2);
            }
            String optString = jSONObject.optString("initData");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(d.d) && m33.M() != null) {
                m33.M().L0(optString, d.d);
            }
            String optString2 = jSONObject.optString(FetchLog.START_TIME);
            if (!TextUtils.isEmpty(optString2)) {
                HybridUbcFlow q = rw2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(optString2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString3 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                m02.c("RedirectToApi", "cb is empty");
                aa3.i(d);
                return new mv1(202, "cb is empty");
            } else if (z53.b().a(d)) {
                z53.b().i("redirectTo", d);
                m02.c("RedirectToApi", "access to this page is prohibited");
                return new mv1(1003, "access to this page is prohibited");
            } else {
                gh3.a0(new a(this, U, optString3, d, uuid, V));
                return mv1.f();
            }
        }
        return (mv1) invokeL.objValue;
    }
}
