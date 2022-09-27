package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class a66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final f56 a(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (f56) p0Var.d(f56.class);
        }
        return (f56) invokeL.objValue;
    }

    public static final c56 b(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (c56) p0Var.d(c56.class);
        }
        return (c56) invokeL.objValue;
    }

    public static final long c(p0 p0Var) {
        InterceptResult invokeL;
        q46 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            c56 b = b(p0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final b56 d(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (b56) p0Var.d(b56.class);
        }
        return (b56) invokeL.objValue;
    }

    public static final d56 e(p0 p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return (d56) p0Var.d(d56.class);
        }
        return (d56) invokeL.objValue;
    }

    public static final long f(p0 p0Var) {
        InterceptResult invokeL;
        q46 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, p0Var)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            c56 b = b(p0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.j();
        }
        return invokeL.longValue;
    }

    public static final boolean g(p0 p0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, p0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return j - f(p0Var) < 0;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(p0 p0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, p0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p0Var, "<this>");
            return j - f(p0Var) > c(p0Var);
        }
        return invokeLJ.booleanValue;
    }
}
