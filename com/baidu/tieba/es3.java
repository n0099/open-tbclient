package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class es3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ds3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ds3 a() {
        InterceptResult invokeV;
        ds3 ds3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (es3.class) {
                if (a == null) {
                    a = new ds3();
                }
                ds3Var = a;
            }
            return ds3Var;
        }
        return (ds3) invokeV.objValue;
    }
}
