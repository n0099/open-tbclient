package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ge1 {
    public static /* synthetic */ Interceptable $ic;
    public static ee1 a;
    public static fe1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947790934, "Lcom/baidu/tieba/ge1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947790934, "Lcom/baidu/tieba/ge1;");
        }
    }

    public static ee1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (qm0.class) {
                    if (a == null) {
                        a = (ee1) ServiceManager.getService(ee1.a);
                    }
                    if (a == null) {
                        a = ee1.b;
                    }
                }
            }
            return a;
        }
        return (ee1) invokeV.objValue;
    }

    public static fe1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (qm0.class) {
                    if (b == null) {
                        b = (fe1) ServiceManager.getService(fe1.a);
                    }
                    if (b == null) {
                        b = fe1.b;
                    }
                }
            }
            return b;
        }
        return (fe1) invokeV.objValue;
    }
}
