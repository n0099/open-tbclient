package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class an8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zm8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zm8 a() {
        InterceptResult invokeV;
        zm8 zm8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (an8.class) {
                if (a == null) {
                    a = new zm8();
                }
                zm8Var = a;
            }
            return zm8Var;
        }
        return (zm8) invokeV.objValue;
    }
}
