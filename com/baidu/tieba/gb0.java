package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gb0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fb0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fb0 a() {
        InterceptResult invokeV;
        fb0 fb0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gb0.class) {
                if (a == null) {
                    a = new fb0();
                }
                fb0Var = a;
            }
            return fb0Var;
        }
        return (fb0) invokeV.objValue;
    }
}
