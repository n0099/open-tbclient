package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedContentResource;
import tbclient.FeedItem;
import tbclient.FeedOriginComponent;
import tbclient.FeedOriginPic;
import tbclient.PicInfo;
import tbclient.VideoField;
/* loaded from: classes6.dex */
public final class g57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:42:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(FeedOriginComponent feedOriginComponent, List<h77<?>> dataList, k37 feedExtraData) {
        z17 z17Var;
        g27 g27Var;
        v17 v17Var;
        r17 r17Var;
        String str;
        String str2;
        String str3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedOriginComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedOriginComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            List<FeedContentResource> _abstract = feedOriginComponent._abstract;
            Intrinsics.checkNotNullExpressionValue(_abstract, "_abstract");
            q17 a = z47.a(spannableStringBuilder, _abstract, new k37());
            if (a.i()) {
                FeedOriginPic feedOriginPic = feedOriginComponent.pic_info;
                if (feedOriginPic != null && feedOriginPic.pics != null) {
                    String str4 = feedOriginPic.schema;
                    if (str4 == null) {
                        str4 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str4, "pic_info.schema ?: \"\"");
                    }
                    List<PicInfo> list = feedOriginComponent.pic_info.pics;
                    Intrinsics.checkNotNullExpressionValue(list, "pic_info.pics");
                    z17Var = i57.b(list, str4, new k37());
                } else {
                    z17Var = null;
                }
                if (feedOriginComponent.video != null) {
                    r47 r47Var = new r47();
                    String schema = feedOriginComponent.schema;
                    Intrinsics.checkNotNullExpressionValue(schema, "schema");
                    r47Var.j(schema);
                    VideoField video = feedOriginComponent.video;
                    Intrinsics.checkNotNullExpressionValue(video, "video");
                    g27Var = o57.b(video, r47Var, new k37());
                } else {
                    g27Var = null;
                }
                FeedItem feedItem = feedOriginComponent.item;
                if (feedItem != null) {
                    HashMap<String, String> a2 = m67.a.a(feedItem.business_info);
                    String str5 = a2.get("apk_detail");
                    String str6 = feedExtraData.a().a().get("origin_thread_id");
                    if (str6 == null) {
                        str3 = "";
                    } else {
                        str3 = str6;
                    }
                    long j = JavaTypesHelper.toLong(a2.get("item_id"), 0L);
                    if (str5 == null) {
                        String str7 = feedOriginComponent.item.name;
                        if (str7 != null && str7.length() != 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            FeedItem item = feedOriginComponent.item;
                            Intrinsics.checkNotNullExpressionValue(item, "item");
                            v17 b = c57.b(item, j, str3, "", "");
                            b.a().j = R.color.CAM_X0205;
                            b.d(false);
                            v17Var = b;
                            r17Var = null;
                            n47 d = l37.d(feedExtraData, "origin_card_click", null, 2, null);
                            str = feedOriginComponent.schema;
                            if (str == null) {
                                str2 = "";
                            } else {
                                str2 = str;
                            }
                            dataList.add(new i77(new x17(a, z17Var, g27Var, v17Var, r17Var, str2, d, null, 128, null), "origin_card"));
                        }
                    } else {
                        FeedItem item2 = feedOriginComponent.item;
                        Intrinsics.checkNotNullExpressionValue(item2, "item");
                        r17 a3 = c57.a(item2, str5, j, str3, "", "");
                        a3.a().j = R.color.CAM_X0205;
                        a3.d(false);
                        r17Var = a3;
                        v17Var = null;
                        n47 d2 = l37.d(feedExtraData, "origin_card_click", null, 2, null);
                        str = feedOriginComponent.schema;
                        if (str == null) {
                        }
                        dataList.add(new i77(new x17(a, z17Var, g27Var, v17Var, r17Var, str2, d2, null, 128, null), "origin_card"));
                    }
                }
                v17Var = null;
                r17Var = null;
                n47 d22 = l37.d(feedExtraData, "origin_card_click", null, 2, null);
                str = feedOriginComponent.schema;
                if (str == null) {
                }
                dataList.add(new i77(new x17(a, z17Var, g27Var, v17Var, r17Var, str2, d22, null, 128, null), "origin_card"));
            }
        }
    }
}
