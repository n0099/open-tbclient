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
/* loaded from: classes5.dex */
public final class c57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final r17 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            t27 t27Var = new t27();
            t27Var.l = jSONObject.optString("appid");
            t27Var.m = item.name;
            t27Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                t27Var.c = (float) item.icon_ratio.doubleValue();
            }
            t27Var.n = jSONObject.optString("apk_name");
            t27Var.o = jSONObject.optString("version");
            t27Var.p = jSONObject.optInt("version_code");
            t27Var.q = jSONObject.optLong("size");
            t27Var.r = item.button_link;
            t27Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                t27Var.f = (float) item.score.doubleValue();
            }
            t27Var.g = item.tags;
            t27Var.s = jSONObject.optString("developer");
            t27Var.t = jSONObject.optString("publisher");
            t27Var.u = jSONObject.optString("authority_url");
            t27Var.v = jSONObject.optString("privacy_url");
            t27Var.w = jSONObject.optInt("pkg_source");
            t27Var.h = item.button_name;
            t27Var.a = j;
            t27Var.k = forumName;
            e67 e67Var = new e67();
            e67Var.a = tid;
            e67Var.b = pageFrom;
            return new r17(t27Var, e67Var, false, 4, null);
        }
        return (r17) invokeCommon.objValue;
    }

    public static final v17 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            d47 d47Var = new d47();
            d47Var.a = j;
            d47Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                d47Var.c = (float) item.icon_ratio.doubleValue();
            }
            d47Var.d = item.name;
            d47Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                d47Var.f = (float) item.score.doubleValue();
            }
            d47Var.g = item.tags;
            d47Var.h = item.button_name;
            d47Var.i = item.button_link;
            d47Var.k = forumName;
            f67 f67Var = new f67();
            f67Var.a = tid;
            f67Var.b = pageFrom;
            return new v17(d47Var, f67Var, false, 4, null);
        }
        return (v17) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<h77<?>> dataList, k37 feedExtraData) {
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
            HashMap<String, String> a2 = m67.a.a(feedItem.business_info);
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
            l77 l77Var = feedExtraData.e().get(PageInfo.KEY);
            if (l77Var == null || (a = l77Var.a(new v27())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new i77(b(feedItem, j, str, str2, str3), "mount"));
            } else {
                dataList.add(new i77(a(feedItem, str5, j, str, str2, str3), "mount_app"));
            }
        }
    }
}
