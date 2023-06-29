package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hz1 extends ez1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hz1(zc3 zc3Var) {
        super(zc3Var, "/swanAPI/cloudRequest");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zc3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((zc3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ez1, com.baidu.tieba.zd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, cc3Var)) == null) {
            return super.d(context, unitedSchemeEntity, callbackHandler, cc3Var);
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ez1
    public void j(Response response, CallbackHandler callbackHandler, String str) {
        String header;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, callbackHandler, str) == null) && (header = response.header("Content-Type", "")) != null && header.contains("application/json")) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("statusCode", response.code());
                jSONObject.put("header", e33.s(response.headers()));
                jSONObject.put("body", response.body().string());
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("body"));
                String optString = jSONObject2.optString("errno", String.valueOf(0));
                String optString2 = jSONObject2.optString("errmsg");
                if (response.isSuccessful() && !cz1.o(optString)) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                    return;
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(cz1.j(optString), cz1.k(optString2)).toString());
            } catch (Exception e) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
            }
        }
    }
}
