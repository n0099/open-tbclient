package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class dl3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cl3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cl3 a() {
        InterceptResult invokeV;
        cl3 cl3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dl3.class) {
                if (a == null) {
                    a = new cl3();
                }
                cl3Var = a;
            }
            return cl3Var;
        }
        return (cl3) invokeV.objValue;
    }
}
