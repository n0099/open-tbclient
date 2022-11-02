package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class cm {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bm a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bm a() {
        InterceptResult invokeV;
        bm bmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cm.class) {
                if (a == null) {
                    a = new bm();
                }
                bmVar = a;
            }
            return bmVar;
        }
        return (bm) invokeV.objValue;
    }
}
