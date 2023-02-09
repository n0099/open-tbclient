package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cx8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bx8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bx8 a() {
        InterceptResult invokeV;
        bx8 bx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cx8.class) {
                if (a == null) {
                    a = new bx8();
                }
                bx8Var = a;
            }
            return bx8Var;
        }
        return (bx8) invokeV.objValue;
    }
}
