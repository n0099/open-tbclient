package com.baidu.tieba;

import com.baidu.tieba.m27;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedKV;
import tbclient.FeedLayout;
/* loaded from: classes5.dex */
public final class i07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(h07 h07Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, h07Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(h07Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            uz6 a = h07Var.a();
            m27.a aVar = m27.a;
            List<FeedKV> list = feedLayout.business_info;
            Intrinsics.checkNotNullExpressionValue(list, "feedLayout.business_info");
            a.b(aVar.a(list));
            q07 b = h07Var.b();
            m27.a aVar2 = m27.a;
            List<FeedKV> list2 = feedLayout.log_info;
            Intrinsics.checkNotNullExpressionValue(list2, "feedLayout.log_info");
            b.b(aVar2.a(list2));
        }
    }

    public static final y07 b(h07 h07Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, h07Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(h07Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            y07 y07Var = new y07(null, null, null, 7, null);
            i37 i37Var = h07Var.d().get(statStrategyKey);
            if (i37Var != null) {
                return new y07(i37Var.getKey(), i37Var.a(h07Var.a()), h07Var.b().a());
            }
            return y07Var;
        }
        return (y07) invokeLL.objValue;
    }
}
