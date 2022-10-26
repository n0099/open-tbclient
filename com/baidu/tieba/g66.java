package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class g66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final e56 a(f56 f56Var, Class type, p0 entity, x46 item) {
        InterceptResult invokeLLLL;
        e56 e56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, f56Var, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(f56Var, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            o0 f = f56Var.f();
            if (f == null || (e56Var = (e56) f.h(type)) == null) {
                return null;
            }
            entity.a(e56Var);
            e56Var.b(item);
            return e56Var;
        }
        return (e56) invokeLLLL.objValue;
    }

    public static final long b(f56 f56Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, f56Var)) == null) {
            Intrinsics.checkNotNullParameter(f56Var, "<this>");
            return d(f56Var).a();
        }
        return invokeL.longValue;
    }

    public static final x66 c(f56 f56Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, f56Var)) == null) {
            Intrinsics.checkNotNullParameter(f56Var, "<this>");
            return f56Var.i().d();
        }
        return (x66) invokeL.objValue;
    }

    public static final a76 d(f56 f56Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, f56Var)) == null) {
            Intrinsics.checkNotNullParameter(f56Var, "<this>");
            return f56Var.i().f();
        }
        return (a76) invokeL.objValue;
    }

    public static final boolean e(f56 f56Var) {
        InterceptResult invokeL;
        d56 d56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, f56Var)) == null) {
            Intrinsics.checkNotNullParameter(f56Var, "<this>");
            o0 f = f56Var.f();
            if (f instanceof d56) {
                d56Var = (d56) f;
            } else {
                d56Var = null;
            }
            if (d56Var == null) {
                return true;
            }
            return d56Var.x();
        }
        return invokeL.booleanValue;
    }
}
