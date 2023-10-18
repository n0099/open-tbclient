package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ep2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dp2 a() {
        InterceptResult invokeV;
        dp2 dp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ep2.class) {
                if (a == null) {
                    a = new dp2();
                }
                dp2Var = a;
            }
            return dp2Var;
        }
        return (dp2) invokeV.objValue;
    }
}
