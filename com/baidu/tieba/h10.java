package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public class h10 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (TextUtils.isEmpty(a)) {
                return PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return g(context, "rtc");
        }
        return (String) invokeL.objValue;
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = PassBiometricUtil.CPU_TYPE_ARMEABI_V7A;
            }
            a = str;
        }
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            return d(context, str, b(context));
        }
        return (String) invokeLL.objValue;
    }

    public static String d(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = b(context);
            }
            return str2 + File.separator + f(str);
        }
        return (String) invokeLLL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            byte[] bytes = "K\u007f@xpU+#HZX\"K!\\d".getBytes();
            if (bytes == null) {
                bytes = null;
            } else {
                int length = bytes.length;
                for (int i = 0; i < length; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 18);
                }
            }
            return new String(y.a(new String(bytes)));
        }
        return (String) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return File.separator + "5.5.2" + File.separator + l();
        }
        return (String) invokeV.objValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            String str = "https://rtc-so.cdn.bcebos.com" + i() + h();
            b = str;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return a() + "_rtc.zip";
        }
        return (String) invokeV.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.contains("?")) {
                str = str.substring(0, str.indexOf("?"));
            }
            return n(str);
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (context == null) {
                return null;
            }
            String absolutePath = context.getFilesDir().getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(absolutePath);
            sb.append(File.separator);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb.append(str);
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        }
        return (String) invokeLL.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String n = n(e() + i() + currentTimeMillis);
            return "?md5hash=" + n + "&timestamp=" + currentTimeMillis;
        }
        return (String) invokeV.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (TextUtils.isEmpty(b)) {
                j();
            }
            return c(context, b) + File.separator + "jniLibs" + File.separator + a();
        }
        return (String) invokeL.objValue;
    }

    public static boolean m(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, context, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                String d = d(context, str, str2);
                return j10.c(d + File.separator + "jniLibs" + File.separator + a() + File.separator + "libjingle_peerconnection_so.so");
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                String str2 = "";
                for (byte b2 : MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() == 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("0");
                        sb.append(hexString);
                        hexString = sb.toString();
                    }
                    str2 = str2 + hexString;
                }
                return str2.toLowerCase();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
