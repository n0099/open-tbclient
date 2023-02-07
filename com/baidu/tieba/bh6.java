package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class bh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends zf6> T a(ag6 ag6Var, Class<T> type, v0 entity, sf6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, ag6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(ag6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            u0 f = ag6Var.f();
            if (f == null || (t = (T) f.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(ag6 ag6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ag6Var)) == null) {
            Intrinsics.checkNotNullParameter(ag6Var, "<this>");
            return d(ag6Var).a();
        }
        return invokeL.longValue;
    }

    public static final sh6 c(ag6 ag6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ag6Var)) == null) {
            Intrinsics.checkNotNullParameter(ag6Var, "<this>");
            return ag6Var.i().d();
        }
        return (sh6) invokeL.objValue;
    }

    public static final vh6 d(ag6 ag6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ag6Var)) == null) {
            Intrinsics.checkNotNullParameter(ag6Var, "<this>");
            return ag6Var.i().f();
        }
        return (vh6) invokeL.objValue;
    }

    public static final boolean e(ag6 ag6Var) {
        InterceptResult invokeL;
        yf6 yf6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ag6Var)) == null) {
            Intrinsics.checkNotNullParameter(ag6Var, "<this>");
            u0 f = ag6Var.f();
            if (f instanceof yf6) {
                yf6Var = (yf6) f;
            } else {
                yf6Var = null;
            }
            if (yf6Var == null) {
                return true;
            }
            return yf6Var.x();
        }
        return invokeL.booleanValue;
    }
}
