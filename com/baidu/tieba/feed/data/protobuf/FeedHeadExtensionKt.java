package com.baidu.tieba.feed.data.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.tieba.R;
import com.baidu.tieba.a97;
import com.baidu.tieba.b97;
import com.baidu.tieba.c97;
import com.baidu.tieba.d77;
import com.baidu.tieba.e55;
import com.baidu.tieba.feed.data.protobuf.FeedHeadExtensionKt;
import com.baidu.tieba.g55;
import com.baidu.tieba.h87;
import com.baidu.tieba.i55;
import com.baidu.tieba.i87;
import com.baidu.tieba.ja7;
import com.baidu.tieba.k87;
import com.baidu.tieba.kg;
import com.baidu.tieba.l87;
import com.baidu.tieba.m87;
import com.baidu.tieba.ma7;
import com.baidu.tieba.p87;
import com.baidu.tieba.pc7;
import com.baidu.tieba.q87;
import com.baidu.tieba.q97;
import com.baidu.tieba.r77;
import com.baidu.tieba.r87;
import com.baidu.tieba.u87;
import com.baidu.tieba.v87;
import com.baidu.tieba.vc7;
import com.baidu.tieba.ve5;
import com.baidu.tieba.w87;
import com.baidu.tieba.w97;
import com.baidu.tieba.ye7;
import com.baidu.tieba.ze7;
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
import tbclient.ComponentFactory;
import tbclient.CustomState;
import tbclient.FeedHeadButton;
import tbclient.FeedHeadComponent;
import tbclient.FeedHeadFigure;
import tbclient.FeedHeadFigureComponent;
import tbclient.FeedHeadIcon;
import tbclient.FeedHeadImg;
import tbclient.FeedHeadSymbol;
import tbclient.FeedHeadText;
import tbclient.FeedKV;
@Metadata(d1 = {"\u0000´\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u001a\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u001a\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002\u001a\u001c\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002\u001a\u001c\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a<\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0019\u001aD\u0010\u001a\u001a\u00020\u0004*\u00020\u001b2\u0010\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e0\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\b\u001aN\u0010\u001a\u001a\u00020\u0004*\u00020&2\u0010\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e0\u001d2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0019\u001a\u0012\u0010*\u001a\u00020+*\u00020,2\u0006\u0010-\u001a\u00020\u0006\u001a\n\u0010.\u001a\u00020/*\u000200\u001a*\u00101\u001a\u0004\u0018\u00010\u0014*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0019\u001a\"\u00102\u001a\u000203*\u0002042\b\u00105\u001a\u0004\u0018\u00010\u000b2\f\u00106\u001a\b\u0012\u0004\u0012\u00020(0\b\u001a\"\u00107\u001a\u000208*\u0002092\b\u00105\u001a\u0004\u0018\u00010\u000b2\f\u00106\u001a\b\u0012\u0004\u0012\u00020(0\b\u001a\u001c\u0010:\u001a\u0004\u0018\u00010;*\u00020<2\u0006\u0010\"\u001a\u00020#2\u0006\u0010=\u001a\u00020\u0006\u001a$\u0010>\u001a\u0004\u0018\u00010\u0002*\u00020<2\u0006\u0010=\u001a\u00020\u00062\u0006\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020(\u001a\n\u0010A\u001a\u00020B*\u00020C\"$\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"HeadOnAttentionClick", "Lkotlin/Function2;", "Lcom/baidu/tieba/feed/widget/uistate/PersonAttentionUiState;", "Lcom/baidu/tbadk/TbPageContext;", "", "findAuthorIsLiving", "", "businessInfo", "", "Ltbclient/FeedKV;", "findAuthorUserId", "", "handlerAlaTimeTextData", "text", "handlerPersonAttention", "state", "pageContext", "handlerTimeTextData", "showUnLikePopupWindow", "toDegradeDataList", "Lcom/baidu/tieba/feed/data/EnableDegradeData;", "list", "Ltbclient/FeedHeadSymbol;", "parentSchema", "headLocalStatInfo", "", "insertTemplateList", "Ltbclient/FeedHeadComponent;", "mutableList", "", "Lcom/baidu/tieba/feed/list/TemplateData;", "feedBackData", "Lcom/baidu/tieba/feed/data/FeedFeedbackData;", "authorIsLiving", "feedExtraData", "Lcom/baidu/tieba/feed/data/FeedExtraData;", "factoryList", "Ltbclient/ComponentFactory;", "Ltbclient/FeedHeadFigureComponent;", "showStatData", "Lcom/baidu/tieba/feed/data/StatData;", "clickStatData", "toCardHeadImageData", "Lcom/baidu/tieba/feed/data/CardHeadImageData;", "Ltbclient/FeedHeadImg;", "isLiving", "toCardVirtualHeadImageData", "Lcom/baidu/tieba/feed/data/CardVirtualHeadImageData;", "Ltbclient/FeedHeadFigure;", "toDegradeData", "toEnableDegradeIconData", "Lcom/baidu/tieba/feed/data/EnableDegradeIconData;", "Ltbclient/FeedHeadIcon;", "schemaStr", "clickStatList", "toEnableDegradeTextData", "Lcom/baidu/tieba/feed/data/EnableDegradeTextData;", "Ltbclient/FeedHeadText;", "toForumAttentionUiState", "Lcom/baidu/tieba/feed/widget/uistate/ForumAttentionUiState;", "Ltbclient/FeedHeadButton;", "fromCache", "toPersonAttentionUiState", "followStatData", "unfollowStatData", "toVirtualImageCustomState", "Lcom/baidu/tbadk/data/VirtualImageCustomState;", "Ltbclient/CustomState;", "lib-templates_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedHeadExtensionKt {
    public static /* synthetic */ Interceptable $ic;
    public static final Function2<ze7, TbPageContext<?>, Unit> a;
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

    public static final void l(g55 dialog, TbPageContext pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, dialog, pageContext) == null) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            kg.a(dialog, pageContext.getPageActivity());
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

    public static final l87 n(FeedHeadFigure feedHeadFigure) {
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
            return new l87(img_url, bg_value, i, str);
        }
        return (l87) invokeL.objValue;
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

    public static final VirtualImageCustomState u(CustomState customState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, customState)) == null) {
            Intrinsics.checkNotNullParameter(customState, "<this>");
            VirtualImageCustomState virtualImageCustomState = new VirtualImageCustomState();
            virtualImageCustomState.parseProto(customState);
            return virtualImageCustomState;
        }
        return (VirtualImageCustomState) invokeL.objValue;
    }

    public static final void f(ze7 ze7Var, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, ze7Var, tbPageContext) == null) {
            new ve5(tbPageContext).i(!ze7Var.h().f(), ze7Var.h().c(), ze7Var.h().e(), false, ze7Var.e(), tbPageContext.getUniqueId(), null, "0");
        }
    }

    public static final i87 m(FeedHeadImg feedHeadImg, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65549, null, feedHeadImg, z)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadImg, "<this>");
            String img_url = feedHeadImg.img_url;
            Intrinsics.checkNotNullExpressionValue(img_url, "img_url");
            Integer shape_type = feedHeadImg.shape_type;
            Intrinsics.checkNotNullExpressionValue(shape_type, "shape_type");
            return new i87(img_url, shape_type.intValue(), feedHeadImg.schema, feedHeadImg.pendant_url, feedHeadImg.corner_url, z, feedHeadImg.masks);
        }
        return (i87) invokeLZ.objValue;
    }

    public static final void h(FeedHeadComponent feedHeadComponent, List<pc7<?>> mutableList, w87 w87Var, boolean z, u87 feedExtraData, List<ComponentFactory> factoryList) {
        ze7 ze7Var;
        ye7 ye7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{feedHeadComponent, mutableList, w87Var, Boolean.valueOf(z), feedExtraData, factoryList}) == null) {
            Intrinsics.checkNotNullParameter(feedHeadComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Intrinsics.checkNotNullParameter(factoryList, "factoryList");
            if (feedHeadComponent.image_data != null) {
                List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(v87.b(feedExtraData, "head_click_selector1"), v87.b(feedExtraData, "head_click_selector2"), v87.b(feedExtraData, "head_click_selector3"), v87.b(feedExtraData, "head_click_selector4"), v87.b(feedExtraData, "head_click_selector5"));
                Map<String, String> c = v87.c(feedExtraData, "head_local_stat_info");
                w97 b = v87.b(feedExtraData, "head_user_follow");
                w97 b2 = v87.b(feedExtraData, "head_user_unfollow");
                FeedHeadButton feedHeadButton = feedHeadComponent.button;
                if (feedHeadButton != null) {
                    ze7Var = t(feedHeadButton, feedExtraData.b(), b, b2);
                } else {
                    ze7Var = null;
                }
                FeedHeadButton feedHeadButton2 = feedHeadComponent.button;
                if (feedHeadButton2 != null) {
                    ye7Var = s(feedHeadButton2, feedExtraData, feedExtraData.b());
                } else {
                    ye7Var = null;
                }
                FeedHeadImg image_data = feedHeadComponent.image_data;
                Intrinsics.checkNotNullExpressionValue(image_data, "image_data");
                mutableList.add(new d77(new h87(m(image_data, z), p(feedHeadComponent.main_data, feedHeadComponent.schema, c), p(feedHeadComponent.extra_data, feedHeadComponent.schema, c)), w87Var, ze7Var, ye7Var, feedHeadComponent.schema, mutableListOf, null, null, null, FileUtils.S_IRWXU, null));
            }
        }
    }

    public static final void i(FeedHeadFigureComponent feedHeadFigureComponent, List<pc7<?>> mutableList, w97 w97Var, w97 w97Var2, w87 w87Var, Map<String, String> headLocalStatInfo) {
        VirtualImageCustomState virtualImageCustomState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{feedHeadFigureComponent, mutableList, w97Var, w97Var2, w87Var, headLocalStatInfo}) == null) {
            Intrinsics.checkNotNullParameter(feedHeadFigureComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            Intrinsics.checkNotNullParameter(headLocalStatInfo, "headLocalStatInfo");
            FeedHeadFigure image_data = feedHeadFigureComponent.image_data;
            if (image_data != null) {
                Intrinsics.checkNotNullExpressionValue(image_data, "image_data");
                l87 n = n(image_data);
                List<p87> p = p(feedHeadFigureComponent.main_data, feedHeadFigureComponent.schema, headLocalStatInfo);
                List<p87> p2 = p(feedHeadFigureComponent.extra_data, feedHeadFigureComponent.schema, headLocalStatInfo);
                CustomState customState = feedHeadFigureComponent.custom_state;
                if (customState != null) {
                    virtualImageCustomState = u(customState);
                } else {
                    virtualImageCustomState = null;
                }
                mutableList.add(new r77(new k87(n, p, p2, virtualImageCustomState, w97Var, w97Var2), w87Var, feedHeadFigureComponent.schema, d(feedHeadFigureComponent.business_info), null, null, null, null, 240, null));
            }
        }
    }

    public static final void j(final ze7 ze7Var, final TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, ze7Var, tbPageContext) == null) {
            i55 i55Var = new i55(tbPageContext.getPageActivity());
            i55Var.t(tbPageContext.getString(R.string.confirm_unlike));
            ArrayList arrayList = new ArrayList();
            final g55 g55Var = new g55(tbPageContext, i55Var);
            e55 e55Var = new e55(tbPageContext.getString(R.string.obfuscated_res_0x7f0f04c4), i55Var);
            e55Var.m(new i55.e() { // from class: com.baidu.tieba.ha7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.i55.e
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FeedHeadExtensionKt.k(ze7.this, tbPageContext, g55Var);
                    }
                }
            });
            arrayList.add(e55Var);
            i55Var.o(new i55.c() { // from class: com.baidu.tieba.ga7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.i55.c
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FeedHeadExtensionKt.l(g55.this, tbPageContext);
                    }
                }
            });
            i55Var.l(arrayList);
            g55Var.k(0.7f);
            kg.i(g55Var, tbPageContext.getPageActivity());
        }
    }

    public static final void k(ze7 state, TbPageContext pageContext, g55 dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, state, pageContext, dialog) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            f(state, pageContext);
            kg.a(dialog, pageContext.getPageActivity());
        }
    }

    public static final p87 o(FeedHeadSymbol feedHeadSymbol, String str, Map<String, String> headLocalStatInfo) {
        InterceptResult invokeLLL;
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
            List<w97> b = ma7.b(list);
            for (w97 w97Var : b) {
                Map<String, String> b2 = w97Var.b();
                if (b2 instanceof HashMap) {
                    ((HashMap) b2).putAll(headLocalStatInfo);
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
                return q(icon, str, b);
            }
            Integer num2 = feedHeadSymbol.type;
            if (num2 != null && num2.intValue() == 1 && (text = feedHeadSymbol.text) != null) {
                Intrinsics.checkNotNullExpressionValue(text, "text");
                String str3 = feedHeadSymbol.schema;
                if (!((str3 == null || str3.length() == 0) ? true : true)) {
                    str = feedHeadSymbol.schema;
                }
                return r(text, str, b);
            }
            return null;
        }
        return (p87) invokeLLL.objValue;
    }

    public static final ye7 s(FeedHeadButton feedHeadButton, u87 feedExtraData, boolean z) {
        InterceptResult invokeLLZ;
        String str;
        String str2;
        String str3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65555, null, feedHeadButton, feedExtraData, z)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadButton, "<this>");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Integer num = feedHeadButton.type;
            String str4 = null;
            if (num == null || num.intValue() != 2) {
                return null;
            }
            if (z) {
                List<FeedKV> list = feedHeadButton.business_info;
                String str5 = (list == null || (str5 = ma7.a(list, "forum_id")) == null) ? "" : "";
                c97 a2 = a97.a.a("tb.feed_home_reco_user_state");
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
            String str6 = (list2 == null || (str6 = ma7.a(list2, "forum_name")) == null) ? "" : "";
            List<FeedKV> list3 = feedHeadButton.business_info;
            if (list3 != null) {
                str = ma7.a(list3, "forum_id");
            } else {
                str = null;
            }
            b97 b97Var = new b97(false, str6, JavaTypesHelper.toLong(str, 0L));
            String str7 = feedExtraData.a().a().get("thread_id");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            List<FeedKV> list4 = feedHeadButton.business_info;
            if (list4 != null) {
                str4 = ma7.a(list4, "forum_id");
            }
            return new ye7(b97Var, str2, JavaTypesHelper.toLong(str4, 0L), null, 8, null);
        }
        return (ye7) invokeLLZ.objValue;
    }

    public static final List<p87> p(List<FeedHeadSymbol> list, String str, Map<String, String> headLocalStatInfo) {
        InterceptResult invokeLLL;
        p87 o;
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

    public static final q87 q(FeedHeadIcon feedHeadIcon, String str, List<w97> clickStatList) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, feedHeadIcon, str, clickStatList)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadIcon, "<this>");
            Intrinsics.checkNotNullParameter(clickStatList, "clickStatList");
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
            return new q87(url, str, intValue, intValue2, intValue3, z, feedHeadIcon.degrade_url, feedHeadIcon.degrade_width, feedHeadIcon.degrade_height, feedHeadIcon.degrade_priority, clickStatList);
        }
        return (q87) invokeLLL.objValue;
    }

    public static final r87 r(FeedHeadText feedHeadText, String str, List<w97> clickStatList) {
        InterceptResult invokeLLL;
        String str2;
        m87 m87Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, feedHeadText, str, clickStatList)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadText, "<this>");
            Intrinsics.checkNotNullParameter(clickStatList, "clickStatList");
            Integer num = feedHeadText.type;
            if (num != null && num.intValue() == 1) {
                str2 = g(feedHeadText.text);
            } else if (num != null && num.intValue() == 2) {
                str2 = e(feedHeadText.text);
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
                m87Var = ja7.a(color);
            } else {
                m87Var = null;
            }
            m87 m87Var2 = m87Var;
            Integer priority = feedHeadText.priority;
            Intrinsics.checkNotNullExpressionValue(priority, "priority");
            int intValue = priority.intValue();
            Integer num2 = feedHeadText.can_degrade;
            if (num2 != null && num2.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            return new r87(str3, m87Var2, str, intValue, z, feedHeadText.degrade_len, feedHeadText.suffix, feedHeadText.degrade_priority, clickStatList);
        }
        return (r87) invokeLLL.objValue;
    }

    public static final ze7 t(FeedHeadButton feedHeadButton, boolean z, w97 followStatData, w97 unfollowStatData) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{feedHeadButton, Boolean.valueOf(z), followStatData, unfollowStatData})) == null) {
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
                        str = ma7.a(list3, "is_like");
                    } else {
                        str = null;
                    }
                    boolean areEqual = Intrinsics.areEqual(str, "1");
                    List<FeedKV> list4 = feedHeadButton.business_info;
                    if (list4 != null && (a4 = ma7.a(list4, "like_status")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(a4)) != null) {
                        i = intOrNull.intValue();
                    } else {
                        i = 0;
                    }
                    if (z) {
                        List<FeedKV> list5 = feedHeadButton.business_info;
                        String str6 = (list5 == null || (str6 = ma7.a(list5, "user_id")) == null) ? "" : "";
                        c97 a5 = a97.a.a("tb.feed_home_reco_user_state");
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
                        c97 a6 = a97.a.a("tb.feed_home_reco_user_state");
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
                            if (list != null || (a3 = ma7.a(list, "user_id")) == null) {
                                str2 = "";
                            } else {
                                str2 = a3;
                            }
                            list2 = feedHeadButton.business_info;
                            if (list2 != null || (a2 = ma7.a(list2, "portrait")) == null) {
                                str3 = "";
                            } else {
                                str3 = a2;
                            }
                            return new ze7(new q97(z2, i2, str2, str3, followStatData, unfollowStatData), null, new FeedHeadExtensionKt$toPersonAttentionUiState$1(vc7.a), a, null, 16, null);
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
                    return new ze7(new q97(z2, i2, str2, str3, followStatData, unfollowStatData), null, new FeedHeadExtensionKt$toPersonAttentionUiState$1(vc7.a), a, null, 16, null);
                }
            }
            return null;
        }
        return (ze7) invokeCommon.objValue;
    }
}
