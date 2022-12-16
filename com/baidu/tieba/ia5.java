package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ia5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ha5 a(View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, view2, z)) == null) {
            if (view2 == null) {
                return null;
            }
            if (view2 instanceof LinearLayout) {
                return new ja5();
            }
            if (view2 instanceof RelativeLayout) {
                return new ma5();
            }
            if (!(view2 instanceof FrameLayout)) {
                return null;
            }
            if (z) {
                return new na5();
            }
            return new fa5();
        }
        return (ha5) invokeLZ.objValue;
    }
}
