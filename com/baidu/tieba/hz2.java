package com.baidu.tieba;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class hz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return 0;
        }
        return invokeL.intValue;
    }

    public static void a(Context context, Drawable drawable, PorterDuff.Mode mode, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65536, null, context, drawable, mode, i) == null) && context != null && drawable != null) {
            int d = d(context);
            if (i >= 0 && i < 255) {
                d = Color.argb((Color.alpha(d) * i) / 255, Color.red(d), Color.green(d), Color.blue(d));
            }
            drawable.setColorFilter(d, mode);
        }
    }

    public static void b(Context context, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, drawable) == null) {
            c(context, drawable, 255);
        }
    }

    public static void c(Context context, Drawable drawable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, context, drawable, i) == null) {
            a(context, drawable, PorterDuff.Mode.SRC_ATOP, i);
        }
    }
}
