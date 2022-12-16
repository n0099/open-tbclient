package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eu3 a() {
        InterceptResult invokeV;
        eu3 eu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fu3.class) {
                if (a == null) {
                    a = new eu3();
                }
                eu3Var = a;
            }
            return eu3Var;
        }
        return (eu3) invokeV.objValue;
    }
}
