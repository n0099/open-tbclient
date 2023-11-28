package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedRoomComponent;
/* loaded from: classes6.dex */
public final class i97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedRoomComponent feedRoomComponent, List<nb7<?>> dataList, n67 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedRoomComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedRoomComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            en6 en6Var = new en6();
            en6Var.p(feedRoomComponent.status);
            en6Var.q(feedRoomComponent.top_label);
            en6Var.l(feedRoomComponent.cover_url);
            en6Var.s(feedRoomComponent.scheme);
            en6Var.x(feedRoomComponent.voice);
            en6Var.t(feedRoomComponent.bottom_labels);
            dataList.add(new ob7(new p47(en6Var, o67.e(feedExtraData, "card_pei_wan_click", null, 2, null), o67.e(feedExtraData, "voice_pei_wan_click", null, 2, null), o67.e(feedExtraData, "card_pei_wan_show", null, 2, null), feedExtraData.a().a(), feedExtraData.c().a()), "pei_wan"));
        }
    }
}
