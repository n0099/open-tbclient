package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hj1 {
    public static /* synthetic */ Interceptable $ic;
    public static fj1 a;
    public static gj1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947825530, "Lcom/baidu/tieba/hj1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947825530, "Lcom/baidu/tieba/hj1;");
        }
    }

    public static fj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ln0.class) {
                    if (a == null) {
                        a = (fj1) ServiceManager.getService(fj1.a);
                    }
                    if (a == null) {
                        a = fj1.b;
                    }
                }
            }
            return a;
        }
        return (fj1) invokeV.objValue;
    }

    public static gj1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (ln0.class) {
                    if (b == null) {
                        b = (gj1) ServiceManager.getService(gj1.a);
                    }
                    if (b == null) {
                        b = gj1.b;
                    }
                }
            }
            return b;
        }
        return (gj1) invokeV.objValue;
    }
}
