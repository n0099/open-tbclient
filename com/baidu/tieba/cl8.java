package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class cl8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bl8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bl8 a() {
        InterceptResult invokeV;
        bl8 bl8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cl8.class) {
                if (a == null) {
                    a = new bl8();
                }
                bl8Var = a;
            }
            return bl8Var;
        }
        return (bl8) invokeV.objValue;
    }
}
