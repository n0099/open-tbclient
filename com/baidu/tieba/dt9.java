package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dt9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ct9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ct9 a() {
        InterceptResult invokeV;
        ct9 ct9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dt9.class) {
                if (a == null) {
                    a = new ct9();
                }
                ct9Var = a;
            }
            return ct9Var;
        }
        return (ct9) invokeV.objValue;
    }
}
