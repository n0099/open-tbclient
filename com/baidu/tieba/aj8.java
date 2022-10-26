package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class aj8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zi8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zi8 a() {
        InterceptResult invokeV;
        zi8 zi8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aj8.class) {
                if (a == null) {
                    a = new zi8();
                }
                zi8Var = a;
            }
            return zi8Var;
        }
        return (zi8) invokeV.objValue;
    }
}
