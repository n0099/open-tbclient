package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ek2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static pk2 a(@NonNull nk2 nk2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, nk2Var)) == null) {
            int i = nk2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new ok2(nk2Var);
                        }
                        return new sk2(nk2Var);
                    }
                    return new qk2(nk2Var);
                }
                return new tk2(nk2Var);
            }
            return new rk2(nk2Var);
        }
        return (pk2) invokeL.objValue;
    }
}
