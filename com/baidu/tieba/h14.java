package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g14 a() {
        InterceptResult invokeV;
        g14 g14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h14.class) {
                if (a == null) {
                    a = new g14();
                }
                g14Var = a;
            }
            return g14Var;
        }
        return (g14) invokeV.objValue;
    }
}
