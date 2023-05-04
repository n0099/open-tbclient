package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.tieba.z07;
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
/* loaded from: classes3.dex */
public final class a07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedOriginComponent feedOriginComponent, List<s17<?>> dataList, uy6 feedExtraData) {
        tx6 tx6Var;
        xx6 xx6Var;
        String str;
        mx6 mx6Var;
        qx6 qx6Var;
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
            lx6 a = sz6.a(spannableStringBuilder, _abstract, new uy6());
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
                    tx6Var = b07.a(list, str3, new uy6());
                } else {
                    tx6Var = null;
                }
                if (feedOriginComponent.video != null) {
                    oz6 oz6Var = new oz6();
                    String schema = feedOriginComponent.schema;
                    Intrinsics.checkNotNullExpressionValue(schema, "schema");
                    oz6Var.g(schema);
                    VideoField video = feedOriginComponent.video;
                    Intrinsics.checkNotNullExpressionValue(video, "video");
                    xx6Var = f07.b(video, oz6Var, new uy6());
                } else {
                    xx6Var = null;
                }
                z07.a aVar = z07.a;
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
                long g = gg.g(a2.get("item_id"), 0L);
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
                        qx6 b = wz6.b(item, g, str, "", "");
                        b.a().j = R.color.CAM_X0205;
                        b.d(false);
                        qx6Var = b;
                    } else {
                        qx6Var = null;
                    }
                    mx6Var = null;
                } else {
                    FeedItem item2 = feedOriginComponent.item;
                    Intrinsics.checkNotNullExpressionValue(item2, "item");
                    mx6 a3 = wz6.a(item2, str4, g, str, "", "");
                    a3.a().j = R.color.CAM_X0205;
                    a3.d(false);
                    mx6Var = a3;
                    qx6Var = null;
                }
                lz6 b2 = vy6.b(feedExtraData, "origin_card_click");
                String str7 = feedOriginComponent.schema;
                if (str7 == null) {
                    str2 = "";
                } else {
                    str2 = str7;
                }
                dataList.add(new t17(new sx6(a, tx6Var, xx6Var, qx6Var, mx6Var, str2, b2, null, 128, null), "origin_card"));
            }
        }
    }
}
