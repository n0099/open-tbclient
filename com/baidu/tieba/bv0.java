package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile av0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized av0 a() {
        InterceptResult invokeV;
        av0 av0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bv0.class) {
                if (a == null) {
                    a = new av0();
                }
                av0Var = a;
            }
            return av0Var;
        }
        return (av0) invokeV.objValue;
    }
}
