package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes5.dex */
public final class a77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<t87<?>> dataList, v57 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            c67 c67Var = new c67();
            c67Var.a = feedLiveComponent.top_label;
            c67Var.b = feedLiveComponent.bottom_label;
            c67Var.c = feedLiveComponent.audience_label;
            c67Var.d = feedLiveComponent.cover_url;
            c67Var.f = feedLiveComponent.schema;
            c67Var.e = w57.b(feedExtraData, "live_head_show");
            dataList.add(new u87(new q47(c67Var, null, 2, null), "live"));
        }
    }
}
