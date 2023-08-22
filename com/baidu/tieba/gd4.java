package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fd4 a() {
        InterceptResult invokeV;
        fd4 fd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gd4.class) {
                if (a == null) {
                    a = new fd4();
                }
                fd4Var = a;
            }
            return fd4Var;
        }
        return (fd4) invokeV.objValue;
    }
}
