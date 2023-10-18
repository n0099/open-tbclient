package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes5.dex */
public final class f57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<h77<?>> dataList, k37 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            a47 a47Var = new a47();
            a47Var.a = feedLiveComponent.top_label;
            a47Var.b = feedLiveComponent.bottom_label;
            a47Var.c = feedLiveComponent.audience_label;
            a47Var.d = feedLiveComponent.cover_url;
            a47Var.f = feedLiveComponent.schema;
            a47Var.e = l37.d(feedExtraData, "live_head_show", null, 2, null);
            dataList.add(new i77(new u17(a47Var, CollectionsKt__CollectionsKt.listOf((Object[]) new n47[]{l37.d(feedExtraData, "live_click", null, 2, null), l37.d(feedExtraData, "live_click2", null, 2, null), l37.d(feedExtraData, "live_click3", null, 2, null)}), null, 4, null), "live"));
        }
    }
}
