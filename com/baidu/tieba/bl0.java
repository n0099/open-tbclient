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
public class bl0 {
    public static /* synthetic */ Interceptable $ic;
    public static yk0 a;
    public static al0 b;
    public static xk0 c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947648675, "Lcom/baidu/tieba/bl0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947648675, "Lcom/baidu/tieba/bl0;");
        }
    }

    public bl0() {
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

    public static xk0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (bl0.class) {
                    if (c == null) {
                        c = (xk0) ServiceManager.getService(xk0.a);
                    }
                    if (c == null) {
                        c = xk0.b;
                    }
                }
            }
            return c;
        }
        return (xk0) invokeV.objValue;
    }

    public static yk0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (bl0.class) {
                    if (a == null) {
                        a = (yk0) ServiceManager.getService(yk0.a);
                    }
                    if (a == null) {
                        a = yk0.b;
                    }
                }
            }
            return a;
        }
        return (yk0) invokeV.objValue;
    }

    public static al0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                synchronized (bl0.class) {
                    if (b == null) {
                        b = (al0) ServiceManager.getService(al0.a);
                    }
                    if (b == null) {
                        b = al0.b;
                    }
                }
            }
            return b;
        }
        return (al0) invokeV.objValue;
    }
}
