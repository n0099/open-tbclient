package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class gq9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fq9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fq9 a() {
        InterceptResult invokeV;
        fq9 fq9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gq9.class) {
                if (a == null) {
                    a = new fq9();
                }
                fq9Var = a;
            }
            return fq9Var;
        }
        return (fq9) invokeV.objValue;
    }
}
