package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(a62 a62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, a62Var)) == null) {
            d72 d72Var = (d72) q72.a(a62Var);
            if (d72Var == null) {
                d82.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return d72Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
