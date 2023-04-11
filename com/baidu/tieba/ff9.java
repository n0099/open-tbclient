package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ff9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ef9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ef9 a() {
        InterceptResult invokeV;
        ef9 ef9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ff9.class) {
                if (a == null) {
                    a = new ef9();
                }
                ef9Var = a;
            }
            return ef9Var;
        }
        return (ef9) invokeV.objValue;
    }
}
