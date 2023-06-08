package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cr9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cr9 a() {
        InterceptResult invokeV;
        cr9 cr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dr9.class) {
                if (a == null) {
                    a = new cr9();
                }
                cr9Var = a;
            }
            return cr9Var;
        }
        return (cr9) invokeV.objValue;
    }
}
