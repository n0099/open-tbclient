package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class et5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dt5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dt5 a() {
        InterceptResult invokeV;
        dt5 dt5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (et5.class) {
                if (a == null) {
                    a = new dt5();
                }
                dt5Var = a;
            }
            return dt5Var;
        }
        return (dt5) invokeV.objValue;
    }
}
