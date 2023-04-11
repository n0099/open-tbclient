package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eq3 a() {
        InterceptResult invokeV;
        eq3 eq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fq3.class) {
                if (a == null) {
                    a = new eq3();
                }
                eq3Var = a;
            }
            return eq3Var;
        }
        return (eq3) invokeV.objValue;
    }
}
