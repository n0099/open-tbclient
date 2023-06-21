package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ht9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gt9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gt9 a() {
        InterceptResult invokeV;
        gt9 gt9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ht9.class) {
                if (a == null) {
                    a = new gt9();
                }
                gt9Var = a;
            }
            return gt9Var;
        }
        return (gt9) invokeV.objValue;
    }
}
