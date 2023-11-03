package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class al0 {
    public static /* synthetic */ Interceptable $ic;
    public static xk0 a;
    public static zk0 b;
    public static wk0 c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947618884, "Lcom/baidu/tieba/al0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947618884, "Lcom/baidu/tieba/al0;");
        }
    }

    public al0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static wk0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (al0.class) {
                    if (c == null) {
                        c = (wk0) ServiceManager.getService(wk0.a);
                    }
                    if (c == null) {
                        c = wk0.b;
                    }
                }
            }
            return c;
        }
        return (wk0) invokeV.objValue;
    }

    public static xk0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (al0.class) {
                    if (a == null) {
                        a = (xk0) ServiceManager.getService(xk0.a);
                    }
                    if (a == null) {
                        a = xk0.b;
                    }
                }
            }
            return a;
        }
        return (xk0) invokeV.objValue;
    }

    public static zk0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                synchronized (al0.class) {
                    if (b == null) {
                        b = (zk0) ServiceManager.getService(zk0.a);
                    }
                    if (b == null) {
                        b = zk0.b;
                    }
                }
            }
            return b;
        }
        return (zk0) invokeV.objValue;
    }
}
