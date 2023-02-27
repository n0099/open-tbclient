package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ar3 extends o03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements fo3<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ m93 e;
        public final /* synthetic */ ar3 f;

        public a(ar3 ar3Var, String str, String str2, String str3, CallbackHandler callbackHandler, m93 m93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar3Var, str, str2, str3, callbackHandler, m93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ar3Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = callbackHandler;
            this.e = m93Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                if (bundle != null && !TextUtils.isEmpty(bundle.getString(BdZeusUtil.URL_KEY_MACHINE))) {
                    String string = bundle.getString(BdZeusUtil.URL_KEY_MACHINE);
                    if (ar3.e) {
                        Log.d("FaceResultVerifyAction", "stoken=" + string);
                    }
                    this.f.z(this.a, string, this.b, this.c, this.d, this.e);
                    return;
                }
                this.d.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(1001, "stoken is null").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ Request c;
        public final /* synthetic */ ar3 d;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public b(ar3 ar3Var, String str, CallbackHandler callbackHandler, Request request) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar3Var, str, callbackHandler, request};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ar3Var;
            this.a = str;
            this.b = callbackHandler;
            this.c = request;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                ar3 ar3Var = this.d;
                String str = "";
                if (exc == null) {
                    message = "";
                } else {
                    message = exc.getMessage();
                }
                ar3Var.A(message, this.a, this.b);
                SwanInterfaceType swanInterfaceType = SwanInterfaceType.FACE_CHECK;
                String httpUrl = this.c.url().toString();
                if (exc != null) {
                    str = exc.getMessage();
                }
                rg3.b(swanInterfaceType, 2101, httpUrl, null, str);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) != null) {
                return invokeLI.objValue;
            }
            this.d.D(response, this.a, this.b);
            return response;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947624743, "Lcom/baidu/tieba/ar3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947624743, "Lcom/baidu/tieba/ar3;");
                return;
            }
        }
        e = wp1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar3(ja3 ja3Var) {
        super(ja3Var, "/swanAPI/faceResultVerify");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ja3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ja3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void A(String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, callbackHandler) == null) {
            m62.i("FaceResultVerifyAction", str);
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
        }
    }

    public final void B(String str, String str2, CallbackHandler callbackHandler, int i, String str3, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, callbackHandler, Integer.valueOf(i), str3, response}) == null) {
            A(str, str2, callbackHandler);
            rg3.c(SwanInterfaceType.FACE_CHECK, i, str3, response);
        }
    }

    public final void C(@NonNull Request request, String str, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, request, str, callbackHandler) == null) {
            pg4 pg4Var = new pg4(request.url().toString(), request.body(), new b(this, str, callbackHandler, request));
            pg4Var.i = request.tag();
            pg4Var.f = true;
            pg4Var.g = true;
            pg4Var.h = true;
            qg4.g().e(pg4Var);
            rg3.a(SwanInterfaceType.FACE_CHECK);
        }
    }

    public final void D(Response response, String str, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, response, str, callbackHandler) == null) {
            if (response == null) {
                B(ADConfigError.REASON_NULL_RESPONSE, str, callbackHandler, 2103, null, null);
            } else if (!response.isSuccessful()) {
                B("response code is error", str, callbackHandler, 2104, null, response);
            } else {
                ResponseBody body = response.body();
                if (body == null) {
                    B("body is null", str, callbackHandler, 2103, null, response);
                    return;
                }
                String str2 = null;
                try {
                    str2 = body.string();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                String str3 = str2;
                if (e) {
                    Log.d("FaceResultVerifyAction", "response body : " + str3);
                }
                if (TextUtils.isEmpty(str3)) {
                    B("body is null", str, callbackHandler, 2103, str3, response);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt != 0) {
                        B(jSONObject.optString("errmsg"), str, callbackHandler, optInt, str3, response);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        A("server data is null", str, callbackHandler);
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0).toString());
                    }
                } catch (JSONException e3) {
                    if (e) {
                        e3.printStackTrace();
                    }
                    B("body format error", str, callbackHandler, 2103, str3, response);
                }
            }
        }
    }

    @Override // com.baidu.tieba.jb3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, m93Var)) == null) {
            if (m93Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is empty");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "callback is empty");
                return false;
            }
            String optString2 = optParamsAsJo.optString("callbackKey");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "callbackKey is empty");
                return false;
            } else if (!m93Var.N().e(context)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in");
                return false;
            } else {
                String a2 = bz1.a(m93Var.b);
                JSONObject n = n(a2);
                np3.t(m93Var.w(), new a(this, optString2, a2, optString, callbackHandler, m93Var), BdZeusUtil.URL_KEY_MACHINE);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Nullable
    public final Request y(@Nullable String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, map)) == null) {
            HttpUrl parse = HttpUrl.parse(i62.a);
            if (parse == null) {
                return null;
            }
            HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/facecheck");
            for (Map.Entry<String, String> entry : h62.b().d.entrySet()) {
                addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
            }
            HttpUrl build = addPathSegments.build();
            Request.Builder builder = new Request.Builder();
            builder.tag(str);
            if (map != null) {
                builder.post(ke3.b(map));
            }
            builder.url(i62.v(build.toString()));
            return builder.build();
        }
        return (Request) invokeLL.objValue;
    }

    public final void z(String str, String str2, String str3, String str4, CallbackHandler callbackHandler, m93 m93Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, callbackHandler, m93Var}) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("callbackkey", str);
                jSONObject.put("client_id", m93Var.b);
                jSONObject2.put("stoken", str2);
                jSONObject2.put(GameGuideConfigInfo.KEY_APP_KEY, m93Var.O());
                jSONObject2.put("host_pkgname", ke3.e().getPackageName());
                jSONObject2.put("host_key_hash", ke3.g());
                jSONObject.put("open", jSONObject2);
            } catch (JSONException e2) {
                if (e) {
                    e2.printStackTrace();
                }
            }
            hashMap.put("data", jSONObject.toString());
            Request y = y(str3, hashMap);
            if (y == null) {
                callbackHandler.handleSchemeDispatchCallback(str4, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
            } else {
                C(y, str4, callbackHandler);
            }
        }
    }
}
