package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Agree;
import tbclient.FeedSocialComponent;
/* loaded from: classes5.dex */
public final class cb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedSocialComponent feedSocialComponent, List<yc7<?>> dataList, b97 feedExtraData, ia7 videoSchemaData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, feedSocialComponent, dataList, feedExtraData, videoSchemaData) == null) {
            Intrinsics.checkNotNullParameter(feedSocialComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Intrinsics.checkNotNullParameter(videoSchemaData, "videoSchemaData");
            ca7 ca7Var = new ca7();
            Agree agree = feedSocialComponent.agree;
            if (agree != null) {
                Integer num = agree.agree_type;
                Intrinsics.checkNotNullExpressionValue(num, "agree.agree_type");
                ca7Var.e = num.intValue();
                Integer num2 = feedSocialComponent.agree.has_agree;
                Intrinsics.checkNotNullExpressionValue(num2, "agree.has_agree");
                if (num2.intValue() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                ca7Var.f = z;
                ca7Var.g = feedSocialComponent.agree.agree_num.longValue();
                Long l = feedSocialComponent.agree.diff_agree_num;
                Intrinsics.checkNotNullExpressionValue(l, "agree.diff_agree_num");
                ca7Var.h = l.longValue();
                Long l2 = feedSocialComponent.agree.disagree_num;
                Intrinsics.checkNotNullExpressionValue(l2, "agree.disagree_num");
                ca7Var.i = l2.longValue();
            }
            ca7Var.a = feedSocialComponent.share_num.intValue();
            ca7Var.b = feedSocialComponent.comment_num.intValue();
            ca7Var.c = String.valueOf(feedSocialComponent.tid);
            Long fid = feedSocialComponent.fid;
            Intrinsics.checkNotNullExpressionValue(fid, "fid");
            ca7Var.d = fid.longValue();
            ca7Var.l = feedExtraData.a();
            videoSchemaData.h(ca7Var.f);
            videoSchemaData.g(ca7Var.g);
            String str = ca7Var.l.a().get("user_id");
            if (str == null) {
                str = "";
            }
            videoSchemaData.k(str);
            String str2 = ca7Var.l.a().get("has_concerned_user");
            if (str2 == null) {
                str2 = "0";
            }
            videoSchemaData.i(str2);
            ca7Var.j = videoSchemaData;
            List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ea7[]{c97.d(feedExtraData, "comment_btn_click", null, 2, null), c97.d(feedExtraData, "comment_btn_click2", null, 2, null), c97.d(feedExtraData, "comment_btn_click3", null, 2, null), c97.d(feedExtraData, "bottom_comment_click_selector1", null, 2, null)});
            List listOf2 = CollectionsKt__CollectionsJVMKt.listOf(c97.d(feedExtraData, "bottom_share_click_selector1", null, 2, null));
            List listOf3 = CollectionsKt__CollectionsJVMKt.listOf(c97.d(feedExtraData, "bottom_agree_click_selector1", null, 2, null));
            g87 g87Var = new g87(ca7Var, null, null, null, null, null, null, 126, null);
            g87Var.o(CollectionsKt___CollectionsKt.plus((Collection) g87Var.h(), (Iterable) listOf));
            g87Var.q(CollectionsKt___CollectionsKt.plus((Collection) g87Var.n(), (Iterable) listOf2));
            g87Var.p(CollectionsKt___CollectionsKt.plus((Collection) g87Var.m(), (Iterable) listOf3));
            dataList.add(new zc7(g87Var, "social_bar"));
        }
    }
}
