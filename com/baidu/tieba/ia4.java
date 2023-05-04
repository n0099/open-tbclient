package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ia4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ha4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ha4 a() {
        InterceptResult invokeV;
        ha4 ha4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ia4.class) {
                if (a == null) {
                    a = new ha4();
                }
                ha4Var = a;
            }
            return ha4Var;
        }
        return (ha4) invokeV.objValue;
    }
}
