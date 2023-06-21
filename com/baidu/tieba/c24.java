package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b24 a() {
        InterceptResult invokeV;
        b24 b24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c24.class) {
                if (a == null) {
                    a = new b24();
                }
                b24Var = a;
            }
            return b24Var;
        }
        return (b24) invokeV.objValue;
    }
}
