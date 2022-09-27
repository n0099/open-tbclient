package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class e44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d44 a() {
        InterceptResult invokeV;
        d44 d44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e44.class) {
                if (a == null) {
                    a = new d44();
                }
                d44Var = a;
            }
            return d44Var;
        }
        return (d44) invokeV.objValue;
    }
}
