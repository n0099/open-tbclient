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
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c04 {
    public static /* synthetic */ Interceptable $ic;
    public static c04 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947620930, "Lcom/baidu/tieba/c04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947620930, "Lcom/baidu/tieba/c04;");
                return;
            }
        }
        a = new c04();
    }

    public c04() {
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

    public static c04 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (c04) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            w72.f("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "12", "swan");
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            ig3 ig3Var = new ig3();
            ig3Var.b = "beforeConfigRequest";
            ig3Var.e = str;
            zf3.g(ig3Var);
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            GameGuideConfigInfo z = fz3.o.z();
            String str7 = "";
            if (z == null) {
                str5 = "";
            } else {
                str5 = z.configName;
            }
            if (z == null) {
                str6 = "";
            } else {
                str6 = z.targetAppPackageId;
            }
            if (z != null) {
                str7 = z.targetAppDownloadUrl;
            }
            ig3 ig3Var = new ig3();
            ig3Var.b = str;
            ig3Var.g = "gbview";
            ig3Var.e = str2;
            ig3Var.a("gameAppkey", str3);
            ig3Var.a("gamePosition", str4);
            ig3Var.a("configName", str5);
            ig3Var.a("targetPackageName", str6);
            ig3Var.a("targetDownloadUrl", str7);
            zf3.g(ig3Var);
        }
    }

    public void c(String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            GameGuideConfigInfo z = fz3.o.z();
            String str4 = "";
            if (z == null) {
                str2 = "";
            } else {
                str2 = z.configName;
            }
            if (z == null) {
                str3 = "";
            } else {
                str3 = z.targetAppPackageId;
            }
            if (z != null) {
                str4 = z.targetAppDownloadUrl;
            }
            ig3 ig3Var = new ig3();
            ig3Var.b = str;
            ig3Var.g = "gbview";
            ig3Var.a("configName", str2);
            ig3Var.a("targetPackageName", str3);
            ig3Var.a("targetDownloadUrl", str4);
            if (str3.equals(kz3.a)) {
                if (an3.F(ns2.c(), str3)) {
                    ig3Var.a("isGamenowInstalled", "1");
                } else {
                    ig3Var.a("isGamenowInstalled", "2");
                }
            }
            zf3.g(ig3Var);
        }
    }

    public void i(int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            GameGuideConfigInfo z = fz3.o.z();
            String str3 = "";
            if (z == null) {
                str = "";
            } else {
                str = z.configName;
            }
            if (z == null) {
                str2 = "";
            } else {
                str2 = z.targetAppPackageId;
            }
            if (z != null) {
                str3 = z.targetAppDownloadUrl;
            }
            ig3 ig3Var = new ig3();
            ig3Var.b = "guideClick";
            ig3Var.g = "wdview";
            ig3Var.a("guideViewNum", String.valueOf(i));
            ig3Var.a("configName", str);
            ig3Var.a("targetPackageName", str2);
            ig3Var.a("targetDownloadUrl", str3);
            zf3.g(ig3Var);
        }
    }

    public void d(String str, boolean z, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
            ig3 ig3Var = new ig3();
            ig3Var.b = "request";
            ig3Var.g = "wdview";
            ig3Var.a("requestStatus", str);
            if (z) {
                str3 = "0";
            } else {
                str3 = "1";
            }
            ig3Var.a("isFromNet", str3);
            ig3Var.a(StatConstants.KEY_EXT_ERR_MSG, str2);
            zf3.g(ig3Var);
            if (TextUtils.equals(str, com.baidu.pass.biometrics.face.liveness.b.a.g0) || (TextUtils.equals(str, "start") && !z)) {
                o();
            }
        }
    }

    public void j(String str, int i, int i2) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048585, this, str, i, i2) == null) {
            GameGuideConfigInfo z = fz3.o.z();
            String str4 = "";
            if (z == null) {
                str2 = "";
            } else {
                str2 = z.configName;
            }
            if (z == null) {
                str3 = "";
            } else {
                str3 = z.targetAppPackageId;
            }
            if (z != null) {
                str4 = z.targetAppDownloadUrl;
            }
            ig3 ig3Var = new ig3();
            ig3Var.b = "wdDialogClick";
            ig3Var.g = "wdview";
            ig3Var.e = str;
            ig3Var.a("coinsThisTime", String.valueOf(i));
            ig3Var.a("coinsTotal", String.valueOf(i2));
            ig3Var.a("configName", str2);
            ig3Var.a("targetPackageName", str3);
            ig3Var.a("targetDownloadUrl", str4);
            zf3.g(ig3Var);
        }
    }

    public void m(String str, String str2, int i) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, str, str2, i) == null) {
            GameGuideConfigInfo z = fz3.o.z();
            String str5 = "";
            if (z == null) {
                str3 = "";
            } else {
                str3 = z.configName;
            }
            if (z == null) {
                str4 = "";
            } else {
                str4 = z.targetAppPackageId;
            }
            if (z != null) {
                str5 = z.targetAppDownloadUrl;
            }
            ig3 ig3Var = new ig3();
            ig3Var.g = str;
            ig3Var.e = str2;
            ig3Var.a("configName", str3);
            ig3Var.a("targetPackageName", str4);
            ig3Var.a("targetDownloadUrl", str5);
            ig3Var.a("GamenowDownloadStatus", Integer.valueOf(i));
            zf3.g(ig3Var);
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        String str8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            GameGuideConfigInfo z = fz3.o.z();
            String str9 = "";
            if (z == null) {
                str7 = "";
            } else {
                str7 = z.configName;
            }
            if (z == null) {
                str8 = "";
            } else {
                str8 = z.targetAppPackageId;
            }
            if (z != null) {
                str9 = z.targetAppDownloadUrl;
            }
            if (!TextUtils.equals(str8, kz3.a)) {
                str6 = str9;
            }
            ig3 ig3Var = new ig3();
            ig3Var.b = str;
            ig3Var.g = str2;
            ig3Var.e = str3;
            ig3Var.a("gameAppkey", str4);
            ig3Var.a("gamePosition", str5);
            ig3Var.a("configName", str7);
            ig3Var.a("targetPackageName", str8);
            ig3Var.a("targetDownloadUrl", str6);
            zf3.g(ig3Var);
        }
    }

    public void f(String str, b04 b04Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, b04Var, str2, str3, str4) == null) {
            JSONObject d = gm3.d(str3);
            d04 d04Var = new d04();
            d04Var.g(b04Var);
            d04Var.b = str;
            d04Var.g = d.optString("from_view");
            d04Var.e = d.optString("from_value");
            d04Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            d04Var.a("targetPackageName", str2);
            d04Var.a("targetDownloadUrl", str4);
            zf3.g(d04Var);
        }
    }

    public void g(String str, b04 b04Var, String str2, String str3, int i, String str4) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, b04Var, str2, str3, Integer.valueOf(i), str4}) == null) {
            JSONObject d = gm3.d(str3);
            long optLong = d.optLong("download_finish_time");
            if (optLong != 0) {
                j = SystemClock.elapsedRealtime() - optLong;
            } else {
                j = 0;
            }
            d04 d04Var = new d04();
            d04Var.g(b04Var);
            d04Var.e = d.optString("from_value");
            d04Var.b = str;
            d04Var.g = d.optString("from_view");
            d04Var.a("error_code", Integer.valueOf(i));
            d04Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            if (j != 0) {
                d04Var.a("timeAfterDownload", Long.valueOf(j));
            }
            d04Var.a("targetPackageName", str2);
            d04Var.a("targetDownloadUrl", str4);
            if (TextUtils.equals(str, "package_expired")) {
                d04Var.a("downloadStatus", d.optString("download_status"));
            }
            if (TextUtils.equals(str, "analysisFailed")) {
                long optLong2 = d.optLong("download_current_bytes");
                long optLong3 = d.optLong("download_total_bytes");
                d04Var.a("downloadCurrentBytes", Long.valueOf(optLong2));
                d04Var.a("downloadTotalBytes", Long.valueOf(optLong3));
            }
            zf3.x("936", d04Var);
        }
    }

    public void h(String str, b04 b04Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, b04Var, str2, str3, str4) == null) {
            g(str, b04Var, str2, str3, 0, str4);
        }
    }

    public void k(int i, int i2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            GameGuideConfigInfo z = fz3.o.z();
            String str3 = "";
            if (z == null) {
                str = "";
            } else {
                str = z.configName;
            }
            if (z == null) {
                str2 = "";
            } else {
                str2 = z.targetAppPackageId;
            }
            if (z != null) {
                str3 = z.targetAppDownloadUrl;
            }
            ig3 ig3Var = new ig3();
            ig3Var.b = "wdDialogShow";
            ig3Var.g = "wdview";
            ig3Var.a("coinsThisTime", String.valueOf(i));
            ig3Var.a("coinsTotal", String.valueOf(i2));
            ig3Var.a("configName", str);
            ig3Var.a("targetPackageName", str2);
            ig3Var.a("targetDownloadUrl", str3);
            if (str2.equals(kz3.a)) {
                if (an3.F(ns2.c(), str2)) {
                    ig3Var.a("isGamenowInstalled", "1");
                } else {
                    ig3Var.a("isGamenowInstalled", "2");
                }
            }
            zf3.g(ig3Var);
        }
    }

    public void l() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GameGuideConfigInfo z = fz3.o.z();
            String str3 = "";
            if (z == null) {
                str = "";
            } else {
                str = z.configName;
            }
            if (z == null) {
                str2 = "";
            } else {
                str2 = z.targetAppPackageId;
            }
            if (z != null) {
                str3 = z.targetAppDownloadUrl;
            }
            ig3 ig3Var = new ig3();
            ig3Var.b = "guideShow";
            ig3Var.g = "wdview";
            ig3Var.a("configName", str);
            ig3Var.a("targetPackageName", str2);
            ig3Var.a("targetDownloadUrl", str3);
            zf3.g(ig3Var);
        }
    }

    public void p(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = x54.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", ns2.h0().i(ns2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", ns2.n().a());
                jSONObject.put("version", an3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) kg4.h(ns2.c()).postRequest().cookieManager(ns2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }

    public void q(int i, String str, String str2, int i2, String str3, long j, long j2) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String d = x54.b().d();
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.equals(str, kz3.a)) {
                str4 = "2101000000";
            } else {
                str4 = "";
            }
            fz3 fz3Var = fz3.o;
            if (fz3Var != null && fz3Var.z() != null && !TextUtils.isEmpty(fz3.o.z().gamenowChannel)) {
                str4 = fz3.o.z().gamenowChannel;
            }
            try {
                jSONObject.put("error_code", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("packagename", str);
                jSONObject.put("downloadurl", str2);
                jSONObject.put("channel", str4);
                jSONObject.put("currentBytes", j);
                jSONObject.put("totalBytes", j2);
                jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, i2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("fileMd5", str3);
                }
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) kg4.h(ns2.c()).postRequest().cookieManager(ns2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
