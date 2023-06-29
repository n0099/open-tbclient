package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tieba.zw2;
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
/* loaded from: classes6.dex */
public final class ij3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej3 a;

        public a(ej3 ej3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ej3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ej3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ji3.k("4165", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947855383, "Lcom/baidu/tieba/ij3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947855383, "Lcom/baidu/tieba/ij3;");
                return;
            }
        }
        a = ms1.a;
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
        if ((interceptable != null && interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3}) != null) || TextUtils.equals(str, GameAssistConstKt.METHOD_GET_LOCATION)) {
            return;
        }
        c(str, i, str2, i2, str3, null);
    }

    public static void c(String str, int i, String str2, int i2, String str3, Response response) {
        kb2 H;
        iy1 q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, response}) == null) {
            ej3 ej3Var = new ej3();
            cc3 b0 = cc3.b0();
            if (b0 == null || (H = px2.T().H()) == null || (q3 = H.q3()) == null) {
                return;
            }
            String l = q3.l();
            zw2.a W = b0.W();
            String Z = b0.Z();
            String appId = b0.getAppId();
            String W2 = W.W();
            String v1 = W.v1();
            String i3 = hl3.i(px2.T().getCoreVersion(), W.G());
            String a2 = a(response);
            String d = NetworkUtils.d();
            ej3Var.a = vi3.n(W.G());
            ej3Var.c = b0.W().T();
            ej3Var.d = b0.W().V();
            ej3Var.f = appId;
            ej3Var.a("name", Z);
            ej3Var.a("apiName", str);
            ej3Var.a("errorCode", String.valueOf(i));
            ej3Var.a("errorMsg", str2);
            ej3Var.a("pagePath", l);
            if (i2 != -1) {
                ej3Var.a("oldErrorCode", String.valueOf(i2));
            }
            ej3Var.a("oldErrorMsg", str3);
            ej3Var.a("scheme", W2);
            ej3Var.a("appVersion", v1);
            ej3Var.a("swan", i3);
            ej3Var.a("requestid", a2);
            ej3Var.a("net", d);
            if (nj4.b() != null) {
                ej3Var.a("SDKVersion", nj4.b().b());
                ej3Var.a("hostName", nj4.b().c());
            }
            wo3.j(new a(ej3Var), "monitor");
        }
    }
}
