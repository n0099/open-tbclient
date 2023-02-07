package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ba4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile aa4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized aa4 a() {
        InterceptResult invokeV;
        aa4 aa4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ba4.class) {
                if (a == null) {
                    a = new aa4();
                }
                aa4Var = a;
            }
            return aa4Var;
        }
        return (aa4) invokeV.objValue;
    }
}
