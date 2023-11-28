package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c74 a() {
        InterceptResult invokeV;
        c74 c74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d74.class) {
                if (a == null) {
                    a = new c74();
                }
                c74Var = a;
            }
            return c74Var;
        }
        return (c74) invokeV.objValue;
    }
}
