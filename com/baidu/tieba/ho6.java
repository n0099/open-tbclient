package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class ho6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends fn6> T a(gn6 gn6Var, Class<T> type, y entity, ym6 item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, gn6Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(gn6Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            x f = gn6Var.f();
            if (f != null && (t = (T) f.h(type)) != null) {
                entity.a(t);
                t.b(item);
                return t;
            }
            return null;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(gn6 gn6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gn6Var)) == null) {
            Intrinsics.checkNotNullParameter(gn6Var, "<this>");
            return d(gn6Var).a();
        }
        return invokeL.longValue;
    }

    public static final yo6 c(gn6 gn6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gn6Var)) == null) {
            Intrinsics.checkNotNullParameter(gn6Var, "<this>");
            return gn6Var.i().d();
        }
        return (yo6) invokeL.objValue;
    }

    public static final bp6 d(gn6 gn6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gn6Var)) == null) {
            Intrinsics.checkNotNullParameter(gn6Var, "<this>");
            return gn6Var.i().f();
        }
        return (bp6) invokeL.objValue;
    }

    public static final boolean e(gn6 gn6Var) {
        InterceptResult invokeL;
        en6 en6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gn6Var)) == null) {
            Intrinsics.checkNotNullParameter(gn6Var, "<this>");
            x f = gn6Var.f();
            if (f instanceof en6) {
                en6Var = (en6) f;
            } else {
                en6Var = null;
            }
            if (en6Var != null) {
                return en6Var.x();
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
