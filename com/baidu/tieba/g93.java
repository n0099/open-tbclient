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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes6.dex */
public class g93 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements e93.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cr2 b;
        public final /* synthetic */ pv2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ p53 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ y42 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ g93 j;

        public a(g93 g93Var, String str, cr2 cr2Var, pv2 pv2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var, String str2, y42 y42Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g93Var, str, cr2Var, pv2Var, unitedSchemeEntity, callbackHandler, p53Var, str2, y42Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = g93Var;
            this.a = str;
            this.b = cr2Var;
            this.c = pv2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = p53Var;
            this.g = str2;
            this.h = y42Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.e93.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vy2.d(this.a);
                p22.i("redirect", "check pages success");
                this.b.p();
                ub2.e f = ub2.f(this.b.getActivity(), zb2.c(this.c.a));
                y83.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.e93.e
        public void b(int i, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ih3Var) == null) {
                p22.c("redirect", "check pages failed");
                this.b.p();
                if (m73.b) {
                    Context context = this.i;
                    h53.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d7) + i).G();
                }
                y83.j(this.d, this.e, this.g);
                dc3.j(this.c, ih3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ub2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pv2 c;
        public final /* synthetic */ y42 d;

        public b(g93 g93Var, ub2.e eVar, String str, pv2 pv2Var, y42 y42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g93Var, eVar, str, pv2Var, y42Var};
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
            this.c = pv2Var;
            this.d = y42Var;
        }

        @Override // com.baidu.tieba.ub2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (m73.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                vy2.e(this.a, this.b);
                y83.e(this.a.a, this.c, this.b);
                kv1.B(this.d, this.c, this.b, false);
                if (m73.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g93(m63 m63Var) {
        super(m63Var, "/swanAPI/redirectTo");
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
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            vy2.b(uuid);
            String o = y83.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                p22.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            cr2 V = cr2.V();
            y42 W = V.W();
            if (W == null) {
                p22.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            pv2 d = pv2.d(o, V.A());
            d.e = "2";
            d.f = uuid;
            dc3.g(d);
            if (!jj3.b(V.t(), d, false)) {
                p22.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                dc3.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && p53.M() != null) {
                p53.M().M0(str, d.d);
            }
            String n = y83.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = uy2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (m73.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = pi3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p22.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                dc3.i(d);
                return false;
            } else if (c83.b().a(d)) {
                c83.b().i("redirectTo", d);
                p22.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                V.a();
                e93.g(p53Var, d, "", new a(this, uuid, V, d, unitedSchemeEntity, callbackHandler, p53Var, optString, W, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(ub2.e eVar, pv2 pv2Var, y42 y42Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, pv2Var, y42Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = uy2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (m73.b) {
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            ub2.q(eVar, new b(this, eVar, str, pv2Var, y42Var));
            if (m73.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
