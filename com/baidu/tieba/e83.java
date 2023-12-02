package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e83 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e83(h73 h73Var) {
        super(h73Var, "/swanAPI/preventPullDownRefresh");
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
                Log.d("PreventPullDownRefresh", "handle entity: " + unitedSchemeEntity.toString());
            }
            JSONObject a = h83.a(unitedSchemeEntity, "params");
            if (a == null) {
                k32.c("preventPullDownRefresh", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                return false;
            }
            String optString = a.optString("slaveId");
            if (TextUtils.isEmpty(optString)) {
                k32.c("preventPullDownRefresh", "slaveId null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "slaveId null");
                return false;
            }
            xr2 V = xr2.V();
            ts1 B = V.B(optString);
            if (!(B instanceof rs1)) {
                k32.c("preventPullDownRefresh", "webViewManager not a SwanAppSlaveManager");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "webViewManager not a SwanAppSlaveManager");
                return false;
            }
            t52 W = V.W();
            if (W == null) {
                k32.c("PreventPullDownRefresh", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            s52 o = W.o();
            if (o == null) {
                k32.c("PreventPullDownRefresh", "slave container is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (TextUtils.equals("7", o.S1().l())) {
                k32.c("PreventPullDownRefresh", "this page is from showModalPage api");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(402);
                return false;
            } else {
                boolean optBoolean = a.optBoolean("prevent", false);
                PullToRefreshBaseWebView e0 = ((rs1) B).e0();
                if (e0 != null) {
                    e0.setIsPreventPullToRefresh(optBoolean);
                    return true;
                }
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
