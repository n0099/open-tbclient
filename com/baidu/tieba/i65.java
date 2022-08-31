package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class i65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static h65 a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            if (view2 instanceof LinearLayout) {
                return new j65();
            }
            if (view2 instanceof RelativeLayout) {
                return new m65();
            }
            if (view2 instanceof FrameLayout) {
                return new f65();
            }
            return null;
        }
        return (h65) invokeL.objValue;
    }

    public static h65 b(View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, view2, z)) == null) {
            if (view2 == null) {
                return null;
            }
            if (view2 instanceof LinearLayout) {
                return new j65();
            }
            if (view2 instanceof RelativeLayout) {
                return new m65();
            }
            if (view2 instanceof FrameLayout) {
                return z ? new n65() : new f65();
            }
            return null;
        }
        return (h65) invokeLZ.objValue;
    }
}
