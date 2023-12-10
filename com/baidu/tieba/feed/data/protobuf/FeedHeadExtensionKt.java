package com.baidu.tieba.feed.data.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.model.AttentionModel;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.tieba.R;
import com.baidu.tieba.a77;
import com.baidu.tieba.bc7;
import com.baidu.tieba.c57;
import com.baidu.tieba.c67;
import com.baidu.tieba.d67;
import com.baidu.tieba.d77;
import com.baidu.tieba.e67;
import com.baidu.tieba.e87;
import com.baidu.tieba.f97;
import com.baidu.tieba.feed.data.protobuf.FeedHeadExtensionKt;
import com.baidu.tieba.he7;
import com.baidu.tieba.i97;
import com.baidu.tieba.ie7;
import com.baidu.tieba.l05;
import com.baidu.tieba.l67;
import com.baidu.tieba.m67;
import com.baidu.tieba.n05;
import com.baidu.tieba.n67;
import com.baidu.tieba.o47;
import com.baidu.tieba.o67;
import com.baidu.tieba.p05;
import com.baidu.tieba.r67;
import com.baidu.tieba.s67;
import com.baidu.tieba.sb7;
import com.baidu.tieba.t67;
import com.baidu.tieba.v77;
import com.baidu.tieba.x67;
import com.baidu.tieba.y57;
import com.baidu.tieba.yb;
import com.baidu.tieba.z57;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import tbclient.BaseTextColor;
import tbclient.CustomState;
import tbclient.FeedContentCustom;
import tbclient.FeedHeadButton;
import tbclient.FeedHeadComponent;
import tbclient.FeedHeadFigure;
import tbclient.FeedHeadFigureComponent;
import tbclient.FeedHeadIcon;
import tbclient.FeedHeadImg;
import tbclient.FeedHeadSymbol;
import tbclient.FeedHeadText;
import tbclient.FeedKV;
@Metadata(d1 = {"\u0000¼\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u001a\u001a\u0010\f\u001a\u0004\u0018\u00010\u00012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u001a\u0014\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u001c\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u001c\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a<\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\n2\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001a\u001a>\u0010\u001b\u001a\u00020\u0006*\u00020\u001c2\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001e2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\b\u001a^\u0010\u001b\u001a\u00020\u0006*\u00020&2\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001e2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010%\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010#\u001a\u00020$\u001a\u0012\u0010*\u001a\u00020+*\u00020,2\u0006\u0010-\u001a\u00020\b\u001a\n\u0010.\u001a\u00020/*\u000200\u001a*\u00101\u001a\u0004\u0018\u00010\u0015*\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001a\u001a.\u00102\u001a\u0004\u0018\u000103*\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00020(0\n2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001a\u001a6\u00107\u001a\u000208*\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u00012\f\u00105\u001a\b\u0012\u0004\u0012\u00020(0\n2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001a\u001a6\u0010;\u001a\u00020<*\u00020=2\b\u0010:\u001a\u0004\u0018\u00010\u00012\f\u00105\u001a\b\u0012\u0004\u0012\u00020(0\n2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001a\u001a\u001c\u0010>\u001a\u0004\u0018\u00010?*\u00020@2\u0006\u0010#\u001a\u00020$2\u0006\u0010A\u001a\u00020\b\u001a$\u0010B\u001a\u0004\u0018\u00010\u0004*\u00020@2\u0006\u0010A\u001a\u00020\b2\u0006\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020(\u001a\n\u0010E\u001a\u00020F*\u00020G\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"CUSTOM_FORUM_LEVEL", "", "HeadOnAttentionClick", "Lkotlin/Function2;", "Lcom/baidu/tieba/feed/widget/uistate/PersonAttentionUiState;", "Lcom/baidu/tbadk/TbPageContext;", "", "findAuthorIsLiving", "", "businessInfo", "", "Ltbclient/FeedKV;", "findAuthorUserId", "handlerAlaTimeTextData", "text", "handlerPersonAttention", "state", "pageContext", "handlerTimeTextData", "showUnLikePopupWindow", "toDegradeDataList", "Lcom/baidu/tieba/feed/data/EnableDegradeData;", "list", "Ltbclient/FeedHeadSymbol;", "parentSchema", "headLocalStatInfo", "", "insertTemplateList", "Ltbclient/FeedHeadComponent;", "mutableList", "", "Lcom/baidu/tieba/feed/list/TemplateData;", "feedBackData", "Lcom/baidu/tieba/feed/data/FeedFeedbackData;", "authorIsLiving", "feedExtraData", "Lcom/baidu/tieba/feed/data/FeedExtraData;", "hasThemeCard", "Ltbclient/FeedHeadFigureComponent;", "showStatData", "Lcom/baidu/tieba/feed/data/StatData;", "clickStatData", "toCardHeadImageData", "Lcom/baidu/tieba/feed/data/CardHeadImageData;", "Ltbclient/FeedHeadImg;", "isLiving", "toCardVirtualHeadImageData", "Lcom/baidu/tieba/feed/data/CardVirtualHeadImageData;", "Ltbclient/FeedHeadFigure;", "toDegradeData", "toEnableDegradeForumLevelData", "Lcom/baidu/tieba/feed/data/EnableDegradeForumLevelData;", "Ltbclient/FeedContentCustom;", "clickStatList", "logInfo", "toEnableDegradeIconData", "Lcom/baidu/tieba/feed/data/EnableDegradeIconData;", "Ltbclient/FeedHeadIcon;", "schemaStr", "toEnableDegradeTextData", "Lcom/baidu/tieba/feed/data/EnableDegradeTextData;", "Ltbclient/FeedHeadText;", "toForumAttentionUiState", "Lcom/baidu/tieba/feed/widget/uistate/ForumAttentionUiState;", "Ltbclient/FeedHeadButton;", "fromCache", "toPersonAttentionUiState", "followStatData", "unfollowStatData", "toVirtualImageCustomState", "Lcom/baidu/tbadk/data/VirtualImageCustomState;", "Ltbclient/CustomState;", "lib-templates_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedHeadExtensionKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function2<ie7, TbPageContext<?>, Unit> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(669861875, "Lcom/baidu/tieba/feed/data/protobuf/FeedHeadExtensionKt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(669861875, "Lcom/baidu/tieba/feed/data/protobuf/FeedHeadExtensionKt;");
                return;
            }
        }
        a = FeedHeadExtensionKt$HeadOnAttentionClick$1.INSTANCE;
    }

    public static final void k(n05 dialog, TbPageContext pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, dialog, pageContext) == null) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            yb.a(dialog, pageContext.getPageActivity());
        }
    }

    public static final boolean c(List<FeedKV> list) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list != null) {
                for (FeedKV feedKV : list) {
                    if (feedKV != null) {
                        str = feedKV.key;
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, "author_is_living")) {
                        return Intrinsics.areEqual(feedKV.value, "1");
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final String d(List<FeedKV> list) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list != null) {
                for (FeedKV feedKV : list) {
                    if (feedKV != null) {
                        str = feedKV.key;
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, "user_id")) {
                        return feedKV.value;
                    }
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static final String g(String str) {
        InterceptResult invokeL;
        Long longOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str != null && (longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str)) != null) {
                long longValue = longOrNull.longValue() * 1000;
                String formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(longValue);
                if (StringHelper.isThisYear(formatTimeForJustNow)) {
                    return StringHelper.getFormatTimeShort(longValue);
                }
                return formatTimeForJustNow;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final d67 n(FeedHeadFigure feedHeadFigure) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, feedHeadFigure)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadFigure, "<this>");
            String img_url = feedHeadFigure.img_url;
            if (Intrinsics.areEqual(feedHeadFigure.bg_type, "tone")) {
                i = 1;
            } else {
                i = 2;
            }
            String bg_value = feedHeadFigure.bg_value;
            String str = feedHeadFigure.corner_url;
            Intrinsics.checkNotNullExpressionValue(img_url, "img_url");
            Intrinsics.checkNotNullExpressionValue(bg_value, "bg_value");
            return new d67(img_url, bg_value, i, str);
        }
        return (d67) invokeL.objValue;
    }

    public static final String e(String str) {
        InterceptResult invokeL;
        Long longOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str != null && (longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str)) != null) {
                return StringHelper.getFormatTimeForAlaCardCreate(longOrNull.longValue() * 1000);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static final VirtualImageCustomState v(CustomState customState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, customState)) == null) {
            Intrinsics.checkNotNullParameter(customState, "<this>");
            VirtualImageCustomState virtualImageCustomState = new VirtualImageCustomState();
            virtualImageCustomState.parseProto(customState);
            return virtualImageCustomState;
        }
        return (VirtualImageCustomState) invokeL.objValue;
    }

    public static final void f(ie7 ie7Var, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, ie7Var, tbPageContext) == null) {
            new AttentionModel(tbPageContext).l(!ie7Var.i().f(), ie7Var.i().c(), ie7Var.i().e(), false, ie7Var.f(), tbPageContext.getUniqueId(), null, "0");
        }
    }

    public static final z57 m(FeedHeadImg feedHeadImg, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65549, null, feedHeadImg, z)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadImg, "<this>");
            String img_url = feedHeadImg.img_url;
            Intrinsics.checkNotNullExpressionValue(img_url, "img_url");
            Integer shape_type = feedHeadImg.shape_type;
            Intrinsics.checkNotNullExpressionValue(shape_type, "shape_type");
            return new z57(img_url, shape_type.intValue(), feedHeadImg.schema, feedHeadImg.pendant_url, feedHeadImg.corner_url, z, feedHeadImg.masks);
        }
        return (z57) invokeLZ.objValue;
    }

    public static final void h(FeedHeadComponent feedHeadComponent, List<sb7<?>> mutableList, t67 t67Var, boolean z, r67 feedExtraData, boolean z2) {
        ie7 ie7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{feedHeadComponent, mutableList, t67Var, Boolean.valueOf(z), feedExtraData, Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(feedHeadComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            if (feedHeadComponent.image_data != null) {
                he7 he7Var = null;
                List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new e87[]{s67.e(feedExtraData, "head_click_selector1", null, 2, null), s67.e(feedExtraData, "head_click_selector2", null, 2, null), s67.e(feedExtraData, "head_click_selector3", null, 2, null), s67.e(feedExtraData, "head_click_selector4", null, 2, null), s67.e(feedExtraData, "head_click_selector5", null, 2, null), s67.e(feedExtraData, "head_click_selector6", null, 2, null)});
                Map<String, String> f = s67.f(feedExtraData, "head_local_stat_info");
                e87 e = s67.e(feedExtraData, "head_user_follow", null, 2, null);
                e87 e2 = s67.e(feedExtraData, "head_user_unfollow", null, 2, null);
                FeedHeadButton feedHeadButton = feedHeadComponent.button;
                if (feedHeadButton != null) {
                    ie7Var = u(feedHeadButton, feedExtraData.b(), e, e2);
                } else {
                    ie7Var = null;
                }
                FeedHeadButton feedHeadButton2 = feedHeadComponent.button;
                if (feedHeadButton2 != null) {
                    he7Var = t(feedHeadButton2, feedExtraData, feedExtraData.b());
                }
                he7 he7Var2 = he7Var;
                FeedHeadImg image_data = feedHeadComponent.image_data;
                Intrinsics.checkNotNullExpressionValue(image_data, "image_data");
                mutableList.add(new o47(new y57(m(image_data, z), p(feedHeadComponent.main_data, feedHeadComponent.schema, f), p(feedHeadComponent.extra_data, feedHeadComponent.schema, f)), t67Var, ie7Var, he7Var2, feedHeadComponent.schema, feedExtraData.a().a(), feedExtraData.c().a(), listOf, z2, null, null, null, 3584, null));
            }
        }
    }

    public static final void i(FeedHeadFigureComponent feedHeadFigureComponent, List<sb7<?>> mutableList, e87 e87Var, e87 e87Var2, t67 t67Var, boolean z, Map<String, String> headLocalStatInfo, r67 feedExtraData) {
        VirtualImageCustomState virtualImageCustomState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{feedHeadFigureComponent, mutableList, e87Var, e87Var2, t67Var, Boolean.valueOf(z), headLocalStatInfo, feedExtraData}) == null) {
            Intrinsics.checkNotNullParameter(feedHeadFigureComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            Intrinsics.checkNotNullParameter(headLocalStatInfo, "headLocalStatInfo");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            FeedHeadFigure image_data = feedHeadFigureComponent.image_data;
            if (image_data != null) {
                Intrinsics.checkNotNullExpressionValue(image_data, "image_data");
                d67 n = n(image_data);
                List<l67> p = p(feedHeadFigureComponent.main_data, feedHeadFigureComponent.schema, headLocalStatInfo);
                List<l67> p2 = p(feedHeadFigureComponent.extra_data, feedHeadFigureComponent.schema, headLocalStatInfo);
                CustomState customState = feedHeadFigureComponent.custom_state;
                if (customState != null) {
                    virtualImageCustomState = v(customState);
                } else {
                    virtualImageCustomState = null;
                }
                mutableList.add(new c57(new c67(n, p, p2, virtualImageCustomState, e87Var, e87Var2), t67Var, feedHeadFigureComponent.schema, d(feedHeadFigureComponent.business_info), feedExtraData.a().a(), feedExtraData.c().a(), z, null, null, null, 896, null));
            }
        }
    }

    public static final void j(final ie7 ie7Var, final TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, ie7Var, tbPageContext) == null) {
            p05 p05Var = new p05(tbPageContext.getPageActivity());
            p05Var.u(tbPageContext.getString(R.string.confirm_unlike));
            ArrayList arrayList = new ArrayList();
            final n05 n05Var = new n05(tbPageContext, p05Var);
            l05 l05Var = new l05(tbPageContext.getString(R.string.obfuscated_res_0x7f0f04d2), p05Var);
            l05Var.n(new p05.e() { // from class: com.baidu.tieba.c97
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.p05.e
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FeedHeadExtensionKt.l(ie7.this, tbPageContext, n05Var);
                    }
                }
            });
            arrayList.add(l05Var);
            p05Var.p(new p05.c() { // from class: com.baidu.tieba.b97
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.p05.c
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FeedHeadExtensionKt.k(n05.this, tbPageContext);
                    }
                }
            });
            p05Var.m(arrayList);
            n05Var.k(0.7f);
            yb.i(n05Var, tbPageContext.getPageActivity());
        }
    }

    public static final void l(ie7 state, TbPageContext pageContext, n05 dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, state, pageContext, dialog) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            f(state, pageContext);
            yb.a(dialog, pageContext.getPageActivity());
        }
    }

    public static final l67 o(FeedHeadSymbol feedHeadSymbol, String str, Map<String, String> headLocalStatInfo) {
        InterceptResult invokeLLL;
        FeedContentCustom feedContentCustom;
        FeedHeadText text;
        FeedHeadIcon icon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, feedHeadSymbol, str, headLocalStatInfo)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadSymbol, "<this>");
            Intrinsics.checkNotNullParameter(headLocalStatInfo, "headLocalStatInfo");
            List list = feedHeadSymbol.log_info;
            if (list == null) {
                list = new ArrayList();
            }
            List<e87> c = i97.c(list);
            for (e87 e87Var : c) {
                Map<String, String> b = e87Var.b();
                if (b instanceof HashMap) {
                    ((HashMap) b).putAll(headLocalStatInfo);
                }
            }
            Integer num = feedHeadSymbol.type;
            boolean z = false;
            if (num != null && num.intValue() == 2 && (icon = feedHeadSymbol.icon) != null) {
                Intrinsics.checkNotNullExpressionValue(icon, "icon");
                String str2 = feedHeadSymbol.schema;
                if (!((str2 == null || str2.length() == 0) ? true : true)) {
                    str = feedHeadSymbol.schema;
                }
                return r(icon, str, c, i97.b(list));
            }
            Integer num2 = feedHeadSymbol.type;
            if (num2 != null && num2.intValue() == 1 && (text = feedHeadSymbol.text) != null) {
                Intrinsics.checkNotNullExpressionValue(text, "text");
                String str3 = feedHeadSymbol.schema;
                if (!((str3 == null || str3.length() == 0) ? true : true)) {
                    str = feedHeadSymbol.schema;
                }
                return s(text, str, c, i97.b(list));
            }
            Integer num3 = feedHeadSymbol.type;
            if (num3 == null || num3.intValue() != 3 || (feedContentCustom = feedHeadSymbol.custom) == null || !Intrinsics.areEqual(feedContentCustom.style, "forum_level")) {
                return null;
            }
            FeedContentCustom custom = feedHeadSymbol.custom;
            Intrinsics.checkNotNullExpressionValue(custom, "custom");
            return q(custom, c, i97.b(list));
        }
        return (l67) invokeLLL.objValue;
    }

    public static final List<l67> p(List<FeedHeadSymbol> list, String str, Map<String, String> headLocalStatInfo) {
        InterceptResult invokeLLL;
        l67 o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, list, str, headLocalStatInfo)) == null) {
            Intrinsics.checkNotNullParameter(headLocalStatInfo, "headLocalStatInfo");
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (FeedHeadSymbol feedHeadSymbol : list) {
                    if (feedHeadSymbol != null && (o = o(feedHeadSymbol, str, headLocalStatInfo)) != null) {
                        arrayList.add(o);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    public static final m67 q(FeedContentCustom feedContentCustom, List<e87> clickStatList, Map<String, String> logInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, feedContentCustom, clickStatList, logInfo)) == null) {
            Intrinsics.checkNotNullParameter(feedContentCustom, "<this>");
            Intrinsics.checkNotNullParameter(clickStatList, "clickStatList");
            Intrinsics.checkNotNullParameter(logInfo, "logInfo");
            m67 e = m67.m.e(feedContentCustom.data);
            if (e != null) {
                e.j(clickStatList);
                e.l(logInfo);
                return e;
            }
            return null;
        }
        return (m67) invokeLLL.objValue;
    }

    public static final n67 r(FeedHeadIcon feedHeadIcon, String str, List<e87> clickStatList, Map<String, String> logInfo) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65554, null, feedHeadIcon, str, clickStatList, logInfo)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadIcon, "<this>");
            Intrinsics.checkNotNullParameter(clickStatList, "clickStatList");
            Intrinsics.checkNotNullParameter(logInfo, "logInfo");
            String url = feedHeadIcon.url;
            Intrinsics.checkNotNullExpressionValue(url, "url");
            Integer width = feedHeadIcon.width;
            Intrinsics.checkNotNullExpressionValue(width, "width");
            int intValue = width.intValue();
            Integer height = feedHeadIcon.height;
            Intrinsics.checkNotNullExpressionValue(height, "height");
            int intValue2 = height.intValue();
            Integer priority = feedHeadIcon.priority;
            Intrinsics.checkNotNullExpressionValue(priority, "priority");
            int intValue3 = priority.intValue();
            Integer num = feedHeadIcon.can_degrade;
            if (num != null && num.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            return new n67(url, str, intValue, intValue2, intValue3, z, feedHeadIcon.degrade_url, feedHeadIcon.degrade_width, feedHeadIcon.degrade_height, feedHeadIcon.degrade_priority, clickStatList, logInfo);
        }
        return (n67) invokeLLLL.objValue;
    }

    public static final o67 s(FeedHeadText feedHeadText, String str, List<e87> clickStatList, Map<String, String> logInfo) {
        InterceptResult invokeLLLL;
        String str2;
        e67 e67Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65555, null, feedHeadText, str, clickStatList, logInfo)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadText, "<this>");
            Intrinsics.checkNotNullParameter(clickStatList, "clickStatList");
            Intrinsics.checkNotNullParameter(logInfo, "logInfo");
            Integer num = feedHeadText.type;
            if (num != null && num.intValue() == 1) {
                str2 = g(feedHeadText.text);
            } else if (num != null && num.intValue() == 2) {
                str2 = e(feedHeadText.text);
            } else if (num != null && num.intValue() == 3) {
                str2 = TbadkCoreApplication.getInst().getString(R.string.repley_when) + g(feedHeadText.text);
            } else {
                str2 = feedHeadText.text;
            }
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            BaseTextColor color = feedHeadText.color;
            if (color != null) {
                Intrinsics.checkNotNullExpressionValue(color, "color");
                e67Var = f97.a(color);
            } else {
                e67Var = null;
            }
            e67 e67Var2 = e67Var;
            Integer priority = feedHeadText.priority;
            Intrinsics.checkNotNullExpressionValue(priority, "priority");
            int intValue = priority.intValue();
            Integer num2 = feedHeadText.can_degrade;
            if (num2 != null && num2.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            Integer degrade_len = feedHeadText.degrade_len;
            Intrinsics.checkNotNullExpressionValue(degrade_len, "degrade_len");
            int intValue2 = degrade_len.intValue();
            String str4 = feedHeadText.suffix;
            Integer degrade_priority = feedHeadText.degrade_priority;
            Intrinsics.checkNotNullExpressionValue(degrade_priority, "degrade_priority");
            return new o67(str3, e67Var2, str, intValue, z, intValue2, str4, degrade_priority.intValue(), clickStatList, logInfo);
        }
        return (o67) invokeLLLL.objValue;
    }

    public static final ie7 u(FeedHeadButton feedHeadButton, boolean z, e87 followStatData, e87 unfollowStatData) {
        InterceptResult invokeCommon;
        String str;
        int i;
        boolean z2;
        int i2;
        List<FeedKV> list;
        String str2;
        List<FeedKV> list2;
        String str3;
        String a2;
        String a3;
        String str4;
        boolean z3;
        String a4;
        Integer intOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{feedHeadButton, Boolean.valueOf(z), followStatData, unfollowStatData})) == null) {
            Intrinsics.checkNotNullParameter(feedHeadButton, "<this>");
            Intrinsics.checkNotNullParameter(followStatData, "followStatData");
            Intrinsics.checkNotNullParameter(unfollowStatData, "unfollowStatData");
            Integer num = feedHeadButton.type;
            String str5 = null;
            if (num != null) {
                boolean z4 = true;
                if (num.intValue() == 1) {
                    List<FeedKV> list3 = feedHeadButton.business_info;
                    if (list3 != null) {
                        str = i97.a(list3, "is_like");
                    } else {
                        str = null;
                    }
                    boolean areEqual = Intrinsics.areEqual(str, "1");
                    List<FeedKV> list4 = feedHeadButton.business_info;
                    if (list4 != null && (a4 = i97.a(list4, "like_status")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(a4)) != null) {
                        i = intOrNull.intValue();
                    } else {
                        i = 0;
                    }
                    if (z) {
                        List<FeedKV> list5 = feedHeadButton.business_info;
                        String str6 = (list5 == null || (str6 = i97.a(list5, "user_id")) == null) ? "" : "";
                        d77 a5 = x67.a.a("tb.feed_home_reco_user_state");
                        if (a5 != null) {
                            str4 = a5.getValue(str6, "is_like");
                        } else {
                            str4 = null;
                        }
                        if (str4 != null && str4.length() != 0) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (!z3) {
                            areEqual = Intrinsics.areEqual(str4, "1");
                        }
                        d77 a6 = x67.a.a("tb.feed_home_reco_user_state");
                        if (a6 != null) {
                            str5 = a6.getValue(str6, "like_status");
                        }
                        if (str5 != null && str5.length() != 0) {
                            z4 = false;
                        }
                        if (!z4) {
                            z2 = areEqual;
                            i2 = JavaTypesHelper.toInt(str5, 0);
                            list = feedHeadButton.business_info;
                            if (list != null || (a3 = i97.a(list, "user_id")) == null) {
                                str2 = "";
                            } else {
                                str2 = a3;
                            }
                            list2 = feedHeadButton.business_info;
                            if (list2 != null || (a2 = i97.a(list2, "portrait")) == null) {
                                str3 = "";
                            } else {
                                str3 = a2;
                            }
                            return new ie7(new v77(z2, i2, str2, str3, followStatData, unfollowStatData), null, new FeedHeadExtensionKt$toPersonAttentionUiState$1(bc7.a), a, null, 16, null);
                        }
                    }
                    z2 = areEqual;
                    i2 = i;
                    list = feedHeadButton.business_info;
                    if (list != null) {
                    }
                    str2 = "";
                    list2 = feedHeadButton.business_info;
                    if (list2 != null) {
                    }
                    str3 = "";
                    return new ie7(new v77(z2, i2, str2, str3, followStatData, unfollowStatData), null, new FeedHeadExtensionKt$toPersonAttentionUiState$1(bc7.a), a, null, 16, null);
                }
            }
            return null;
        }
        return (ie7) invokeCommon.objValue;
    }

    public static final he7 t(FeedHeadButton feedHeadButton, r67 feedExtraData, boolean z) {
        InterceptResult invokeLLZ;
        String str;
        String str2;
        String str3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65556, null, feedHeadButton, feedExtraData, z)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadButton, "<this>");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Integer num = feedHeadButton.type;
            String str4 = null;
            if (num == null || num.intValue() != 2) {
                return null;
            }
            if (z) {
                List<FeedKV> list = feedHeadButton.business_info;
                String str5 = (list == null || (str5 = i97.a(list, "forum_id")) == null) ? "" : "";
                d77 a2 = x67.a.a("tb.feed_home_reco_user_state");
                if (a2 != null) {
                    str3 = a2.getValue(str5, "is_like");
                } else {
                    str3 = null;
                }
                if (str3 != null && str3.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2 && Intrinsics.areEqual(str3, "1")) {
                    return null;
                }
            }
            List<FeedKV> list2 = feedHeadButton.business_info;
            String str6 = (list2 == null || (str6 = i97.a(list2, "forum_name")) == null) ? "" : "";
            List<FeedKV> list3 = feedHeadButton.business_info;
            if (list3 != null) {
                str = i97.a(list3, "forum_id");
            } else {
                str = null;
            }
            a77 a77Var = new a77(false, str6, JavaTypesHelper.toLong(str, 0L));
            String str7 = feedExtraData.a().a().get("thread_id");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            List<FeedKV> list4 = feedHeadButton.business_info;
            if (list4 != null) {
                str4 = i97.a(list4, "forum_id");
            }
            return new he7(a77Var, str2, JavaTypesHelper.toLong(str4, 0L), null, 8, null);
        }
        return (he7) invokeLLZ.objValue;
    }
}
