package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cx9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bx9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bx9 a() {
        InterceptResult invokeV;
        bx9 bx9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cx9.class) {
                if (a == null) {
                    a = new bx9();
                }
                bx9Var = a;
            }
            return bx9Var;
        }
        return (bx9) invokeV.objValue;
    }
}
