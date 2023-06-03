package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class fu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends dt6> T a(et6 et6Var, Class<T> type, g0 entity, ws6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, et6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(et6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            f0 f = et6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(et6 et6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, et6Var)) == null) {
            Intrinsics.checkNotNullParameter(et6Var, "<this>");
            return d(et6Var).a();
        }
        return invokeL.longValue;
    }

    public static final wu6 c(et6 et6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, et6Var)) == null) {
            Intrinsics.checkNotNullParameter(et6Var, "<this>");
            return et6Var.i().d();
        }
        return (wu6) invokeL.objValue;
    }

    public static final zu6 d(et6 et6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, et6Var)) == null) {
            Intrinsics.checkNotNullParameter(et6Var, "<this>");
            return et6Var.i().f();
        }
        return (zu6) invokeL.objValue;
    }

    public static final boolean e(et6 et6Var) {
        InterceptResult invokeL;
        ct6 ct6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, et6Var)) == null) {
            Intrinsics.checkNotNullParameter(et6Var, "<this>");
            f0 f = et6Var.f();
            if (f instanceof ct6) {
                ct6Var = (ct6) f;
            } else {
                ct6Var = null;
            }
            if (ct6Var != null) {
                return ct6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
