package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.h6c;
import com.baidu.tieba.pp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class bo3 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public abstract String r();

    /* loaded from: classes5.dex */
    public class c implements h6c.a<fo3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public class a implements pp2.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n6c a;

            public a(c cVar, n6c n6cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, n6cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = n6cVar;
            }

            @Override // com.baidu.tieba.pp2.a
            public void a(o83 o83Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, o83Var) == null) {
                    fo3 fo3Var = new fo3();
                    if (o83Var != null && !TextUtils.isEmpty(o83Var.a)) {
                        fo3Var.a = o83Var.a;
                        fo3Var.b = o83Var.c;
                        fo3Var.c = o83Var.b;
                    } else {
                        fo3Var.a = "unknown";
                    }
                    this.a.onNext(fo3Var);
                    this.a.onCompleted();
                }
            }

            @Override // com.baidu.tieba.pp2.a
            public void onFailed(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    this.a.onError(new Throwable());
                }
            }
        }

        public c(bo3 bo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(n6c<? super fo3> n6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, n6cVar) == null) {
                wo2.I().b("bd09", true, false, new a(this, n6cVar));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements v6c<fo3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo3 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ bo3 e;

        public a(bo3 bo3Var, eo3 eo3Var, Context context, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bo3Var, eo3Var, context, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = bo3Var;
            this.a = eo3Var;
            this.b = context;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(fo3 fo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fo3Var) == null) {
                go3.b(this.a, fo3Var);
                this.e.t(this.b, this.c, this.d, this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements v6c<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;
        public final /* synthetic */ eo3 d;
        public final /* synthetic */ bo3 e;

        public b(bo3 bo3Var, Context context, CallbackHandler callbackHandler, String str, eo3 eo3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bo3Var, context, callbackHandler, str, eo3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = bo3Var;
            this.a = context;
            this.b = callbackHandler;
            this.c = str;
            this.d = eo3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v6c
        /* renamed from: a */
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                p22.o("recommend", "get param(l) info fail: " + th.getMessage());
                this.e.t(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ik3<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public d(bo3 bo3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bo3Var, callbackHandler, str};
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
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                if (jSONObject == null) {
                    p22.c("recommend", ADConfigError.REASON_NULL_RESPONSE);
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, ADConfigError.REASON_NULL_RESPONSE).toString());
                    return;
                }
                p22.i("recommend", "recommend action execute success");
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik3 a;

        public e(bo3 bo3Var, ik3 ik3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bo3Var, ik3Var};
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
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (jSONObject == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("info", "on success but jsonObject is null");
                        jSONObject2.put("statusCode", i);
                    } catch (JSONException e) {
                        if (m73.b) {
                            e.printStackTrace();
                        }
                    }
                    go3.f(jSONObject2.toString());
                }
                this.a.a(jSONObject);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                p22.d("recommend", "http response with exception:", exc);
                this.a.a(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "http request fail with exception : " + exc.getMessage());
                } catch (JSONException e) {
                    if (m73.b) {
                        e.printStackTrace();
                    }
                }
                go3.f(jSONObject.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                p22.i("recommend", "parse response");
                String str = StringUtil.NULL_STRING;
                if (response != null && response.body() != null) {
                    String string = response.body().string();
                    if (TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("info", "parse response fail");
                            jSONObject.put("response code", response.code());
                            if (string != null) {
                                str = SchemeCollecter.CLASSIFY_EMPTY;
                            }
                            jSONObject.put("response body", str);
                        } catch (JSONException e) {
                            if (m73.b) {
                                e.printStackTrace();
                            }
                        }
                        go3.f(jSONObject.toString());
                        return null;
                    }
                    return new JSONObject(string);
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("info", "parse response fail");
                    if (response == null) {
                        jSONObject2.put("response", StringUtil.NULL_STRING);
                    } else {
                        jSONObject2.put("response code", response.code());
                        if (response.body() == null) {
                            jSONObject2.put("response body", StringUtil.NULL_STRING);
                        } else {
                            jSONObject2.put("response", "unknown");
                        }
                    }
                } catch (JSONException e2) {
                    if (m73.b) {
                        e2.printStackTrace();
                    }
                }
                go3.f(jSONObject2.toString());
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo3(m63 m63Var, String str) {
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
            if (m73.b) {
                Log.d("BaseRecommendAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            if (p53Var == null) {
                p22.c("recommend", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a2 = m73.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                p22.c("recommend", "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
                return false;
            }
            String optString = a2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p22.c("recommend", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                p22.i("recommend", "start perform request");
                s(context, callbackHandler, optString, optJSONObject);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            p22.c("recommend", "param data is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "param data is empty");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @NonNull
    public final ik3<JSONObject> o(@NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str)) == null) {
            return new d(this, callbackHandler, str);
        }
        return (ik3) invokeLL.objValue;
    }

    @NonNull
    public final ResponseCallback<JSONObject> p(@NonNull ik3<JSONObject> ik3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ik3Var)) == null) {
            return new e(this, ik3Var);
        }
        return (ResponseCallback) invokeL.objValue;
    }

    public final h6c<fo3> q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (context == null) {
                return null;
            }
            if (wh3.h() && (context.checkSelfPermission(com.kuaishou.weapon.p0.h.g) != 0 || context.checkSelfPermission(com.kuaishou.weapon.p0.h.h) != 0)) {
                return null;
            }
            return h6c.d(new c(this));
        }
        return (h6c) invokeL.objValue;
    }

    public final void s(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, callbackHandler, str, jSONObject) == null) {
            p22.i("recommend", "get request params");
            eo3 eo3Var = new eo3(context, jSONObject);
            h6c<fo3> q = q(context);
            if (q != null) {
                q.K(60L, TimeUnit.MILLISECONDS).I(new a(this, eo3Var, context, callbackHandler, str), new b(this, context, callbackHandler, str, eo3Var));
                return;
            }
            p22.o("recommend", "get param(l) is null");
            t(context, callbackHandler, str, eo3Var);
        }
    }

    public final void t(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull eo3 eo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, callbackHandler, str, eo3Var) == null) {
            p22.i("recommend", "start real perform request");
            String v = l22.v(r());
            ik3<JSONObject> o = o(callbackHandler, str);
            ResponseCallback<JSONObject> p = p(o);
            MediaType parse = MediaType.parse("application/json");
            p22.i("recommend", "encrypt request param");
            String a2 = go3.a(eo3Var.d());
            if (TextUtils.isEmpty(a2)) {
                p22.c("recommend", "encrypt request param fail");
                o.a(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "encrypt request param fail");
                } catch (JSONException e2) {
                    if (m73.b) {
                        e2.printStackTrace();
                    }
                }
                go3.f(jSONObject.toString());
                return;
            }
            p22.i("recommend", "execute request");
            ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postRequest().url(v)).requestBody(RequestBody.create(parse, a2)).build().executeAsync(p);
        }
    }
}
