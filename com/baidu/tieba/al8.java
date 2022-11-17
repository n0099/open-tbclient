package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class al8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zk8 a() {
        InterceptResult invokeV;
        zk8 zk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (al8.class) {
                if (a == null) {
                    a = new zk8();
                }
                zk8Var = a;
            }
            return zk8Var;
        }
        return (zk8) invokeV.objValue;
    }
}
