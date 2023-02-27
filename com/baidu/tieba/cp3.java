package com.baidu.tieba;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class cp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull bp3 bp3Var, @NonNull sz2 sz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bp3Var, sz2Var) == null) {
            bp3Var.f(sz2Var.d());
            bp3Var.g(sz2Var.e());
            if (sz2Var.g()) {
                bp3Var.a(1);
            } else {
                bp3Var.e(1);
            }
        }
    }

    public static FrameLayout.LayoutParams b(@NonNull tv1 tv1Var, @NonNull sz2 sz2Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tv1Var, sz2Var)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(sz2Var.f(), sz2Var.c());
            int i2 = 0;
            if (sz2Var.g()) {
                i2 = tv1Var.getWebViewScrollX();
                i = tv1Var.getWebViewScrollY();
            } else {
                i = 0;
            }
            layoutParams.leftMargin = sz2Var.d() + i2;
            layoutParams.topMargin = sz2Var.e() + i;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeLL.objValue;
    }
}
