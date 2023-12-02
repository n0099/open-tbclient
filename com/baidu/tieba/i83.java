package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i83 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i83(h73 h73Var) {
        super(h73Var, "/swanAPI/checkAppInstalled");
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
            JSONObject a = h83.a(unitedSchemeEntity, "params");
            if (a == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
                k32.i("SwanCheckAppInstalledAction", "params parse error");
                return false;
            }
            String optString = a.optString("name");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parameter error");
                k32.i("SwanCheckAppInstalledAction", "packageName empty");
                return false;
            }
            PackageInfo packageInfo = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(optString, 0);
            } catch (PackageManager.NameNotFoundException e) {
                k32.d("SwanCheckAppInstalledAction", e.getMessage(), e);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (packageInfo != null) {
                    jSONObject.put("hasApp", true);
                    jSONObject.put(PushService.APP_VERSION_NAME, packageInfo.versionName);
                    jSONObject.put(PushService.APP_VERSION_CODE, packageInfo.versionCode);
                } else {
                    jSONObject.put("hasApp", false);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0, "success"));
            } catch (JSONException e2) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage());
                k32.d("SwanCheckAppInstalledAction", e2.getMessage(), e2);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
