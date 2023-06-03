package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hna {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gna a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gna a() {
        InterceptResult invokeV;
        gna gnaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hna.class) {
                if (a == null) {
                    a = new gna();
                }
                gnaVar = a;
            }
            return gnaVar;
        }
        return (gna) invokeV.objValue;
    }
}
