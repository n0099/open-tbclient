package com.baidu.tieba;

import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tieba.iz6;
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
public final class fy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final vv6 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            pw6 pw6Var = new pw6();
            pw6Var.l = jSONObject.optString("appid");
            pw6Var.m = item.name;
            pw6Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                pw6Var.c = (float) item.icon_ratio.doubleValue();
            }
            pw6Var.n = jSONObject.optString("apk_name");
            pw6Var.o = jSONObject.optString("version");
            pw6Var.p = jSONObject.optInt("version_code");
            pw6Var.q = jSONObject.optLong("size");
            pw6Var.r = item.button_link;
            pw6Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                pw6Var.f = (float) item.score.doubleValue();
            }
            pw6Var.g = item.tags;
            pw6Var.s = jSONObject.optString("developer");
            pw6Var.t = jSONObject.optString("publisher");
            pw6Var.u = jSONObject.optString("authority_url");
            pw6Var.v = jSONObject.optString("privacy_url");
            pw6Var.w = jSONObject.optInt("pkg_source");
            pw6Var.h = item.button_name;
            pw6Var.a = j;
            pw6Var.k = forumName;
            cz6 cz6Var = new cz6();
            cz6Var.a = tid;
            cz6Var.b = pageFrom;
            return new vv6(pw6Var, cz6Var, false, 4, null);
        }
        return (vv6) invokeCommon.objValue;
    }

    public static final zv6 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            nx6 nx6Var = new nx6();
            nx6Var.a = j;
            nx6Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                nx6Var.c = (float) item.icon_ratio.doubleValue();
            }
            nx6Var.d = item.name;
            nx6Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                nx6Var.f = (float) item.score.doubleValue();
            }
            nx6Var.g = item.tags;
            nx6Var.h = item.button_name;
            nx6Var.i = item.button_link;
            nx6Var.k = forumName;
            dz6 dz6Var = new dz6();
            dz6Var.a = tid;
            dz6Var.b = pageFrom;
            return new zv6(nx6Var, dz6Var, false, 4, null);
        }
        return (zv6) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<b07<?>> dataList, dx6 feedExtraData) {
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
            iz6.a aVar = iz6.a;
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
            e07 e07Var = feedExtraData.d().get(PageInfo.KEY);
            if (e07Var == null || (a = e07Var.a(new qw6())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new c07(b(feedItem, g, str, str2, str3), "mount"));
            } else {
                dataList.add(new c07(a(feedItem, str5, g, str, str2, str3), "mount_app"));
            }
        }
    }
}
