package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hs8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gs8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gs8 a() {
        InterceptResult invokeV;
        gs8 gs8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hs8.class) {
                if (a == null) {
                    a = new gs8();
                }
                gs8Var = a;
            }
            return gs8Var;
        }
        return (gs8) invokeV.objValue;
    }
}
