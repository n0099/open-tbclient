package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c06 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b06 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b06 a() {
        InterceptResult invokeV;
        b06 b06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c06.class) {
                if (a == null) {
                    a = new b06();
                }
                b06Var = a;
            }
            return b06Var;
        }
        return (b06) invokeV.objValue;
    }
}
