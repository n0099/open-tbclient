package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bs3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile as3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized as3 a() {
        InterceptResult invokeV;
        as3 as3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bs3.class) {
                if (a == null) {
                    a = new as3();
                }
                as3Var = a;
            }
            return as3Var;
        }
        return (as3) invokeV.objValue;
    }
}
