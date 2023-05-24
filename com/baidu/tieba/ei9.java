package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ei9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile di9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized di9 a() {
        InterceptResult invokeV;
        di9 di9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ei9.class) {
                if (a == null) {
                    a = new di9();
                }
                di9Var = a;
            }
            return di9Var;
        }
        return (di9) invokeV.objValue;
    }
}
