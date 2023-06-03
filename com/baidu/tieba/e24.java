package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d24 a() {
        InterceptResult invokeV;
        d24 d24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e24.class) {
                if (a == null) {
                    a = new d24();
                }
                d24Var = a;
            }
            return d24Var;
        }
        return (d24) invokeV.objValue;
    }
}
