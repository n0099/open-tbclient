package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fj1 {
    public static /* synthetic */ Interceptable $ic;
    public static dj1 a;
    public static ej1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947765948, "Lcom/baidu/tieba/fj1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947765948, "Lcom/baidu/tieba/fj1;");
        }
    }

    public static dj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (tn0.class) {
                    if (a == null) {
                        a = (dj1) ServiceManager.getService(dj1.a);
                    }
                    if (a == null) {
                        a = dj1.b;
                    }
                }
            }
            return a;
        }
        return (dj1) invokeV.objValue;
    }

    public static ej1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (tn0.class) {
                    if (b == null) {
                        b = (ej1) ServiceManager.getService(ej1.a);
                    }
                    if (b == null) {
                        b = ej1.b;
                    }
                }
            }
            return b;
        }
        return (ej1) invokeV.objValue;
    }
}
