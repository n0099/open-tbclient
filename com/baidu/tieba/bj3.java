package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull aj3 aj3Var, @NonNull rt2 rt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, aj3Var, rt2Var) == null) {
            aj3Var.f(rt2Var.d());
            aj3Var.g(rt2Var.e());
            if (rt2Var.g()) {
                aj3Var.a(1);
            } else {
                aj3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull sp1 sp1Var, @NonNull rt2 rt2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, sp1Var, rt2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rt2Var.f(), rt2Var.c());
            int i2 = 0;
            if (rt2Var.g()) {
                i2 = sp1Var.getWebViewScrollX();
                i = sp1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = rt2Var.d() + i2;
            layoutParams.topMargin = rt2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
