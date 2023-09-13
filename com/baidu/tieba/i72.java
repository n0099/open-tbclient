package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(e62 e62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, e62Var)) == null) {
            h72 h72Var = (h72) u72.a(e62Var);
            if (h72Var == null) {
                h82.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return h72Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
