package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class e04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d04 a() {
        InterceptResult invokeV;
        d04 d04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e04.class) {
                if (a == null) {
                    a = new d04();
                }
                d04Var = a;
            }
            return d04Var;
        }
        return (d04) invokeV.objValue;
    }
}
