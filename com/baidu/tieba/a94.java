package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a94 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z84 a() {
        InterceptResult invokeV;
        z84 z84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a94.class) {
                if (a == null) {
                    a = new z84();
                }
                z84Var = a;
            }
            return z84Var;
        }
        return (z84) invokeV.objValue;
    }
}
