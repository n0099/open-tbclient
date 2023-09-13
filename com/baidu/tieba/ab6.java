package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ab6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile za6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized za6 a() {
        InterceptResult invokeV;
        za6 za6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ab6.class) {
                if (a == null) {
                    a = new za6();
                }
                za6Var = a;
            }
            return za6Var;
        }
        return (za6) invokeV.objValue;
    }
}
