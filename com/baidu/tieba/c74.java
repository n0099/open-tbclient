package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b74 a() {
        InterceptResult invokeV;
        b74 b74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c74.class) {
                if (a == null) {
                    a = new b74();
                }
                b74Var = a;
            }
            return b74Var;
        }
        return (b74) invokeV.objValue;
    }
}
