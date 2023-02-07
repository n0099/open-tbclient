package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gw8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fw8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fw8 a() {
        InterceptResult invokeV;
        fw8 fw8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gw8.class) {
                if (a == null) {
                    a = new fw8();
                }
                fw8Var = a;
            }
            return fw8Var;
        }
        return (fw8) invokeV.objValue;
    }
}
