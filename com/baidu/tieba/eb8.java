package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class eb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(t85 t85Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, t85Var)) == null) {
            if (t85Var != null) {
                return t85Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(t85 t85Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{t85Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) || a(t85Var) || context == null || view2 == null) {
            return;
        }
        if (t85Var == null) {
            t85Var = new t85(context, onClickListener);
        }
        t85Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
        t85Var.attachView(view2, z);
        t85Var.p();
        t85Var.onChangeSkinType();
    }
}
