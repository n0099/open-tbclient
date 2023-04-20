package com.baidu.tieba;

import com.baidu.tieba.jz6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedKV;
import tbclient.FeedLayout;
/* loaded from: classes4.dex */
public final class fx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(ex6 ex6Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, ex6Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(ex6Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            rw6 a = ex6Var.a();
            jz6.a aVar = jz6.a;
            List<FeedKV> list = feedLayout.business_info;
            Intrinsics.checkNotNullExpressionValue(list, "feedLayout.business_info");
            a.b(aVar.a(list));
            nx6 b = ex6Var.b();
            jz6.a aVar2 = jz6.a;
            List<FeedKV> list2 = feedLayout.log_info;
            Intrinsics.checkNotNullExpressionValue(list2, "feedLayout.log_info");
            b.b(aVar2.a(list2));
        }
    }

    public static final vx6 b(ex6 ex6Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ex6Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(ex6Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            vx6 vx6Var = new vx6(null, null, null, 7, null);
            f07 f07Var = ex6Var.d().get(statStrategyKey);
            if (f07Var != null) {
                return new vx6(f07Var.getKey(), f07Var.a(ex6Var.a()), ex6Var.b().a());
            }
            return vx6Var;
        }
        return (vx6) invokeLL.objValue;
    }
}
