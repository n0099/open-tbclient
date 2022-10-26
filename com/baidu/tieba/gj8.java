package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gj8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fj8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fj8 a() {
        InterceptResult invokeV;
        fj8 fj8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gj8.class) {
                if (a == null) {
                    a = new fj8();
                }
                fj8Var = a;
            }
            return fj8Var;
        }
        return (fj8) invokeV.objValue;
    }
}
