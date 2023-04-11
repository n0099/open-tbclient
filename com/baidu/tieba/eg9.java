package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class eg9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dg9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dg9 a() {
        InterceptResult invokeV;
        dg9 dg9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eg9.class) {
                if (a == null) {
                    a = new dg9();
                }
                dg9Var = a;
            }
            return dg9Var;
        }
        return (dg9) invokeV.objValue;
    }
}
