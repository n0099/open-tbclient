package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class fq2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eq2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eq2 a() {
        InterceptResult invokeV;
        eq2 eq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fq2.class) {
                if (a == null) {
                    a = new eq2();
                }
                eq2Var = a;
            }
            return eq2Var;
        }
        return (eq2) invokeV.objValue;
    }
}
