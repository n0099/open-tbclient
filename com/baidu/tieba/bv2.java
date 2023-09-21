package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile av2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized av2 a() {
        InterceptResult invokeV;
        av2 av2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bv2.class) {
                if (a == null) {
                    a = new av2();
                }
                av2Var = a;
            }
            return av2Var;
        }
        return (av2) invokeV.objValue;
    }
}
