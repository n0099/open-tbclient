package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ea4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile da4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized da4 a() {
        InterceptResult invokeV;
        da4 da4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ea4.class) {
                if (a == null) {
                    a = new da4();
                }
                da4Var = a;
            }
            return da4Var;
        }
        return (da4) invokeV.objValue;
    }
}
