package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bg9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ag9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ag9 a() {
        InterceptResult invokeV;
        ag9 ag9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bg9.class) {
                if (a == null) {
                    a = new ag9();
                }
                ag9Var = a;
            }
            return ag9Var;
        }
        return (ag9) invokeV.objValue;
    }
}
