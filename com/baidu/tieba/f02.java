package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(bz1 bz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bz1Var)) == null) {
            e02 e02Var = (e02) r02.a(bz1Var);
            if (e02Var == null) {
                e12.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return e02Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
