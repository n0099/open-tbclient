package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes3.dex */
public abstract class dk2 extends j53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean j(UnitedSchemeEntity unitedSchemeEntity, pk2 pk2Var, List list);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dk2(j43 j43Var, String str) {
        super(j43Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j43Var, str};
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

    @Override // com.baidu.tieba.j53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, m33Var)) == null) {
            if (m33Var == null) {
                m02.c("componentFullScreen", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (j53.b) {
                    Log.e("SwanAppAction", "getAutoRotationSync --- illegal swanApp");
                }
                return false;
            } else if (context == null) {
                m02.c("componentFullScreen", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                if (j53.b) {
                    Log.e("SwanAppAction", "getAutoRotationSync --- illegal context");
                }
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    m02.c("componentFullScreen", "none params");
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
                        m02.c("componentFullScreen", "empty component id list");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                        return false;
                    }
                    up1 A = zo2.U().A(optString);
                    if (!(A instanceof SwanAppWebViewManager)) {
                        m02.c("componentFullScreen", "cant get WebView");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                        return false;
                    }
                    pk2 F0 = ((SwanAppWebViewManager) A).F0();
                    if (F0 == null) {
                        m02.c("componentFullScreen", "cant get CustomViewHelper");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                        return false;
                    } else if (!j(unitedSchemeEntity, F0, arrayList)) {
                        m02.c("componentFullScreen", "custom view handle fail");
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                        return false;
                    } else {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                        return true;
                    }
                }
                m02.c("componentFullScreen", "param error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
