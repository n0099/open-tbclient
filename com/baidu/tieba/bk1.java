package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bk1 {
    public static /* synthetic */ Interceptable $ic;
    public static zj1 a;
    public static ak1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947647745, "Lcom/baidu/tieba/bk1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947647745, "Lcom/baidu/tieba/bk1;");
        }
    }

    public static zj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (fo0.class) {
                    if (a == null) {
                        a = (zj1) ServiceManager.getService(zj1.a);
                    }
                    if (a == null) {
                        a = zj1.b;
                    }
                }
            }
            return a;
        }
        return (zj1) invokeV.objValue;
    }

    public static ak1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (fo0.class) {
                    if (b == null) {
                        b = (ak1) ServiceManager.getService(ak1.a);
                    }
                    if (b == null) {
                        b = ak1.b;
                    }
                }
            }
            return b;
        }
        return (ak1) invokeV.objValue;
    }
}
