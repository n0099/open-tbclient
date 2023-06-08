package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class gx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fx3 a() {
        InterceptResult invokeV;
        fx3 fx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gx3.class) {
                if (a == null) {
                    a = new fx3();
                }
                fx3Var = a;
            }
            return fx3Var;
        }
        return (fx3) invokeV.objValue;
    }
}
