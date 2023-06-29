package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ex3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dx3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dx3 a() {
        InterceptResult invokeV;
        dx3 dx3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ex3.class) {
                if (a == null) {
                    a = new dx3();
                }
                dx3Var = a;
            }
            return dx3Var;
        }
        return (dx3) invokeV.objValue;
    }
}
