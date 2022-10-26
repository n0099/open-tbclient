package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ij8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hj8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hj8 a() {
        InterceptResult invokeV;
        hj8 hj8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ij8.class) {
                if (a == null) {
                    a = new hj8();
                }
                hj8Var = a;
            }
            return hj8Var;
        }
        return (hj8) invokeV.objValue;
    }
}
