package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ao5 ao5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ao5Var)) == null) {
            if (ao5Var != null) {
                return ao5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(ao5 ao5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ao5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(ao5Var) && context != null && view2 != null) {
            if (ao5Var == null) {
                ao5Var = new ao5(context, onClickListener);
            }
            ao5Var.j(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            ao5Var.attachView(view2, z);
            ao5Var.o();
            ao5Var.onChangeSkinType();
        }
    }
}
