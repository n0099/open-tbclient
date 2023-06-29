package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ia6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ha6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ha6 a() {
        InterceptResult invokeV;
        ha6 ha6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ia6.class) {
                if (a == null) {
                    a = new ha6();
                }
                ha6Var = a;
            }
            return ha6Var;
        }
        return (ha6) invokeV.objValue;
    }
}
