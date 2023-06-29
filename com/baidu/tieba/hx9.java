package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hx9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gx9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gx9 a() {
        InterceptResult invokeV;
        gx9 gx9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hx9.class) {
                if (a == null) {
                    a = new gx9();
                }
                gx9Var = a;
            }
            return gx9Var;
        }
        return (gx9) invokeV.objValue;
    }
}
