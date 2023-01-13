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
import com.baidu.tieba.oa2;
import com.baidu.tieba.y73;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
@Deprecated
/* loaded from: classes3.dex */
public class a83 extends g63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements y73.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wp2 b;
        public final /* synthetic */ ju2 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ j43 f;
        public final /* synthetic */ String g;
        public final /* synthetic */ s32 h;
        public final /* synthetic */ Context i;
        public final /* synthetic */ a83 j;

        public a(a83 a83Var, String str, wp2 wp2Var, ju2 ju2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j43 j43Var, String str2, s32 s32Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a83Var, str, wp2Var, ju2Var, unitedSchemeEntity, callbackHandler, j43Var, str2, s32Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = a83Var;
            this.a = str;
            this.b = wp2Var;
            this.c = ju2Var;
            this.d = unitedSchemeEntity;
            this.e = callbackHandler;
            this.f = j43Var;
            this.g = str2;
            this.h = s32Var;
            this.i = context;
        }

        @Override // com.baidu.tieba.y73.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                px2.d(this.a);
                j12.i("redirect", "check pages success");
                this.b.o();
                oa2.e f = oa2.f(this.b.getActivity(), ta2.c(this.c.a));
                s73.l(this.d, this.e, this.f, f.a.a(), this.c.a, null, this.g);
                this.j.n(f, this.c, this.h, this.a);
            }
        }

        @Override // com.baidu.tieba.y73.e
        public void b(int i, cg3 cg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cg3Var) == null) {
                j12.c("redirect", "check pages failed");
                this.b.o();
                if (g63.b) {
                    Context context = this.i;
                    b43.g(context, this.i.getString(R.string.obfuscated_res_0x7f0f01aa) + i).G();
                }
                s73.j(this.d, this.e, this.g);
                xa3.j(this.c, cg3Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements oa2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oa2.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ju2 c;
        public final /* synthetic */ s32 d;

        public b(a83 a83Var, oa2.e eVar, String str, ju2 ju2Var, s32 s32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a83Var, eVar, str, ju2Var, s32Var};
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
            this.c = ju2Var;
            this.d = s32Var;
        }

        @Override // com.baidu.tieba.oa2.f
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (g63.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady start.");
                }
                px2.e(this.a, this.b);
                s73.e(this.a.a, this.c, this.b);
                du1.A(this.d, this.c, this.b, false);
                if (g63.b) {
                    Log.d("redirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a83(g53 g53Var) {
        super(g53Var, "/swanAPI/redirectTo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g53Var};
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

    @Override // com.baidu.tieba.g63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j43 j43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, j43Var)) == null) {
            if (g63.b) {
                Log.d("redirectTo", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            px2.b(uuid);
            String o = s73.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                j12.c("redirect", "url is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            wp2 U = wp2.U();
            s32 V = U.V();
            if (V == null) {
                j12.c("redirect", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            ju2 d = ju2.d(o, U.z());
            d.e = "2";
            d.f = uuid;
            xa3.g(d);
            if (!di3.b(U.s(), d, false)) {
                j12.c("redirect", "page params error : path=" + d.a + " ; routePath=" + d.d);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                xa3.i(d);
                return false;
            }
            String str = unitedSchemeEntity.getParams().get("initData");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d.d) && j43.M() != null) {
                j43.M().L0(str, d.d);
            }
            String n = s73.n(unitedSchemeEntity, "params", FetchLog.START_TIME);
            if (!TextUtils.isEmpty(n)) {
                HybridUbcFlow q = ox2.q("route", uuid);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("fe_route_start");
                ubcFlowEvent.h(Long.valueOf(n).longValue());
                q.F(ubcFlowEvent);
            }
            if (g63.b) {
                Log.d("redirectTo", "PreloadSlaveManager start.");
            }
            String optString = jh3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j12.c("redirect", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                xa3.i(d);
                return false;
            } else if (w63.b().a(d)) {
                w63.b().i("redirectTo", d);
                j12.c("redirectTo", "access to this page is prohibited");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1003, "access to this page is prohibited"));
                return false;
            } else {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                U.a();
                y73.g(j43Var, d, "", new a(this, uuid, U, d, unitedSchemeEntity, callbackHandler, j43Var, optString, V, context), uuid);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(oa2.e eVar, ju2 ju2Var, s32 s32Var, String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, ju2Var, s32Var, str) == null) {
            if (eVar != null && eVar.b) {
                z = true;
            } else {
                z = false;
            }
            HybridUbcFlow q = ox2.q("route", str);
            q.F(new UbcFlowEvent("na_pre_load_slave_check"));
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            q.D("preload", str2);
            if (g63.b) {
                Log.d("redirectTo", "tryToExecutePageRoute start. isReady : " + z);
            }
            oa2.q(eVar, new b(this, eVar, str, ju2Var, s32Var));
            if (g63.b) {
                Log.d("redirectTo", "tryToExecutePageRoute end.");
            }
        }
    }
}
