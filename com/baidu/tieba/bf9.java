package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bf9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile af9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized af9 a() {
        InterceptResult invokeV;
        af9 af9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bf9.class) {
                if (a == null) {
                    a = new af9();
                }
                af9Var = a;
            }
            return af9Var;
        }
        return (af9) invokeV.objValue;
    }
}
