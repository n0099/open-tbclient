package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cv6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bv6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bv6 a() {
        InterceptResult invokeV;
        bv6 bv6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cv6.class) {
                if (a == null) {
                    a = new bv6();
                }
                bv6Var = a;
            }
            return bv6Var;
        }
        return (bv6) invokeV.objValue;
    }
}
