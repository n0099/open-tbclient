package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class av5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zu5 a() {
        InterceptResult invokeV;
        zu5 zu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (av5.class) {
                if (a == null) {
                    a = new zu5();
                }
                zu5Var = a;
            }
            return zu5Var;
        }
        return (zu5) invokeV.objValue;
    }
}
