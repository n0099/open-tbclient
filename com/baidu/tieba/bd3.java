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
public class bd3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/preventPullDownRefresh");
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
                Log.d("PreventPullDownRefresh", "handle entity: " + unitedSchemeEntity.toString());
            }
            JSONObject a = ed3.a(unitedSchemeEntity, "params");
            if (a == null) {
                h82.c("preventPullDownRefresh", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                return false;
            }
            String optString = a.optString("slaveId");
            if (TextUtils.isEmpty(optString)) {
                h82.c("preventPullDownRefresh", "slaveId null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "slaveId null");
                return false;
            }
            uw2 T2 = uw2.T();
            px1 A = T2.A(optString);
            if (!(A instanceof nx1)) {
                h82.c("preventPullDownRefresh", "webViewManager not a SwanAppSlaveManager");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "webViewManager not a SwanAppSlaveManager");
                return false;
            }
            qa2 U = T2.U();
            if (U == null) {
                h82.c("PreventPullDownRefresh", "manager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            pa2 o = U.o();
            if (o == null) {
                h82.c("PreventPullDownRefresh", "slave container is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (TextUtils.equals("7", o.O1().l())) {
                h82.c("PreventPullDownRefresh", "this page is from showModalPage api");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(402);
                return false;
            } else {
                boolean optBoolean = a.optBoolean("prevent", false);
                PullToRefreshBaseWebView f0 = ((nx1) A).f0();
                if (f0 != null) {
                    f0.setIsPreventPullToRefresh(optBoolean);
                    return true;
                }
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
