package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile au3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized au3 a() {
        InterceptResult invokeV;
        au3 au3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bu3.class) {
                if (a == null) {
                    a = new au3();
                }
                au3Var = a;
            }
            return au3Var;
        }
        return (au3) invokeV.objValue;
    }
}
