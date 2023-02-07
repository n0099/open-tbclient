package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class ch6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final hg6 a(v0 v0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, v0Var)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            return (hg6) v0Var.d(hg6.class);
        }
        return (hg6) invokeL.objValue;
    }

    public static final eg6 b(v0 v0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, v0Var)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            return (eg6) v0Var.d(eg6.class);
        }
        return (eg6) invokeL.objValue;
    }

    public static final long c(v0 v0Var) {
        InterceptResult invokeL;
        sf6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, v0Var)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            eg6 b = b(v0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final dg6 d(v0 v0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, v0Var)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            return (dg6) v0Var.d(dg6.class);
        }
        return (dg6) invokeL.objValue;
    }

    public static final fg6 e(v0 v0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, v0Var)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            return (fg6) v0Var.d(fg6.class);
        }
        return (fg6) invokeL.objValue;
    }

    public static final long f(v0 v0Var) {
        InterceptResult invokeL;
        sf6 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, v0Var)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            eg6 b = b(v0Var);
            if (b == null || (a = b.a()) == null) {
                return 0L;
            }
            return a.j();
        }
        return invokeL.longValue;
    }

    public static final boolean g(v0 v0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, v0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            if (j - f(v0Var) < 0) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(v0 v0Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, v0Var, j)) == null) {
            Intrinsics.checkNotNullParameter(v0Var, "<this>");
            if (j - f(v0Var) > c(v0Var)) {
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }
}
