package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.baidu.tieba.lr0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes4.dex */
public final class f21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: android.text.SpannableString */
    /* JADX WARN: Multi-variable type inference failed */
    public static final TextView a(Context context, lr0.c cVar) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, cVar)) == null) {
            if (cVar != null && !StringsKt__StringsJVMKt.isBlank(cVar.a)) {
                int[] iArr = cVar.b;
                if (iArr != null && iArr.length == 2) {
                    SpannableString spannableString = new SpannableString(cVar.a);
                    int a = y41.a(cVar.d, R.color.nad_sliding_tag_highlight_color_default);
                    StyleSpan styleSpan = new StyleSpan(1);
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(a);
                    spannableString.setSpan(styleSpan, iArr[0], iArr[1], 17);
                    spannableString.setSpan(foregroundColorSpan, iArr[0], iArr[1], 17);
                    str = spannableString;
                } else {
                    str = cVar.a;
                }
                int a2 = y41.a(cVar.c, R.color.nad_sliding_tag_text_color_default);
                TextView textView = new TextView(context);
                textView.setText(str);
                textView.setTextColor(a2);
                return textView;
            }
            return null;
        }
        return (TextView) invokeLL.objValue;
    }
}
