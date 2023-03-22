package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c69 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b69 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b69 a() {
        InterceptResult invokeV;
        b69 b69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c69.class) {
                if (a == null) {
                    a = new b69();
                }
                b69Var = a;
            }
            return b69Var;
        }
        return (b69) invokeV.objValue;
    }
}
