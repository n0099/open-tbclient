package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hs5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gs5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gs5 a() {
        InterceptResult invokeV;
        gs5 gs5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hs5.class) {
                if (a == null) {
                    a = new gs5();
                }
                gs5Var = a;
            }
            return gs5Var;
        }
        return (gs5) invokeV.objValue;
    }
}
