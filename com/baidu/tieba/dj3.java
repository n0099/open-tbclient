package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dj3 extends db3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj3(da3 da3Var) {
        super(da3Var, "/swanAPI/brightness");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {da3Var};
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

    @Override // com.baidu.tieba.db3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, g93Var)) == null) {
            if (db3.b) {
                Log.d("Brightness", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011d  */
    @Override // com.baidu.tieba.db3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, g93 g93Var) {
        InterceptResult invokeLLLLL;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, g93Var)) == null) {
            if (db3.b) {
                Log.d("Brightness", "handleSubAction: " + unitedSchemeEntity.toString());
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (db3.b) {
                Log.i("Brightness", "handleSubAction params: " + unitedSchemeEntity.getParam("params"));
            }
            JSONObject jSONObject = null;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity == null) {
                g62.c("brightness", "activity is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            int i = 1001;
            char c = 65535;
            int hashCode = str.hashCode();
            boolean z = true;
            if (hashCode != -1634890823) {
                if (hashCode != 1913219981) {
                    if (hashCode == 1913231513 && str.equals("/swanAPI/brightness/set")) {
                        c = 0;
                    }
                } else if (str.equals("/swanAPI/brightness/get")) {
                    c = 1;
                }
            } else if (str.equals("/swanAPI/brightness/keepScreenOn")) {
                c = 2;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        if (optParamsAsJo == null) {
                            g62.c("brightness", "paramsJson is null");
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                            return false;
                        }
                        try {
                            ej3.c().f(activity, optParamsAsJo.getBoolean("keepScreenOn"));
                        } catch (JSONException unused) {
                        }
                    }
                    z = false;
                } else {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("value", ej3.c().a(activity));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (z) {
                    if (jSONObject != null) {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    } else {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    }
                } else {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(i);
                }
                return z;
            } else if (optParamsAsJo == null) {
                g62.c("brightness", "paramsJson is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else {
                String optString = optParamsAsJo.optString("value");
                float f = -1.0f;
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        f = Float.parseFloat(optString);
                    } catch (Exception unused2) {
                    }
                }
                if (f >= 0.0f && f <= 1.0f) {
                    ej3.c().e(activity, f);
                    if (z) {
                    }
                    return z;
                }
                i = 202;
                z = false;
                if (z) {
                }
                return z;
            }
        }
        return invokeLLLLL.booleanValue;
    }
}
