package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.down.utils.Constants;
import com.baidu.lcp.sdk.pb.LcmPb$Common;
import com.baidu.tieba.h80;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Long.valueOf(j), str, str2}) == null) {
            try {
                h80.c cVar = new h80.c(context);
                cVar.e(str);
                cVar.f("1");
                cVar.c(j);
                cVar.d(str2);
                cVar.a(501112L);
                cVar.b();
            } catch (Exception e) {
                l90.c("LCPCommon", "businessEvent exception ", e);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String f(String str, String str2, String str3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{str, str2, str3, Long.valueOf(j)})) == null) {
            return e(String.format("%s%s%s%d", str, str2, str3, Long.valueOf(j)));
        }
        return (String) invokeCommon.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                l90.c("LCPCommon", "getAppVersionName NameNotFoundException", e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static Object c(Context context, boolean z) {
        InterceptResult invokeLZ;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, context, z)) == null) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = Build.VERSION.RELEASE;
            String str2 = Build.MANUFACTURER;
            String str3 = Build.MODEL;
            if (TextUtils.isEmpty(b(context))) {
                b = "";
            } else {
                b = b(context);
            }
            long currentTimeMillis = System.currentTimeMillis();
            String b2 = m90.b(context);
            String e = m90.e(context);
            try {
                if (z) {
                    if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(e)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, valueOf);
                        jSONObject.put("cuid", e);
                        jSONObject.put(HttpConstants.DEVICE_TYPE, "android");
                        jSONObject.put(HttpConstants.OS_VERSION, str);
                        jSONObject.put("manufacture", str2);
                        jSONObject.put(ARPMessageType.ARPMessageParamKeys.MODEL_TYPE_KEY, str3);
                        jSONObject.put("app_id", m90.b(context));
                        jSONObject.put("app_version", b);
                        jSONObject.put("sdk_version", "2280016");
                        jSONObject.put("ts", currentTimeMillis);
                        jSONObject.put("sign", f(b2, e, "android", currentTimeMillis));
                        return jSONObject;
                    }
                    l90.b("LCPCommon", "getData appId : " + b2 + ", cuid :" + e);
                    return null;
                }
                String str4 = "nonNet";
                if (RequsetNetworkUtils.isNetworkAvailable(context)) {
                    if (RequsetNetworkUtils.isWifiConnected(context)) {
                        str4 = "wifi";
                    } else {
                        str4 = RequsetNetworkUtils.getMobileType(context);
                    }
                }
                LcmPb$Common.b newBuilder = LcmPb$Common.newBuilder();
                newBuilder.w(e);
                newBuilder.x("android");
                newBuilder.B(str);
                newBuilder.y(str2);
                newBuilder.z(str3);
                newBuilder.u(b2);
                newBuilder.v(b);
                newBuilder.D("2280016");
                newBuilder.A(str4);
                newBuilder.C(d(context));
                return newBuilder.build();
            } catch (Exception e2) {
                l90.c("LCPCommon", "getData :", e2);
                return null;
            }
        }
        return invokeLZ.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            String str3 = "";
            if (upperCase.contains("XIAOMI")) {
                str = "ro.miui.ui.version.code";
            } else if (upperCase.contains("HUAWEI")) {
                str = "ro.build.version.emui";
            } else if (upperCase.contains("MEIZU")) {
                str = RomUtils.PROP_RO_BUILD_DISPLAY_ID;
            } else if (upperCase.contains("OPPO")) {
                str = "ro.build.version.opporom";
            } else if (!upperCase.contains("VIVO")) {
                str = "";
            } else {
                str = "ro.vivo.os.version";
            }
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    str2 = SystemProperties.get(str);
                } else {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
                }
                str3 = str2;
            } catch (Throwable unused) {
                if (Build.VERSION.SDK_INT >= 21 && upperCase.contains("HUAWEI")) {
                    return Constants.SDK_VER;
                }
                if (upperCase.contains("HUAWEI")) {
                    return "1.0";
                }
                if (upperCase.contains("XIAOMI")) {
                    return "4.0";
                }
                if (upperCase.contains("MEIZU")) {
                    return "6.0";
                }
                if (upperCase.contains("OPPO")) {
                    return "3.0";
                }
                if (upperCase.contains("VIVO")) {
                    return "3.2";
                }
            }
            if (upperCase.contains("HUAWEI") && !TextUtils.isEmpty(str3)) {
                String substring = str3.substring(str3.indexOf("_") + 1, str3.length());
                if (!substring.matches("\\d+\\.\\d+$") && Build.VERSION.SDK_INT >= 21) {
                    return Constants.SDK_VER;
                }
                return substring;
            }
            if (upperCase.contains("MEIZU")) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = Build.DISPLAY;
                }
                Matcher matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(str3);
                if (matcher.find()) {
                    str3 = matcher.group();
                }
            } else if (upperCase.contains("OPPO") && !TextUtils.isEmpty(str3)) {
                Matcher matcher2 = Pattern.compile("^V(\\d+\\.\\d+)").matcher(str3);
                if (matcher2.find()) {
                    str3 = matcher2.group(1);
                }
            } else if (upperCase.contains("VIVO") && !TextUtils.isEmpty(str3)) {
                Matcher matcher3 = Pattern.compile("^\\d+(\\.\\d+)?").matcher(str3);
                if (matcher3.find()) {
                    return matcher3.group();
                }
            }
            return str3;
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    int i = b & 255;
                    if (i < 16) {
                        sb.append(0);
                    }
                    sb.append(Integer.toHexString(i));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
