package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile az3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized az3 a() {
        InterceptResult invokeV;
        az3 az3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bz3.class) {
                if (a == null) {
                    a = new az3();
                }
                az3Var = a;
            }
            return az3Var;
        }
        return (az3) invokeV.objValue;
    }
}
