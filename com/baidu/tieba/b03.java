package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b03 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a03 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a03 a() {
        InterceptResult invokeV;
        a03 a03Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b03.class) {
                if (a == null) {
                    a = new a03();
                }
                a03Var = a;
            }
            return a03Var;
        }
        return (a03) invokeV.objValue;
    }
}
