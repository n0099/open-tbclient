package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull u51 u51Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, u51Var, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("javascript:")) {
            str = "javascript:" + str;
        }
        u51Var.loadUrl(str, null);
    }

    public static <T> void b(@NonNull u51 u51Var, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{u51Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            a(u51Var, "NadJsControl.visibleRectChange(".concat(String.valueOf(i)).concat(",").concat(String.valueOf(i2)).concat(",").concat(String.valueOf(i3)).concat(",").concat(String.valueOf(i4)).concat(");"));
        }
    }
}
