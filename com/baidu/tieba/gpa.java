package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fpa a() {
        InterceptResult invokeV;
        fpa fpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gpa.class) {
                if (a == null) {
                    a = new fpa();
                }
                fpaVar = a;
            }
            return fpaVar;
        }
        return (fpa) invokeV.objValue;
    }
}
