package com.baidu.tieba.feed.data.protobuf;

import android.content.Context;
import com.baidu.tieba.a87;
import com.baidu.tieba.g57;
import com.baidu.tieba.i87;
import com.baidu.tieba.n67;
import com.baidu.tieba.nb7;
import com.baidu.tieba.o67;
import com.baidu.tieba.ob7;
import com.baidu.tieba.s97;
import com.baidu.tieba.y77;
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
    public static final Function2<Context, y77, Boolean> a;
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

    public static final void a(FeedSocialComponent feedSocialComponent, List<nb7<?>> dataList, n67 feedExtraData, i87 videoSchemaData) {
        List list;
        g57 g57Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, feedSocialComponent, dataList, feedExtraData, videoSchemaData) == null) {
            Intrinsics.checkNotNullParameter(feedSocialComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Intrinsics.checkNotNullParameter(videoSchemaData, "videoSchemaData");
            y77 y77Var = new y77();
            Agree agree = feedSocialComponent.agree;
            if (agree != null) {
                Integer num = agree.agree_type;
                Intrinsics.checkNotNullExpressionValue(num, "agree.agree_type");
                y77Var.e = num.intValue();
                Integer num2 = feedSocialComponent.agree.has_agree;
                Intrinsics.checkNotNullExpressionValue(num2, "agree.has_agree");
                if (num2.intValue() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                y77Var.f = z;
                y77Var.g = feedSocialComponent.agree.agree_num.longValue();
                Long l = feedSocialComponent.agree.diff_agree_num;
                Intrinsics.checkNotNullExpressionValue(l, "agree.diff_agree_num");
                y77Var.h = l.longValue();
                Long l2 = feedSocialComponent.agree.disagree_num;
                Intrinsics.checkNotNullExpressionValue(l2, "agree.disagree_num");
                y77Var.i = l2.longValue();
            }
            y77Var.a = feedSocialComponent.share_num.intValue();
            y77Var.b = feedSocialComponent.comment_num.intValue();
            y77Var.c = String.valueOf(feedSocialComponent.tid);
            Long fid = feedSocialComponent.fid;
            Intrinsics.checkNotNullExpressionValue(fid, "fid");
            y77Var.d = fid.longValue();
            y77Var.l = feedExtraData.a();
            videoSchemaData.h(y77Var.f);
            videoSchemaData.g(y77Var.g);
            String str = y77Var.l.a().get("user_id");
            if (str == null) {
                str = "";
            }
            videoSchemaData.k(str);
            String str2 = y77Var.l.a().get("has_concerned_user");
            if (str2 == null) {
                str2 = "0";
            }
            videoSchemaData.i(str2);
            y77Var.j = videoSchemaData;
            y77Var.m = s97.b(feedSocialComponent.manage_list);
            List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a87[]{o67.e(feedExtraData, "comment_btn_click", null, 2, null), o67.e(feedExtraData, "comment_btn_click2", null, 2, null), o67.e(feedExtraData, "comment_btn_click3", null, 2, null), o67.e(feedExtraData, "bottom_comment_click_selector1", null, 2, null)});
            List listOf2 = CollectionsKt__CollectionsJVMKt.listOf(o67.e(feedExtraData, "bottom_share_click_selector1", null, 2, null));
            List listOf3 = CollectionsKt__CollectionsJVMKt.listOf(o67.e(feedExtraData, "bottom_agree_click_selector1", null, 2, null));
            Map<String, String> a2 = feedExtraData.a().a();
            Map<String, String> a3 = feedExtraData.c().a();
            if (y77Var.a()) {
                list = listOf2;
                g57Var = new g57(y77Var, null, null, null, a2, a3, null, null, null, a, 462, null);
            } else {
                list = listOf2;
                g57Var = new g57(y77Var, null, null, null, a2, a3, null, null, null, null, 974, null);
            }
            g57Var.t(CollectionsKt___CollectionsKt.plus((Collection) g57Var.l(), (Iterable) listOf));
            g57Var.v(CollectionsKt___CollectionsKt.plus((Collection) g57Var.s(), (Iterable) list));
            g57Var.u(CollectionsKt___CollectionsKt.plus((Collection) g57Var.r(), (Iterable) listOf3));
            dataList.add(new ob7(g57Var, "social_bar"));
        }
    }
}
