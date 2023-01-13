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
public class fv3 {
    public static /* synthetic */ Interceptable $ic;
    public static fv3 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947777542, "Lcom/baidu/tieba/fv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947777542, "Lcom/baidu/tieba/fv3;");
                return;
            }
        }
        a = new fv3();
    }

    public fv3() {
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

    public static fv3 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (fv3) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            z22.f("T43rINkXjgPfdKNXTuhQER2KdACVdB00", "12", "swan");
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            lb3 lb3Var = new lb3();
            lb3Var.b = "beforeConfigRequest";
            lb3Var.e = str;
            cb3.g(lb3Var);
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            GameGuideConfigInfo z = iu3.o.z();
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
            lb3 lb3Var = new lb3();
            lb3Var.b = str;
            lb3Var.g = "gbview";
            lb3Var.e = str2;
            lb3Var.a("gameAppkey", str3);
            lb3Var.a("gamePosition", str4);
            lb3Var.a("configName", str5);
            lb3Var.a("targetPackageName", str6);
            lb3Var.a("targetDownloadUrl", str7);
            cb3.g(lb3Var);
        }
    }

    public void c(String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            GameGuideConfigInfo z = iu3.o.z();
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
            lb3 lb3Var = new lb3();
            lb3Var.b = str;
            lb3Var.g = "gbview";
            lb3Var.a("configName", str2);
            lb3Var.a("targetPackageName", str3);
            lb3Var.a("targetDownloadUrl", str4);
            if (str3.equals(nu3.a)) {
                if (di3.F(qn2.c(), str3)) {
                    lb3Var.a("isGamenowInstalled", "1");
                } else {
                    lb3Var.a("isGamenowInstalled", "2");
                }
            }
            cb3.g(lb3Var);
        }
    }

    public void d(String str, boolean z, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
            lb3 lb3Var = new lb3();
            lb3Var.b = "request";
            lb3Var.g = "wdview";
            lb3Var.a("requestStatus", str);
            if (z) {
                str3 = "0";
            } else {
                str3 = "1";
            }
            lb3Var.a("isFromNet", str3);
            lb3Var.a(StatConstants.KEY_EXT_ERR_MSG, str2);
            cb3.g(lb3Var);
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
            GameGuideConfigInfo z = iu3.o.z();
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
            lb3 lb3Var = new lb3();
            lb3Var.b = "wdDialogClick";
            lb3Var.g = "wdview";
            lb3Var.e = str;
            lb3Var.a("coinsThisTime", String.valueOf(i));
            lb3Var.a("coinsTotal", String.valueOf(i2));
            lb3Var.a("configName", str2);
            lb3Var.a("targetPackageName", str3);
            lb3Var.a("targetDownloadUrl", str4);
            cb3.g(lb3Var);
        }
    }

    public void m(String str, String str2, int i) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, str, str2, i) == null) {
            GameGuideConfigInfo z = iu3.o.z();
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
            lb3 lb3Var = new lb3();
            lb3Var.g = str;
            lb3Var.e = str2;
            lb3Var.a("configName", str3);
            lb3Var.a("targetPackageName", str4);
            lb3Var.a("targetDownloadUrl", str5);
            lb3Var.a("GamenowDownloadStatus", Integer.valueOf(i));
            cb3.g(lb3Var);
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        String str8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            GameGuideConfigInfo z = iu3.o.z();
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
            if (!TextUtils.equals(str8, nu3.a)) {
                str6 = str9;
            }
            lb3 lb3Var = new lb3();
            lb3Var.b = str;
            lb3Var.g = str2;
            lb3Var.e = str3;
            lb3Var.a("gameAppkey", str4);
            lb3Var.a("gamePosition", str5);
            lb3Var.a("configName", str7);
            lb3Var.a("targetPackageName", str8);
            lb3Var.a("targetDownloadUrl", str6);
            cb3.g(lb3Var);
        }
    }

    public void f(String str, ev3 ev3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, ev3Var, str2, str3, str4) == null) {
            JSONObject d = jh3.d(str3);
            gv3 gv3Var = new gv3();
            gv3Var.g(ev3Var);
            gv3Var.b = str;
            gv3Var.g = d.optString("from_view");
            gv3Var.e = d.optString("from_value");
            gv3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            gv3Var.a("targetPackageName", str2);
            gv3Var.a("targetDownloadUrl", str4);
            cb3.g(gv3Var);
        }
    }

    public void g(String str, ev3 ev3Var, String str2, String str3, int i, String str4) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, ev3Var, str2, str3, Integer.valueOf(i), str4}) == null) {
            JSONObject d = jh3.d(str3);
            long optLong = d.optLong("download_finish_time");
            if (optLong != 0) {
                j = SystemClock.elapsedRealtime() - optLong;
            } else {
                j = 0;
            }
            gv3 gv3Var = new gv3();
            gv3Var.g(ev3Var);
            gv3Var.e = d.optString("from_value");
            gv3Var.b = str;
            gv3Var.g = d.optString("from_view");
            gv3Var.a("error_code", Integer.valueOf(i));
            gv3Var.a("configName", d.optString(GameGuideConfigInfo.KEY_CONFIG_NAME));
            if (j != 0) {
                gv3Var.a("timeAfterDownload", Long.valueOf(j));
            }
            gv3Var.a("targetPackageName", str2);
            gv3Var.a("targetDownloadUrl", str4);
            if (TextUtils.equals(str, "package_expired")) {
                gv3Var.a("downloadStatus", d.optString("download_status"));
            }
            if (TextUtils.equals(str, "analysisFailed")) {
                long optLong2 = d.optLong("download_current_bytes");
                long optLong3 = d.optLong("download_total_bytes");
                gv3Var.a("downloadCurrentBytes", Long.valueOf(optLong2));
                gv3Var.a("downloadTotalBytes", Long.valueOf(optLong3));
            }
            cb3.x("936", gv3Var);
        }
    }

    public void h(String str, ev3 ev3Var, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, ev3Var, str2, str3, str4) == null) {
            g(str, ev3Var, str2, str3, 0, str4);
        }
    }

    public void i(int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            GameGuideConfigInfo z = iu3.o.z();
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
            lb3 lb3Var = new lb3();
            lb3Var.b = "guideClick";
            lb3Var.g = "wdview";
            lb3Var.a("guideViewNum", String.valueOf(i));
            lb3Var.a("configName", str);
            lb3Var.a("targetPackageName", str2);
            lb3Var.a("targetDownloadUrl", str3);
            cb3.g(lb3Var);
        }
    }

    public void k(int i, int i2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            GameGuideConfigInfo z = iu3.o.z();
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
            lb3 lb3Var = new lb3();
            lb3Var.b = "wdDialogShow";
            lb3Var.g = "wdview";
            lb3Var.a("coinsThisTime", String.valueOf(i));
            lb3Var.a("coinsTotal", String.valueOf(i2));
            lb3Var.a("configName", str);
            lb3Var.a("targetPackageName", str2);
            lb3Var.a("targetDownloadUrl", str3);
            if (str2.equals(nu3.a)) {
                if (di3.F(qn2.c(), str2)) {
                    lb3Var.a("isGamenowInstalled", "1");
                } else {
                    lb3Var.a("isGamenowInstalled", "2");
                }
            }
            cb3.g(lb3Var);
        }
    }

    public void l() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            GameGuideConfigInfo z = iu3.o.z();
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
            lb3 lb3Var = new lb3();
            lb3Var.b = "guideShow";
            lb3Var.g = "wdview";
            lb3Var.a("configName", str);
            lb3Var.a("targetPackageName", str2);
            lb3Var.a("targetDownloadUrl", str3);
            cb3.g(lb3Var);
        }
    }

    public void p(int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, str2, str3}) == null) {
            String d = a14.b().d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid", qn2.h0().i(qn2.c()));
                jSONObject.put("type", i);
                jSONObject.put("time", System.currentTimeMillis() / 1000);
                jSONObject.put("host", qn2.n().a());
                jSONObject.put("version", di3.D());
                jSONObject.put("package", str);
                jSONObject.put("appid", str2);
                jSONObject.put("url", str3);
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) nb4.h(qn2.c()).postRequest().cookieManager(qn2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }

    public void q(int i, String str, String str2, int i2, String str3, long j, long j2) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            String d = a14.b().d();
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.equals(str, nu3.a)) {
                str4 = "2101000000";
            } else {
                str4 = "";
            }
            iu3 iu3Var = iu3.o;
            if (iu3Var != null && iu3Var.z() != null && !TextUtils.isEmpty(iu3.o.z().gamenowChannel)) {
                str4 = iu3.o.z().gamenowChannel;
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
                ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) nb4.h(qn2.c()).postRequest().cookieManager(qn2.q().a())).url(d)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(null);
            } catch (Exception unused) {
            }
        }
    }
}
