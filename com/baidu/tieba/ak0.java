package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public final class ak0 {
    public static /* synthetic */ Interceptable $ic;
    public static fk0 a;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static dk0 a(fk0 fk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fk0Var)) == null) {
            if (fk0Var instanceof dk0) {
                return (dk0) fk0Var;
            }
            return null;
        }
        return (dk0) invokeL.objValue;
    }

    public static gk0 b(fk0 fk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fk0Var)) == null) {
            if (fk0Var instanceof gk0) {
                return (gk0) fk0Var;
            }
            return null;
        }
        return (gk0) invokeL.objValue;
    }

    public static void c(@NonNull fk0 fk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fk0Var) == null) {
            synchronized (fk0.class) {
                if (a != null) {
                    return;
                }
                a = fk0Var;
            }
        }
    }

    public static void g(ek0 ek0Var) {
        gk0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, ek0Var) == null) && (b = b(a)) != null) {
            b.c(ek0Var);
        }
    }

    public static void h(ek0 ek0Var) {
        gk0 b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, ek0Var) == null) && (b = b(a)) != null) {
            b.e(ek0Var);
        }
    }

    @Nullable
    public static LinkedList<WeakReference<Activity>> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            dk0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.a();
        }
        return (LinkedList) invokeV.objValue;
    }

    @Nullable
    public static Activity e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            dk0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.b();
        }
        return (Activity) invokeV.objValue;
    }

    @Nullable
    public static Activity f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            dk0 a2 = a(a);
            if (a2 == null) {
                return null;
            }
            return a2.d();
        }
        return (Activity) invokeV.objValue;
    }
}
