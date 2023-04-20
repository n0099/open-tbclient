package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c03 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b03 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b03 a() {
        InterceptResult invokeV;
        b03 b03Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c03.class) {
                if (a == null) {
                    a = new b03();
                }
                b03Var = a;
            }
            return b03Var;
        }
        return (b03) invokeV.objValue;
    }
}
