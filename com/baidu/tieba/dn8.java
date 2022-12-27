package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class dn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cn8 a() {
        InterceptResult invokeV;
        cn8 cn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dn8.class) {
                if (a == null) {
                    a = new cn8();
                }
                cn8Var = a;
            }
            return cn8Var;
        }
        return (cn8) invokeV.objValue;
    }
}
