package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dr6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cr6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cr6 a() {
        InterceptResult invokeV;
        cr6 cr6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dr6.class) {
                if (a == null) {
                    a = new cr6();
                }
                cr6Var = a;
            }
            return cr6Var;
        }
        return (cr6) invokeV.objValue;
    }
}
