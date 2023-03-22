package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fr2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile er2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized er2 a() {
        InterceptResult invokeV;
        er2 er2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fr2.class) {
                if (a == null) {
                    a = new er2();
                }
                er2Var = a;
            }
            return er2Var;
        }
        return (er2) invokeV.objValue;
    }
}
