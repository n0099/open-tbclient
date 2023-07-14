package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.editortools.BLauncher;
import com.baidu.tbadk.editortools.DLauncher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static hj5 a(Context context, lj5 lj5Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, lj5Var, i)) == null) {
            if (i != 1) {
                return new DLauncher(context, lj5Var);
            }
            return new BLauncher(context, lj5Var);
        }
        return (hj5) invokeLLI.objValue;
    }
}
