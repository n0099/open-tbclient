package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ec4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ec4 a() {
        InterceptResult invokeV;
        ec4 ec4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fc4.class) {
                if (a == null) {
                    a = new ec4();
                }
                ec4Var = a;
            }
            return ec4Var;
        }
        return (ec4) invokeV.objValue;
    }
}
