package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c95 a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            if (view2 instanceof LinearLayout) {
                return new e95();
            }
            if (view2 instanceof RelativeLayout) {
                return new h95();
            }
            if (view2 instanceof FrameLayout) {
                return new a95();
            }
            return null;
        }
        return (c95) invokeL.objValue;
    }

    public static c95 b(View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, view2, z)) == null) {
            if (view2 == null) {
                return null;
            }
            if (view2 instanceof LinearLayout) {
                return new e95();
            }
            if (view2 instanceof RelativeLayout) {
                return new h95();
            }
            if (view2 instanceof FrameLayout) {
                return z ? new i95() : new a95();
            }
            return null;
        }
        return (c95) invokeLZ.objValue;
    }
}
