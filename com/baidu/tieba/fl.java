package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fl {
    public static /* synthetic */ Interceptable $ic;
    public static volatile el a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized el a() {
        InterceptResult invokeV;
        el elVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fl.class) {
                if (a == null) {
                    a = new el();
                }
                elVar = a;
            }
            return elVar;
        }
        return (el) invokeV.objValue;
    }
}
