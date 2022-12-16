package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bl3 a() {
        InterceptResult invokeV;
        bl3 bl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cl3.class) {
                if (a == null) {
                    a = new bl3();
                }
                bl3Var = a;
            }
            return bl3Var;
        }
        return (bl3) invokeV.objValue;
    }
}
