package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(w62 w62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, w62Var)) == null) {
            z72 z72Var = (z72) m82.a(w62Var);
            if (z72Var == null) {
                z82.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return z72Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
