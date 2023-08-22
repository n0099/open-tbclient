package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ca6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ba6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ba6 a() {
        InterceptResult invokeV;
        ba6 ba6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ca6.class) {
                if (a == null) {
                    a = new ba6();
                }
                ba6Var = a;
            }
            return ba6Var;
        }
        return (ba6) invokeV.objValue;
    }
}
