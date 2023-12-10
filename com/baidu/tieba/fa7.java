package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes5.dex */
public final class fa7 implements aa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fa7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.aa7
    public SpannableString b(Context context, b87 richTextData, ClickableSpan clickableSpan) {
        InterceptResult invokeLLL;
        e67 b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, richTextData, clickableSpan)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(richTextData, "richTextData");
            Intrinsics.checkNotNullParameter(clickableSpan, "clickableSpan");
            g87 g = richTextData.g();
            SpannableString spannableString = new SpannableString(g.c());
            if (g.b() != null) {
                if ((clickableSpan instanceof ba7) && (b = g.b()) != null) {
                    ((ba7) clickableSpan).a(jd7.a.a(b));
                }
                int length = g.c().length();
                if (StringsKt__StringsJVMKt.endsWith$default(g.c(), " ", false, 2, null)) {
                    length = g.c().length() - 1;
                }
                spannableString.setSpan(clickableSpan, 0, length, 33);
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}
