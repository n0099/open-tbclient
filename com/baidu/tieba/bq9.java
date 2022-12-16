package com.baidu.tieba;

import com.baidu.tieba.ow9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Comparator;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class bq9 implements Comparator {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ bq9 a = new bq9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ bq9() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? ow9.b.h((Double) obj, (Double) obj2) : invokeLL.intValue;
    }
}
