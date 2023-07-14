package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ag4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ag4 a() {
        InterceptResult invokeV;
        ag4 ag4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bg4.class) {
                if (a == null) {
                    a = new ag4();
                }
                ag4Var = a;
            }
            return ag4Var;
        }
        return (ag4) invokeV.objValue;
    }
}
