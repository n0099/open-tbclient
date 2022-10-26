package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile an2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized an2 a() {
        InterceptResult invokeV;
        an2 an2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bn2.class) {
                if (a == null) {
                    a = new an2();
                }
                an2Var = a;
            }
            return an2Var;
        }
        return (an2) invokeV.objValue;
    }
}
