package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fi3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ei3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ei3 a() {
        InterceptResult invokeV;
        ei3 ei3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fi3.class) {
                if (a == null) {
                    a = new ei3();
                }
                ei3Var = a;
            }
            return ei3Var;
        }
        return (ei3) invokeV.objValue;
    }
}
