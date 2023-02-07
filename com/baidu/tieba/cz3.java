package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bz3 a() {
        InterceptResult invokeV;
        bz3 bz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cz3.class) {
                if (a == null) {
                    a = new bz3();
                }
                bz3Var = a;
            }
            return bz3Var;
        }
        return (bz3) invokeV.objValue;
    }
}
