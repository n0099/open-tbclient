package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bc4 a() {
        InterceptResult invokeV;
        bc4 bc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cc4.class) {
                if (a == null) {
                    a = new bc4();
                }
                bc4Var = a;
            }
            return bc4Var;
        }
        return (bc4) invokeV.objValue;
    }
}
