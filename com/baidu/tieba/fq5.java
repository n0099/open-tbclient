package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fq5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eq5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eq5 a() {
        InterceptResult invokeV;
        eq5 eq5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fq5.class) {
                if (a == null) {
                    a = new eq5();
                }
                eq5Var = a;
            }
            return eq5Var;
        }
        return (eq5) invokeV.objValue;
    }
}
