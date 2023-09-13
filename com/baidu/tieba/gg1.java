package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gg1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fg1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fg1 a() {
        InterceptResult invokeV;
        fg1 fg1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gg1.class) {
                if (a == null) {
                    a = new fg1();
                }
                fg1Var = a;
            }
            return fg1Var;
        }
        return (fg1) invokeV.objValue;
    }
}
