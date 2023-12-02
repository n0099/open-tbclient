package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.cyberplayer.sdk.task.UpgradeInfo;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bb3 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb3(h73 h73Var) {
        super(h73Var, "/swanAPI/login");
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
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            if (k63Var != null && k63Var.o0()) {
                if (h83.b) {
                    Log.d("LoginAction", "LoginAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                return false;
            } else if (k63Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                sp2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception").toString());
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                    sp2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "params is null").toString());
                    tu1.K(k63Var, 1, 201, "params is null");
                    return false;
                }
                String optString = optParamsAsJo.optString("invokeFrom");
                if (optString.equals("component")) {
                    str = "loginButton";
                } else {
                    str = "loginApi";
                }
                String str2 = str;
                dd3.T(str2, "create");
                String optString2 = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    sp2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    tu1.K(k63Var, 1, 201, "empty cb");
                    return false;
                } else if (!optParamsAsJo.optBoolean(UpgradeInfo.KEY_INT_FORCE_UPGRADE, true) && !k63Var.N().e(context)) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                    sp2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                    tu1.K(k63Var, 43, 10004, "user not logged in");
                    return true;
                } else {
                    if (!k63Var.N().e(context)) {
                        dd3.S("show", 1, optString);
                    }
                    if (!j63.K().q().N().e(context)) {
                        dd3.T(str2, "passLogin");
                    }
                    tu1.E(k63Var, (Activity) context, optParamsAsJo, callbackHandler, optString2, true, str2);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }
}
