package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bv3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile av3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized av3 a() {
        InterceptResult invokeV;
        av3 av3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bv3.class) {
                if (a == null) {
                    a = new av3();
                }
                av3Var = a;
            }
            return av3Var;
        }
        return (av3) invokeV.objValue;
    }
}
