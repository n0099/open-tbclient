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
import com.baidu.tieba.b73;
import com.baidu.tieba.r92;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class c73 extends j53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements b73.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ zo2 b;
        public final /* synthetic */ mt2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ m33 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ v22 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ c73 j;

        public a(c73 c73Var, String str, zo2 zo2Var, mt2 mt2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m33 m33Var, String str2, v22 v22Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c73Var, str, zo2Var, mt2Var, unitedSchemeEntity, callbackHandler, m33Var, str2, v22Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = c73Var;
            this.a = str;
            this.b = zo2Var;
            this.c = mt2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = m33Var;
            this.g = str2;
            this.h = v22Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.b73.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                sw2.d(this.a);
                m02.i("relaunch", "check pages success");
                this.b.o();
                r92.e f = r92.f(this.b.getActivity(), w92.c(this.c.a));
                v63.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.p(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.b73.e
        public void b(int i, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ff3Var) == null) {
                m02.c("relaunch", "check pages failed");
                this.b.o();
                if (j53.b) {
                    Context context = this.i;
                    e33.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01a8) + i).G();
                }
                v63.j(this.d, this.e, this.g);
                aa3.j(this.c, ff3Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements r92.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r92.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mt2 c;
        public final /* synthetic */ v22 d;

        public b(c73 c73Var, r92.e eVar, String str, mt2 mt2Var, v22 v22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c73Var, eVar, str, mt2Var, v22Var};
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
                if (j53.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady start.");
                }
                sw2.e(this.a, this.b);
                v63.e(this.a.a, this.c, this.b);
                c73.o(this.d, this.c, this.b);
                if (j53.b) {
                    Log.d("ReLaunchAction", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c73(j43 j43Var) {
        super(j43Var, "/swanAPI/reLaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j43Var};
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

    public static void o(v22 v22Var, mt2 mt2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, v22Var, mt2Var, str) == null) {
            ht1.y(v22Var, mt2Var, str);
        }
    }

    @Override // com.baidu.tieba.j53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, m33Var)) == null) {
            if (j53.b) {
                Log.d("ReLaunchAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            sw2.b(uuid);
            String o = v63.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                m02.c("relaunch", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            zo2 U = zo2.U();
            v22 V = U.V();
            if (V == null) {
                m02.c("relaunch", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            mt2 d = mt2.d(o, U.z());
            d.e = "3";
            d.f = uuid;
            aa3.g(d);
            if (!gh3.b(U.s(), d, true)) {
                m02.c("relaunch", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                aa3.i(d);
                return false;
            }
            String n = v63.n(unitedSchemeEntity, "params", "initData");
            if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(d.d) && m33.M() != null) {
                m33.M().L0(n, d.d);
            }
            String n2 = v63.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n2)) {
                HybridUbcFlow q = rw2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n2).longValue());
                q.F(ubcFlowEvent);
            }
            String optString = mg3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                m02.c("relaunch", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                aa3.i(d);
                return false;
            } else if (z53.b().a(d)) {
                z53.b().i("reLaunch", d);
                m02.c("ReLaunchAction", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                b73.g(m33Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, m33Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(r92.e eVar, mt2 mt2Var, v22 v22Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, mt2Var, v22Var, str) == null) {
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
            if (j53.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute start. isReady : " + z);
            }
            r92.q(eVar, new b(this, eVar, str, mt2Var, v22Var));
            if (j53.b) {
                Log.d("ReLaunchAction", "tryToExecutePageRoute end.");
            }
        }
    }
}
