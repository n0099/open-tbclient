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
public final class d97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final i47 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            l57 l57Var = new l57();
            l57Var.l = jSONObject.optString("appid");
            l57Var.m = item.name;
            l57Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                l57Var.c = (float) item.icon_ratio.doubleValue();
            }
            l57Var.n = jSONObject.optString("apk_name");
            l57Var.o = jSONObject.optString("version");
            l57Var.p = jSONObject.optInt("version_code");
            l57Var.q = jSONObject.optLong("size");
            l57Var.r = item.button_link;
            l57Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                l57Var.f = (float) item.score.doubleValue();
            }
            l57Var.g = item.tags;
            l57Var.s = jSONObject.optString("developer");
            l57Var.t = jSONObject.optString("publisher");
            l57Var.u = jSONObject.optString("authority_url");
            l57Var.v = jSONObject.optString("privacy_url");
            l57Var.w = jSONObject.optInt("pkg_source");
            l57Var.h = item.button_name;
            l57Var.a = j;
            l57Var.k = forumName;
            ia7 ia7Var = new ia7();
            ia7Var.a = tid;
            ia7Var.b = pageFrom;
            return new i47(l57Var, ia7Var, false, 4, null);
        }
        return (i47) invokeCommon.objValue;
    }

    public static final m47 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            k77 k77Var = new k77();
            k77Var.a = j;
            k77Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                k77Var.c = (float) item.icon_ratio.doubleValue();
            }
            k77Var.d = item.name;
            k77Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                k77Var.f = (float) item.score.doubleValue();
            }
            k77Var.g = item.tags;
            k77Var.h = item.button_name;
            k77Var.i = item.button_link;
            k77Var.k = forumName;
            ja7 ja7Var = new ja7();
            ja7Var.a = tid;
            ja7Var.b = pageFrom;
            return new m47(k77Var, ja7Var, false, 4, null);
        }
        return (m47) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<nb7<?>> dataList, n67 feedExtraData) {
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
            HashMap<String, String> a2 = ra7.a.a(feedItem.business_info);
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
            ub7 ub7Var = feedExtraData.e().get(PageInfo.KEY);
            if (ub7Var == null || (a = ub7Var.a(new r57())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new ob7(b(feedItem, j, str, str2, str3), "mount"));
            } else {
                dataList.add(new ob7(a(feedItem, str5, j, str, str2, str3), "mount_app"));
            }
        }
    }
}
