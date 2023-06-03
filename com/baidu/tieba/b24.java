package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a24 a() {
        InterceptResult invokeV;
        a24 a24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b24.class) {
                if (a == null) {
                    a = new a24();
                }
                a24Var = a;
            }
            return a24Var;
        }
        return (a24) invokeV.objValue;
    }
}
