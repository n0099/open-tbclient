package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class go1 extends co1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ho1 c;
        public final /* synthetic */ go1 d;

        public a(go1 go1Var, CallbackHandler callbackHandler, String str, ho1 ho1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go1Var, callbackHandler, str, ho1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = go1Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = ho1Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.d.r(response, this.a, this.b, this.c);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ go1 d;

        public b(go1 go1Var, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {go1Var, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = go1Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (co1.c) {
                    Log.i("CloudUploadAction", "onFailure: ");
                }
                go1 go1Var = this.d;
                CallbackHandler callbackHandler = this.a;
                String str = this.b;
                go1Var.s(callbackHandler, str, null, "uploadFile:fail" + exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(ao1.n(this.c, null, "uploadFile:ok"), 0).toString());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) ? response : invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public go1(x13 x13Var) {
        super(x13Var, "/swanAPI/cloudUploadFile");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((x13) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.co1, com.baidu.tieba.x23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, a13Var)) == null) {
            if (a13Var == null) {
                return l(unitedSchemeEntity, 1001, "swanApp is null");
            }
            JSONObject a2 = x23.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                return l(unitedSchemeEntity, 202, "illegal params");
            }
            String param = unitedSchemeEntity.getParam(WebChromeClient.KEY_ARG_CALLBACK);
            if (TextUtils.isEmpty(param)) {
                return l(unitedSchemeEntity, 202, "illegal callback");
            }
            String optString = a2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return l(unitedSchemeEntity, 202, "illegal cb");
            }
            if (co1.c) {
                Log.d("CloudUploadAction", "schema params : " + a2.toString());
                Log.d("CloudUploadAction", "schema cb : " + optString);
            }
            ho1 p = p(a2);
            if (p == null) {
                l(unitedSchemeEntity, 202, "illegal params");
                return false;
            }
            Request c = ao1.c(a13Var, a2, unitedSchemeEntity);
            if (c != null) {
                callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                ao1.p(c.url().toString(), c.body(), new a(this, callbackHandler, optString, p));
                return true;
            }
            callbackHandler.handleSchemeDispatchCallback(param, unitedSchemeEntity.result.toString());
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.co1
    public void j(Response response, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, callbackHandler, str) == null) {
        }
    }

    public ho1 p(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("fileMap");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("stringMap");
            if (optJSONObject == null || optJSONObject2 == null) {
                return null;
            }
            String optString = optJSONObject2.optString("cloudPath");
            if (TextUtils.isEmpty(optString) || optString.startsWith("/") || optString.contains("@")) {
                return null;
            }
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String M = i83.M(optJSONObject.optString(keys.next()), a13.g0());
                if (M != null && !TextUtils.isEmpty(M)) {
                    File file = new File(M);
                    if (file.exists()) {
                        ho1 ho1Var = new ho1(file);
                        u(jSONObject, ho1Var.contentLength());
                        return ho1Var;
                    }
                }
            }
            return null;
        }
        return (ho1) invokeL.objValue;
    }

    public final int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (co1.c) {
                    e.printStackTrace();
                }
                return 1001;
            }
        }
        return invokeL.intValue;
    }

    public final void r(Response response, CallbackHandler callbackHandler, String str, RequestBody requestBody) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, response, callbackHandler, str, requestBody) == null) {
            if (!response.isSuccessful()) {
                s(callbackHandler, str, null, null);
                return;
            }
            String header = response.header("Content-Type", "");
            if (header != null && header.contains("application/json")) {
                JSONObject m = ao1.m(response);
                if (m != null && response.isSuccessful()) {
                    String optString = m.optString("errno", String.valueOf(0));
                    String optString2 = m.optString("errmsg");
                    if (ao1.o(optString)) {
                        s(callbackHandler, str, optString, optString2);
                        return;
                    }
                    String optString3 = m.optString("UploadUrl");
                    String optString4 = m.optString("fileID");
                    if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                        JSONObject optJSONObject = m.optJSONObject("ExtraHeaders");
                        if (optJSONObject == null) {
                            s(callbackHandler, str, optString, optString2);
                            return;
                        }
                        Map<String, String> t = t(optJSONObject);
                        try {
                            Request build = new Request.Builder().headers(Headers.of(t)).url(optString3).put(requestBody).build();
                            if (a13.M() == null) {
                                k(callbackHandler, str, 1001, "uploadFile:fail");
                                return;
                            }
                            b84 b84Var = new b84(build.url().toString(), build.body(), new b(this, callbackHandler, str, optString4));
                            b84Var.c = t;
                            b84Var.f = true;
                            b84Var.g = false;
                            b84Var.h = true;
                            c84.g().f(b84Var);
                            return;
                        } catch (Exception e) {
                            if (co1.c) {
                                e.printStackTrace();
                            }
                            s(callbackHandler, str, optString, optString2);
                            return;
                        }
                    }
                    s(callbackHandler, str, optString, optString2);
                    return;
                }
                k(callbackHandler, str, 1001, "uploadFile:fail");
                return;
            }
            k(callbackHandler, str, 1001, "uploadFile:fail");
        }
    }

    public final void s(CallbackHandler callbackHandler, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, callbackHandler, str, str2, str3) == null) {
            if (TextUtils.isEmpty(str2)) {
                k(callbackHandler, str, 1001, "uploadFile:fail");
            } else {
                k(callbackHandler, str, q(str2), ao1.k(str3));
            }
        }
    }

    @NonNull
    public final Map<String, String> t(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            ArrayMap arrayMap = new ArrayMap();
            if (jSONObject == null) {
                return arrayMap;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                arrayMap.put(next, jSONObject.optString(next));
            }
            return arrayMap;
        }
        return (Map) invokeL.objValue;
    }

    public final void u(JSONObject jSONObject, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048583, this, jSONObject, j) == null) || jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("stringMap");
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("Content-Length", String.valueOf(j));
            jSONObject2.put("Headers", jSONObject3);
            if (optJSONObject != null) {
                optJSONObject.put("data", jSONObject2);
                jSONObject.put("stringMap", optJSONObject);
            }
        } catch (JSONException e) {
            if (co1.c) {
                e.printStackTrace();
            }
        }
    }
}
