package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes6.dex */
public final class g97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<nb7<?>> dataList, n67 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            h77 h77Var = new h77();
            h77Var.a = feedLiveComponent.top_label;
            h77Var.b = feedLiveComponent.bottom_label;
            h77Var.c = feedLiveComponent.audience_label;
            h77Var.d = feedLiveComponent.cover_url;
            h77Var.f = feedLiveComponent.schema;
            h77Var.e = o67.e(feedExtraData, "live_head_show", null, 2, null);
            dataList.add(new ob7(new l47(h77Var, CollectionsKt__CollectionsKt.listOf((Object[]) new a87[]{o67.e(feedExtraData, "live_click", null, 2, null), o67.e(feedExtraData, "live_click2", null, 2, null), o67.e(feedExtraData, "live_click3", null, 2, null)}), feedExtraData.a().a(), feedExtraData.c().a(), null, 16, null), "live"));
        }
    }
}
