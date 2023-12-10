package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class ii7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean d(t87 t87Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t87Var)) == null) {
            if (t87Var.a() instanceof w57) {
                return ((w57) t87Var.a()).q();
            }
            if (t87Var.a() instanceof cg7) {
                return ((cg7) t87Var.a()).w();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final String f(t87 t87Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, t87Var)) == null) {
            if (t87Var.a() instanceof w57) {
                return ((w57) t87Var.a()).m();
            }
            if (t87Var.a() instanceof cg7) {
                return ((cg7) t87Var.a()).r();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static final boolean e(t87 t87Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, t87Var, z)) == null) {
            if (t87Var.a() instanceof w57) {
                ((w57) t87Var.a()).r(z);
                return false;
            } else if (t87Var.a() instanceof cg7) {
                ((cg7) t87Var.a()).x(z);
                return false;
            } else {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }
}
