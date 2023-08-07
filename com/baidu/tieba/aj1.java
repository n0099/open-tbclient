package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class aj1 {
    public static /* synthetic */ Interceptable $ic;
    public static yi1 a;
    public static zi1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947616993, "Lcom/baidu/tieba/aj1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947616993, "Lcom/baidu/tieba/aj1;");
        }
    }

    public static yi1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (qn0.class) {
                    if (a == null) {
                        a = (yi1) ServiceManager.getService(yi1.a);
                    }
                    if (a == null) {
                        a = yi1.b;
                    }
                }
            }
            return a;
        }
        return (yi1) invokeV.objValue;
    }

    public static zi1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (qn0.class) {
                    if (b == null) {
                        b = (zi1) ServiceManager.getService(zi1.a);
                    }
                    if (b == null) {
                        b = zi1.b;
                    }
                }
            }
            return b;
        }
        return (zi1) invokeV.objValue;
    }
}
