package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fca {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eca a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eca a() {
        InterceptResult invokeV;
        eca ecaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fca.class) {
                if (a == null) {
                    a = new eca();
                }
                ecaVar = a;
            }
            return ecaVar;
        }
        return (eca) invokeV.objValue;
    }
}
