package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ex6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dx6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dx6 a() {
        InterceptResult invokeV;
        dx6 dx6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ex6.class) {
                if (a == null) {
                    a = new dx6();
                }
                dx6Var = a;
            }
            return dx6Var;
        }
        return (dx6) invokeV.objValue;
    }
}
