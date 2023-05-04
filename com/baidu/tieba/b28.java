package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (i != 6) {
                if (i != 8) {
                    if (i != 30) {
                        switch (i) {
                            case 10:
                                return 6;
                            case 11:
                                return 7;
                            case 12:
                                return 8;
                            default:
                                return -2;
                        }
                    }
                    return -9;
                }
                return 5;
            }
            return -1;
        }
        return invokeI.intValue;
    }
}
