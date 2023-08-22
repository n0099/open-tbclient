package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class aab {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v9b a;
    public static s9b b;
    public static u9b c;
    public static t9b d;
    public static u8b e;
    public static y8b f;
    public transient /* synthetic */ FieldHolder $fh;

    public aab() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static v9b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (aab.class) {
                if (a == null) {
                    a = z9b.a();
                }
            }
            return a;
        }
        return (v9b) invokeV.objValue;
    }

    public static s9b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            s9b s9bVar = b;
            if (s9bVar != null) {
                return s9bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                b = a.a();
            }
            return b;
        }
        return (s9b) invokeV.objValue;
    }

    public static t9b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            t9b t9bVar = d;
            if (t9bVar != null) {
                return t9bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                d = a.e();
            }
            return d;
        }
        return (t9b) invokeV.objValue;
    }

    public static u9b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            u9b u9bVar = c;
            if (u9bVar != null) {
                return u9bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                c = a.b();
            }
            return c;
        }
        return (u9b) invokeV.objValue;
    }

    public static u8b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            u8b u8bVar = e;
            if (u8bVar != null) {
                return u8bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                e = a.c();
            }
            return e;
        }
        return (u8b) invokeV.objValue;
    }

    public static y8b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            y8b y8bVar = f;
            if (y8bVar != null) {
                return y8bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f = a.d();
            }
            return f;
        }
        return (y8b) invokeV.objValue;
    }
}
