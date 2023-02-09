package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gx8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fx8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fx8 a() {
        InterceptResult invokeV;
        fx8 fx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gx8.class) {
                if (a == null) {
                    a = new fx8();
                }
                fx8Var = a;
            }
            return fx8Var;
        }
        return (fx8) invokeV.objValue;
    }
}
