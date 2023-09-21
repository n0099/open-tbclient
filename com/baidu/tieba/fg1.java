package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fg1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eg1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eg1 a() {
        InterceptResult invokeV;
        eg1 eg1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fg1.class) {
                if (a == null) {
                    a = new eg1();
                }
                eg1Var = a;
            }
            return eg1Var;
        }
        return (eg1) invokeV.objValue;
    }
}
