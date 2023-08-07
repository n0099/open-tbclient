package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fw3 a() {
        InterceptResult invokeV;
        fw3 fw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gw3.class) {
                if (a == null) {
                    a = new fw3();
                }
                fw3Var = a;
            }
            return fw3Var;
        }
        return (fw3) invokeV.objValue;
    }
}
