package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class am3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull zl3 zl3Var, @NonNull qw2 qw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, zl3Var, qw2Var) == null) {
            zl3Var.f(qw2Var.d());
            zl3Var.g(qw2Var.e());
            if (qw2Var.g()) {
                zl3Var.a(1);
            } else {
                zl3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull ss1 ss1Var, @NonNull qw2 qw2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ss1Var, qw2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(qw2Var.f(), qw2Var.c());
            int i2 = 0;
            if (qw2Var.g()) {
                i2 = ss1Var.getWebViewScrollX();
                i = ss1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = qw2Var.d() + i2;
            layoutParams.topMargin = qw2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
