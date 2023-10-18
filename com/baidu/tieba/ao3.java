package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ao3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zn3 a() {
        InterceptResult invokeV;
        zn3 zn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ao3.class) {
                if (a == null) {
                    a = new zn3();
                }
                zn3Var = a;
            }
            return zn3Var;
        }
        return (zn3) invokeV.objValue;
    }
}
