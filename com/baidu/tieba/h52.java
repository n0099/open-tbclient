package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class h52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(d42 d42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, d42Var)) == null) {
            g52 g52Var = (g52) t52.a(d42Var);
            if (g52Var == null) {
                g62.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return g52Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
