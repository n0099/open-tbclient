package com.baidu.tieba;

import android.graphics.Typeface;
import android.widget.TextView;
import com.baidu.nadcore.styles.Font;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) ? i >= 100 && i <= 900 && i % 100 == 0 : invokeI.booleanValue;
    }

    public static void b(TextView textView, Font font) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, textView, font) == null) || textView == null || font == null) {
            return;
        }
        c(textView, font.getFontWeight());
    }

    public static void c(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65538, null, textView, i) == null) && textView != null && a(i)) {
            if (i >= 600) {
                textView.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                textView.setTypeface(Typeface.defaultFromStyle(0));
            }
        }
    }
}
