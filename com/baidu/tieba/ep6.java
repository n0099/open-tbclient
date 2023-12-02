package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ep6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dp6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dp6 a() {
        InterceptResult invokeV;
        dp6 dp6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ep6.class) {
                if (a == null) {
                    a = new dp6();
                }
                dp6Var = a;
            }
            return dp6Var;
        }
        return (dp6) invokeV.objValue;
    }
}
