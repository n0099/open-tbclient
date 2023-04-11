package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hf9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gf9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gf9 a() {
        InterceptResult invokeV;
        gf9 gf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hf9.class) {
                if (a == null) {
                    a = new gf9();
                }
                gf9Var = a;
            }
            return gf9Var;
        }
        return (gf9) invokeV.objValue;
    }
}
