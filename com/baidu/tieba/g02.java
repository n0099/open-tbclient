package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class g02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(cz1 cz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cz1Var)) == null) {
            f02 f02Var = (f02) s02.a(cz1Var);
            if (f02Var == null) {
                f12.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return f02Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
