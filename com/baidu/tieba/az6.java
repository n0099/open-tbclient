package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class az6 implements sy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public az6() {
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

    @Override // com.baidu.tieba.sy6
    public SpannableString b(Context context, tx6 richTextData, ClickableSpan clickableSpan) {
        InterceptResult invokeLLL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, richTextData, clickableSpan)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(richTextData, "richTextData");
            Intrinsics.checkNotNullParameter(clickableSpan, "clickableSpan");
            String c = richTextData.f().c();
            SpannableString spannableString = new SpannableString(c);
            int g = ii.g(zu6.a, R.dimen.L_X01);
            int g2 = ii.g(zu6.a, R.dimen.tbds10);
            int g3 = ii.g(zu6.a, R.dimen.T_X10);
            int g4 = ii.g(zu6.a, R.dimen.M_W_X002);
            int g5 = ii.g(zu6.a, R.dimen.M_W_X002);
            int g6 = ii.g(zu6.a, R.dimen.tbds42);
            yw6 a = richTextData.f().a();
            if (a != null) {
                i = i17.a.b(a);
            } else {
                i = R.color.CAM_X0302;
            }
            yw6 b = richTextData.f().b();
            if (b != null) {
                i2 = i17.a.b(b);
            } else {
                i2 = R.color.CAM_X0101;
            }
            u45 u45Var = new u45(g, -1, i, g3, i2, g4, g6);
            u45Var.b(g2);
            u45Var.i(g5);
            u45Var.f(true);
            u45Var.g(true);
            u45Var.d(ii.g(zu6.a, R.dimen.tbds7));
            spannableString.setSpan(u45Var, 0, c.length(), 17);
            if (!TextUtils.isEmpty(richTextData.d())) {
                spannableString.setSpan(clickableSpan, 0, c.length(), 33);
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}
