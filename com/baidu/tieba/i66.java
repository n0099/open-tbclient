package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h66 a() {
        InterceptResult invokeV;
        h66 h66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i66.class) {
                if (a == null) {
                    a = new h66();
                }
                h66Var = a;
            }
            return h66Var;
        }
        return (h66) invokeV.objValue;
    }
}
