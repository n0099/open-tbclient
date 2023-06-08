package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fq6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eq6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eq6 a() {
        InterceptResult invokeV;
        eq6 eq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fq6.class) {
                if (a == null) {
                    a = new eq6();
                }
                eq6Var = a;
            }
            return eq6Var;
        }
        return (eq6) invokeV.objValue;
    }
}
