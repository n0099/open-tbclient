package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bka a() {
        InterceptResult invokeV;
        bka bkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cka.class) {
                if (a == null) {
                    a = new bka();
                }
                bkaVar = a;
            }
            return bkaVar;
        }
        return (bka) invokeV.objValue;
    }
}
