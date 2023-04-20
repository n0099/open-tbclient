package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class dt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ct3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ct3 a() {
        InterceptResult invokeV;
        ct3 ct3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dt3.class) {
                if (a == null) {
                    a = new ct3();
                }
                ct3Var = a;
            }
            return ct3Var;
        }
        return (ct3) invokeV.objValue;
    }
}
