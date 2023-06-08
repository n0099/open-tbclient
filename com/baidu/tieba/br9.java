package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class br9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ar9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ar9 a() {
        InterceptResult invokeV;
        ar9 ar9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (br9.class) {
                if (a == null) {
                    a = new ar9();
                }
                ar9Var = a;
            }
            return ar9Var;
        }
        return (ar9) invokeV.objValue;
    }
}
