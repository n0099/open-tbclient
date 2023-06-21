package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ez3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ez3 a() {
        InterceptResult invokeV;
        ez3 ez3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fz3.class) {
                if (a == null) {
                    a = new ez3();
                }
                ez3Var = a;
            }
            return ez3Var;
        }
        return (ez3) invokeV.objValue;
    }
}
