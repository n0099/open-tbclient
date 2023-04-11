package com.baidu.tieba;

import com.baidu.tieba.iz6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedKV;
import tbclient.FeedLayout;
/* loaded from: classes4.dex */
public final class ex6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(dx6 dx6Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, dx6Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(dx6Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            qw6 a = dx6Var.a();
            iz6.a aVar = iz6.a;
            List<FeedKV> list = feedLayout.business_info;
            Intrinsics.checkNotNullExpressionValue(list, "feedLayout.business_info");
            a.b(aVar.a(list));
            mx6 b = dx6Var.b();
            iz6.a aVar2 = iz6.a;
            List<FeedKV> list2 = feedLayout.log_info;
            Intrinsics.checkNotNullExpressionValue(list2, "feedLayout.log_info");
            b.b(aVar2.a(list2));
        }
    }

    public static final ux6 b(dx6 dx6Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, dx6Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(dx6Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            ux6 ux6Var = new ux6(null, null, null, 7, null);
            e07 e07Var = dx6Var.d().get(statStrategyKey);
            if (e07Var != null) {
                return new ux6(e07Var.getKey(), e07Var.a(dx6Var.a()), dx6Var.b().a());
            }
            return ux6Var;
        }
        return (ux6) invokeLL.objValue;
    }
}
