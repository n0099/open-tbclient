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
import com.baidu.tieba.pc2;
import com.baidu.tieba.z93;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes5.dex */
public class ba3 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements z93.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xr2 b;
        public final /* synthetic */ kw2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ k63 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ t52 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ ba3 j;

        public a(ba3 ba3Var, String str, xr2 xr2Var, kw2 kw2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var, String str2, t52 t52Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba3Var, str, xr2Var, kw2Var, unitedSchemeEntity, callbackHandler, k63Var, str2, t52Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = ba3Var;
            this.a = str;
            this.b = xr2Var;
            this.c = kw2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = k63Var;
            this.g = str2;
            this.h = t52Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.z93.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                qz2.d(this.a);
                k32.i("redirect", "check pages success");
                this.b.p();
                pc2.e f = pc2.f(this.b.getActivity(), uc2.c(this.c.a));
                t93.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.z93.e
        public void b(int i, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, di3Var) == null) {
                k32.c("redirect", "check pages failed");
                this.b.p();
                if (h83.b) {
                    Context context = this.i;
                    c63.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01df) + i).G();
                }
                t93.j(this.d, this.e, this.g);
                yc3.j(this.c, di3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pc2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pc2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kw2 c;
        public final /* synthetic */ t52 d;

        public b(ba3 ba3Var, pc2.e eVar, String str, kw2 kw2Var, t52 t52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba3Var, eVar, str, kw2Var, t52Var};
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
            this.c = kw2Var;
            this.d = t52Var;
        }

        @Override // com.baidu.tieba.pc2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (h83.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                qz2.e(this.a, this.b);
                t93.e(this.a.a, this.c, this.b);
                fw1.B(this.d, this.c, this.b, false);
                if (h83.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba3(h73 h73Var) {
        super(h73Var, "/swanAPI/redirectTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var};
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

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            if (h83.b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            qz2.b(uuid);
            String o = t93.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                k32.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            xr2 V = xr2.V();
            t52 W = V.W();
            if (W == null) {
                k32.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            kw2 d = kw2.d(o, V.A());
            d.e = "2";
            d.f = uuid;
            yc3.g(d);
            if (!ek3.b(V.t(), d, false)) {
                k32.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                yc3.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && k63.M() != null) {
                k63.M().M0(str, d.d);
            }
            String n = t93.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = pz2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (h83.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = kj3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                k32.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                yc3.i(d);
                return false;
            } else if (x83.b().a(d)) {
                x83.b().i("redirectTo", d);
                k32.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                V.a();
                z93.g(k63Var, d, "", new a(this, uuid, V, d, unitedSchemeEntity, callbackHandler, k63Var, optString, W, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(pc2.e eVar, kw2 kw2Var, t52 t52Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, kw2Var, t52Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = pz2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (h83.b) {
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            pc2.q(eVar, new b(this, eVar, str, kw2Var, t52Var));
            if (h83.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
