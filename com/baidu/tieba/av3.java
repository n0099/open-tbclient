package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class av3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zu3 a() {
        InterceptResult invokeV;
        zu3 zu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (av3.class) {
                if (a == null) {
                    a = new zu3();
                }
                zu3Var = a;
            }
            return zu3Var;
        }
        return (zu3) invokeV.objValue;
    }
}
