package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a66 a() {
        InterceptResult invokeV;
        a66 a66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b66.class) {
                if (a == null) {
                    a = new a66();
                }
                a66Var = a;
            }
            return a66Var;
        }
        return (a66) invokeV.objValue;
    }
}
