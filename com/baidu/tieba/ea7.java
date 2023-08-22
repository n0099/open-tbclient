package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ea7 implements w97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ea7() {
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

    @Override // com.baidu.tieba.w97
    public SpannableString b(Context context, o87 richTextData, ClickableSpan clickableSpan) {
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
            int dimens = BdUtilHelper.getDimens(w47.a, R.dimen.L_X01);
            int dimens2 = BdUtilHelper.getDimens(w47.a, R.dimen.tbds10);
            int dimens3 = BdUtilHelper.getDimens(w47.a, R.dimen.T_X10);
            int dimens4 = BdUtilHelper.getDimens(w47.a, R.dimen.M_W_X002);
            int dimens5 = BdUtilHelper.getDimens(w47.a, R.dimen.M_W_X002);
            int dimens6 = BdUtilHelper.getDimens(w47.a, R.dimen.tbds42);
            h77 a = richTextData.f().a();
            if (a != null) {
                i = vc7.a.b(a);
            } else {
                i = R.color.CAM_X0302;
            }
            h77 b = richTextData.f().b();
            if (b != null) {
                i2 = vc7.a.b(b);
            } else {
                i2 = R.color.CAM_X0101;
            }
            k95 k95Var = new k95(dimens, -1, i, dimens3, i2, dimens4, dimens6);
            k95Var.b(dimens2);
            k95Var.i(dimens5);
            k95Var.f(true);
            k95Var.g(true);
            k95Var.d(BdUtilHelper.getDimens(w47.a, R.dimen.tbds7));
            spannableString.setSpan(k95Var, 0, c.length(), 17);
            if (!TextUtils.isEmpty(richTextData.d())) {
                spannableString.setSpan(clickableSpan, 0, c.length(), 33);
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}
