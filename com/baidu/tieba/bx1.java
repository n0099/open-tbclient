package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bx1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(xv1 xv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, xv1Var)) == null) {
            ax1 ax1Var = (ax1) nx1.a(xv1Var);
            if (ax1Var == null) {
                ay1.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return ax1Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
