package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class du5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cu5 a() {
        InterceptResult invokeV;
        cu5 cu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (du5.class) {
                if (a == null) {
                    a = new cu5();
                }
                cu5Var = a;
            }
            return cu5Var;
        }
        return (cu5) invokeV.objValue;
    }
}
