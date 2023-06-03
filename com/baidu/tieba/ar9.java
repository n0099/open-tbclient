package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ar9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zq9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zq9 a() {
        InterceptResult invokeV;
        zq9 zq9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ar9.class) {
                if (a == null) {
                    a = new zq9();
                }
                zq9Var = a;
            }
            return zq9Var;
        }
        return (zq9) invokeV.objValue;
    }
}
