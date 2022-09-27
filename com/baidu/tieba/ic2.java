package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ic2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static tc2 a(@NonNull rc2 rc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rc2Var)) == null) {
            int i = rc2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new sc2(rc2Var);
                        }
                        return new wc2(rc2Var);
                    }
                    return new uc2(rc2Var);
                }
                return new xc2(rc2Var);
            }
            return new vc2(rc2Var);
        }
        return (tc2) invokeL.objValue;
    }
}
