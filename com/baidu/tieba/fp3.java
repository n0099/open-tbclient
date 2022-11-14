package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class fp3 {
    public static /* synthetic */ Interceptable $ic;
    public static Method a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947771776, "Lcom/baidu/tieba/fp3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947771776, "Lcom/baidu/tieba/fp3;");
                return;
            }
        }
        try {
            a = j84.i(j84.b("android.os.SystemProperties", true), "get", String.class);
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            Method method = a;
            if (method != null) {
                try {
                    return (String) method.invoke(null, str);
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
