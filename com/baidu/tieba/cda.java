package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cda {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bda a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bda a() {
        InterceptResult invokeV;
        bda bdaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cda.class) {
                if (a == null) {
                    a = new bda();
                }
                bdaVar = a;
            }
            return bdaVar;
        }
        return (bda) invokeV.objValue;
    }
}
