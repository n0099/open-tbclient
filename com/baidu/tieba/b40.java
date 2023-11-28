package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b40 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a40 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a40 a() {
        InterceptResult invokeV;
        a40 a40Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b40.class) {
                if (a == null) {
                    a = new a40();
                }
                a40Var = a;
            }
            return a40Var;
        }
        return (a40) invokeV.objValue;
    }
}
