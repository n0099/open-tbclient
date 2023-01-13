package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class co2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bo2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bo2 a() {
        InterceptResult invokeV;
        bo2 bo2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (co2.class) {
                if (a == null) {
                    a = new bo2();
                }
                bo2Var = a;
            }
            return bo2Var;
        }
        return (bo2) invokeV.objValue;
    }
}
