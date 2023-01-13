package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gl3 a() {
        InterceptResult invokeV;
        gl3 gl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hl3.class) {
                if (a == null) {
                    a = new gl3();
                }
                gl3Var = a;
            }
            return gl3Var;
        }
        return (gl3) invokeV.objValue;
    }
}
