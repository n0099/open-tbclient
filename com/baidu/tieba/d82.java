package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(z62 z62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, z62Var)) == null) {
            c82 c82Var = (c82) p82.a(z62Var);
            if (c82Var == null) {
                c92.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return c82Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
