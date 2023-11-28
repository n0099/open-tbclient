package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hb1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gb1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gb1 a() {
        InterceptResult invokeV;
        gb1 gb1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hb1.class) {
                if (a == null) {
                    a = new gb1();
                }
                gb1Var = a;
            }
            return gb1Var;
        }
        return (gb1) invokeV.objValue;
    }
}
