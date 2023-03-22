package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes4.dex */
public class dz2 extends vy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public void y(@NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ HttpUrl b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ long e;
        public final /* synthetic */ c f;

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public a(dz2 dz2Var, String str, HttpUrl httpUrl, String str2, int i, long j, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dz2Var, str, httpUrl, str2, Integer.valueOf(i), Long.valueOf(j), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = httpUrl;
            this.c = str2;
            this.d = i;
            this.e = j;
            this.f = cVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                me3.C(this.c, this.d, null, this.e, System.currentTimeMillis(), this.a);
                if (exc instanceof IOException) {
                    this.f.onFailure(null, (IOException) exc);
                } else {
                    this.f.onFailure(null, new IOException(exc));
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, response, i, networkStatRecord)) == null) {
                dd2.k().C(this.a, this.b, networkStatRecord);
                me3.C(this.c, this.d, networkStatRecord, this.e, System.currentTimeMillis(), this.a);
                this.f.onResponse(null, response);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements mm3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public b(dz2 dz2Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dz2Var, callbackHandler, str};
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
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public t73 a;
        public JSONObject b;
        public String c;
        public String d;
        public CallbackHandler e;
        public String f;
        public long g;
        public final /* synthetic */ dz2 h;

        public c(@NonNull dz2 dz2Var, @NonNull t73 t73Var, @NonNull JSONObject jSONObject, @NonNull String str, String str2, @NonNull CallbackHandler callbackHandler, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dz2Var, t73Var, jSONObject, str, str2, callbackHandler, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = dz2Var;
            this.a = t73Var;
            this.b = jSONObject;
            this.c = str;
            this.d = str2;
            this.e = callbackHandler;
            this.f = str3;
            this.g = System.currentTimeMillis();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (q93.b) {
                    Log.d("RequestAction", "onFailure: " + iOException.getMessage());
                }
                int G = this.a.Y().G();
                String l = me3.l();
                String e = nl3.n().e();
                SwanAppNetworkUtils.a(xe4.g().getOkHttpClient(), this.d);
                this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                me3.Q(0, this.c, G, iOException.getMessage(), l, e, this.g, System.currentTimeMillis(), this.d);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!me3.o(this.c)) {
                    pg3.l().x(this.c, response.headers("Set-cookie"));
                }
                String J = hx1.J(this.b);
                String L = hx1.L(this.b);
                int G = this.a.Y().G();
                long currentTimeMillis = System.currentTimeMillis();
                String l = me3.l();
                String e = nl3.n().e();
                String optString = this.b.optString("cb");
                try {
                    long K = hx1.K(response);
                    if (K <= Config.FULL_TRACE_LOG_LIMIT) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, response.code());
                        jSONObject.put("header", vy2.s(response.headers()));
                        hx1.R(jSONObject, response.body(), J, L);
                        this.h.y(jSONObject);
                        this.e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        hx1.S(this.a, this.c, K, currentTimeMillis);
                        this.e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, "response json length over limits").toString());
                    }
                } catch (IOException | JSONException e2) {
                    if (q93.b) {
                        Log.d("RequestAction", Log.getStackTraceString(e2));
                    }
                    this.e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                }
                int code = response.code();
                String message = response.message();
                if (q93.b) {
                    Log.d("RequestAction", "onResponse: respCode: " + code + ", url=" + this.c + ", msg=" + message);
                }
                me3.Q(code, this.c, G, message, l, e, this.g, System.currentTimeMillis(), this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dz2(q83 q83Var) {
        super(q83Var, "/swanAPI/request");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((q83) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dz2(q83 q83Var, String str) {
        super(q83Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((q83) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public boolean A(@NonNull t73 t73Var, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, t73Var, unitedSchemeEntity, callbackHandler, str)) == null) {
            JSONObject a2 = q93.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                return false;
            }
            Pair<HttpRequest, Integer> C = hx1.C(a2, str);
            HttpRequest httpRequest = (HttpRequest) C.first;
            if (httpRequest == null) {
                unitedSchemeEntity.result = t(((Integer) C.second).intValue());
                return false;
            }
            z(t73Var, a2, httpRequest, str, callbackHandler);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            if (q93.b) {
                Log.d("RequestApi", "request with scheme : " + unitedSchemeEntity.getParam("params"));
            }
            if (!k(t73Var, unitedSchemeEntity)) {
                return false;
            }
            String a2 = ix1.a(t73Var.b);
            if (!A(t73Var, unitedSchemeEntity, callbackHandler, a2)) {
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a2), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean x(@NonNull t73 t73Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, CallbackHandler callbackHandler, @NonNull String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{t73Var, jSONObject, str, str2, callbackHandler, str3})) == null) {
            return ar2.e().i(t73Var, jSONObject, str, str2, new c(this, t73Var, jSONObject, str, str2, callbackHandler, str3), new b(this, callbackHandler, str3));
        }
        return invokeCommon.booleanValue;
    }

    public final void z(@NonNull t73 t73Var, @NonNull JSONObject jSONObject, @NonNull HttpRequest httpRequest, @NonNull String str, @NonNull CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, t73Var, jSONObject, httpRequest, str, callbackHandler) == null) {
            HttpUrl url = httpRequest.getOkRequest().url();
            String httpUrl = url.toString();
            String optString = jSONObject.optString("cb");
            if (x(t73Var, jSONObject, httpUrl, str, callbackHandler, optString)) {
                return;
            }
            httpRequest.executeStat(new a(this, str, url, httpUrl, t73Var.Y().G(), System.currentTimeMillis(), new c(this, t73Var, jSONObject, httpUrl, str, callbackHandler, optString)));
        }
    }
}
