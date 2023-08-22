package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile by3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized by3 a() {
        InterceptResult invokeV;
        by3 by3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cy3.class) {
                if (a == null) {
                    a = new by3();
                }
                by3Var = a;
            }
            return by3Var;
        }
        return (by3) invokeV.objValue;
    }
}
