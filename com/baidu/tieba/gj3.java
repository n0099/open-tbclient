package com.baidu.tieba;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gj3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gj3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/getStorageInfoSync");
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
            if (hb3Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            }
            qi3 f0 = hb3Var.f0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SavedStateHandle.KEYS, new JSONArray((Collection) f0.g().a()));
                jSONObject.put(CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE, f0.e() / 1024);
                jSONObject.put("limitSize", f0.n() / 1024);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                return true;
            } catch (JSONException e) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "JSONException");
                if (ed3.b) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
