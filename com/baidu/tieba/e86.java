package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e86 extends vc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ ya3 c;
        public final /* synthetic */ e86 d;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public a(e86 e86Var, String str, CallbackHandler callbackHandler, ya3 ya3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e86Var, str, callbackHandler, ya3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = e86Var;
            this.a = str;
            this.b = callbackHandler;
            this.c = ya3Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.b.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.d.n(response, this.a, this.b, this.c);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e86(vb3 vb3Var) {
        super(vb3Var, "/swanAPI/navigateToProgram");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vb3Var};
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

    @Override // com.baidu.tieba.vc3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, ya3Var)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (ya3Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                String g0 = ya3.g0();
                if (!TextUtils.isEmpty(g0) && !TextUtils.isEmpty(g0.trim())) {
                    String optString = optParamsAsJo.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    }
                    String optString2 = optParamsAsJo.optString("path");
                    if (!StringUtils.isNull(optString2) && optString2.contains("/pages/frshistory/frshistory?")) {
                        l86.j(context, unitedSchemeEntity.getParam("params"));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                        return true;
                    }
                    Request l = l(g0, optParamsAsJo);
                    if (l == null) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    }
                    m(l.body(), unitedSchemeEntity, optString, callbackHandler, ya3Var);
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final Uri k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            String schemeHead = SchemeConfig.getSchemeHead();
            if (TextUtils.isEmpty(schemeHead)) {
                schemeHead = BaiduIdentityManager.VALUE_OSNAME;
            }
            buildUpon.scheme(schemeHead);
            if (vc3.b) {
                Log.i("NavigateToSmartProgram", buildUpon.build().toString());
            }
            return buildUpon.build();
        }
        return (Uri) invokeL.objValue;
    }

    public final Request l(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject)) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                String b = y03.b(so3.n());
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(GameGuideConfigInfo.KEY_APP_KEY, str);
                    jSONObject2.put("srcAppPage", b);
                    jSONObject2.put("params", jSONObject);
                    Request build = new Request.Builder().url(fu2.o().I()).post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject2.toString())).build();
                    if (vc3.b) {
                        Log.i("NavigateToSmartProgram", "appId :" + str + "\nrequest params" + jSONObject2.toString());
                    }
                    return build;
                } catch (Exception e) {
                    if (vc3.b) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (Request) invokeLL.objValue;
    }

    public final void m(RequestBody requestBody, UnitedSchemeEntity unitedSchemeEntity, String str, CallbackHandler callbackHandler, ya3 ya3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, requestBody, unitedSchemeEntity, str, callbackHandler, ya3Var) == null) {
            bi4 bi4Var = new bi4(fu2.o().I(), requestBody, new a(this, str, callbackHandler, ya3Var));
            bi4Var.f = true;
            bi4Var.g = false;
            bi4Var.h = true;
            ci4.g().e(bi4Var);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void n(Response response, String str, CallbackHandler callbackHandler, ya3 ya3Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, response, str, callbackHandler, ya3Var) == null) {
            try {
                JSONObject jSONObject = new JSONObject(response.body().string());
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    return;
                }
                Uri k = k(optJSONObject.optString("scheme"));
                if (k == null) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    return;
                }
                if (SchemeRouter.invokeScheme(ya3Var.getApplicationContext(), k, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    i = 0;
                } else {
                    i = 1001;
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i).toString());
            } catch (Exception e) {
                if (vc3.b) {
                    Log.d("NavigateToSmartProgram", e.getMessage());
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
            }
        }
    }
}
