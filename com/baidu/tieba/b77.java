package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.tieba.a87;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedContentResource;
import tbclient.FeedItem;
import tbclient.FeedKV;
import tbclient.FeedOriginComponent;
import tbclient.FeedOriginPic;
import tbclient.PicInfo;
import tbclient.VideoField;
/* loaded from: classes5.dex */
public final class b77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedOriginComponent feedOriginComponent, List<t87<?>> dataList, v57 feedExtraData) {
        u47 u47Var;
        y47 y47Var;
        String str;
        n47 n47Var;
        r47 r47Var;
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedOriginComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedOriginComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            List<FeedContentResource> _abstract = feedOriginComponent._abstract;
            Intrinsics.checkNotNullExpressionValue(_abstract, "_abstract");
            m47 a = t67.a(spannableStringBuilder, _abstract, new v57());
            if (a.g()) {
                FeedOriginPic feedOriginPic = feedOriginComponent.pic_info;
                if (feedOriginPic != null && feedOriginPic.pics != null) {
                    String str3 = feedOriginPic.schema;
                    if (str3 == null) {
                        str3 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str3, "pic_info.schema ?: \"\"");
                    }
                    List<PicInfo> list = feedOriginComponent.pic_info.pics;
                    Intrinsics.checkNotNullExpressionValue(list, "pic_info.pics");
                    u47Var = c77.a(list, str3, new v57());
                } else {
                    u47Var = null;
                }
                if (feedOriginComponent.video != null) {
                    p67 p67Var = new p67();
                    String schema = feedOriginComponent.schema;
                    Intrinsics.checkNotNullExpressionValue(schema, "schema");
                    p67Var.g(schema);
                    VideoField video = feedOriginComponent.video;
                    Intrinsics.checkNotNullExpressionValue(video, "video");
                    y47Var = g77.b(video, p67Var, new v57());
                } else {
                    y47Var = null;
                }
                a87.a aVar = a87.a;
                List<FeedKV> list2 = feedOriginComponent.item.business_info;
                Intrinsics.checkNotNullExpressionValue(list2, "item.business_info");
                HashMap<String, String> a2 = aVar.a(list2);
                String str4 = a2.get("apk_detail");
                String str5 = feedExtraData.a().a().get("origin_thread_id");
                if (str5 == null) {
                    str = "";
                } else {
                    str = str5;
                }
                long g = vg.g(a2.get("item_id"), 0L);
                if (str4 == null) {
                    String str6 = feedOriginComponent.item.name;
                    if (str6 != null && str6.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        FeedItem item = feedOriginComponent.item;
                        Intrinsics.checkNotNullExpressionValue(item, "item");
                        r47 b = x67.b(item, g, str, "", "");
                        b.a().j = R.color.CAM_X0205;
                        b.d(false);
                        r47Var = b;
                    } else {
                        r47Var = null;
                    }
                    n47Var = null;
                } else {
                    FeedItem item2 = feedOriginComponent.item;
                    Intrinsics.checkNotNullExpressionValue(item2, "item");
                    n47 a3 = x67.a(item2, str4, g, str, "", "");
                    a3.a().j = R.color.CAM_X0205;
                    a3.d(false);
                    n47Var = a3;
                    r47Var = null;
                }
                m67 b2 = w57.b(feedExtraData, "origin_card_click");
                String str7 = feedOriginComponent.schema;
                if (str7 == null) {
                    str2 = "";
                } else {
                    str2 = str7;
                }
                dataList.add(new u87(new t47(a, u47Var, y47Var, r47Var, n47Var, str2, b2, null, 128, null), "origin_card"));
            }
        }
    }
}
