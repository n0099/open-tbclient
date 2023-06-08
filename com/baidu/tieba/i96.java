package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h96 a() {
        InterceptResult invokeV;
        h96 h96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i96.class) {
                if (a == null) {
                    a = new h96();
                }
                h96Var = a;
            }
            return h96Var;
        }
        return (h96) invokeV.objValue;
    }
}
