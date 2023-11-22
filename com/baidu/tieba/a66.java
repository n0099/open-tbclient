package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z56 a() {
        InterceptResult invokeV;
        z56 z56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a66.class) {
                if (a == null) {
                    a = new z56();
                }
                z56Var = a;
            }
            return z56Var;
        }
        return (z56) invokeV.objValue;
    }
}
