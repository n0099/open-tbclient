package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class eo2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile do2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized do2 a() {
        InterceptResult invokeV;
        do2 do2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eo2.class) {
                if (a == null) {
                    a = new do2();
                }
                do2Var = a;
            }
            return do2Var;
        }
        return (do2) invokeV.objValue;
    }
}
