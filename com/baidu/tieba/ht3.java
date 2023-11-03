package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ht3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gt3 a() {
        InterceptResult invokeV;
        gt3 gt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ht3.class) {
                if (a == null) {
                    a = new gt3();
                }
                gt3Var = a;
            }
            return gt3Var;
        }
        return (gt3) invokeV.objValue;
    }
}
