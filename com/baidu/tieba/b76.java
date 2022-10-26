package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class b76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final z66 a(Comparable initial, Function1 change) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, initial, change)) == null) {
            Intrinsics.checkNotNullParameter(initial, "initial");
            Intrinsics.checkNotNullParameter(change, "change");
            return new z66(initial, change);
        }
        return (z66) invokeLL.objValue;
    }
}
