package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ax3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface d {
        void onFail(String str);

        void onSuccess(Object obj);
    }

    /* loaded from: classes3.dex */
    public final class a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                this.a.onFail(exc.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject e = ax3.e(str, this.a);
                    if (e == null) {
                        return;
                    }
                    this.a.onSuccess(cx3.a(e));
                    return;
                }
                this.a.onFail(ADConfigError.REASON_NULL_RESPONSE);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class b extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                this.a.onFail(exc.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject e = ax3.e(str, this.a);
                    if (e == null) {
                        return;
                    }
                    this.a.onSuccess(bx3.a(e));
                    return;
                }
                this.a.onFail(ADConfigError.REASON_NULL_RESPONSE);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class c extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m33 a;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            }
        }

        public c(m33 m33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m33Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                try {
                    if (new JSONObject(str).getInt("errno") != 0) {
                        ub3 a = ac3.a();
                        a.putInt("swangame_valid__" + this.a.O(), 0);
                        return;
                    }
                    ub3 a2 = ac3.a();
                    a2.putInt("swangame_valid__" + this.a.O(), 1);
                    ax3.g("1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void b() {
        m33 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && (b0 = m33.b0()) != null && !c() && tm2.h0().e(tm2.c())) {
            if (d()) {
                g("1");
            } else {
                ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) t14.a().getRequest().cookieManager(tm2.q().a())).url(d04.b().a())).addUrlParam("appKey", b0.O())).requestFrom(16)).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE)).build().executeAsync(new c(b0));
            }
        }
    }

    public static void f() {
        m33 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && (b0 = m33.b0()) != null && d() && tm2.h0().e(tm2.c())) {
            ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) t14.a().getRequest().cookieManager(tm2.q().a())).url(d04.b().i())).addUrlParam("appKey", b0.O())).requestFrom(16)).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE)).build().executeAsync(null);
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            m33 b0 = m33.b0();
            if (b0 == null) {
                return true;
            }
            ub3 a2 = ac3.a();
            if (a2.getInt("swangame_valid__" + b0.O(), -1) == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            m33 b0 = m33.b0();
            if (b0 == null) {
                return false;
            }
            ub3 a2 = ac3.a();
            if (1 != a2.getInt("swangame_valid__" + b0.O(), -1)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static JSONObject e(String str, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, dVar)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("errno", -1) != 0) {
                    dVar.onFail(jSONObject.optString("errmsg"));
                    return null;
                }
                return jSONObject.optJSONObject("data");
            } catch (Exception e) {
                dVar.onFail(e.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void g(String str) {
        m33 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, str) == null) && (b0 = m33.b0()) != null && d() && tm2.h0().e(tm2.c())) {
            String h = tm2.h0().h(tm2.c());
            if (TextUtils.isEmpty(h)) {
                return;
            }
            String d2 = sj4.d(Base64.encode(h.getBytes(), 0), false);
            String i = tm2.h0().i(tm2.c());
            if (!TextUtils.isEmpty(i) && i.length() > 32) {
                i = i.substring(0, 32);
            }
            ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) t14.a().getRequest().cookieManager(tm2.q().a())).url(d04.b().q())).addUrlParam("sessionId", d2)).addUrlParam("deviceId", i)).addUrlParam("behaviorType", str)).addUrlParam("behaviorTime", String.valueOf(System.currentTimeMillis() / 1000))).addUrlParam("appKey", b0.O())).requestFrom(16)).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE)).build().executeAsync(null);
        }
    }

    public static void h(String str, d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65543, null, str, dVar) != null) || dVar == null) {
            return;
        }
        m33 b0 = m33.b0();
        if (b0 == null) {
            dVar.onFail("swan app is null");
            return;
        }
        ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) t14.a().getRequest().cookieManager(tm2.q().a())).url(d04.b().j())).addUrlParam("appkey", b0.O())).addUrlParam(IMConstants.SERVICE_TYPE_ORDER, str)).requestFrom(16)).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE)).build().executeAsync(new b(dVar));
    }

    public static void i(long j, d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJL(65544, null, j, dVar) != null) || dVar == null) {
            return;
        }
        m33 b0 = m33.b0();
        if (b0 == null) {
            dVar.onFail("swan app is null");
            return;
        }
        ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) t14.a().getRequest().cookieManager(tm2.q().a())).url(d04.b().h())).addUrlParam("appkey", b0.O())).addUrlParam("duration", String.valueOf(j))).requestFrom(16)).requestSubFrom(ARPMessageType.MSG_TYPE_SHARE)).build().executeAsync(new a(dVar));
    }
}
