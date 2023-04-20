package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fq3 a() {
        InterceptResult invokeV;
        fq3 fq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gq3.class) {
                if (a == null) {
                    a = new fq3();
                }
                fq3Var = a;
            }
            return fq3Var;
        }
        return (fq3) invokeV.objValue;
    }
}
