package com.baidu.tieba;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bz {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448301141, "Lcom/baidu/tieba/bz;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448301141, "Lcom/baidu/tieba/bz;");
                return;
            }
        }
        a = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
    }

    public static void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, view2) == null) {
            view2.setPivotX(0.0f);
            ViewPropertyAnimator animate = view2.animate();
            animate.scaleY(1.0f);
            animate.scaleX(1.0f);
            animate.translationY(0.0f);
            animate.setDuration(0L);
            animate.start();
        }
    }

    public static void b(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, view2, i) == null) {
            view2.setPivotX(0.0f);
            ViewPropertyAnimator animate = view2.animate();
            animate.scaleY(0.75f);
            animate.scaleX(0.75f);
            animate.translationY(-a);
            animate.setDuration(i);
            animate.start();
        }
    }
}
