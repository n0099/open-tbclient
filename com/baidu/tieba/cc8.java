package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class cc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(k95 k95Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, k95Var)) == null) {
            if (k95Var != null) {
                return k95Var.isViewAttached();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(k95 k95Var, View.OnClickListener onClickListener, Context context, View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{k95Var, onClickListener, context, view2, str, Boolean.valueOf(z)}) == null) && !a(k95Var) && context != null && view2 != null) {
            if (k95Var == null) {
                k95Var = new k95(context, onClickListener);
            }
            k95Var.k(context.getResources().getDimensionPixelSize(R.dimen.tbds530));
            k95Var.attachView(view2, z);
            k95Var.p();
            k95Var.onChangeSkinType();
        }
    }
}
