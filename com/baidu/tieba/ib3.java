package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.ae2;
import com.baidu.tieba.e72;
import com.baidu.tieba.kb3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes4.dex */
public class ib3 extends s93 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes4.dex */
    public class a implements kb3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ v73 b;
        public final /* synthetic */ it2 c;
        public final /* synthetic */ vx2 d;
        public final /* synthetic */ e72 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ ib3 j;

        public a(ib3 ib3Var, String str, v73 v73Var, it2 it2Var, vx2 vx2Var, e72 e72Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib3Var, str, v73Var, it2Var, vx2Var, e72Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = ib3Var;
            this.a = str;
            this.b = v73Var;
            this.c = it2Var;
            this.d = vx2Var;
            this.e = e72Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.kb3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b13.d(this.a);
                v42.i("navigateTo", "check pages success");
                oe3.F(true, this.b.Y().T());
                this.c.o();
                ae2.e f = ae2.f(this.c.getActivity(), fe2.c(this.d.a));
                eb3.l(this.f, this.g, this.b, f.a.a(), this.d.a, eb3.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.kb3.e
        public void b(int i, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, oj3Var) == null) {
                v42.c("navigateTo", "check pages failed");
                oe3.F(false, this.b.Y().T());
                this.c.o();
                if (s93.b) {
                    Context context = this.i;
                    n73.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01aa) + i).G();
                }
                eb3.j(this.f, this.g, this.h);
                je3.j(this.d, oj3Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ae2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ vx2 c;
        public final /* synthetic */ e72 d;
        public final /* synthetic */ ib3 e;

        public b(ib3 ib3Var, ae2.e eVar, String str, vx2 vx2Var, e72 e72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib3Var, eVar, str, vx2Var, e72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ib3Var;
            this.a = eVar;
            this.b = str;
            this.c = vx2Var;
            this.d = e72Var;
        }

        @Override // com.baidu.tieba.ae2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (s93.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                b13.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (s93.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947847695, "Lcom/baidu/tieba/ib3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947847695, "Lcom/baidu/tieba/ib3;");
                return;
            }
        }
        d = cr2.g0().q();
        if (s93.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ib3(s83 s83Var) {
        super(s83Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s83Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.s93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, v73Var)) == null) {
            if (s93.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            b13.b(uuid);
            String o = eb3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                v42.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            it2 U = it2.U();
            e72 V = U.V();
            if (V == null) {
                v42.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            vx2 d2 = vx2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            je3.g(d2);
            if (!pl3.b(U.s(), d2, false)) {
                v42.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                je3.i(d2);
                return false;
            }
            String n = eb3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && v73.M() != null) {
                v73.M().L0(n, d2.d);
            }
            String n2 = eb3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = a13.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (s93.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = vk3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                v42.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                je3.i(d2);
                return false;
            } else if (ia3.b().a(d2)) {
                ia3.b().i("navigateTo", d2);
                v42.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                kb3.g(v73Var, d2, "", new a(this, uuid, v73Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(bu1 bu1Var, vx2 vx2Var, e72 e72Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bu1Var, vx2Var, e72Var, str) == null) && (activity = it2.U().getActivity()) != null && !activity.isFinishing()) {
            eb3.e(bu1Var, vx2Var, str);
            b13.c(0, str);
            if (e72Var.k() < d) {
                d72.V3(pl3.n());
                e72.b i = e72Var.i("navigateTo");
                i.n(e72.g, e72.i);
                i.k("normal", vx2Var).b();
                fk3.c(e72Var, this.c);
                a13.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                b13.a(str, vx2Var);
                return;
            }
            px1.A(e72Var, vx2Var, str, true);
        }
    }

    public final void p(ae2.e eVar, vx2 vx2Var, e72 e72Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, vx2Var, e72Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = a13.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (s93.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            ae2.q(eVar, new b(this, eVar, str, vx2Var, e72Var));
            if (s93.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
