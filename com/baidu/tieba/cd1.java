package com.baidu.tieba;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2, View view3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, view2, view3, i) == null) {
            b(view2, view3, i, i, i, i);
        }
    }

    public static void b(View view2, View view3, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{view2, view3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && view3 != null && view2 != null) {
            if (view2.getTouchDelegate() instanceof yc1) {
                ((yc1) view2.getTouchDelegate()).a(view3, i, i2, i3, i4);
            } else {
                view2.setTouchDelegate(new yc1(view3, i, i2, i3, i4));
            }
        }
    }
}
