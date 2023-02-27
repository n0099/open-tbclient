package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class dt2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ct2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ct2 a() {
        InterceptResult invokeV;
        ct2 ct2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dt2.class) {
                if (a == null) {
                    a = new ct2();
                }
                ct2Var = a;
            }
            return ct2Var;
        }
        return (ct2) invokeV.objValue;
    }
}
