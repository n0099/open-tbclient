package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ha3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static FullScreenFloatView a(Context context, ViewGroup viewGroup, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, viewGroup, i)) == null) {
            if (context != null && viewGroup != null) {
                FullScreenFloatView b = b(context, i);
                viewGroup.addView(b);
                return b;
            }
            return null;
        }
        return (FullScreenFloatView) invokeLLI.objValue;
    }

    public static FullScreenFloatView b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i)) == null) {
            if (context == null) {
                return null;
            }
            int i2 = R.layout.obfuscated_res_0x7f0d00ac;
            if (i != 1 && i == 2) {
                i2 = R.layout.obfuscated_res_0x7f0d00ad;
            }
            return (FullScreenFloatView) LayoutInflater.from(context.getApplicationContext()).inflate(i2, (ViewGroup) null);
        }
        return (FullScreenFloatView) invokeLI.objValue;
    }
}
