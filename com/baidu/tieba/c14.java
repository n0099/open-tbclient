package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b14 a() {
        InterceptResult invokeV;
        b14 b14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c14.class) {
                if (a == null) {
                    a = new b14();
                }
                b14Var = a;
            }
            return b14Var;
        }
        return (b14) invokeV.objValue;
    }
}
