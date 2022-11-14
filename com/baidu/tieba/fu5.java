package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fu5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eu5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eu5 a() {
        InterceptResult invokeV;
        eu5 eu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fu5.class) {
                if (a == null) {
                    a = new eu5();
                }
                eu5Var = a;
            }
            return eu5Var;
        }
        return (eu5) invokeV.objValue;
    }
}
