package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bh1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ah1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ah1 a() {
        InterceptResult invokeV;
        ah1 ah1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bh1.class) {
                if (a == null) {
                    a = new ah1();
                }
                ah1Var = a;
            }
            return ah1Var;
        }
        return (ah1) invokeV.objValue;
    }
}
