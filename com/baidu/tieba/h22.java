package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(e12 e12Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, e12Var)) == null) {
            g22 g22Var = (g22) t22.a(e12Var);
            if (g22Var == null) {
                g32.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return g22Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
