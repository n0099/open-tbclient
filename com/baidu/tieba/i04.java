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
/* loaded from: classes4.dex */
public class i04 {
    public static /* synthetic */ Interceptable $ic;
    public static i04 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947799676, "Lcom/baidu/tieba/i04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947799676, "Lcom/baidu/tieba/i04;");
                return;
            }
        }
        a = new i04();
    }

    public i04() {
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

    public static i04 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (i04) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c82.f("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "12", "swan");
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            og3 og3Var = new og3();
            og3Var.b = "beforeConfigRequest";
            og3Var.e = str;
            fg3.g(og3Var);
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            GameGuideConfigInfo z = lz3.o.z();
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
            og3 og3Var = new og3();
            og3Var.b = str;
            og3Var.g = "gbview";
            og3Var.e = str2;
            og3Var.a("gameAppkey", str3);
            og3Var.a("gamePosition", str4);
            og3Var.a("configName", str5);
            og3Var.a("targetPackageName", str6);
            og3Var.a("targetDownloadUrl", str7);
            fg3.g(og3Var);
        }
    }

    public void c(String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            GameGuideConfigInfo z = lz3.o.z();
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
            og3 og3Var = new og3();
            og3Var.b = str;
            og3Var.g = "gbview";
            og3Var.a("configName", str2);
            og3Var.a("targetPackageName", str3);
            og3Var.a("targetDownloadUrl", str4);
            if (str3.equals(qz3.a)) {
                if (gn3.F(ts2.c(), str3)) {
                    og3Var.a("isGamenowInstalled", "1");
                } else {
                    og3Var.a("isGamenowInstalled", "2");
                }
            }
            fg3.g(og3Var);
        }
    }

    public void d(String str, boolean z, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
            og3 og3Var = new og3();
            og3Var.b = "request";
            og3Var.g = "wdview";
            og3Var.a("requestStatus", str);
            if (z) {
                str3 = "0";
            } else {
                str3 = "1";
            }
            og3Var.a("isFromNet", str3);
            og3Var.a(StatConstants.KEY_EXT_ERR_MSG, str2);
            fg3.g(og3Var);
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
            GameGuideConfigInfo z = lz3.o.z();
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
            og3 og3Var = new og3();
            og3Var.b = "wdDialogClick";
            og3Var.g = "wdview";
            og3Var.e = str;
            og3Var.a("coinsThisTime", String.valueOf(i));
            og3Var.a("coinsTotal", String.valueOf(i2));
            og3Var.a("configName", str2);
            og3Var.a("targetPackageName", str3);
            og3Var.a("targetDownloadUrl", str4);
            fg3.g(og3Var);
        }
    }

    public void m(String str, String str2, int i) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, str, str2, i) == null) {
            GameGuideConfigInfo z = lz3.o.z();
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
            og3 og3Var = new og3();
            og3Var.g = str;
            og3Var.e = str2;
            og3Var.a("configName", str3);
            og3Var.a("targetPackageName", str4);
            og3Var.a("targetDownloadUrl", str5);
            og3Var.a("GamenowDownloadStatus", Integer.valueOf(i));
            fg3.g(og3Var);
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        String str8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            GameGuideConfigInfo z = lz3.o.z();
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
            if (!TextUtils.equals(str8, qz3.a)) {
                str6 = str9;
            }
            og3 og3Var = new og3();
            og3Var.b = str;
            og3Var.g = str2;
            og3Var.e = str3;
            og3Var.a("gameAppkey", str4);
            og3Var.a("gamePosition", str5);
            og3Var.a("configName", str7);
            og3Var.a("targetPackageName", str8);
            og3Var.a("targetDownloadUrl", str6);
            fg3.g(og3Var);
        }
    }

    public void f(String str, h04 h04Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, h04Var, str2, str3, str4) == null) {
            JSONObject d = mm3.d(str3);
            j04 j04Var = new j04();
            j04Var.g(h04Var);
            j04Var.b = str;
            j04Var.g = d.optString("from_view");
            j04Var.e = d.optString("from_value");
            j04Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            j04Var.a("targetPackageName", str2);
            j04Var.a("targetDownloadUrl", str4);
            fg3.g(j04Var);
        }
    }

    public void g(String str, h04 h04Var, String str2, String str3, int i, String str4) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, h04Var, str2, str3, Integer.valueOf(i), str4}) == null) {
            JSONObject d = mm3.d(str3);
            long optLong = d.optLong("download_finish_time");
            if (optLong != 0) {
                j = SystemClock.elapsedRealtime() - optLong;
            } else {
                j = 0;
            }
            j04 j04Var = new j04();
            j04Var.g(h04Var);
            j04Var.e = d.optString("from_value");
            j04Var.b = str;
            j04Var.g = d.optString("from_view");
            j04Var.a("error_code", Integer.valueOf(i));
            j04Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            if (j != 0) {
                j04Var.a("timeAfterDownload", Long.valueOf(j));
            }
            j04Var.a("targetPackageName", str2);
            j04Var.a("targetDownloadUrl", str4);
            if (TextUtils.equals(str, "package_expired")) {
                j04Var.a("downloadStatus", d.optString("download_status"));
            }
            if (TextUtils.equals(str, "analysisFailed")) {
                long optLong2 = d.optLong("download_current_bytes");
                long optLong3 = d.optLong("download_total_bytes");
                j04Var.a("downloadCurrentBytes", Long.valueOf(optLong2));
                j04Var.a("downloadTotalBytes", Long.valueOf(optLong3));
            }
            fg3.x("936", j04Var);
        }
    }

    public void h(String str, h04 h04Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, h04Var, str2, str3, str4) == null) {
            g(str, h04Var, str2, str3, 0, str4);
        }
    }

    public void i(int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            GameGuideConfigInfo z = lz3.o.z();
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
            og3 og3Var = new og3();
            og3Var.b = "guideClick";
            og3Var.g = "wdview";
            og3Var.a("guideViewNum", String.valueOf(i));
            og3Var.a("configName", str);
            og3Var.a("targetPackageName", str2);
            og3Var.a("targetDownloadUrl", str3);
            fg3.g(og3Var);
        }
    }

    public void k(int i, int i2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            GameGuideConfigInfo z = lz3.o.z();
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
            og3 og3Var = new og3();
            og3Var.b = "wdDialogShow";
            og3Var.g = "wdview";
            og3Var.a("coinsThisTime", String.valueOf(i));
            og3Var.a("coinsTotal", String.valueOf(i2));
            og3Var.a("configName", str);
            og3Var.a("targetPackageName", str2);
            og3Var.a("targetDownloadUrl", str3);
            if (str2.equals(qz3.a)) {
                if (gn3.F(ts2.c(), str2)) {
                    og3Var.a("isGamenowInstalled", "1");
                } else {
                    og3Var.a("isGamenowInstalled", "2");
                }
            }
            fg3.g(og3Var);
        }
    }

    public void l() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GameGuideConfigInfo z = lz3.o.z();
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
            og3 og3Var = new og3();
            og3Var.b = "guideShow";
            og3Var.g = "wdview";
            og3Var.a("configName", str);
            og3Var.a("targetPackageName", str2);
            og3Var.a("targetDownloadUrl", str3);
            fg3.g(og3Var);
        }
    }

    public void p(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = d64.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", ts2.h0().i(ts2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", ts2.n().a());
                jSONObject.put("version", gn3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) qg4.h(ts2.c()).postRequest().cookieManager(ts2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }

    public void q(int i, String str, String str2, int i2, String str3, long j, long j2) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String d = d64.b().d();
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.equals(str, qz3.a)) {
                str4 = "2101000000";
            } else {
                str4 = "";
            }
            lz3 lz3Var = lz3.o;
            if (lz3Var != null && lz3Var.z() != null && !TextUtils.isEmpty(lz3.o.z().gamenowChannel)) {
                str4 = lz3.o.z().gamenowChannel;
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
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) qg4.h(ts2.c()).postRequest().cookieManager(ts2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
