package com.baidu.tieba;

import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.FeedItem;
/* loaded from: classes6.dex */
public final class h97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final m47 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            p57 p57Var = new p57();
            p57Var.l = jSONObject.optString("appid");
            p57Var.m = item.name;
            p57Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                p57Var.c = (float) item.icon_ratio.doubleValue();
            }
            p57Var.n = jSONObject.optString("apk_name");
            p57Var.o = jSONObject.optString("version");
            p57Var.p = jSONObject.optInt("version_code");
            p57Var.q = jSONObject.optLong("size");
            p57Var.r = item.button_link;
            p57Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                p57Var.f = (float) item.score.doubleValue();
            }
            p57Var.g = item.tags;
            p57Var.s = jSONObject.optString("developer");
            p57Var.t = jSONObject.optString("publisher");
            p57Var.u = jSONObject.optString("authority_url");
            p57Var.v = jSONObject.optString("privacy_url");
            p57Var.w = jSONObject.optInt("pkg_source");
            p57Var.h = item.button_name;
            p57Var.a = j;
            p57Var.k = forumName;
            ma7 ma7Var = new ma7();
            ma7Var.a = tid;
            ma7Var.b = pageFrom;
            return new m47(p57Var, ma7Var, false, 4, null);
        }
        return (m47) invokeCommon.objValue;
    }

    public static final q47 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            o77 o77Var = new o77();
            o77Var.a = j;
            o77Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                o77Var.c = (float) item.icon_ratio.doubleValue();
            }
            o77Var.d = item.name;
            o77Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                o77Var.f = (float) item.score.doubleValue();
            }
            o77Var.g = item.tags;
            o77Var.h = item.button_name;
            o77Var.i = item.button_link;
            o77Var.k = forumName;
            na7 na7Var = new na7();
            na7Var.a = tid;
            na7Var.b = pageFrom;
            return new q47(o77Var, na7Var, false, 4, null);
        }
        return (q47) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<rb7<?>> dataList, r67 feedExtraData) {
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
            HashMap<String, String> a2 = va7.a.a(feedItem.business_info);
            String str5 = a2.get("apk_detail");
            String str6 = feedExtraData.a().a().get("thread_id");
            if (str6 == null) {
                str = "";
            } else {
                str = str6;
            }
            long j = JavaTypesHelper.toLong(a2.get("item_id"), 0L);
            String str7 = a2.get("forum_name");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            yb7 yb7Var = feedExtraData.e().get(PageInfo.KEY);
            if (yb7Var == null || (a = yb7Var.a(new v57())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new sb7(b(feedItem, j, str, str2, str3), "mount"));
            } else {
                dataList.add(new sb7(a(feedItem, str5, j, str, str2, str3), "mount_app"));
            }
        }
    }
}
