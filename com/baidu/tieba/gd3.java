package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class gd3 extends db3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pv1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd3(da3 da3Var) {
        super(da3Var, "/swanAPI/webviewPostMessage");
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
                Log.d("WebViewPostMsgAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            g62.i("webviewPostMsg", "start post webview msg");
            pv1 pv1Var = this.c;
            if (pv1Var == null) {
                g62.c("webviewPostMsg", "none webview widget");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none webview widget");
                return false;
            }
            ed3 params = pv1Var.getParams();
            if (params == null) {
                g62.c("webviewPostMsg", "none WWWParams");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none WWWParams");
                return false;
            }
            JSONObject a = db3.a(unitedSchemeEntity, "params");
            if (a == null) {
                g62.c("webviewPostMsg", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                return false;
            } else if (!a.has("data")) {
                g62.c("webviewPostMsg", "none param data");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none param data");
                return false;
            } else {
                String optString = a.optString("data");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("data", optString);
                    jSONObject.put("eventType", "message");
                    jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, params.c);
                    jSONObject.put("webviewId", params.b);
                } catch (JSONException e) {
                    if (db3.b) {
                        e.printStackTrace();
                    }
                    g62.c("webviewPostMsg", "meet json exception");
                }
                no3.c(params.c, params.b, AlbumActivityConfig.FROM_WEB_VIEW, "message", jSONObject);
                g62.i("webviewPostMsg", "post webview msg success");
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public void j(pv1 pv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pv1Var) == null) {
            this.c = pv1Var;
        }
    }
}
