package com.baidu.tieba;

import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tieba.jz6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.FeedItem;
import tbclient.FeedKV;
/* loaded from: classes4.dex */
public final class gy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final wv6 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            qw6 qw6Var = new qw6();
            qw6Var.l = jSONObject.optString("appid");
            qw6Var.m = item.name;
            qw6Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                qw6Var.c = (float) item.icon_ratio.doubleValue();
            }
            qw6Var.n = jSONObject.optString("apk_name");
            qw6Var.o = jSONObject.optString("version");
            qw6Var.p = jSONObject.optInt("version_code");
            qw6Var.q = jSONObject.optLong("size");
            qw6Var.r = item.button_link;
            qw6Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                qw6Var.f = (float) item.score.doubleValue();
            }
            qw6Var.g = item.tags;
            qw6Var.s = jSONObject.optString("developer");
            qw6Var.t = jSONObject.optString("publisher");
            qw6Var.u = jSONObject.optString("authority_url");
            qw6Var.v = jSONObject.optString("privacy_url");
            qw6Var.w = jSONObject.optInt("pkg_source");
            qw6Var.h = item.button_name;
            qw6Var.a = j;
            qw6Var.k = forumName;
            dz6 dz6Var = new dz6();
            dz6Var.a = tid;
            dz6Var.b = pageFrom;
            return new wv6(qw6Var, dz6Var, false, 4, null);
        }
        return (wv6) invokeCommon.objValue;
    }

    public static final aw6 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            ox6 ox6Var = new ox6();
            ox6Var.a = j;
            ox6Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                ox6Var.c = (float) item.icon_ratio.doubleValue();
            }
            ox6Var.d = item.name;
            ox6Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                ox6Var.f = (float) item.score.doubleValue();
            }
            ox6Var.g = item.tags;
            ox6Var.h = item.button_name;
            ox6Var.i = item.button_link;
            ox6Var.k = forumName;
            ez6 ez6Var = new ez6();
            ez6Var.a = tid;
            ez6Var.b = pageFrom;
            return new aw6(ox6Var, ez6Var, false, 4, null);
        }
        return (aw6) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<c07<?>> dataList, ex6 feedExtraData) {
        String str;
        String str2;
        String str3;
        Map<String, String> a;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, feedItem, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedItem, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            jz6.a aVar = jz6.a;
            List<FeedKV> business_info = feedItem.business_info;
            Intrinsics.checkNotNullExpressionValue(business_info, "business_info");
            HashMap<String, String> a2 = aVar.a(business_info);
            String str5 = a2.get("apk_detail");
            String str6 = feedExtraData.a().a().get("thread_id");
            if (str6 == null) {
                str = "";
            } else {
                str = str6;
            }
            long g = gg.g(a2.get("item_id"), 0L);
            String str7 = a2.get("forum_name");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            f07 f07Var = feedExtraData.d().get(PageInfo.KEY);
            if (f07Var == null || (a = f07Var.a(new rw6())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new d07(b(feedItem, g, str, str2, str3), "mount"));
            } else {
                dataList.add(new d07(a(feedItem, str5, g, str, str2, str3), "mount_app"));
            }
        }
    }
}
