package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hs3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gs3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gs3 a() {
        InterceptResult invokeV;
        gs3 gs3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hs3.class) {
                if (a == null) {
                    a = new gs3();
                }
                gs3Var = a;
            }
            return gs3Var;
        }
        return (gs3) invokeV.objValue;
    }
}
