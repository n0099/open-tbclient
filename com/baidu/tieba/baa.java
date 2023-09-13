package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class baa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile aaa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized aaa a() {
        InterceptResult invokeV;
        aaa aaaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (baa.class) {
                if (a == null) {
                    a = new aaa();
                }
                aaaVar = a;
            }
            return aaaVar;
        }
        return (aaa) invokeV.objValue;
    }
}
