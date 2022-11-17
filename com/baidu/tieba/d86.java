package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class d86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends b76> T a(c76 c76Var, Class<T> type, p0 entity, u66 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, c76Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(c76Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            o0 f = c76Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(c76 c76Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c76Var)) == null) {
            Intrinsics.checkNotNullParameter(c76Var, "<this>");
            return d(c76Var).a();
        }
        return invokeL.longValue;
    }

    public static final u86 c(c76 c76Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c76Var)) == null) {
            Intrinsics.checkNotNullParameter(c76Var, "<this>");
            return c76Var.i().d();
        }
        return (u86) invokeL.objValue;
    }

    public static final x86 d(c76 c76Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, c76Var)) == null) {
            Intrinsics.checkNotNullParameter(c76Var, "<this>");
            return c76Var.i().f();
        }
        return (x86) invokeL.objValue;
    }

    public static final boolean e(c76 c76Var) {
        InterceptResult invokeL;
        a76 a76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c76Var)) == null) {
            Intrinsics.checkNotNullParameter(c76Var, "<this>");
            o0 f = c76Var.f();
            if (f instanceof a76) {
                a76Var = (a76) f;
            } else {
                a76Var = null;
            }
            if (a76Var == null) {
                return true;
            }
            return a76Var.x();
        }
        return invokeL.booleanValue;
    }
}
