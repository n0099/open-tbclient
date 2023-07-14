package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h4b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c4b a;
    public static z3b b;
    public static b4b c;
    public static a4b d;
    public static b3b e;
    public static f3b f;
    public transient /* synthetic */ FieldHolder $fh;

    public h4b() {
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

    public static c4b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (h4b.class) {
                if (a == null) {
                    a = g4b.a();
                }
            }
            return a;
        }
        return (c4b) invokeV.objValue;
    }

    public static z3b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            z3b z3bVar = b;
            if (z3bVar != null) {
                return z3bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                b = a.a();
            }
            return b;
        }
        return (z3b) invokeV.objValue;
    }

    public static a4b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            a4b a4bVar = d;
            if (a4bVar != null) {
                return a4bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                d = a.e();
            }
            return d;
        }
        return (a4b) invokeV.objValue;
    }

    public static b4b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            b4b b4bVar = c;
            if (b4bVar != null) {
                return b4bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                c = a.b();
            }
            return c;
        }
        return (b4b) invokeV.objValue;
    }

    public static b3b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            b3b b3bVar = e;
            if (b3bVar != null) {
                return b3bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                e = a.c();
            }
            return e;
        }
        return (b3b) invokeV.objValue;
    }

    public static f3b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            f3b f3bVar = f;
            if (f3bVar != null) {
                return f3bVar;
            }
            if (a == null) {
                a = d();
            }
            if (a != null) {
                f = a.d();
            }
            return f;
        }
        return (f3b) invokeV.objValue;
    }
}
