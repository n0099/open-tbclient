package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class gm2 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean j(@NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull sm2 sm2Var, @NonNull List<String> list);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gm2(m63 m63Var, String str) {
        super(m63Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var, str};
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

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            if (p53Var == null) {
                p22.c("componentFullScreen", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (m73.b) {
                    Log.e("SwanAppAction", "getAutoRotationSync --- illegal swanApp");
                }
                return false;
            } else if (context == null) {
                p22.c("componentFullScreen", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                if (m73.b) {
                    Log.e("SwanAppAction", "getAutoRotationSync --- illegal context");
                }
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    p22.c("componentFullScreen", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("slaveId");
                JSONArray optJSONArray = optParamsAsJo.optJSONArray("componentId");
                if (!TextUtils.isEmpty(optString) && optJSONArray != null && optJSONArray.length() != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString2 = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString2)) {
                            arrayList.add(optString2);
                        }
                    }
                    if (arrayList.size() == 0) {
                        p22.c("componentFullScreen", "empty component id list");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                        return false;
                    }
                    yr1 B = cr2.V().B(optString);
                    if (!(B instanceof SwanAppWebViewManager)) {
                        p22.c("componentFullScreen", "cant get WebView");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                        return false;
                    }
                    sm2 C0 = ((SwanAppWebViewManager) B).C0();
                    if (C0 == null) {
                        p22.c("componentFullScreen", "cant get CustomViewHelper");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                        return false;
                    } else if (!j(unitedSchemeEntity, C0, arrayList)) {
                        p22.c("componentFullScreen", "custom view handle fail");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                        return false;
                    } else {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                        return true;
                    }
                }
                p22.c("componentFullScreen", "param error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
