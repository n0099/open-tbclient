package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class db1 {
    public static /* synthetic */ Interceptable $ic;
    public static bb1 a;
    public static cb1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947698678, "Lcom/baidu/tieba/db1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947698678, "Lcom/baidu/tieba/db1;");
        }
    }

    public static bb1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (rk0.class) {
                    if (a == null) {
                        a = (bb1) ServiceManager.getService(bb1.a);
                    }
                    if (a == null) {
                        a = bb1.b;
                    }
                }
            }
            return a;
        }
        return (bb1) invokeV.objValue;
    }

    public static cb1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (rk0.class) {
                    if (b == null) {
                        b = (cb1) ServiceManager.getService(cb1.a);
                    }
                    if (b == null) {
                        b = cb1.b;
                    }
                }
            }
            return b;
        }
        return (cb1) invokeV.objValue;
    }
}
