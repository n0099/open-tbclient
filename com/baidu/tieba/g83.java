package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tieba.xl2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class g83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c83 a;

        public a(c83 c83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h73.k("4165", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947747751, "Lcom/baidu/tieba/g83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947747751, "Lcom/baidu/tieba/g83;");
                return;
            }
        }
        a = kh1.a;
    }

    public static String a(Response response) {
        InterceptResult invokeL;
        ResponseBody body;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, response)) == null) {
            if (response == null || (body = response.body()) == null) {
                return "";
            }
            JSONObject jSONObject = null;
            try {
                str = body.string();
            } catch (IOException e) {
                if (a) {
                    e.printStackTrace();
                }
                str = null;
            }
            if (str == null) {
                return "";
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject == null ? "" : jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
        }
        return (String) invokeL.objValue;
    }

    public static void b(String str, int i, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3}) == null) || TextUtils.equals(str, "getLocation")) {
            return;
        }
        c(str, i, str2, i2, str3, null);
    }

    public static void c(String str, int i, String str2, int i2, String str3, Response response) {
        i02 H;
        gn1 o3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, response}) == null) {
            c83 c83Var = new c83();
            a13 b0 = a13.b0();
            if (b0 == null || (H = nm2.U().H()) == null || (o3 = H.o3()) == null) {
                return;
            }
            String l = o3.l();
            xl2.a W = b0.W();
            String Z = b0.Z();
            String appId = b0.getAppId();
            String W2 = W.W();
            String v1 = W.v1();
            String i3 = fa3.i(nm2.U().M(), W.G());
            String a2 = a(response);
            String d = NetworkUtils.d();
            c83Var.a = t73.n(W.G());
            c83Var.c = b0.W().T();
            c83Var.d = b0.W().V();
            c83Var.f = appId;
            c83Var.a("name", Z);
            c83Var.a("apiName", str);
            c83Var.a("errorCode", String.valueOf(i));
            c83Var.a("errorMsg", str2);
            c83Var.a("pagePath", l);
            if (i2 != -1) {
                c83Var.a("oldErrorCode", String.valueOf(i2));
            }
            c83Var.a("oldErrorMsg", str3);
            c83Var.a("scheme", W2);
            c83Var.a("appVersion", v1);
            c83Var.a("swan", i3);
            c83Var.a(BaseJsonData.TAG_REQUESTID, a2);
            c83Var.a("net", d);
            if (j84.b() != null) {
                c83Var.a("SDKVersion", j84.b().b());
                c83Var.a("hostName", j84.b().c());
            }
            ud3.j(new a(c83Var), "monitor");
        }
    }
}
