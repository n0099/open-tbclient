package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class an2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zm2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zm2 a() {
        InterceptResult invokeV;
        zm2 zm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (an2.class) {
                if (a == null) {
                    a = new zm2();
                }
                zm2Var = a;
            }
            return zm2Var;
        }
        return (zm2) invokeV.objValue;
    }
}
