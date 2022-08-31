package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ep5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dp5 a() {
        InterceptResult invokeV;
        dp5 dp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ep5.class) {
                if (a == null) {
                    a = new dp5();
                }
                dp5Var = a;
            }
            return dp5Var;
        }
        return (dp5) invokeV.objValue;
    }
}
