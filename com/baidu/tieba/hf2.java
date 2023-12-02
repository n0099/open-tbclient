package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hf2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static sf2 a(@NonNull qf2 qf2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qf2Var)) == null) {
            int i = qf2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new rf2(qf2Var);
                        }
                        return new vf2(qf2Var);
                    }
                    return new tf2(qf2Var);
                }
                return new wf2(qf2Var);
            }
            return new uf2(qf2Var);
        }
        return (sf2) invokeL.objValue;
    }
}
