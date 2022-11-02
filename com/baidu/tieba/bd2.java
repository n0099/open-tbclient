package com.baidu.tieba;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static md2 a(@NonNull kd2 kd2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, kd2Var)) == null) {
            int i = kd2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new ld2(kd2Var);
                        }
                        return new pd2(kd2Var);
                    }
                    return new nd2(kd2Var);
                }
                return new qd2(kd2Var);
            }
            return new od2(kd2Var);
        }
        return (md2) invokeL.objValue;
    }
}
