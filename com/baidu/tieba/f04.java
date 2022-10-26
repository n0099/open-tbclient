package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class f04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e04 a() {
        InterceptResult invokeV;
        e04 e04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f04.class) {
                if (a == null) {
                    a = new e04();
                }
                e04Var = a;
            }
            return e04Var;
        }
        return (e04) invokeV.objValue;
    }
}
