package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fw0 a() {
        InterceptResult invokeV;
        fw0 fw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gw0.class) {
                if (a == null) {
                    a = new fw0();
                }
                fw0Var = a;
            }
            return fw0Var;
        }
        return (fw0) invokeV.objValue;
    }
}
