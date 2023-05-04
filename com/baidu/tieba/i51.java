package com.baidu.tieba;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public final class i51 {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public static String[] b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface a {
        void onEvent(String str, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947804388, "Lcom/baidu/tieba/i51;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947804388, "Lcom/baidu/tieba/i51;");
                return;
            }
        }
        b = new String[]{"lib/arm64-v8a", "lib/armeabi", "lib/x86", "lib/mips"};
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                return Process.is64Bit();
            }
            if (i < 21) {
                return false;
            }
            String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
            if (strArr.length <= 0) {
                return false;
            }
            return Build.CPU_ABI.equals(strArr[0]);
        }
        return invokeV.booleanValue;
    }

    public static long a(InputStream inputStream, OutputStream outputStream, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, inputStream, outputStream, i)) == null) {
            if (inputStream != null && outputStream != null) {
                try {
                    byte[] bArr = new byte[i * 1024];
                    long j = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            outputStream.write(bArr, 0, read);
                            j += read;
                        } else {
                            outputStream.flush();
                            return j;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return 0L;
        }
        return invokeLLI.longValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!str.startsWith("lib")) {
                str2 = "lib" + str;
            } else {
                str2 = str;
            }
            if (!str.endsWith(".so")) {
                return str2 + ".so";
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("lib") && str.endsWith(".so") && (split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX)) != null && split.length == 2) {
                return split[0].substring(3);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void e(String str, String str2) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) && (aVar = a) != null) {
            aVar.onEvent(str, str2);
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, str) == null) && !TextUtils.isEmpty(str)) {
            e("24", str);
        }
    }
}
