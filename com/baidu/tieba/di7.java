package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class di7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean d(p87 p87Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, p87Var)) == null) {
            if (p87Var.a() instanceof s57) {
                return ((s57) p87Var.a()).q();
            }
            if (p87Var.a() instanceof xf7) {
                return ((xf7) p87Var.a()).w();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final String f(p87 p87Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, p87Var)) == null) {
            if (p87Var.a() instanceof s57) {
                return ((s57) p87Var.a()).m();
            }
            if (p87Var.a() instanceof xf7) {
                return ((xf7) p87Var.a()).r();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static final boolean e(p87 p87Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, p87Var, z)) == null) {
            if (p87Var.a() instanceof s57) {
                ((s57) p87Var.a()).r(z);
                return false;
            } else if (p87Var.a() instanceof xf7) {
                ((xf7) p87Var.a()).x(z);
                return false;
            } else {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }
}
