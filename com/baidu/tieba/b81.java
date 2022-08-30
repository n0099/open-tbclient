package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b81 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a81 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a81 a() {
        InterceptResult invokeV;
        a81 a81Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b81.class) {
                if (a == null) {
                    a = new a81();
                }
                a81Var = a;
            }
            return a81Var;
        }
        return (a81) invokeV.objValue;
    }
}
