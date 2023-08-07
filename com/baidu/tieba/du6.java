package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class du6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends bt6> T a(ct6 ct6Var, Class<T> type, h0 entity, us6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, ct6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(ct6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            g0 f = ct6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(ct6 ct6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ct6Var)) == null) {
            Intrinsics.checkNotNullParameter(ct6Var, "<this>");
            return d(ct6Var).a();
        }
        return invokeL.longValue;
    }

    public static final uu6 c(ct6 ct6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ct6Var)) == null) {
            Intrinsics.checkNotNullParameter(ct6Var, "<this>");
            return ct6Var.i().d();
        }
        return (uu6) invokeL.objValue;
    }

    public static final xu6 d(ct6 ct6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ct6Var)) == null) {
            Intrinsics.checkNotNullParameter(ct6Var, "<this>");
            return ct6Var.i().f();
        }
        return (xu6) invokeL.objValue;
    }

    public static final boolean e(ct6 ct6Var) {
        InterceptResult invokeL;
        at6 at6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ct6Var)) == null) {
            Intrinsics.checkNotNullParameter(ct6Var, "<this>");
            g0 f = ct6Var.f();
            if (f instanceof at6) {
                at6Var = (at6) f;
            } else {
                at6Var = null;
            }
            if (at6Var != null) {
                return at6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
