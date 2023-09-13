package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.gamecenter.appmanager.notification.InstallNotifyReceiver;
import com.baidu.tieba.ew2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947802559, "Lcom/baidu/tieba/i34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947802559, "Lcom/baidu/tieba/i34;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void a(String str, String str2, String str3, String str4, g34 g34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, g34Var) == null) {
            String l = h34.l(str2);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            if (a) {
                Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            h34 h34Var = new h34();
            h34Var.m(g34Var);
            h34Var.b = l;
            h34Var.e = str3;
            h34Var.v = str;
            h34Var.l = bp3.D();
            if (hb3.b0() != null) {
                ew2.a W = hb3.b0().W();
                h34Var.a = ai3.n(W.G());
                h34Var.f = W.H();
                h34Var.c = W.T();
            }
            h34Var.t = str4;
            ai3.x("1245", h34Var);
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            c(str, str2, "");
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, str3) == null) {
            String l = h34.l(str);
            if (TextUtils.isEmpty(l)) {
                return;
            }
            h34 h34Var = new h34();
            h34Var.b = l;
            h34Var.a(InstallNotifyReceiver.OPPORTUNITY, str2);
            if (str3 == null) {
                str3 = "";
            }
            h34Var.a("packageName", str3);
            ai3.x("1245", h34Var);
        }
    }

    public static void d(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = y74.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", ou2.h0().i(ou2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", ou2.n().a());
                jSONObject.put("version", bp3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) li4.h(ou2.c()).postRequest().cookieManager(ou2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
