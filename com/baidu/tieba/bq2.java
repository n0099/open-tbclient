package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bq2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile aq2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized aq2 a() {
        InterceptResult invokeV;
        aq2 aq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bq2.class) {
                if (a == null) {
                    a = new aq2();
                }
                aq2Var = a;
            }
            return aq2Var;
        }
        return (aq2) invokeV.objValue;
    }
}
