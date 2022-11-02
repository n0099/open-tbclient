package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ak8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ak8 a() {
        InterceptResult invokeV;
        ak8 ak8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bk8.class) {
                if (a == null) {
                    a = new ak8();
                }
                ak8Var = a;
            }
            return ak8Var;
        }
        return (ak8) invokeV.objValue;
    }
}
