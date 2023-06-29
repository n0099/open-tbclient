package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cy9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile by9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized by9 a() {
        InterceptResult invokeV;
        by9 by9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cy9.class) {
                if (a == null) {
                    a = new by9();
                }
                by9Var = a;
            }
            return by9Var;
        }
        return (by9) invokeV.objValue;
    }
}
