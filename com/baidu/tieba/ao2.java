package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ao2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zn2 a() {
        InterceptResult invokeV;
        zn2 zn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ao2.class) {
                if (a == null) {
                    a = new zn2();
                }
                zn2Var = a;
            }
            return zn2Var;
        }
        return (zn2) invokeV.objValue;
    }
}
