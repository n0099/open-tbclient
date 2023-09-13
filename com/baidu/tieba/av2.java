package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class av2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zu2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zu2 a() {
        InterceptResult invokeV;
        zu2 zu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (av2.class) {
                if (a == null) {
                    a = new zu2();
                }
                zu2Var = a;
            }
            return zu2Var;
        }
        return (zu2) invokeV.objValue;
    }
}
