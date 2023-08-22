package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dd3 extends f23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int e;

    /* loaded from: classes5.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ dd3 f;

        public a(dd3 dd3Var, CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd3Var, callbackHandler, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = dd3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                ji3.b("uploadFile", 3011, exc.getMessage(), 1001, exc.getMessage());
                qw2.T().Q();
                this.a.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
                this.f.q(this.e);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
                qw2.T().Q();
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                this.f.z(response, this.a, this.b, this.c, this.d, this.e);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements x23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ dd3 e;

        public b(dd3 dd3Var, long j, String str, String str2, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dd3Var, Long.valueOf(j), str, str2, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dd3Var;
            this.a = j;
            this.b = str;
            this.c = str2;
            this.d = callbackHandler;
        }

        @Override // com.baidu.tieba.x23
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeJ(1048576, this, j) != null) {
                return;
            }
            this.e.x(this.a, j, this.b, this.c, this.d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dd3(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/uploadFile");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ac3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
    }

    public static void A(MultipartBody.Builder builder, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, builder, jSONObject) == null) && builder != null && jSONObject != null && jSONObject.length() >= 1) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    String optString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(optString)) {
                        builder.addFormDataPart(next, optString);
                    }
                }
            }
        }
    }

    public final void B(MultipartBody.Builder builder, String str, String str2, h23 h23Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, builder, str, str2, h23Var) == null) && builder != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && h23Var != null) {
            builder.addFormDataPart(str, str2, h23Var);
        }
    }

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            if (db3Var == null) {
                ji3.b("uploadFile", 2001, "swanApp is null", 1001, "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a2 = ad3.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                ji3.b("uploadFile", 1001, "illegal params", 202, "illegal params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            }
            String optString = a2.optString("onProgressUpdate");
            String optString2 = a2.optString("headersReceivedEvent");
            String optString3 = a2.optString("cb");
            if (TextUtils.isEmpty(optString3)) {
                ji3.b("uploadFile", 1001, "illegal resultCallback", 202, "illegal resultCallback");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
                return false;
            }
            String g0 = db3.g0();
            if (TextUtils.isEmpty(g0)) {
                ji3.b("uploadFile", 1001, "illegal appId", 202, "illegal appId");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
                return false;
            }
            String a3 = s02.a(g0);
            String valueOf = String.valueOf(System.currentTimeMillis());
            Request w = w(a2, optString, a3, valueOf, db3Var, callbackHandler);
            if (w == null) {
                ji3.b("uploadFile", 1001, "params is invalid, build request fail", -1, "");
                unitedSchemeEntity.result = t(this.e);
                q(valueOf);
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject("header");
            u23 u23Var = new u23();
            HashMap<String, String> m = f23.m(optJSONObject, true);
            String optString4 = a2.optString("__plugin__");
            if (!TextUtils.isEmpty(optString4)) {
                ek4 h = b73.h(optString4);
                if (m == null) {
                    m = new HashMap<>();
                }
                m.put("X-SWAN-HOSTSIGN", a73.b(h));
            }
            HashMap<String, String> hashMap = m;
            hashMap.putAll(v23.a("uploadFile", a2.optString("__plugin__")));
            u23Var.a(hashMap);
            qw2.T().Z();
            gi4 gi4Var = new gi4(w.url().toString(), w.body(), new a(this, callbackHandler, optString, optString3, optString2, valueOf));
            gi4Var.c = hashMap;
            gi4Var.i = w.tag();
            gi4Var.f = true;
            gi4Var.g = false;
            gi4Var.h = true;
            gi4Var.k = 2;
            hi4.g().e(gi4Var);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a3), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e7, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L48;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Request w(@Nullable JSONObject jSONObject, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable db3 db3Var, @Nullable CallbackHandler callbackHandler) {
        InterceptResult invokeCommon;
        HttpUrl f;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{jSONObject, str, str2, str3, db3Var, callbackHandler})) == null) {
            if (jSONObject == null || (f = s02.f(jSONObject.optString("url"))) == null) {
                return null;
            }
            String httpUrl = f.toString();
            if (TextUtils.isEmpty(httpUrl)) {
                return null;
            }
            int c = ub3.c("uploadFile", httpUrl, jSONObject.optString("__plugin__"));
            this.e = c;
            if (c != 0) {
                return null;
            }
            String optString = jSONObject.optString("filePath", "");
            if (TextUtils.isEmpty(optString) || hr4.x(optString)) {
                return null;
            }
            String a2 = qw2.T().G().a(optString);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            File file = new File(a2);
            if (!file.exists() || !file.isFile()) {
                return null;
            }
            long length = file.length();
            if (length > 524288000) {
                if (ad3.b) {
                    Log.i("UploadFileAction", "file over size: " + (length / 1048576) + " MB.");
                }
                this.e = 5;
                return null;
            }
            String optString2 = jSONObject.optString("name", "");
            if (TextUtils.isEmpty(optString2)) {
                return null;
            }
            if (jSONObject.has("formData") && !(jSONObject.opt("formData") instanceof JSONObject)) {
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("formData");
            this.c.put(str3, 0L);
            String name = file.getName();
            if (!TextUtils.isEmpty(name)) {
                str4 = zn3.d(zn3.b(name));
            }
            str4 = IMAudioTransRequest.CONTENT_TYPE;
            h23 h23Var = new h23(file, str4, new b(this, length, str, str3, callbackHandler));
            MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            A(type, optJSONObject);
            B(type, optString2, file.getName(), h23Var);
            return new Request.Builder().url(httpUrl).tag(str2).post(type.build()).build();
        }
        return (Request) invokeCommon.objValue;
    }

    public final void x(long j, long j2, String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2, callbackHandler}) == null) && j > 0 && j2 <= j && j2 != 0 && !TextUtils.isEmpty(str) && callbackHandler != null) {
            int floor = (int) Math.floor((100 * j2) / j);
            if (System.currentTimeMillis() - p(str2) > 500 || floor == 100) {
                if (floor <= 100) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("progress", floor);
                        jSONObject.put("totalBytesSent", j2);
                        jSONObject.put("totalBytesExpectedToSend", j);
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } catch (Exception e) {
                        if (ad3.b) {
                            e.printStackTrace();
                        }
                    }
                }
                this.c.put(str2, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public final void y(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody) throws IOException, JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, jSONObject, responseBody) != null) || responseBody == null) {
            return;
        }
        String string = responseBody.string();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            jSONObject.put("data", new JSONObject(string));
        } catch (JSONException unused) {
            jSONObject.put("data", string);
        }
    }

    public final void z(Response response, CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{response, callbackHandler, str, str2, str3, str4}) == null) {
            try {
                try {
                    r(str3, f23.s(response.headers()));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", response.code());
                    y(jSONObject, response.body());
                    if (jSONObject.toString().length() > 26214400) {
                        ji3.b("uploadFile", 3002, "response json length over limits", 1001, "response json length over limits");
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    }
                } catch (Exception e) {
                    if (ad3.b) {
                        e.printStackTrace();
                    }
                    ji3.b("uploadFile", 2009, "json exception", 1001, e.getMessage());
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                }
            } finally {
                q(str4);
            }
        }
    }
}
