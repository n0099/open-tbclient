package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class eo8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile do8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized do8 a() {
        InterceptResult invokeV;
        do8 do8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eo8.class) {
                if (a == null) {
                    a = new do8();
                }
                do8Var = a;
            }
            return do8Var;
        }
        return (do8) invokeV.objValue;
    }
}
