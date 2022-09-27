package com.baidu.tieba;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class hu3 {
    public static /* synthetic */ Interceptable $ic;
    public static hu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947836163, "Lcom/baidu/tieba/hu3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947836163, "Lcom/baidu/tieba/hu3;");
                return;
            }
        }
        a = new hu3();
    }

    public hu3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static hu3 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (hu3) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            na3 na3Var = new na3();
            na3Var.b = "beforeConfigRequest";
            na3Var.e = str;
            ea3.g(na3Var);
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            GameGuideConfigInfo z = kt3.o.z();
            String str5 = z != null ? z.configName : "";
            String str6 = z != null ? z.targetAppPackageId : "";
            String str7 = z != null ? z.targetAppDownloadUrl : "";
            na3 na3Var = new na3();
            na3Var.b = str;
            na3Var.g = "gbview";
            na3Var.e = str2;
            na3Var.a("gameAppkey", str3);
            na3Var.a("gamePosition", str4);
            na3Var.a("configName", str5);
            na3Var.a("targetPackageName", str6);
            na3Var.a("targetDownloadUrl", str7);
            ea3.g(na3Var);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            GameGuideConfigInfo z = kt3.o.z();
            String str2 = z != null ? z.configName : "";
            String str3 = z != null ? z.targetAppPackageId : "";
            String str4 = z != null ? z.targetAppDownloadUrl : "";
            na3 na3Var = new na3();
            na3Var.b = str;
            na3Var.g = "gbview";
            na3Var.a("configName", str2);
            na3Var.a("targetPackageName", str3);
            na3Var.a("targetDownloadUrl", str4);
            if (str3.equals(pt3.a)) {
                if (fh3.F(sm2.c(), str3)) {
                    na3Var.a("isGamenowInstalled", "1");
                } else {
                    na3Var.a("isGamenowInstalled", "2");
                }
            }
            ea3.g(na3Var);
        }
    }

    public void d(String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
            na3 na3Var = new na3();
            na3Var.b = "request";
            na3Var.g = "wdview";
            na3Var.a("requestStatus", str);
            na3Var.a("isFromNet", z ? "0" : "1");
            na3Var.a(StatConstants.KEY_EXT_ERR_MSG, str2);
            ea3.g(na3Var);
            if (TextUtils.equals(str, com.baidu.pass.biometrics.face.liveness.b.a.g0) || (TextUtils.equals(str, "start") && !z)) {
                o();
            }
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            GameGuideConfigInfo z = kt3.o.z();
            String str7 = z != null ? z.configName : "";
            String str8 = z != null ? z.targetAppPackageId : "";
            String str9 = z != null ? z.targetAppDownloadUrl : "";
            if (!TextUtils.equals(str8, pt3.a)) {
                str6 = str9;
            }
            na3 na3Var = new na3();
            na3Var.b = str;
            na3Var.g = str2;
            na3Var.e = str3;
            na3Var.a("gameAppkey", str4);
            na3Var.a("gamePosition", str5);
            na3Var.a("configName", str7);
            na3Var.a("targetPackageName", str8);
            na3Var.a("targetDownloadUrl", str6);
            ea3.g(na3Var);
        }
    }

    public void f(String str, gu3 gu3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, gu3Var, str2, str3, str4) == null) {
            JSONObject d = lg3.d(str3);
            iu3 iu3Var = new iu3();
            iu3Var.g(gu3Var);
            iu3Var.b = str;
            iu3Var.g = d.optString("from_view");
            iu3Var.e = d.optString("from_value");
            iu3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            iu3Var.a("targetPackageName", str2);
            iu3Var.a("targetDownloadUrl", str4);
            ea3.g(iu3Var);
        }
    }

    public void g(String str, gu3 gu3Var, String str2, String str3, int i, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, gu3Var, str2, str3, Integer.valueOf(i), str4}) == null) {
            JSONObject d = lg3.d(str3);
            long optLong = d.optLong("download_finish_time");
            long elapsedRealtime = optLong != 0 ? SystemClock.elapsedRealtime() - optLong : 0L;
            iu3 iu3Var = new iu3();
            iu3Var.g(gu3Var);
            iu3Var.e = d.optString("from_value");
            iu3Var.b = str;
            iu3Var.g = d.optString("from_view");
            iu3Var.a("error_code", Integer.valueOf(i));
            iu3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            if (elapsedRealtime != 0) {
                iu3Var.a("timeAfterDownload", Long.valueOf(elapsedRealtime));
            }
            iu3Var.a("targetPackageName", str2);
            iu3Var.a("targetDownloadUrl", str4);
            if (TextUtils.equals(str, "package_expired")) {
                iu3Var.a("downloadStatus", d.optString("download_status"));
            }
            if (TextUtils.equals(str, "analysisFailed")) {
                long optLong2 = d.optLong("download_current_bytes");
                long optLong3 = d.optLong("download_total_bytes");
                iu3Var.a("downloadCurrentBytes", Long.valueOf(optLong2));
                iu3Var.a("downloadTotalBytes", Long.valueOf(optLong3));
            }
            ea3.x("936", iu3Var);
        }
    }

    public void h(String str, gu3 gu3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, gu3Var, str2, str3, str4) == null) {
            g(str, gu3Var, str2, str3, 0, str4);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            GameGuideConfigInfo z = kt3.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            na3 na3Var = new na3();
            na3Var.b = "guideClick";
            na3Var.g = "wdview";
            na3Var.a("guideViewNum", String.valueOf(i));
            na3Var.a("configName", str);
            na3Var.a("targetPackageName", str2);
            na3Var.a("targetDownloadUrl", str3);
            ea3.g(na3Var);
        }
    }

    public void j(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, str, i, i2) == null) {
            GameGuideConfigInfo z = kt3.o.z();
            String str2 = z != null ? z.configName : "";
            String str3 = z != null ? z.targetAppPackageId : "";
            String str4 = z != null ? z.targetAppDownloadUrl : "";
            na3 na3Var = new na3();
            na3Var.b = "wdDialogClick";
            na3Var.g = "wdview";
            na3Var.e = str;
            na3Var.a("coinsThisTime", String.valueOf(i));
            na3Var.a("coinsTotal", String.valueOf(i2));
            na3Var.a("configName", str2);
            na3Var.a("targetPackageName", str3);
            na3Var.a("targetDownloadUrl", str4);
            ea3.g(na3Var);
        }
    }

    public void k(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            GameGuideConfigInfo z = kt3.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            na3 na3Var = new na3();
            na3Var.b = "wdDialogShow";
            na3Var.g = "wdview";
            na3Var.a("coinsThisTime", String.valueOf(i));
            na3Var.a("coinsTotal", String.valueOf(i2));
            na3Var.a("configName", str);
            na3Var.a("targetPackageName", str2);
            na3Var.a("targetDownloadUrl", str3);
            if (str2.equals(pt3.a)) {
                if (fh3.F(sm2.c(), str2)) {
                    na3Var.a("isGamenowInstalled", "1");
                } else {
                    na3Var.a("isGamenowInstalled", "2");
                }
            }
            ea3.g(na3Var);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GameGuideConfigInfo z = kt3.o.z();
            String str = z != null ? z.configName : "";
            String str2 = z != null ? z.targetAppPackageId : "";
            String str3 = z != null ? z.targetAppDownloadUrl : "";
            na3 na3Var = new na3();
            na3Var.b = "guideShow";
            na3Var.g = "wdview";
            na3Var.a("configName", str);
            na3Var.a("targetPackageName", str2);
            na3Var.a("targetDownloadUrl", str3);
            ea3.g(na3Var);
        }
    }

    public void m(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, str, str2, i) == null) {
            GameGuideConfigInfo z = kt3.o.z();
            String str3 = z != null ? z.configName : "";
            String str4 = z != null ? z.targetAppPackageId : "";
            String str5 = z != null ? z.targetAppDownloadUrl : "";
            na3 na3Var = new na3();
            na3Var.g = str;
            na3Var.e = str2;
            na3Var.a("configName", str3);
            na3Var.a("targetPackageName", str4);
            na3Var.a("targetDownloadUrl", str5);
            na3Var.a("GamenowDownloadStatus", Integer.valueOf(i));
            ea3.g(na3Var);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b22.f("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "12", "swan");
        }
    }

    public void p(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = c04.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", sm2.h0().i(sm2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", sm2.n().a());
                jSONObject.put("version", fh3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) pa4.h(sm2.c()).postRequest().cookieManager(sm2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }

    public void q(int i, String str, String str2, int i2, String str3, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String d = c04.b().d();
            JSONObject jSONObject = new JSONObject();
            String str4 = TextUtils.equals(str, pt3.a) ? "2101000000" : "";
            kt3 kt3Var = kt3.o;
            if (kt3Var != null && kt3Var.z() != null && !TextUtils.isEmpty(kt3.o.z().gamenowChannel)) {
                str4 = kt3.o.z().gamenowChannel;
            }
            try {
                jSONObject.put("error_code", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("packagename", str);
                jSONObject.put("downloadurl", str2);
                jSONObject.put("channel", str4);
                jSONObject.put("currentBytes", j);
                jSONObject.put("totalBytes", j2);
                jSONObject.put("errorReason", i2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("fileMd5", str3);
                }
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) pa4.h(sm2.c()).postRequest().cookieManager(sm2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
