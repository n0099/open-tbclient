package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cq2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bq2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bq2 a() {
        InterceptResult invokeV;
        bq2 bq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cq2.class) {
                if (a == null) {
                    a = new bq2();
                }
                bq2Var = a;
            }
            return bq2Var;
        }
        return (bq2) invokeV.objValue;
    }
}
