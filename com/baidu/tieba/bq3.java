package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile aq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized aq3 a() {
        InterceptResult invokeV;
        aq3 aq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bq3.class) {
                if (a == null) {
                    a = new aq3();
                }
                aq3Var = a;
            }
            return aq3Var;
        }
        return (aq3) invokeV.objValue;
    }
}
