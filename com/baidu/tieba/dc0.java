package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dc0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cc0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cc0 a() {
        InterceptResult invokeV;
        cc0 cc0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dc0.class) {
                if (a == null) {
                    a = new cc0();
                }
                cc0Var = a;
            }
            return cc0Var;
        }
        return (cc0) invokeV.objValue;
    }
}
