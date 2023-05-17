package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class hz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gz3 a() {
        InterceptResult invokeV;
        gz3 gz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hz3.class) {
                if (a == null) {
                    a = new gz3();
                }
                gz3Var = a;
            }
            return gz3Var;
        }
        return (gz3) invokeV.objValue;
    }
}
