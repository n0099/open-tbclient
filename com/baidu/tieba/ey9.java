package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ey9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dy9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dy9 a() {
        InterceptResult invokeV;
        dy9 dy9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ey9.class) {
                if (a == null) {
                    a = new dy9();
                }
                dy9Var = a;
            }
            return dy9Var;
        }
        return (dy9) invokeV.objValue;
    }
}
