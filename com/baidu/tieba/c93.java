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
import com.baidu.tieba.e93;
import com.baidu.tieba.ub2;
import com.baidu.tieba.y42;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes5.dex */
public class c93 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes5.dex */
    public class a implements e93.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ p53 b;
        public final /* synthetic */ cr2 c;
        public final /* synthetic */ pv2 d;
        public final /* synthetic */ y42 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ c93 j;

        public a(c93 c93Var, String str, p53 p53Var, cr2 cr2Var, pv2 pv2Var, y42 y42Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c93Var, str, p53Var, cr2Var, pv2Var, y42Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = c93Var;
            this.a = str;
            this.b = p53Var;
            this.c = cr2Var;
            this.d = pv2Var;
            this.e = y42Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.e93.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vy2.d(this.a);
                p22.i("navigateTo", "check pages success");
                ic3.F(true, this.b.Z().U());
                this.c.p();
                ub2.e f = ub2.f(this.c.getActivity(), zb2.c(this.d.a));
                y83.l(this.f, this.g, this.b, f.a.a(), this.d.a, y83.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.e93.e
        public void b(int i, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ih3Var) == null) {
                p22.c("navigateTo", "check pages failed");
                ic3.F(false, this.b.Z().U());
                this.c.p();
                if (m73.b) {
                    Context context = this.i;
                    h53.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d7) + i).G();
                }
                y83.j(this.f, this.g, this.h);
                dc3.j(this.d, ih3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ub2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ pv2 c;
        public final /* synthetic */ y42 d;
        public final /* synthetic */ c93 e;

        public b(c93 c93Var, ub2.e eVar, String str, pv2 pv2Var, y42 y42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c93Var, eVar, str, pv2Var, y42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = c93Var;
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
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                vy2.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (m73.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947629548, "Lcom/baidu/tieba/c93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947629548, "Lcom/baidu/tieba/c93;");
                return;
            }
        }
        d = wo2.g0().q();
        if (m73.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c93(m63 m63Var) {
        super(m63Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var};
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

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            if (m73.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            vy2.b(uuid);
            String o = y83.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                p22.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            cr2 V = cr2.V();
            y42 W = V.W();
            if (W == null) {
                p22.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            pv2 d2 = pv2.d(o, V.A());
            d2.e = "0";
            d2.f = uuid;
            dc3.g(d2);
            if (!jj3.b(V.t(), d2, false)) {
                p22.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                dc3.i(d2);
                return false;
            }
            String n = y83.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && p53.M() != null) {
                p53.M().M0(n, d2.d);
            }
            String n2 = y83.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = uy2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (m73.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = pi3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p22.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                dc3.i(d2);
                return false;
            } else if (c83.b().a(d2)) {
                c83.b().i("navigateTo", d2);
                p22.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                V.a();
                e93.g(p53Var, d2, "", new a(this, uuid, p53Var, V, d2, W, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(wr1 wr1Var, pv2 pv2Var, y42 y42Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wr1Var, pv2Var, y42Var, str) == null) && (activity = cr2.V().getActivity()) != null && !activity.isFinishing()) {
            y83.e(wr1Var, pv2Var, str);
            vy2.c(0, str);
            if (y42Var.k() < d) {
                x42.Z3(jj3.n());
                y42.b i = y42Var.i("navigateTo");
                i.n(y42.g, y42.i);
                i.k("normal", pv2Var).b();
                zh3.c(y42Var, this.c);
                uy2.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                vy2.a(str, pv2Var);
                return;
            }
            kv1.B(y42Var, pv2Var, str, true);
        }
    }

    public final void p(ub2.e eVar, pv2 pv2Var, y42 y42Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, pv2Var, y42Var, str) == null) {
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
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            ub2.q(eVar, new b(this, eVar, str, pv2Var, y42Var));
            if (m73.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
