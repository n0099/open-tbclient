package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ao8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zn8 a() {
        InterceptResult invokeV;
        zn8 zn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ao8.class) {
                if (a == null) {
                    a = new zn8();
                }
                zn8Var = a;
            }
            return zn8Var;
        }
        return (zn8) invokeV.objValue;
    }
}
