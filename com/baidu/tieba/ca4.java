package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ca4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ba4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ba4 a() {
        InterceptResult invokeV;
        ba4 ba4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ca4.class) {
                if (a == null) {
                    a = new ba4();
                }
                ba4Var = a;
            }
            return ba4Var;
        }
        return (ba4) invokeV.objValue;
    }
}
