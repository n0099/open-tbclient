package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class e74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d74 a() {
        InterceptResult invokeV;
        d74 d74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e74.class) {
                if (a == null) {
                    a = new d74();
                }
                d74Var = a;
            }
            return d74Var;
        }
        return (d74) invokeV.objValue;
    }
}
