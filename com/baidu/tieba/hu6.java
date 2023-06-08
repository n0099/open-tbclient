package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class hu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends ft6> T a(gt6 gt6Var, Class<T> type, g0 entity, ys6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, gt6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(gt6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            f0 f = gt6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(gt6 gt6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gt6Var)) == null) {
            Intrinsics.checkNotNullParameter(gt6Var, "<this>");
            return d(gt6Var).a();
        }
        return invokeL.longValue;
    }

    public static final yu6 c(gt6 gt6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gt6Var)) == null) {
            Intrinsics.checkNotNullParameter(gt6Var, "<this>");
            return gt6Var.i().d();
        }
        return (yu6) invokeL.objValue;
    }

    public static final bv6 d(gt6 gt6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gt6Var)) == null) {
            Intrinsics.checkNotNullParameter(gt6Var, "<this>");
            return gt6Var.i().f();
        }
        return (bv6) invokeL.objValue;
    }

    public static final boolean e(gt6 gt6Var) {
        InterceptResult invokeL;
        et6 et6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gt6Var)) == null) {
            Intrinsics.checkNotNullParameter(gt6Var, "<this>");
            f0 f = gt6Var.f();
            if (f instanceof et6) {
                et6Var = (et6) f;
            } else {
                et6Var = null;
            }
            if (et6Var != null) {
                return et6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
