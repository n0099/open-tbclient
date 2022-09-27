package com.baidu.tieba;

import com.baidu.tieba.sq9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Comparator;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class fk9 implements Comparator {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ fk9 a = new fk9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ fk9() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? sq9.b.h((Double) obj, (Double) obj2) : invokeLL.intValue;
    }
}
