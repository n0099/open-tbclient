package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hr5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gr5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gr5 a() {
        InterceptResult invokeV;
        gr5 gr5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hr5.class) {
                if (a == null) {
                    a = new gr5();
                }
                gr5Var = a;
            }
            return gr5Var;
        }
        return (gr5) invokeV.objValue;
    }
}
