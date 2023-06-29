package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ig4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hg4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hg4 a() {
        InterceptResult invokeV;
        hg4 hg4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ig4.class) {
                if (a == null) {
                    a = new hg4();
                }
                hg4Var = a;
            }
            return hg4Var;
        }
        return (hg4) invokeV.objValue;
    }
}
