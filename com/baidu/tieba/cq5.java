package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class cq5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bq5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bq5 a() {
        InterceptResult invokeV;
        bq5 bq5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cq5.class) {
                if (a == null) {
                    a = new bq5();
                }
                bq5Var = a;
            }
            return bq5Var;
        }
        return (bq5) invokeV.objValue;
    }
}
