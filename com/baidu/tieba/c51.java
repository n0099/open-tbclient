package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c51 {
    public static /* synthetic */ Interceptable $ic;
    public static f51 a;
    public static i51 b;
    public static j51 c;
    public static m41 d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947625642, "Lcom/baidu/tieba/c51;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947625642, "Lcom/baidu/tieba/c51;");
        }
    }

    public c51() {
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

    public static f51 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (c51.class) {
                    if (a == null) {
                        a = (f51) ServiceManager.getService(f51.a);
                    }
                    if (a == null) {
                        a = f51.b;
                    }
                }
            }
            return a;
        }
        return (f51) invokeV.objValue;
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? zi0.b() : (Context) invokeV.objValue;
    }

    public static g51 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? g51.a : (g51) invokeV.objValue;
    }

    public static d51 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? d51.a : (d51) invokeV.objValue;
    }

    public static e51 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? e51.a : (e51) invokeV.objValue;
    }

    public static m41 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (d == null) {
                synchronized (c51.class) {
                    if (d == null) {
                        d = (m41) ServiceManager.getService(m41.a);
                    }
                    if (d == null) {
                        d = m41.b;
                    }
                }
            }
            return d;
        }
        return (m41) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? qm0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static i51 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (b == null) {
                synchronized (c51.class) {
                    if (b == null) {
                        b = (i51) ServiceManager.getService(i51.a);
                    }
                    if (b == null) {
                        b = i51.b;
                    }
                }
            }
            return b;
        }
        return (i51) invokeV.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? qm0.b().a().a("nad_web_view_type_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static j51 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (c == null) {
                synchronized (c51.class) {
                    if (c == null) {
                        c = (j51) ServiceManager.getService(j51.a);
                    }
                    if (c == null) {
                        c = j51.b;
                    }
                }
            }
            return c;
        }
        return (j51) invokeV.objValue;
    }
}
