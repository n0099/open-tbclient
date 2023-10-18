package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.tieba.ua3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class en3 extends rw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ p53 d;
        public final /* synthetic */ en3 e;

        /* renamed from: com.baidu.tieba.en3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0269a implements ik3<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0269a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ik3
            /* renamed from: b */
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    a aVar = this.a;
                    aVar.e.E(str, aVar.a, aVar.b, aVar.d);
                }
            }
        }

        public a(en3 en3Var, CallbackHandler callbackHandler, String str, String str2, p53 p53Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {en3Var, callbackHandler, str, str2, p53Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = en3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
            this.d = p53Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                if (!na3.h(sa3Var)) {
                    na3.q(sa3Var, this.a, this.b);
                } else {
                    en3.z(this.c, new C0269a(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ik3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public b(en3 en3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {en3Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.handleSchemeDispatchCallback(this.b, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik3 a;
        public final /* synthetic */ Request b;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public c(ik3 ik3Var, Request request) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik3Var, request};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik3Var;
            this.b = request;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                String str = "";
                if (exc == null) {
                    message = "";
                } else {
                    message = exc.getMessage();
                }
                this.a.a(en3.A(message));
                SwanInterfaceType swanInterfaceType = SwanInterfaceType.REAL_NAME_CHECK;
                String httpUrl = this.b.url().toString();
                if (exc != null) {
                    str = exc.getMessage();
                }
                uc3.b(swanInterfaceType, 2101, httpUrl, null, str);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) != null) {
                return invokeLI.objValue;
            }
            en3.F(response, this.a);
            return response;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements ik3<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik3 a;

        public d(ik3 ik3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(Bundle bundle) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
                if (bundle == null) {
                    this.a.a(UnitedSchemeUtility.wrapCallbackParams(1001, "result is null").toString());
                    return;
                }
                String g = oi3.g(bundle, "callbackKey");
                if (TextUtils.isEmpty(g)) {
                    this.a.a(UnitedSchemeUtility.wrapCallbackParams(1001, oi3.g(bundle, "failMsg")).toString());
                    return;
                }
                p22.i("FaceVerifyAction", g);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("callbackKey", g);
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                } catch (JSONException e) {
                    if (en3.e) {
                        e.printStackTrace();
                    }
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
                }
                this.a.a(wrapCallbackParams.toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947740063, "Lcom/baidu/tieba/en3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947740063, "Lcom/baidu/tieba/en3;");
                return;
            }
        }
        e = am1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public en3(m63 m63Var) {
        super(m63Var, "/swanAPI/faceVerify");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((m63) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static String A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            p22.i("FaceVerifyAction", str);
            return UnitedSchemeUtility.wrapCallbackParams(1001, str).toString();
        }
        return (String) invokeL.objValue;
    }

    public static String B(String str, int i, String str2, Response response) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65539, null, str, i, str2, response)) == null) {
            uc3.c(SwanInterfaceType.REAL_NAME_CHECK, i, str2, response);
            return A(str);
        }
        return (String) invokeLILL.objValue;
    }

    public static void C(@NonNull Request request, ik3<String> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, request, ik3Var) == null) {
            sc4 sc4Var = new sc4(request.url().toString(), request.body(), new c(ik3Var, request));
            sc4Var.i = request.tag();
            sc4Var.f = true;
            sc4Var.g = true;
            sc4Var.h = true;
            tc4.g().e(sc4Var);
            uc3.a(SwanInterfaceType.REAL_NAME_CHECK);
        }
    }

    public static void D(String str, p53 p53Var, ik3<String> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, p53Var, ik3Var) == null) {
            ql3.J(p53Var.w(), str, p53Var.b, new d(ik3Var));
        }
    }

    public static void F(Response response, ik3<String> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, response, ik3Var) == null) {
            String str = null;
            if (response == null) {
                ik3Var.a(B(ADConfigError.REASON_NULL_RESPONSE, 2103, null, null));
            } else if (!response.isSuccessful()) {
                ik3Var.a(B("response code is error", RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, null, response));
            } else {
                ResponseBody body = response.body();
                if (body == null) {
                    ik3Var.a(B("body is null", 2103, null, response));
                    return;
                }
                try {
                    str = body.string();
                } catch (IOException e2) {
                    if (e) {
                        e2.printStackTrace();
                    }
                }
                if (e) {
                    Log.d("FaceVerifyAction", "response body : " + str);
                }
                if (TextUtils.isEmpty(str)) {
                    ik3Var.a(B("body is null", 2103, str, response));
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno");
                    if (optInt != 0) {
                        ik3Var.a(B(jSONObject.optString("errmsg"), optInt, str, response));
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        ik3Var.a(A("server data is null"));
                    } else {
                        ik3Var.a(String.valueOf(optJSONObject.optInt("real_name")));
                    }
                } catch (JSONException e3) {
                    if (e) {
                        e3.printStackTrace();
                    }
                    ik3Var.a(B("body format error", 2103, str, response));
                }
            }
        }
    }

    public static void z(String str, ik3<String> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, ik3Var) == null) {
            Request y = y(str);
            if (y == null) {
                ik3Var.a(null);
            } else {
                C(y, ik3Var);
            }
        }
    }

    @Nullable
    public static Request y(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            HttpUrl parse = HttpUrl.parse(l22.a);
            if (parse == null) {
                return null;
            }
            HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments("ma/authentication/realnamecheck");
            for (Map.Entry<String, String> entry : k22.b().d.entrySet()) {
                addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
            }
            HttpUrl build = addPathSegments.build();
            Request.Builder builder = new Request.Builder();
            builder.tag(str);
            builder.post(new FormBody.Builder().build());
            builder.url(l22.v(build.toString()));
            return builder.build();
        }
        return (Request) invokeL.objValue;
    }

    public final void E(String str, CallbackHandler callbackHandler, String str2, p53 p53Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, callbackHandler, str2, p53Var) == null) {
            if (str == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "illegal request").toString());
            } else if (!TextUtils.equals(str, "1") && !TextUtils.equals(str, "0")) {
                callbackHandler.handleSchemeDispatchCallback(str2, str);
            } else {
                D(str, p53Var, new b(this, callbackHandler, str2));
            }
        }
    }

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            if (p53Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else if (p53Var.o0()) {
                if (e) {
                    Log.d("FaceVerifyAction", "FaceVerifyAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
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
                String a2 = fv1.a(p53Var.b);
                JSONObject n = n(a2);
                p53Var.f0().h(context, "mapp_i_face_verify", na3.j(optParamsAsJo), new a(this, callbackHandler, optString, a2, p53Var));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n, 0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
