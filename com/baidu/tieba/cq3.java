package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bq3 a() {
        InterceptResult invokeV;
        bq3 bq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cq3.class) {
                if (a == null) {
                    a = new bq3();
                }
                bq3Var = a;
            }
            return bq3Var;
        }
        return (bq3) invokeV.objValue;
    }
}
