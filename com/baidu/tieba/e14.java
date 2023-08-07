package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d14 a() {
        InterceptResult invokeV;
        d14 d14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e14.class) {
                if (a == null) {
                    a = new d14();
                }
                d14Var = a;
            }
            return d14Var;
        }
        return (d14) invokeV.objValue;
    }
}
