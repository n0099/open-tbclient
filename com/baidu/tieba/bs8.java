package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bs8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile as8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized as8 a() {
        InterceptResult invokeV;
        as8 as8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bs8.class) {
                if (a == null) {
                    a = new as8();
                }
                as8Var = a;
            }
            return as8Var;
        }
        return (as8) invokeV.objValue;
    }
}
