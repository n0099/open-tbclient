package com.baidu.tieba.feed.data.protobuf;

import android.content.Context;
import com.baidu.tieba.c87;
import com.baidu.tieba.e87;
import com.baidu.tieba.k57;
import com.baidu.tieba.m87;
import com.baidu.tieba.r67;
import com.baidu.tieba.rb7;
import com.baidu.tieba.s67;
import com.baidu.tieba.sb7;
import com.baidu.tieba.w97;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Agree;
import tbclient.FeedSocialComponent;
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"onShowManageClickImpl", "Lkotlin/Function2;", "Landroid/content/Context;", "Lcom/baidu/tieba/feed/data/SocialMeta;", "", "insertTemplateList", "", "Ltbclient/FeedSocialComponent;", "dataList", "", "Lcom/baidu/tieba/feed/list/TemplateData;", "feedExtraData", "Lcom/baidu/tieba/feed/data/FeedExtraData;", "videoSchemaData", "Lcom/baidu/tieba/feed/data/VideoSchemaData;", "lib-templates_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedSocialExtensionKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function2<Context, c87, Boolean> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1695353344, "Lcom/baidu/tieba/feed/data/protobuf/FeedSocialExtensionKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1695353344, "Lcom/baidu/tieba/feed/data/protobuf/FeedSocialExtensionKt;");
                return;
            }
        }
        a = FeedSocialExtensionKt$onShowManageClickImpl$1.INSTANCE;
    }

    public static final void a(FeedSocialComponent feedSocialComponent, List<rb7<?>> dataList, r67 feedExtraData, m87 videoSchemaData) {
        List list;
        k57 k57Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, feedSocialComponent, dataList, feedExtraData, videoSchemaData) == null) {
            Intrinsics.checkNotNullParameter(feedSocialComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Intrinsics.checkNotNullParameter(videoSchemaData, "videoSchemaData");
            c87 c87Var = new c87();
            Agree agree = feedSocialComponent.agree;
            if (agree != null) {
                Integer num = agree.agree_type;
                Intrinsics.checkNotNullExpressionValue(num, "agree.agree_type");
                c87Var.e = num.intValue();
                Integer num2 = feedSocialComponent.agree.has_agree;
                Intrinsics.checkNotNullExpressionValue(num2, "agree.has_agree");
                if (num2.intValue() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                c87Var.f = z;
                c87Var.g = feedSocialComponent.agree.agree_num.longValue();
                Long l = feedSocialComponent.agree.diff_agree_num;
                Intrinsics.checkNotNullExpressionValue(l, "agree.diff_agree_num");
                c87Var.h = l.longValue();
                Long l2 = feedSocialComponent.agree.disagree_num;
                Intrinsics.checkNotNullExpressionValue(l2, "agree.disagree_num");
                c87Var.i = l2.longValue();
            }
            c87Var.a = feedSocialComponent.share_num.intValue();
            c87Var.b = feedSocialComponent.comment_num.intValue();
            c87Var.c = String.valueOf(feedSocialComponent.tid);
            Long fid = feedSocialComponent.fid;
            Intrinsics.checkNotNullExpressionValue(fid, "fid");
            c87Var.d = fid.longValue();
            c87Var.l = feedExtraData.a();
            videoSchemaData.h(c87Var.f);
            videoSchemaData.g(c87Var.g);
            String str = c87Var.l.a().get("user_id");
            if (str == null) {
                str = "";
            }
            videoSchemaData.k(str);
            String str2 = c87Var.l.a().get("has_concerned_user");
            if (str2 == null) {
                str2 = "0";
            }
            videoSchemaData.i(str2);
            c87Var.j = videoSchemaData;
            c87Var.m = w97.b(feedSocialComponent.manage_list);
            List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new e87[]{s67.e(feedExtraData, "comment_btn_click", null, 2, null), s67.e(feedExtraData, "comment_btn_click2", null, 2, null), s67.e(feedExtraData, "comment_btn_click3", null, 2, null), s67.e(feedExtraData, "bottom_comment_click_selector1", null, 2, null)});
            List listOf2 = CollectionsKt__CollectionsJVMKt.listOf(s67.e(feedExtraData, "bottom_share_click_selector1", null, 2, null));
            List listOf3 = CollectionsKt__CollectionsJVMKt.listOf(s67.e(feedExtraData, "bottom_agree_click_selector1", null, 2, null));
            Map<String, String> a2 = feedExtraData.a().a();
            Map<String, String> a3 = feedExtraData.c().a();
            if (c87Var.a()) {
                list = listOf2;
                k57Var = new k57(c87Var, null, null, null, a2, a3, null, null, null, a, 462, null);
            } else {
                list = listOf2;
                k57Var = new k57(c87Var, null, null, null, a2, a3, null, null, null, null, 974, null);
            }
            k57Var.t(CollectionsKt___CollectionsKt.plus((Collection) k57Var.l(), (Iterable) listOf));
            k57Var.v(CollectionsKt___CollectionsKt.plus((Collection) k57Var.s(), (Iterable) list));
            k57Var.u(CollectionsKt___CollectionsKt.plus((Collection) k57Var.r(), (Iterable) listOf3));
            dataList.add(new sb7(k57Var, "social_bar"));
        }
    }
}
