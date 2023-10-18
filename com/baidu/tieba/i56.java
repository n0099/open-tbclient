package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h56 a() {
        InterceptResult invokeV;
        h56 h56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i56.class) {
                if (a == null) {
                    a = new h56();
                }
                h56Var = a;
            }
            return h56Var;
        }
        return (h56) invokeV.objValue;
    }
}
