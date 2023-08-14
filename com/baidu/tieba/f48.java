package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public final class f48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final e48 a(DataRes.Builder builderData, ThreadInfo threadInfo) {
        InterceptResult invokeLL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, builderData, threadInfo)) == null) {
            Intrinsics.checkNotNullParameter(builderData, "builderData");
            Intrinsics.checkNotNullParameter(threadInfo, "threadInfo");
            Long l = threadInfo.tid;
            Intrinsics.checkNotNullExpressionValue(l, "threadInfo.tid");
            e48 e48Var = new e48(l.longValue(), false, 2, null);
            Integer num2 = builderData.is_need_live_ununiq;
            if (num2 != null && num2.intValue() == 1 && (num = threadInfo.thread_type) != null && num.intValue() == 69) {
                e48Var.b(false);
            }
            return e48Var;
        }
        return (e48) invokeLL.objValue;
    }
}
