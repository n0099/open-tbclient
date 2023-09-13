package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cc4 a() {
        InterceptResult invokeV;
        cc4 cc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dc4.class) {
                if (a == null) {
                    a = new cc4();
                }
                cc4Var = a;
            }
            return cc4Var;
        }
        return (cc4) invokeV.objValue;
    }
}
