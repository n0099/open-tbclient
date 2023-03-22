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
import com.baidu.tieba.ora;
import com.baidu.tieba.tr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class fq3 extends q93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public abstract String r();

    /* loaded from: classes4.dex */
    public class c implements ora.a<jq3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public class a implements tr2.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ura a;

            public a(c cVar, ura uraVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, uraVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = uraVar;
            }

            @Override // com.baidu.tieba.tr2.a
            public void a(sa3 sa3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, sa3Var) == null) {
                    jq3 jq3Var = new jq3();
                    if (sa3Var != null && !TextUtils.isEmpty(sa3Var.a)) {
                        jq3Var.a = sa3Var.a;
                        jq3Var.b = sa3Var.c;
                        jq3Var.c = sa3Var.b;
                    } else {
                        jq3Var.a = "unknown";
                    }
                    this.a.onNext(jq3Var);
                    this.a.onCompleted();
                }
            }

            @Override // com.baidu.tieba.tr2.a
            public void onFailed(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    this.a.onError(new Throwable());
                }
            }
        }

        public c(fq3 fq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq3Var};
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
        @Override // com.baidu.tieba.ora.a, com.baidu.tieba.csa
        public void call(ura<? super jq3> uraVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, uraVar) == null) {
                ar2.I().b("bd09", true, false, new a(this, uraVar));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements csa<jq3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iq3 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ fq3 e;

        public a(fq3 fq3Var, iq3 iq3Var, Context context, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq3Var, iq3Var, context, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = fq3Var;
            this.a = iq3Var;
            this.b = context;
            this.c = callbackHandler;
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.csa
        public void call(jq3 jq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jq3Var) == null) {
                kq3.b(this.a, jq3Var);
                this.e.t(this.b, this.c, this.d, this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements csa<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;
        public final /* synthetic */ iq3 d;
        public final /* synthetic */ fq3 e;

        public b(fq3 fq3Var, Context context, CallbackHandler callbackHandler, String str, iq3 iq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq3Var, context, callbackHandler, str, iq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = fq3Var;
            this.a = context;
            this.b = callbackHandler;
            this.c = str;
            this.d = iq3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.csa
        public void call(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                t42.o("recommend", "get param(l) info fail: " + th.getMessage());
                this.e.t(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements mm3<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public d(fq3 fq3Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq3Var, callbackHandler, str};
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
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                if (jSONObject == null) {
                    t42.c("recommend", ADConfigError.REASON_NULL_RESPONSE);
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, ADConfigError.REASON_NULL_RESPONSE).toString());
                    return;
                }
                t42.i("recommend", "recommend action execute success");
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm3 a;

        public e(fq3 fq3Var, mm3 mm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq3Var, mm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mm3Var;
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
                        jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i);
                    } catch (JSONException e) {
                        if (q93.b) {
                            e.printStackTrace();
                        }
                    }
                    kq3.f(jSONObject2.toString());
                }
                this.a.a(jSONObject);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                t42.d("recommend", "http response with exception:", exc);
                this.a.a(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "http request fail with exception : " + exc.getMessage());
                } catch (JSONException e) {
                    if (q93.b) {
                        e.printStackTrace();
                    }
                }
                kq3.f(jSONObject.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                t42.i("recommend", "parse response");
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
                            if (q93.b) {
                                e.printStackTrace();
                            }
                        }
                        kq3.f(jSONObject.toString());
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
                    if (q93.b) {
                        e2.printStackTrace();
                    }
                }
                kq3.f(jSONObject2.toString());
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fq3(q83 q83Var, String str) {
        super(q83Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var, str};
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

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            if (q93.b) {
                Log.d("BaseRecommendAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            if (t73Var == null) {
                t42.c("recommend", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            JSONObject a2 = q93.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                t42.c("recommend", "param is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
                return false;
            }
            String optString = a2.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                t42.c("recommend", "cb is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                t42.i("recommend", "start perform request");
                s(context, callbackHandler, optString, optJSONObject);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            t42.c("recommend", "param data is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "param data is empty");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @NonNull
    public final mm3<JSONObject> o(@NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str)) == null) {
            return new d(this, callbackHandler, str);
        }
        return (mm3) invokeLL.objValue;
    }

    @NonNull
    public final ResponseCallback<JSONObject> p(@NonNull mm3<JSONObject> mm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mm3Var)) == null) {
            return new e(this, mm3Var);
        }
        return (ResponseCallback) invokeL.objValue;
    }

    public final ora<jq3> q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (context == null) {
                return null;
            }
            if (ak3.h() && (context.checkSelfPermission(com.kuaishou.weapon.p0.h.g) != 0 || context.checkSelfPermission(com.kuaishou.weapon.p0.h.h) != 0)) {
                return null;
            }
            return ora.a(new c(this));
        }
        return (ora) invokeL.objValue;
    }

    public final void s(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, callbackHandler, str, jSONObject) == null) {
            t42.i("recommend", "get request params");
            iq3 iq3Var = new iq3(context, jSONObject);
            ora<jq3> q = q(context);
            if (q != null) {
                q.z(60L, TimeUnit.MILLISECONDS).x(new a(this, iq3Var, context, callbackHandler, str), new b(this, context, callbackHandler, str, iq3Var));
                return;
            }
            t42.o("recommend", "get param(l) is null");
            t(context, callbackHandler, str, iq3Var);
        }
    }

    public final void t(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull iq3 iq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, callbackHandler, str, iq3Var) == null) {
            t42.i("recommend", "start real perform request");
            String v = p42.v(r());
            mm3<JSONObject> o = o(callbackHandler, str);
            ResponseCallback<JSONObject> p = p(o);
            MediaType parse = MediaType.parse("application/json");
            t42.i("recommend", "encrypt request param");
            String a2 = kq3.a(iq3Var.d());
            if (TextUtils.isEmpty(a2)) {
                t42.c("recommend", "encrypt request param fail");
                o.a(null);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "encrypt request param fail");
                } catch (JSONException e2) {
                    if (q93.b) {
                        e2.printStackTrace();
                    }
                }
                kq3.f(jSONObject.toString());
                return;
            }
            t42.i("recommend", "execute request");
            ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postRequest().url(v)).requestBody(RequestBody.create(parse, a2)).build().executeAsync(p);
        }
    }
}
