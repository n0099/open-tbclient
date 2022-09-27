package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
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
/* loaded from: classes3.dex */
public class e73 extends i53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements a73.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yo2 b;
        public final /* synthetic */ u22 c;
        public final /* synthetic */ lt2 d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ Context g;
        public final /* synthetic */ String h;
        public final /* synthetic */ e73 i;

        /* renamed from: com.baidu.tieba.e73$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0234a implements q92.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q92.e a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ a c;

            public C0234a(a aVar, q92.e eVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, eVar, jSONObject};
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
                this.a = eVar;
                this.b = jSONObject;
            }

            @Override // com.baidu.tieba.q92.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    rw2.e(this.a, this.c.a);
                    rp1 rp1Var = this.a.a;
                    a aVar = this.c;
                    u63.e(rp1Var, aVar.d, aVar.a);
                    rw2.c(5, this.c.a);
                    a aVar2 = this.c;
                    aVar2.i.n(aVar2.c, aVar2.d, aVar2.a);
                    a aVar3 = this.c;
                    UnitedSchemeUtility.callCallback(aVar3.e, aVar3.f, UnitedSchemeUtility.wrapCallbackParams(this.b, 0));
                }
            }
        }

        public a(e73 e73Var, String str, yo2 yo2Var, u22 u22Var, lt2 lt2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e73Var, str, yo2Var, u22Var, lt2Var, callbackHandler, unitedSchemeEntity, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = e73Var;
            this.a = str;
            this.b = yo2Var;
            this.c = u22Var;
            this.d = lt2Var;
            this.e = callbackHandler;
            this.f = unitedSchemeEntity;
            this.g = context;
            this.h = str2;
        }

        @Override // com.baidu.tieba.a73.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                rw2.d(this.a);
                this.b.o();
                t22 l = this.c.l();
                if (l != null && !TextUtils.isEmpty(l.w3(this.d.d))) {
                    JSONObject c = u63.c(l.w3(this.d.d));
                    rw2.c(4, this.a);
                    this.i.n(this.c, this.d, this.a);
                    UnitedSchemeUtility.callCallback(this.e, this.f, UnitedSchemeUtility.wrapCallbackParams(c, 0));
                    return;
                }
                q92.e f = q92.f(this.b.getActivity(), v92.c(this.d.d));
                JSONObject c2 = u63.c(str);
                HybridUbcFlow q = qw2.q("route", this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f.b ? "1" : "0");
                q92.q(f, new C0234a(this, f, c2));
            }
        }

        @Override // com.baidu.tieba.a73.e
        public void b(int i, ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ef3Var) == null) {
                this.b.o();
                if (i53.b) {
                    Context context = this.g;
                    d33.g(context, this.g.getString(R.string.obfuscated_res_0x7f0f01a8) + i).G();
                }
                if (!TextUtils.isEmpty(this.h)) {
                    u63.j(this.f, this.e, this.h);
                }
                z93.j(this.d, ef3Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u22 a;
        public final /* synthetic */ lt2 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ e73 d;

        public b(e73 e73Var, u22 u22Var, lt2 lt2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e73Var, u22Var, lt2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = e73Var;
            this.a = u22Var;
            this.b = lt2Var;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.m(this.a, this.b, this.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e73(i43 i43Var) {
        super(i43Var, "/swanAPI/switchTab");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            if (i53.b) {
                Log.d("SwitchTabAction", "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            rw2.b(uuid);
            String o = u63.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                l02.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = lg3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            yo2 U = yo2.U();
            u22 V = U.V();
            if (V == null) {
                l02.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            lt2 d = lt2.d(o, U.z());
            d.e = "4";
            d.f = uuid;
            z93.g(d);
            if (!fh3.c(U.s(), d)) {
                l02.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                z93.i(d);
                return false;
            }
            String n = u63.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = qw2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            U.a();
            a73.g(l33Var, d, "", new a(this, uuid, U, V, d, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            l02.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(u22 u22Var, lt2 lt2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u22Var, lt2Var, str) == null) {
            t22.S3(fh3.n());
            u22.b i = u22Var.i("switchTab");
            i.n(0, 0);
            i.i();
            i.q(lt2Var).b();
            qw2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            rw2.a(str, lt2Var);
        }
    }

    public final void n(u22 u22Var, lt2 lt2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, u22Var, lt2Var, str) == null) {
            if (fh3.O()) {
                m(u22Var, lt2Var, str);
            } else {
                fh3.a0(new b(this, u22Var, lt2Var, str));
            }
        }
    }
}
