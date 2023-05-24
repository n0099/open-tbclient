package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dl9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cl9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cl9 a() {
        InterceptResult invokeV;
        cl9 cl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dl9.class) {
                if (a == null) {
                    a = new cl9();
                }
                cl9Var = a;
            }
            return cl9Var;
        }
        return (cl9) invokeV.objValue;
    }
}
