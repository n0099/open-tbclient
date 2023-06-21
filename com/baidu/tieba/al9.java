package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class al9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(an5 an5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, an5Var)) == null) {
            if (an5Var != null) {
                return an5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(an5 an5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{an5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(an5Var) && context != null && view2 != null) {
            if (an5Var == null) {
                an5Var = new an5(context, onClickListener);
            }
            an5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            an5Var.attachView(view2, z);
            an5Var.p();
            an5Var.onChangeSkinType();
        }
    }
}
