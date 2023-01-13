package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class il8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ab5 ab5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ab5Var)) == null) {
            if (ab5Var != null) {
                return ab5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(ab5 ab5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ab5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(ab5Var) && context != null && view2 != null) {
            if (ab5Var == null) {
                ab5Var = new ab5(context, onClickListener);
            }
            ab5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            ab5Var.attachView(view2, z);
            ab5Var.p();
            ab5Var.onChangeSkinType();
        }
    }
}
