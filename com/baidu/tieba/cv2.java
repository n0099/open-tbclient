package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bv2 a() {
        InterceptResult invokeV;
        bv2 bv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cv2.class) {
                if (a == null) {
                    a = new bv2();
                }
                bv2Var = a;
            }
            return bv2Var;
        }
        return (bv2) invokeV.objValue;
    }
}
