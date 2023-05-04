package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: HeaderViewLogic.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class bh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ch7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return new dh7();
        }
        return (ch7) invokeV.objValue;
    }

    public static View b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            return view2.findViewById(R.id.obfuscated_res_0x7f090c74);
        }
        return (View) invokeL.objValue;
    }

    @NonNull
    public static TextView c(@NonNull View view2, boolean z) {
        InterceptResult invokeLZ;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, view2, z)) == null) {
            if (z) {
                textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e80);
            } else {
                textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e81);
            }
            textView.bringToFront();
            g35.d(textView).w(R.color.CAM_X0619);
            return textView;
        }
        return (TextView) invokeLZ.objValue;
    }

    public static void d(@NonNull View view2, @NonNull View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view2, view3) == null) {
            g35 d = g35.d(view2);
            d.o(R.string.J_X11);
            d.t(R.array.Mask_X005);
        }
    }
}
