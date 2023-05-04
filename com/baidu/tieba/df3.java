package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tieba.us2;
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
public final class df3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze3 a;

        public a(ze3 ze3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ee3.k("4165", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947702584, "Lcom/baidu/tieba/df3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947702584, "Lcom/baidu/tieba/df3;");
                return;
            }
        }
        a = ho1.a;
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
            if (jSONObject == null) {
                return "";
            }
            return jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
        }
        return (String) invokeL.objValue;
    }

    public static void b(String str, int i, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3}) != null) || TextUtils.equals(str, "getLocation")) {
            return;
        }
        c(str, i, str2, i2, str3, null);
    }

    public static void c(String str, int i, String str2, int i2, String str3, Response response) {
        f72 H;
        du1 r3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, response}) == null) {
            ze3 ze3Var = new ze3();
            x73 b0 = x73.b0();
            if (b0 == null || (H = kt2.U().H()) == null || (r3 = H.r3()) == null) {
                return;
            }
            String m = r3.m();
            us2.a W = b0.W();
            String Z = b0.Z();
            String appId = b0.getAppId();
            String W2 = W.W();
            String v1 = W.v1();
            String i3 = ch3.i(kt2.U().M(), W.G());
            String a2 = a(response);
            String d = NetworkUtils.d();
            ze3Var.a = qe3.n(W.G());
            ze3Var.c = b0.W().T();
            ze3Var.d = b0.W().V();
            ze3Var.f = appId;
            ze3Var.a("name", Z);
            ze3Var.a("apiName", str);
            ze3Var.a("errorCode", String.valueOf(i));
            ze3Var.a("errorMsg", str2);
            ze3Var.a("pagePath", m);
            if (i2 != -1) {
                ze3Var.a("oldErrorCode", String.valueOf(i2));
            }
            ze3Var.a("oldErrorMsg", str3);
            ze3Var.a("scheme", W2);
            ze3Var.a("appVersion", v1);
            ze3Var.a("swan", i3);
            ze3Var.a(BaseJsonData.TAG_REQUESTID, a2);
            ze3Var.a("net", d);
            if (if4.b() != null) {
                ze3Var.a("SDKVersion", if4.b().b());
                ze3Var.a("hostName", if4.b().c());
            }
            rk3.j(new a(ze3Var), "monitor");
        }
    }
}
