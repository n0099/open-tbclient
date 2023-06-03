package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class da6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ca6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ca6 a() {
        InterceptResult invokeV;
        ca6 ca6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (da6.class) {
                if (a == null) {
                    a = new ca6();
                }
                ca6Var = a;
            }
            return ca6Var;
        }
        return (ca6) invokeV.objValue;
    }
}
