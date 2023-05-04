package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hi9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gi9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gi9 a() {
        InterceptResult invokeV;
        gi9 gi9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hi9.class) {
                if (a == null) {
                    a = new gi9();
                }
                gi9Var = a;
            }
            return gi9Var;
        }
        return (gi9) invokeV.objValue;
    }
}
