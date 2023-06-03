package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ak1 {
    public static /* synthetic */ Interceptable $ic;
    public static yj1 a;
    public static zj1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947617954, "Lcom/baidu/tieba/ak1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947617954, "Lcom/baidu/tieba/ak1;");
        }
    }

    public static yj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (eo0.class) {
                    if (a == null) {
                        a = (yj1) ServiceManager.getService(yj1.a);
                    }
                    if (a == null) {
                        a = yj1.b;
                    }
                }
            }
            return a;
        }
        return (yj1) invokeV.objValue;
    }

    public static zj1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (eo0.class) {
                    if (b == null) {
                        b = (zj1) ServiceManager.getService(zj1.a);
                    }
                    if (b == null) {
                        b = zj1.b;
                    }
                }
            }
            return b;
        }
        return (zj1) invokeV.objValue;
    }
}
