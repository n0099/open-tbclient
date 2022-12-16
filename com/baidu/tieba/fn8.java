package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile en8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized en8 a() {
        InterceptResult invokeV;
        en8 en8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fn8.class) {
                if (a == null) {
                    a = new en8();
                }
                en8Var = a;
            }
            return en8Var;
        }
        return (en8) invokeV.objValue;
    }
}
