package com.baidu.tieba;

import com.baidu.tieba.ts9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Comparator;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class gm9 implements Comparator {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ gm9 a = new gm9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ gm9() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? ts9.b.h((Double) obj, (Double) obj2) : invokeLL.intValue;
    }
}
