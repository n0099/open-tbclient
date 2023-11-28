package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes5.dex */
public final class ee7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a(String active, String task) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, active, task)) == null) {
            Intrinsics.checkNotNullParameter(active, "active");
            Intrinsics.checkNotNullParameter(task, "task");
            return active + SignatureImpl.SEP + task;
        }
        return (String) invokeLL.objValue;
    }
}
