package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ek1 {
    public static /* synthetic */ Interceptable $ic;
    public static ck1 a;
    public static dk1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947737118, "Lcom/baidu/tieba/ek1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947737118, "Lcom/baidu/tieba/ek1;");
        }
    }

    public static ck1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (io0.class) {
                    if (a == null) {
                        a = (ck1) ServiceManager.getService(ck1.a);
                    }
                    if (a == null) {
                        a = ck1.b;
                    }
                }
            }
            return a;
        }
        return (ck1) invokeV.objValue;
    }

    public static dk1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (io0.class) {
                    if (b == null) {
                        b = (dk1) ServiceManager.getService(dk1.a);
                    }
                    if (b == null) {
                        b = dk1.b;
                    }
                }
            }
            return b;
        }
        return (dk1) invokeV.objValue;
    }
}
