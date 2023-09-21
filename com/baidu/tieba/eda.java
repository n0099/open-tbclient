package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class eda {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dda a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dda a() {
        InterceptResult invokeV;
        dda ddaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eda.class) {
                if (a == null) {
                    a = new dda();
                }
                ddaVar = a;
            }
            return ddaVar;
        }
        return (dda) invokeV.objValue;
    }
}
