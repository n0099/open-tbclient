package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ax6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final fw6 a(i0 i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, i0Var)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            return (fw6) i0Var.d(fw6.class);
        }
        return (fw6) invokeL.objValue;
    }

    public static final cw6 b(i0 i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, i0Var)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            return (cw6) i0Var.d(cw6.class);
        }
        return (cw6) invokeL.objValue;
    }

    public static final long c(i0 i0Var) {
        InterceptResult invokeL;
        qv6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, i0Var)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            cw6 b = b(i0Var);
            if (b != null && (a = b.a()) != null) {
                return a.g();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final bw6 d(i0 i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, i0Var)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            return (bw6) i0Var.d(bw6.class);
        }
        return (bw6) invokeL.objValue;
    }

    public static final dw6 e(i0 i0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, i0Var)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            return (dw6) i0Var.d(dw6.class);
        }
        return (dw6) invokeL.objValue;
    }

    public static final long f(i0 i0Var) {
        InterceptResult invokeL;
        qv6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, i0Var)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            cw6 b = b(i0Var);
            if (b != null && (a = b.a()) != null) {
                return a.j();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final boolean g(i0 i0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, i0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            if (j - f(i0Var) < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(i0 i0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, i0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(i0Var, "<this>");
            if (j - f(i0Var) > c(i0Var)) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
