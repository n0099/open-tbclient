package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ada {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zca a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zca a() {
        InterceptResult invokeV;
        zca zcaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ada.class) {
                if (a == null) {
                    a = new zca();
                }
                zcaVar = a;
            }
            return zcaVar;
        }
        return (zca) invokeV.objValue;
    }
}
