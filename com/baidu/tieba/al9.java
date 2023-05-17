package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class al9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zk9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zk9 a() {
        InterceptResult invokeV;
        zk9 zk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (al9.class) {
                if (a == null) {
                    a = new zk9();
                }
                zk9Var = a;
            }
            return zk9Var;
        }
        return (zk9) invokeV.objValue;
    }
}
