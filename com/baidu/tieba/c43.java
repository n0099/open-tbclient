package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c43 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b43 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b43 a() {
        InterceptResult invokeV;
        b43 b43Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c43.class) {
                if (a == null) {
                    a = new b43();
                }
                b43Var = a;
            }
            return b43Var;
        }
        return (b43) invokeV.objValue;
    }
}
