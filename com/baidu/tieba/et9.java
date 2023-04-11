package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class et9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i == 1990059 : invokeI.booleanValue;
    }

    public static void a(p05 p05Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65536, null, p05Var, i) == null) && p05Var != null && i >= 0) {
            int i2 = 1;
            int i3 = i + 1;
            boolean d = p05Var.d();
            String valueOf = String.valueOf(TbadkCoreApplication.getCurrentAccountId());
            if (d) {
                i2 = 2;
            }
            TiebaStatic.log(new StatisticItem("c14633").param("uid", valueOf).param("obj_locate", i3).param("obj_type", i2));
        }
    }

    public static boolean b(Activity activity, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, activity, i, str)) == null) {
            if (d(i)) {
                e(activity, str);
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static void g(ViewGroup viewGroup, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65542, null, viewGroup, str, z) == null) && viewGroup != null && !TextUtils.isEmpty(str)) {
            BdTopToast bdTopToast = new BdTopToast(viewGroup.getContext());
            bdTopToast.h(z);
            bdTopToast.g(str);
            bdTopToast.i(viewGroup);
        }
    }

    public static String c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            Object tag = view2.getTag();
            if (tag instanceof sl9) {
                sl9 sl9Var = (sl9) tag;
                if (sl9Var.q() != null) {
                    return sl9Var.q().getUserId();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void e(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, str) == null) && activity != null && !TextUtils.isEmpty(str)) {
            g((ViewGroup) activity.findViewById(16908290), str, false);
        }
    }

    public static void f(View view2, sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, view2, sl9Var) != null) || view2 == null) {
            return;
        }
        view2.setTag(sl9Var);
    }
}
