package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(f12 f12Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, f12Var)) == null) {
            h22 h22Var = (h22) u22.a(f12Var);
            if (h22Var == null) {
                h32.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return h22Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
