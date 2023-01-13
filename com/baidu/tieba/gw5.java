package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gw5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fw5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fw5 a() {
        InterceptResult invokeV;
        fw5 fw5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gw5.class) {
                if (a == null) {
                    a = new fw5();
                }
                fw5Var = a;
            }
            return fw5Var;
        }
        return (fw5) invokeV.objValue;
    }
}
