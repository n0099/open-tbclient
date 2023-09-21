package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ij1 {
    public static /* synthetic */ Interceptable $ic;
    public static gj1 a;
    public static hj1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947855321, "Lcom/baidu/tieba/ij1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947855321, "Lcom/baidu/tieba/ij1;");
        }
    }

    public static gj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (tn0.class) {
                    if (a == null) {
                        a = (gj1) ServiceManager.getService(gj1.a);
                    }
                    if (a == null) {
                        a = gj1.b;
                    }
                }
            }
            return a;
        }
        return (gj1) invokeV.objValue;
    }

    public static hj1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (tn0.class) {
                    if (b == null) {
                        b = (hj1) ServiceManager.getService(hj1.a);
                    }
                    if (b == null) {
                        b = hj1.b;
                    }
                }
            }
            return b;
        }
        return (hj1) invokeV.objValue;
    }
}
