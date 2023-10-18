package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fl3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull el3 el3Var, @NonNull vv2 vv2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, el3Var, vv2Var) == null) {
            el3Var.f(vv2Var.d());
            el3Var.g(vv2Var.e());
            if (vv2Var.g()) {
                el3Var.a(1);
            } else {
                el3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull xr1 xr1Var, @NonNull vv2 vv2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, xr1Var, vv2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(vv2Var.f(), vv2Var.c());
            int i2 = 0;
            if (vv2Var.g()) {
                i2 = xr1Var.getWebViewScrollX();
                i = xr1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = vv2Var.d() + i2;
            layoutParams.topMargin = vv2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
