package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ak2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static lk2 a(@NonNull jk2 jk2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jk2Var)) == null) {
            int i = jk2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new kk2(jk2Var);
                        }
                        return new ok2(jk2Var);
                    }
                    return new mk2(jk2Var);
                }
                return new pk2(jk2Var);
            }
            return new nk2(jk2Var);
        }
        return (lk2) invokeL.objValue;
    }
}
