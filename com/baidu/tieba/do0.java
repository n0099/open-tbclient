package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class do0 {
    public static /* synthetic */ Interceptable $ic;
    public static io0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static go0 a(io0 io0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, io0Var)) == null) {
            if (io0Var instanceof go0) {
                return (go0) io0Var;
            }
            return null;
        }
        return (go0) invokeL.objValue;
    }

    public static jo0 b(io0 io0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, io0Var)) == null) {
            if (io0Var instanceof jo0) {
                return (jo0) io0Var;
            }
            return null;
        }
        return (jo0) invokeL.objValue;
    }

    public static void c(@NonNull io0 io0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, io0Var) == null) {
            synchronized (io0.class) {
                if (a != null) {
                    return;
                }
                a = io0Var;
            }
        }
    }

    public static void f(ho0 ho0Var) {
        jo0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, ho0Var) == null) && (b = b(a)) != null) {
            b.b(ho0Var);
        }
    }

    public static void g(ho0 ho0Var) {
        jo0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, ho0Var) == null) && (b = b(a)) != null) {
            b.d(ho0Var);
        }
    }

    @Nullable
    public static Activity d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            go0 a2 = a(a);
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
            go0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.c();
        }
        return (Activity) invokeV.objValue;
    }
}
