package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class an3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zm3 a() {
        InterceptResult invokeV;
        zm3 zm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (an3.class) {
                if (a == null) {
                    a = new zm3();
                }
                zm3Var = a;
            }
            return zm3Var;
        }
        return (zm3) invokeV.objValue;
    }
}
