package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ac4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ac4 a() {
        InterceptResult invokeV;
        ac4 ac4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bc4.class) {
                if (a == null) {
                    a = new ac4();
                }
                ac4Var = a;
            }
            return ac4Var;
        }
        return (ac4) invokeV.objValue;
    }
}
