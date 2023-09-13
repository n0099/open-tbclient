package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h14 a() {
        InterceptResult invokeV;
        h14 h14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i14.class) {
                if (a == null) {
                    a = new h14();
                }
                h14Var = a;
            }
            return h14Var;
        }
        return (h14) invokeV.objValue;
    }
}
