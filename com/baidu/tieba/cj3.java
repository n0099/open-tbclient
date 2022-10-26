package com.baidu.tieba;

import android.widget.FrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class cj3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(bj3 bj3Var, st2 st2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bj3Var, st2Var) == null) {
            bj3Var.f(st2Var.d());
            bj3Var.g(st2Var.e());
            if (st2Var.g()) {
                bj3Var.a(1);
            } else {
                bj3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(tp1 tp1Var, st2 st2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tp1Var, st2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(st2Var.f(), st2Var.c());
            int i2 = 0;
            if (st2Var.g()) {
                i2 = tp1Var.getWebViewScrollX();
                i = tp1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = st2Var.d() + i2;
            layoutParams.topMargin = st2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
