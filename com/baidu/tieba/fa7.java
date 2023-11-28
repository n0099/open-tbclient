package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.g55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class fa7 implements w97 {
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

    @Override // com.baidu.tieba.w97
    public SpannableString b(Context context, x77 richTextData, ClickableSpan clickableSpan) {
        InterceptResult invokeLLL;
        Unit unit;
        Unit unit2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, richTextData, clickableSpan)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(richTextData, "richTextData");
            Intrinsics.checkNotNullParameter(clickableSpan, "clickableSpan");
            String c = richTextData.g().c();
            SpannableString spannableString = new SpannableString(c);
            int dimens = BdUtilHelper.getDimens(r27.a, R.dimen.L_X02);
            int dimens2 = BdUtilHelper.getDimens(r27.a, R.dimen.tbds10);
            int dimens3 = BdUtilHelper.getDimens(r27.a, R.dimen.T_X10);
            int dimens4 = BdUtilHelper.getDimens(r27.a, R.dimen.M_W_X002);
            int dimens5 = BdUtilHelper.getDimens(context, R.dimen.tbds1);
            int dimens6 = BdUtilHelper.getDimens(r27.a, R.dimen.M_W_X002);
            int dimens7 = BdUtilHelper.getDimens(r27.a, R.dimen.tbds40);
            g55.a aVar = new g55.a();
            a67 b = richTextData.g().b();
            if (b != null) {
                aVar.a = ed7.a.d(b);
                aVar.b = ed7.a.c(b);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                aVar.a = SkinManager.getColor(0, (int) R.color.CAM_X0306);
                aVar.b = SkinManager.getColor(4, (int) R.color.CAM_X0306);
            }
            g55.a aVar2 = new g55.a();
            a67 a = richTextData.g().a();
            if (a != null) {
                aVar2.a = ed7.a.d(a);
                aVar2.b = ed7.a.c(a);
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            if (unit2 == null) {
                aVar2.a = SkinManager.getColor(0, (int) R.color.CAM_X0306);
                aVar2.b = SkinManager.getColor(4, (int) R.color.CAM_X0306);
            }
            g55 g55Var = new g55(dimens, -1, aVar2, dimens3, aVar, dimens4, dimens7);
            g55Var.b(dimens2);
            g55Var.h(dimens5);
            g55Var.i(dimens6);
            g55Var.f(false);
            g55Var.g(true);
            g55Var.a(0.5f);
            g55Var.d(BdUtilHelper.getDimens(r27.a, R.dimen.tbds7));
            spannableString.setSpan(g55Var, 0, c.length(), 17);
            if (!TextUtils.isEmpty(richTextData.e())) {
                spannableString.setSpan(clickableSpan, 0, c.length(), 33);
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}
