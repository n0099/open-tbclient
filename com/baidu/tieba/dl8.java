package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class dl8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cl8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cl8 a() {
        InterceptResult invokeV;
        cl8 cl8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dl8.class) {
                if (a == null) {
                    a = new cl8();
                }
                cl8Var = a;
            }
            return cl8Var;
        }
        return (cl8) invokeV.objValue;
    }
}
