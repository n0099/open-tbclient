package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.e93;
import com.baidu.tieba.ub2;
import com.baidu.tieba.y42;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i93 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements e93.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cr2 b;
        public final /* synthetic */ y42 c;
        public final /* synthetic */ pv2 d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ Context g;
        public final /* synthetic */ String h;
        public final /* synthetic */ i93 i;

        /* renamed from: com.baidu.tieba.i93$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0328a implements ub2.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ub2.e a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ a c;

            public C0328a(a aVar, ub2.e eVar, JSONObject jSONObject) {
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

            @Override // com.baidu.tieba.ub2.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    vy2.e(this.a, this.c.a);
                    wr1 wr1Var = this.a.a;
                    a aVar = this.c;
                    y83.e(wr1Var, aVar.d, aVar.a);
                    vy2.c(5, this.c.a);
                    a aVar2 = this.c;
                    aVar2.i.n(aVar2.c, aVar2.d, aVar2.a);
                    a aVar3 = this.c;
                    UnitedSchemeUtility.callCallback(aVar3.e, aVar3.f, UnitedSchemeUtility.wrapCallbackParams(this.b, 0));
                }
            }
        }

        public a(i93 i93Var, String str, cr2 cr2Var, y42 y42Var, pv2 pv2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i93Var, str, cr2Var, y42Var, pv2Var, callbackHandler, unitedSchemeEntity, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = i93Var;
            this.a = str;
            this.b = cr2Var;
            this.c = y42Var;
            this.d = pv2Var;
            this.e = callbackHandler;
            this.f = unitedSchemeEntity;
            this.g = context;
            this.h = str2;
        }

        @Override // com.baidu.tieba.e93.e
        public void a(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vy2.d(this.a);
                this.b.p();
                x42 l = this.c.l();
                if (l != null && !TextUtils.isEmpty(l.D3(this.d.d))) {
                    JSONObject c = y83.c(l.D3(this.d.d));
                    vy2.c(4, this.a);
                    this.i.n(this.c, this.d, this.a);
                    UnitedSchemeUtility.callCallback(this.e, this.f, UnitedSchemeUtility.wrapCallbackParams(c, 0));
                    return;
                }
                ub2.e f = ub2.f(this.b.getActivity(), zb2.c(this.d.d));
                JSONObject c2 = y83.c(str);
                HybridUbcFlow q = uy2.q("route", this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                if (f.b) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                q.D("preload", str2);
                ub2.q(f, new C0328a(this, f, c2));
            }
        }

        @Override // com.baidu.tieba.e93.e
        public void b(int i, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ih3Var) == null) {
                this.b.p();
                if (m73.b) {
                    Context context = this.g;
                    h53.g(context, this.g.getString(R.string.obfuscated_res_0x7f0f01d7) + i).G();
                }
                if (!TextUtils.isEmpty(this.h)) {
                    y83.j(this.f, this.e, this.h);
                }
                dc3.j(this.d, ih3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y42 a;
        public final /* synthetic */ pv2 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ i93 d;

        public b(i93 i93Var, y42 y42Var, pv2 pv2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i93Var, y42Var, pv2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = i93Var;
            this.a = y42Var;
            this.b = pv2Var;
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
    public i93(m63 m63Var) {
        super(m63Var, "/swanAPI/switchTab");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var};
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

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            if (m73.b) {
                Log.d("SwitchTabAction", "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            vy2.b(uuid);
            String o = y83.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                p22.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = pi3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            cr2 V = cr2.V();
            y42 W = V.W();
            if (W == null) {
                p22.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            pv2 d = pv2.d(o, V.A());
            d.e = "4";
            d.f = uuid;
            dc3.g(d);
            if (!jj3.c(V.t(), d)) {
                p22.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                dc3.i(d);
                return false;
            }
            String n = y83.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = uy2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            V.a();
            e93.g(p53Var, d, "", new a(this, uuid, V, W, d, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            p22.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(y42 y42Var, pv2 pv2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y42Var, pv2Var, str) == null) {
            x42.Z3(jj3.n());
            y42.b i = y42Var.i("switchTab");
            i.n(0, 0);
            i.i();
            i.q(pv2Var).b();
            uy2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            vy2.a(str, pv2Var);
        }
    }

    public final void n(y42 y42Var, pv2 pv2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, y42Var, pv2Var, str) == null) {
            if (jj3.O()) {
                m(y42Var, pv2Var, str);
            } else {
                jj3.a0(new b(this, y42Var, pv2Var, str));
            }
        }
    }
}
