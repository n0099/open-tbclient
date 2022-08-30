package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fg8 a() {
        InterceptResult invokeV;
        fg8 fg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gg8.class) {
                if (a == null) {
                    a = new fg8();
                }
                fg8Var = a;
            }
            return fg8Var;
        }
        return (fg8) invokeV.objValue;
    }
}
