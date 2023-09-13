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
public class af3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements we3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ uw2 b;
        public final /* synthetic */ qa2 c;
        public final /* synthetic */ h13 d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ Context g;
        public final /* synthetic */ String h;
        public final /* synthetic */ af3 i;

        /* renamed from: com.baidu.tieba.af3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0232a implements mh2.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ mh2.e a;
            public final /* synthetic */ JSONObject b;
            public final /* synthetic */ a c;

            public C0232a(a aVar, mh2.e eVar, JSONObject jSONObject) {
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

            @Override // com.baidu.tieba.mh2.f
            public void onReady() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    n43.e(this.a, this.c.a);
                    nx1 nx1Var = this.a.a;
                    a aVar = this.c;
                    qe3.e(nx1Var, aVar.d, aVar.a);
                    n43.c(5, this.c.a);
                    a aVar2 = this.c;
                    aVar2.i.n(aVar2.c, aVar2.d, aVar2.a);
                    a aVar3 = this.c;
                    UnitedSchemeUtility.callCallback(aVar3.e, aVar3.f, UnitedSchemeUtility.wrapCallbackParams(this.b, 0));
                }
            }
        }

        public a(af3 af3Var, String str, uw2 uw2Var, qa2 qa2Var, h13 h13Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af3Var, str, uw2Var, qa2Var, h13Var, callbackHandler, unitedSchemeEntity, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = af3Var;
            this.a = str;
            this.b = uw2Var;
            this.c = qa2Var;
            this.d = h13Var;
            this.e = callbackHandler;
            this.f = unitedSchemeEntity;
            this.g = context;
            this.h = str2;
        }

        @Override // com.baidu.tieba.we3.e
        public void a(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                n43.d(this.a);
                this.b.o();
                pa2 l = this.c.l();
                if (l != null && !TextUtils.isEmpty(l.y3(this.d.d))) {
                    JSONObject c = qe3.c(l.y3(this.d.d));
                    n43.c(4, this.a);
                    this.i.n(this.c, this.d, this.a);
                    UnitedSchemeUtility.callCallback(this.e, this.f, UnitedSchemeUtility.wrapCallbackParams(c, 0));
                    return;
                }
                mh2.e f = mh2.f(this.b.getActivity(), rh2.c(this.d.d));
                JSONObject c2 = qe3.c(str);
                HybridUbcFlow q = m43.q("route", this.a);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                if (f.b) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                q.D("preload", str2);
                mh2.q(f, new C0232a(this, f, c2));
            }
        }

        @Override // com.baidu.tieba.we3.e
        public void b(int i, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, an3Var) == null) {
                this.b.o();
                if (ed3.b) {
                    Context context = this.g;
                    za3.g(context, this.g.getString(R.string.obfuscated_res_0x7f0f01d5) + i).G();
                }
                if (!TextUtils.isEmpty(this.h)) {
                    qe3.j(this.f, this.e, this.h);
                }
                vh3.j(this.d, an3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qa2 a;
        public final /* synthetic */ h13 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ af3 d;

        public b(af3 af3Var, qa2 qa2Var, h13 h13Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af3Var, qa2Var, h13Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = af3Var;
            this.a = qa2Var;
            this.b = h13Var;
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
    public af3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/switchTab");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
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

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("SwitchTabAction", "SwitchTabAction#handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            n43.b(uuid);
            String o = qe3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                h82.c("switchTab", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = ho3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            uw2 T2 = uw2.T();
            qa2 U = T2.U();
            if (U == null) {
                h82.c("switchTab", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            h13 d = h13.d(o, T2.z());
            d.e = "4";
            d.f = uuid;
            vh3.g(d);
            if (!bp3.c(T2.s(), d)) {
                h82.c("switchTab", "tab params error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                vh3.i(d);
                return false;
            }
            String n = qe3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = m43.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            T2.a();
            we3.g(hb3Var, d, "", new a(this, uuid, T2, U, d, callbackHandler, unitedSchemeEntity, context, optString), uuid);
            h82.i("switchTab", "create and load page");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(qa2 qa2Var, h13 h13Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qa2Var, h13Var, str) == null) {
            pa2.U3(bp3.n());
            qa2.b i = qa2Var.i("switchTab");
            i.n(0, 0);
            i.i();
            i.q(h13Var).b();
            m43.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
            n43.a(str, h13Var);
        }
    }

    public final void n(qa2 qa2Var, h13 h13Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, qa2Var, h13Var, str) == null) {
            if (bp3.O()) {
                m(qa2Var, h13Var, str);
            } else {
                bp3.a0(new b(this, qa2Var, h13Var, str));
            }
        }
    }
}
