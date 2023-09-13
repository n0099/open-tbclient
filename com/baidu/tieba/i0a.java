package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(wn5 wn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wn5Var)) == null) {
            if (wn5Var != null) {
                return wn5Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(wn5 wn5Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{wn5Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(wn5Var) && context != null && view2 != null) {
            if (wn5Var == null) {
                wn5Var = new wn5(context, onClickListener);
            }
            wn5Var.j(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            wn5Var.attachView(view2, z);
            wn5Var.o();
            wn5Var.onChangeSkinType();
        }
    }
}
