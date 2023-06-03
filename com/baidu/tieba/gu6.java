package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class gu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final lt6 a(g0 g0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, g0Var)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            return (lt6) g0Var.d(lt6.class);
        }
        return (lt6) invokeL.objValue;
    }

    public static final it6 b(g0 g0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, g0Var)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            return (it6) g0Var.d(it6.class);
        }
        return (it6) invokeL.objValue;
    }

    public static final long c(g0 g0Var) {
        InterceptResult invokeL;
        ws6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, g0Var)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            it6 b = b(g0Var);
            if (b != null && (a = b.a()) != null) {
                return a.g();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final ht6 d(g0 g0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, g0Var)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            return (ht6) g0Var.d(ht6.class);
        }
        return (ht6) invokeL.objValue;
    }

    public static final jt6 e(g0 g0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, g0Var)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            return (jt6) g0Var.d(jt6.class);
        }
        return (jt6) invokeL.objValue;
    }

    public static final long f(g0 g0Var) {
        InterceptResult invokeL;
        ws6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, g0Var)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            it6 b = b(g0Var);
            if (b != null && (a = b.a()) != null) {
                return a.j();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final boolean g(g0 g0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, g0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            if (j - f(g0Var) < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(g0 g0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, g0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(g0Var, "<this>");
            if (j - f(g0Var) > c(g0Var)) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
