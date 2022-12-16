package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class g84 {
    public static /* synthetic */ Interceptable $ic;
    public static Object a;
    public static Method b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947747782, "Lcom/baidu/tieba/g84;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947747782, "Lcom/baidu/tieba/g84;");
        }
    }

    public static boolean a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, strArr)) == null) {
            if (!c) {
                e();
            }
            Method method = b;
            if (method == null) {
                return false;
            }
            try {
                method.invoke(a, strArr);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) {
            if (!f()) {
                return true;
            }
            if (cls == null) {
                return false;
            }
            return a(b(cls.getName()));
        }
        return invokeL.booleanValue;
    }

    public static boolean d(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, strArr)) == null) {
            if (!f()) {
                return true;
            }
            if (strArr != null && strArr.length > 0) {
                return a(strArr);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String replaceAll = str.replaceAll(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, "/");
            if (!replaceAll.startsWith(PreferencesUtil.LEFT_MOUNT)) {
                return "L" + replaceAll + ";";
            }
            return replaceAll;
        }
        return (String) invokeL.objValue;
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (g84.class) {
                if (c) {
                    return;
                }
                try {
                    c = true;
                    Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                    Method b2 = h84.b(cls, "getRuntime", new Class[0]);
                    if (b2 != null) {
                        b2.setAccessible(true);
                        Object invoke = b2.invoke(null, new Object[0]);
                        a = invoke;
                        if (invoke != null) {
                            Method b3 = h84.b(cls, "setHiddenApiExemptions", String[].class);
                            b = b3;
                            if (b3 != null) {
                                b3.setAccessible(true);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (Build.VERSION.SDK_INT > 29) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
