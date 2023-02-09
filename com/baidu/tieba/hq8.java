package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(lf5 lf5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, lf5Var)) == null) {
            if (lf5Var != null) {
                return lf5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(lf5 lf5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{lf5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(lf5Var) && context != null && view2 != null) {
            if (lf5Var == null) {
                lf5Var = new lf5(context, onClickListener);
            }
            lf5Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            lf5Var.attachView(view2, z);
            lf5Var.p();
            lf5Var.onChangeSkinType();
        }
    }
}
