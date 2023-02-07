package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a06 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zz5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zz5 a() {
        InterceptResult invokeV;
        zz5 zz5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a06.class) {
                if (a == null) {
                    a = new zz5();
                }
                zz5Var = a;
            }
            return zz5Var;
        }
        return (zz5) invokeV.objValue;
    }
}
