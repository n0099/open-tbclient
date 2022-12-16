package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile er3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized er3 a() {
        InterceptResult invokeV;
        er3 er3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fr3.class) {
                if (a == null) {
                    a = new er3();
                }
                er3Var = a;
            }
            return er3Var;
        }
        return (er3) invokeV.objValue;
    }
}
