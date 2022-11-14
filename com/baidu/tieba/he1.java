package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class he1 {
    public static /* synthetic */ Interceptable $ic;
    public static fe1 a;
    public static ge1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947820725, "Lcom/baidu/tieba/he1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947820725, "Lcom/baidu/tieba/he1;");
        }
    }

    public static fe1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (rm0.class) {
                    if (a == null) {
                        a = (fe1) ServiceManager.getService(fe1.a);
                    }
                    if (a == null) {
                        a = fe1.b;
                    }
                }
            }
            return a;
        }
        return (fe1) invokeV.objValue;
    }

    public static ge1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (rm0.class) {
                    if (b == null) {
                        b = (ge1) ServiceManager.getService(ge1.a);
                    }
                    if (b == null) {
                        b = ge1.b;
                    }
                }
            }
            return b;
        }
        return (ge1) invokeV.objValue;
    }
}
