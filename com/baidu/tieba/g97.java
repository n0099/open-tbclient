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
public final class g97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final x57 a(FeedItem item, String apkDetailStr, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{item, apkDetailStr, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(apkDetailStr, "apkDetailStr");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            JSONObject jSONObject = new JSONObject(apkDetailStr);
            y67 y67Var = new y67();
            y67Var.l = jSONObject.optString("appid");
            y67Var.m = item.name;
            y67Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                y67Var.c = (float) item.icon_ratio.doubleValue();
            }
            y67Var.n = jSONObject.optString("apk_name");
            y67Var.o = jSONObject.optString("version");
            y67Var.p = jSONObject.optInt("version_code");
            y67Var.q = jSONObject.optLong("size");
            y67Var.r = item.button_link;
            y67Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                y67Var.f = (float) item.score.doubleValue();
            }
            y67Var.g = item.tags;
            y67Var.s = jSONObject.optString("developer");
            y67Var.t = jSONObject.optString("publisher");
            y67Var.u = jSONObject.optString("authority_url");
            y67Var.v = jSONObject.optString("privacy_url");
            y67Var.w = jSONObject.optInt("pkg_source");
            y67Var.h = item.button_name;
            y67Var.a = j;
            y67Var.k = forumName;
            ha7 ha7Var = new ha7();
            ha7Var.a = tid;
            ha7Var.b = pageFrom;
            return new x57(y67Var, ha7Var, false, 4, null);
        }
        return (x57) invokeCommon.objValue;
    }

    public static final b67 b(FeedItem item, long j, String tid, String forumName, String pageFrom) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{item, Long.valueOf(j), tid, forumName, pageFrom})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            Intrinsics.checkNotNullParameter(pageFrom, "pageFrom");
            i87 i87Var = new i87();
            i87Var.a = j;
            i87Var.b = item.icon_url;
            Double d = item.icon_ratio;
            if (d != null) {
                d.doubleValue();
                i87Var.c = (float) item.icon_ratio.doubleValue();
            }
            i87Var.d = item.name;
            i87Var.e = 1;
            Double d2 = item.score;
            if (d2 != null) {
                d2.doubleValue();
                i87Var.f = (float) item.score.doubleValue();
            }
            i87Var.g = item.tags;
            i87Var.h = item.button_name;
            i87Var.i = item.button_link;
            i87Var.k = forumName;
            ia7 ia7Var = new ia7();
            ia7Var.a = tid;
            ia7Var.b = pageFrom;
            return new b67(i87Var, ia7Var, false, 4, null);
        }
        return (b67) invokeCommon.objValue;
    }

    public static final void c(FeedItem feedItem, List<jb7<?>> dataList, p77 feedExtraData) {
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
            HashMap<String, String> a2 = oa7.a.a(feedItem.business_info);
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
            nb7 nb7Var = feedExtraData.e().get(PageInfo.KEY);
            if (nb7Var == null || (a = nb7Var.a(new a77())) == null || (str4 = a.get("page_from")) == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str5 == null) {
                dataList.add(new kb7(b(feedItem, j, str, str2, str3), "mount"));
            } else {
                dataList.add(new kb7(a(feedItem, str5, j, str, str2, str3), "mount_app"));
            }
        }
    }
}
