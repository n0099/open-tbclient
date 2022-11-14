package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class c86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends a76> T a(b76 b76Var, Class<T> type, p0 entity, t66 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, b76Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(b76Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            o0 f = b76Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(b76 b76Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, b76Var)) == null) {
            Intrinsics.checkNotNullParameter(b76Var, "<this>");
            return d(b76Var).a();
        }
        return invokeL.longValue;
    }

    public static final t86 c(b76 b76Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, b76Var)) == null) {
            Intrinsics.checkNotNullParameter(b76Var, "<this>");
            return b76Var.i().d();
        }
        return (t86) invokeL.objValue;
    }

    public static final w86 d(b76 b76Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, b76Var)) == null) {
            Intrinsics.checkNotNullParameter(b76Var, "<this>");
            return b76Var.i().f();
        }
        return (w86) invokeL.objValue;
    }

    public static final boolean e(b76 b76Var) {
        InterceptResult invokeL;
        z66 z66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, b76Var)) == null) {
            Intrinsics.checkNotNullParameter(b76Var, "<this>");
            o0 f = b76Var.f();
            if (f instanceof z66) {
                z66Var = (z66) f;
            } else {
                z66Var = null;
            }
            if (z66Var == null) {
                return true;
            }
            return z66Var.x();
        }
        return invokeL.booleanValue;
    }
}
