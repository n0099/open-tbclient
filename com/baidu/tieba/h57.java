package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedRoomComponent;
/* loaded from: classes6.dex */
public final class h57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedRoomComponent feedRoomComponent, List<h77<?>> dataList, k37 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedRoomComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedRoomComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            wk6 wk6Var = new wk6();
            wk6Var.p(feedRoomComponent.status);
            wk6Var.q(feedRoomComponent.top_label);
            wk6Var.l(feedRoomComponent.cover_url);
            wk6Var.r(feedRoomComponent.scheme);
            wk6Var.v(feedRoomComponent.voice);
            wk6Var.t(feedRoomComponent.bottom_labels);
            dataList.add(new i77(new y17(wk6Var, l37.d(feedExtraData, "card_pei_wan_click", null, 2, null), l37.d(feedExtraData, "voice_pei_wan_click", null, 2, null), l37.d(feedExtraData, "card_pei_wan_show", null, 2, null)), "pei_wan"));
        }
    }
}
