package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b16 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a16 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a16 a() {
        InterceptResult invokeV;
        a16 a16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b16.class) {
                if (a == null) {
                    a = new a16();
                }
                a16Var = a;
            }
            return a16Var;
        }
        return (a16) invokeV.objValue;
    }
}
