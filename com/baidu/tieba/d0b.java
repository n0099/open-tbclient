package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class d0b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != -1039745817) {
                if (hashCode != -732377866) {
                    if (hashCode != 3198785 || !str.equals("help")) {
                        return 9;
                    }
                    return 14;
                } else if (!str.equals("article")) {
                    return 9;
                } else {
                    return 11;
                }
            }
            str.equals("normal");
            return 9;
        }
        return invokeL.intValue;
    }
}
