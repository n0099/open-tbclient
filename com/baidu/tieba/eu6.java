package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class eu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends ct6> T a(dt6 dt6Var, Class<T> type, h0 entity, vs6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, dt6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(dt6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            g0 f = dt6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(dt6 dt6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dt6Var)) == null) {
            Intrinsics.checkNotNullParameter(dt6Var, "<this>");
            return d(dt6Var).a();
        }
        return invokeL.longValue;
    }

    public static final vu6 c(dt6 dt6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dt6Var)) == null) {
            Intrinsics.checkNotNullParameter(dt6Var, "<this>");
            return dt6Var.i().d();
        }
        return (vu6) invokeL.objValue;
    }

    public static final yu6 d(dt6 dt6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, dt6Var)) == null) {
            Intrinsics.checkNotNullParameter(dt6Var, "<this>");
            return dt6Var.i().f();
        }
        return (yu6) invokeL.objValue;
    }

    public static final boolean e(dt6 dt6Var) {
        InterceptResult invokeL;
        bt6 bt6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dt6Var)) == null) {
            Intrinsics.checkNotNullParameter(dt6Var, "<this>");
            g0 f = dt6Var.f();
            if (f instanceof bt6) {
                bt6Var = (bt6) f;
            } else {
                bt6Var = null;
            }
            if (bt6Var != null) {
                return bt6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
