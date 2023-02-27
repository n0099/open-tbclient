package com.baidu.tieba;

import android.graphics.Paint;
import android.text.Spanned;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Paint.FontMetricsInt fontMetricsInt, int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65536, null, fontMetricsInt, i) != null) || (i3 = (i2 = fontMetricsInt.descent) - fontMetricsInt.ascent) <= 0) {
            return;
        }
        int round = Math.round(i2 * ((i * 1.0f) / i3));
        fontMetricsInt.descent = round;
        fontMetricsInt.ascent = round - i;
    }

    public static boolean b(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, charSequence)) == null) {
            if (!(charSequence instanceof Spanned)) {
                return false;
            }
            Spanned spanned = (Spanned) charSequence;
            if (((EMTextView.a[]) spanned.getSpans(0, spanned.length(), EMTextView.a.class)).length <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
