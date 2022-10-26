package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bs5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile as5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized as5 a() {
        InterceptResult invokeV;
        as5 as5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bs5.class) {
                if (a == null) {
                    a = new as5();
                }
                as5Var = a;
            }
            return as5Var;
        }
        return (as5) invokeV.objValue;
    }
}
