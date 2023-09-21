package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(d62 d62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, d62Var)) == null) {
            g72 g72Var = (g72) t72.a(d62Var);
            if (g72Var == null) {
                g82.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return g72Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
