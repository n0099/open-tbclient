package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ed4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dd4 a() {
        InterceptResult invokeV;
        dd4 dd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ed4.class) {
                if (a == null) {
                    a = new dd4();
                }
                dd4Var = a;
            }
            return dd4Var;
        }
        return (dd4) invokeV.objValue;
    }
}
