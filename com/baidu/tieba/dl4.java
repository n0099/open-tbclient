package com.baidu.tieba;

import android.graphics.Paint;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            return view2.getLayerType();
        }
        return invokeL.intValue;
    }

    public static void b(View view2, int i, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, view2, i, paint) == null) {
            view2.setLayerType(i, paint);
        }
    }

    public static void c(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, view2, z) == null) {
            view2.setSaveFromParentEnabled(z);
        }
    }
}
