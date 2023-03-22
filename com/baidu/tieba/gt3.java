package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ft3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ft3 a() {
        InterceptResult invokeV;
        ft3 ft3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gt3.class) {
                if (a == null) {
                    a = new ft3();
                }
                ft3Var = a;
            }
            return ft3Var;
        }
        return (ft3) invokeV.objValue;
    }
}
