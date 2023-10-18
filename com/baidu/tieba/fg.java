package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fg {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eg a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eg a() {
        InterceptResult invokeV;
        eg egVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fg.class) {
                if (a == null) {
                    a = new eg();
                }
                egVar = a;
            }
            return egVar;
        }
        return (eg) invokeV.objValue;
    }
}
