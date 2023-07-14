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
import com.baidu.tieba.ai2;
import com.baidu.tieba.eb2;
import com.baidu.tieba.kf3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes6.dex */
public class if3 extends sd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes6.dex */
    public class a implements kf3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ vb3 b;
        public final /* synthetic */ ix2 c;
        public final /* synthetic */ v13 d;
        public final /* synthetic */ eb2 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ if3 j;

        public a(if3 if3Var, String str, vb3 vb3Var, ix2 ix2Var, v13 v13Var, eb2 eb2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if3Var, str, vb3Var, ix2Var, v13Var, eb2Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = if3Var;
            this.a = str;
            this.b = vb3Var;
            this.c = ix2Var;
            this.d = v13Var;
            this.e = eb2Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.kf3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b53.d(this.a);
                v82.i("navigateTo", "check pages success");
                oi3.F(true, this.b.Y().T());
                this.c.o();
                ai2.e f = ai2.f(this.c.getActivity(), fi2.c(this.d.a));
                ef3.l(this.f, this.g, this.b, f.a.a(), this.d.a, ef3.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.kf3.e
        public void b(int i, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, on3Var) == null) {
                v82.c("navigateTo", "check pages failed");
                oi3.F(false, this.b.Y().T());
                this.c.o();
                if (sd3.b) {
                    Context context = this.i;
                    nb3.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01d4) + i).G();
                }
                ef3.j(this.f, this.g, this.h);
                ji3.j(this.d, on3Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ai2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ai2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ v13 c;
        public final /* synthetic */ eb2 d;
        public final /* synthetic */ if3 e;

        public b(if3 if3Var, ai2.e eVar, String str, v13 v13Var, eb2 eb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if3Var, eVar, str, v13Var, eb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = if3Var;
            this.a = eVar;
            this.b = str;
            this.c = v13Var;
            this.d = eb2Var;
        }

        @Override // com.baidu.tieba.ai2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (sd3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                b53.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (sd3.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947851539, "Lcom/baidu/tieba/if3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947851539, "Lcom/baidu/tieba/if3;");
                return;
            }
        }
        d = cv2.g0().q();
        if (sd3.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public if3(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc3Var};
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

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            if (sd3.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            b53.b(uuid);
            String o = ef3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                v82.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            ix2 T2 = ix2.T();
            eb2 U = T2.U();
            if (U == null) {
                v82.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            v13 d2 = v13.d(o, T2.z());
            d2.e = "0";
            d2.f = uuid;
            ji3.g(d2);
            if (!pp3.b(T2.s(), d2, false)) {
                v82.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                ji3.i(d2);
                return false;
            }
            String n = ef3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && vb3.M() != null) {
                vb3.M().L0(n, d2.d);
            }
            String n2 = ef3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = a53.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (sd3.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = vo3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                v82.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                ji3.i(d2);
                return false;
            } else if (ie3.b().a(d2)) {
                ie3.b().i("navigateTo", d2);
                v82.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                T2.a();
                kf3.g(vb3Var, d2, "", new a(this, uuid, vb3Var, T2, d2, U, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(by1 by1Var, v13 v13Var, eb2 eb2Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, by1Var, v13Var, eb2Var, str) == null) && (activity = ix2.T().getActivity()) != null && !activity.isFinishing()) {
            ef3.e(by1Var, v13Var, str);
            b53.c(0, str);
            if (eb2Var.k() < d) {
                db2.U3(pp3.n());
                eb2.b i = eb2Var.i("navigateTo");
                i.n(eb2.g, eb2.i);
                i.k("normal", v13Var).b();
                fo3.c(eb2Var, this.c);
                a53.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                b53.a(str, v13Var);
                return;
            }
            p12.A(eb2Var, v13Var, str, true);
        }
    }

    public final void p(ai2.e eVar, v13 v13Var, eb2 eb2Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, v13Var, eb2Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = a53.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (sd3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            ai2.q(eVar, new b(this, eVar, str, v13Var, eb2Var));
            if (sd3.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
