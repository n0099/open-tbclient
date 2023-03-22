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
import com.baidu.tieba.c72;
import com.baidu.tieba.ib3;
import com.baidu.tieba.yd2;
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
public class gb3 extends q93 {
    public static /* synthetic */ Interceptable $ic;
    public static final int d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;

    /* loaded from: classes4.dex */
    public class a implements ib3.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ t73 b;
        public final /* synthetic */ gt2 c;
        public final /* synthetic */ tx2 d;
        public final /* synthetic */ c72 e;
        public final /* synthetic */ UnitedSchemeEntity f;
        public final /* synthetic */ CallbackHandler g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ gb3 j;

        public a(gb3 gb3Var, String str, t73 t73Var, gt2 gt2Var, tx2 tx2Var, c72 c72Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str2, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb3Var, str, t73Var, gt2Var, tx2Var, c72Var, unitedSchemeEntity, callbackHandler, str2, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = gb3Var;
            this.a = str;
            this.b = t73Var;
            this.c = gt2Var;
            this.d = tx2Var;
            this.e = c72Var;
            this.f = unitedSchemeEntity;
            this.g = callbackHandler;
            this.h = str2;
            this.i = context;
        }

        @Override // com.baidu.tieba.ib3.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                z03.d(this.a);
                t42.i("navigateTo", "check pages success");
                me3.F(true, this.b.Y().T());
                this.c.o();
                yd2.e f = yd2.f(this.c.getActivity(), de2.c(this.d.a));
                cb3.l(this.f, this.g, this.b, f.a.a(), this.d.a, cb3.g(this.e), this.h);
                this.j.p(f, this.d, this.e, this.a);
            }
        }

        @Override // com.baidu.tieba.ib3.e
        public void b(int i, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, mj3Var) == null) {
                t42.c("navigateTo", "check pages failed");
                me3.F(false, this.b.Y().T());
                this.c.o();
                if (q93.b) {
                    Context context = this.i;
                    l73.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01aa) + i).G();
                }
                cb3.j(this.f, this.g, this.h);
                he3.j(this.d, mj3Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements yd2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yd2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tx2 c;
        public final /* synthetic */ c72 d;
        public final /* synthetic */ gb3 e;

        public b(gb3 gb3Var, yd2.e eVar, String str, tx2 tx2Var, c72 c72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb3Var, eVar, str, tx2Var, c72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = gb3Var;
            this.a = eVar;
            this.b = str;
            this.c = tx2Var;
            this.d = c72Var;
        }

        @Override // com.baidu.tieba.yd2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (q93.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady start.");
                }
                z03.e(this.a, this.b);
                this.e.o(this.a.a, this.c, this.d, this.b);
                if (q93.b) {
                    Log.d("NavigateToAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947788113, "Lcom/baidu/tieba/gb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947788113, "Lcom/baidu/tieba/gb3;");
                return;
            }
        }
        d = ar2.g0().q();
        if (q93.b) {
            Log.d("NavigateToAction", "NavigateToAction max count: " + d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb3(q83 q83Var) {
        super(q83Var, "/swanAPI/navigateTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var};
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

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            if (q93.b) {
                Log.d("NavigateToAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = context;
            String uuid = UUID.randomUUID().toString();
            z03.b(uuid);
            String o = cb3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                t42.c("navigateTo", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            gt2 U = gt2.U();
            c72 V = U.V();
            if (V == null) {
                t42.c("navigateTo", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            tx2 d2 = tx2.d(o, U.z());
            d2.e = "0";
            d2.f = uuid;
            he3.g(d2);
            if (!nl3.b(U.s(), d2, false)) {
                t42.c("navigateTo", "page params error : path=" + d2.a + " ; routePath=" + d2.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                he3.i(d2);
                return false;
            }
            String n = cb3.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d2.d) && t73.M() != null) {
                t73.M().L0(n, d2.d);
            }
            String n2 = cb3.n(unitedSchemeEntity, "params", "startTime");
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = y03.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            if (q93.b) {
                Log.d("NavigateToAction", "PreloadSlaveManager start.");
            }
            String optString = tk3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                t42.c("navigateTo", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                he3.i(d2);
                return false;
            } else if (ga3.b().a(d2)) {
                ga3.b().i("navigateTo", d2);
                t42.c("NavigateToAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                ib3.g(t73Var, d2, "", new a(this, uuid, t73Var, U, d2, V, unitedSchemeEntity, callbackHandler, optString, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(zt1 zt1Var, tx2 tx2Var, c72 c72Var, String str) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zt1Var, tx2Var, c72Var, str) == null) && (activity = gt2.U().getActivity()) != null && !activity.isFinishing()) {
            cb3.e(zt1Var, tx2Var, str);
            z03.c(0, str);
            if (c72Var.k() < d) {
                b72.V3(nl3.n());
                c72.b i = c72Var.i("navigateTo");
                i.n(c72.g, c72.i);
                i.k("normal", tx2Var).b();
                dk3.c(c72Var, this.c);
                y03.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                z03.a(str, tx2Var);
                return;
            }
            nx1.A(c72Var, tx2Var, str, true);
        }
    }

    public final void p(yd2.e eVar, tx2 tx2Var, c72 c72Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, tx2Var, c72Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = y03.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (q93.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            yd2.q(eVar, new b(this, eVar, str, tx2Var, c72Var));
            if (q93.b) {
                Log.d("NavigateToAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
