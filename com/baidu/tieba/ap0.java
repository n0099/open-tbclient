package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class ap0 {
    public static /* synthetic */ Interceptable $ic;
    public static fp0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static dp0 a(fp0 fp0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fp0Var)) == null) {
            if (fp0Var instanceof dp0) {
                return (dp0) fp0Var;
            }
            return null;
        }
        return (dp0) invokeL.objValue;
    }

    public static gp0 b(fp0 fp0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fp0Var)) == null) {
            if (fp0Var instanceof gp0) {
                return (gp0) fp0Var;
            }
            return null;
        }
        return (gp0) invokeL.objValue;
    }

    public static void c(@NonNull fp0 fp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fp0Var) == null) {
            synchronized (fp0.class) {
                if (a != null) {
                    return;
                }
                a = fp0Var;
            }
        }
    }

    public static void f(ep0 ep0Var) {
        gp0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, ep0Var) == null) && (b = b(a)) != null) {
            b.b(ep0Var);
        }
    }

    public static void g(ep0 ep0Var) {
        gp0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, ep0Var) == null) && (b = b(a)) != null) {
            b.d(ep0Var);
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            dp0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.a();
        }
        return (Activity) invokeV.objValue;
    }

    @Nullable
    public static Activity e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            dp0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }
}
