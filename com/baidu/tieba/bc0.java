package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class bc0 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static boolean b;
    public static String c;
    public static ArrayList<String> d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947640026, "Lcom/baidu/tieba/bc0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947640026, "Lcom/baidu/tieba/bc0;");
                return;
            }
        }
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            l(appInfoService.isDebug());
        }
        a = bc0.class.getName();
        b = false;
        c = null;
        d = new ArrayList<>();
    }

    public bc0() {
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

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return b;
        }
        return invokeV.booleanValue;
    }

    public static String a(boolean z, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), str, str2, str3})) == null) {
            if (!i()) {
                return null;
            }
            String str4 = c;
            if (str4 != null && !str3.startsWith(str4)) {
                return null;
            }
            if (z && !j(str)) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer.append(str);
            stringBuffer.append(":");
            stringBuffer.append(str2);
            stringBuffer.append(":");
            stringBuffer.append(str3);
            return stringBuffer.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static void b(String str, String str2, String str3) {
        String a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, str, str2, str3) == null) && (a2 = a(true, str, str2, str3)) != null) {
            Log.d(a, a2);
        }
    }

    public static void f(String str, String str2, String str3) {
        String a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65543, null, str, str2, str3) == null) && (a2 = a(false, str, str2, str3)) != null) {
            Log.e(a, a2);
        }
    }

    public static void h(String str, String str2, String str3) {
        String a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65545, null, str, str2, str3) == null) && (a2 = a(true, str, str2, str3)) != null) {
            Log.i(a, a2);
        }
    }

    public static void m(String str, String str2, String str3) {
        String a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65550, null, str, str2, str3) == null) && (a2 = a(true, str, str2, str3)) != null) {
            Log.v(a, a2);
        }
    }

    public static void n(String str, String str2, String str3) {
        String a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65551, null, str, str2, str3) == null) && (a2 = a(false, str, str2, str3)) != null) {
            Log.w(a, a2);
        }
    }

    public static int c(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, th)) == null) {
            if (i() && th != null) {
                Log.e(a, th.getMessage(), th);
                return k(0, th.getMessage());
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return k(0, str);
        }
        return invokeL.intValue;
    }

    public static int e(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, th)) == null) {
            return k(0, th.getMessage());
        }
        return invokeL.intValue;
    }

    public static int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return k(2, str);
        }
        return invokeL.intValue;
    }

    public static void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            b = z;
        }
    }

    public static boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            boolean z = false;
            if (d.size() == 0) {
                return false;
            }
            Iterator<String> it = d.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next())) {
                    z = true;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static int k(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65548, null, i, str)) == null) {
            if (!i()) {
                return -1;
            }
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length < 5) {
                return -1;
            }
            StackTraceElement stackTraceElement = stackTrace[4];
            String methodName = stackTraceElement.getMethodName();
            String className = stackTraceElement.getClassName();
            if (i > 1 && !j(className)) {
                return -1;
            }
            if (i == 0) {
                f(className, methodName, str);
                return 0;
            } else if (i == 1) {
                n(className, methodName, str);
                return 0;
            } else if (i == 2) {
                h(className, methodName, str);
                return 0;
            } else if (i == 3) {
                b(className, methodName, str);
                return 0;
            } else {
                m(className, methodName, str);
                return 0;
            }
        }
        return invokeIL.intValue;
    }
}
