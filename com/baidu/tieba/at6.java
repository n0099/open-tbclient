package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class at6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final fs6 a(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            return (fs6) y0Var.d(fs6.class);
        }
        return (fs6) invokeL.objValue;
    }

    public static final cs6 b(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            return (cs6) y0Var.d(cs6.class);
        }
        return (cs6) invokeL.objValue;
    }

    public static final long c(y0 y0Var) {
        InterceptResult invokeL;
        qr6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            cs6 b = b(y0Var);
            if (b != null && (a = b.a()) != null) {
                return a.g();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final bs6 d(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            return (bs6) y0Var.d(bs6.class);
        }
        return (bs6) invokeL.objValue;
    }

    public static final ds6 e(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            return (ds6) y0Var.d(ds6.class);
        }
        return (ds6) invokeL.objValue;
    }

    public static final long f(y0 y0Var) {
        InterceptResult invokeL;
        qr6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, y0Var)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            cs6 b = b(y0Var);
            if (b != null && (a = b.a()) != null) {
                return a.j();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final boolean g(y0 y0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, y0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            if (j - f(y0Var) < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(y0 y0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, y0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(y0Var, "<this>");
            if (j - f(y0Var) > c(y0Var)) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
