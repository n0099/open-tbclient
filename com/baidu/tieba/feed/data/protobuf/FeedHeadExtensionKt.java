package com.baidu.tieba.feed.data.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.tieba.R;
import com.baidu.tieba.a67;
import com.baidu.tieba.aa7;
import com.baidu.tieba.b67;
import com.baidu.tieba.c67;
import com.baidu.tieba.c77;
import com.baidu.tieba.cc7;
import com.baidu.tieba.dc7;
import com.baidu.tieba.fe5;
import com.baidu.tieba.feed.data.protobuf.FeedHeadExtensionKt;
import com.baidu.tieba.g67;
import com.baidu.tieba.h67;
import com.baidu.tieba.i67;
import com.baidu.tieba.jg;
import com.baidu.tieba.k47;
import com.baidu.tieba.n57;
import com.baidu.tieba.o57;
import com.baidu.tieba.p77;
import com.baidu.tieba.q57;
import com.baidu.tieba.r57;
import com.baidu.tieba.s45;
import com.baidu.tieba.s57;
import com.baidu.tieba.s77;
import com.baidu.tieba.u45;
import com.baidu.tieba.u97;
import com.baidu.tieba.v57;
import com.baidu.tieba.w45;
import com.baidu.tieba.w57;
import com.baidu.tieba.w67;
import com.baidu.tieba.x47;
import com.baidu.tieba.x57;
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
    public static final Function2<dc7, TbPageContext<?>, Unit> a;
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

    public static final void l(u45 dialog, TbPageContext pageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, dialog, pageContext) == null) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            jg.a(dialog, pageContext.getPageActivity());
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

    public static final r57 n(FeedHeadFigure feedHeadFigure) {
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
            return new r57(img_url, bg_value, i, str);
        }
        return (r57) invokeL.objValue;
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

    public static final void f(dc7 dc7Var, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, dc7Var, tbPageContext) == null) {
            new fe5(tbPageContext).i(!dc7Var.h().f(), dc7Var.h().c(), dc7Var.h().e(), false, dc7Var.e(), tbPageContext.getUniqueId(), null, "0");
        }
    }

    public static final o57 m(FeedHeadImg feedHeadImg, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65549, null, feedHeadImg, z)) == null) {
            Intrinsics.checkNotNullParameter(feedHeadImg, "<this>");
            String img_url = feedHeadImg.img_url;
            Intrinsics.checkNotNullExpressionValue(img_url, "img_url");
            Integer shape_type = feedHeadImg.shape_type;
            Intrinsics.checkNotNullExpressionValue(shape_type, "shape_type");
            return new o57(img_url, shape_type.intValue(), feedHeadImg.schema, feedHeadImg.pendant_url, feedHeadImg.corner_url, z, feedHeadImg.masks);
        }
        return (o57) invokeLZ.objValue;
    }

    public static final void h(FeedHeadComponent feedHeadComponent, List<u97<?>> mutableList, c67 c67Var, boolean z, a67 feedExtraData, List<ComponentFactory> factoryList) {
        dc7 dc7Var;
        cc7 cc7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{feedHeadComponent, mutableList, c67Var, Boolean.valueOf(z), feedExtraData, factoryList}) == null) {
            Intrinsics.checkNotNullParameter(feedHeadComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            Intrinsics.checkNotNullParameter(factoryList, "factoryList");
            if (feedHeadComponent.image_data != null) {
                List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(b67.b(feedExtraData, "head_click_selector1"), b67.b(feedExtraData, "head_click_selector2"), b67.b(feedExtraData, "head_click_selector3"), b67.b(feedExtraData, "head_click_selector4"), b67.b(feedExtraData, "head_click_selector5"));
                Map<String, String> c = b67.c(feedExtraData, "head_local_stat_info");
                c77 b = b67.b(feedExtraData, "head_user_follow");
                c77 b2 = b67.b(feedExtraData, "head_user_unfollow");
                FeedHeadButton feedHeadButton = feedHeadComponent.button;
                if (feedHeadButton != null) {
                    dc7Var = t(feedHeadButton, feedExtraData.b(), b, b2);
                } else {
                    dc7Var = null;
                }
                FeedHeadButton feedHeadButton2 = feedHeadComponent.button;
                if (feedHeadButton2 != null) {
                    cc7Var = s(feedHeadButton2, feedExtraData, feedExtraData.b());
                } else {
                    cc7Var = null;
                }
                FeedHeadImg image_data = feedHeadComponent.image_data;
                Intrinsics.checkNotNullExpressionValue(image_data, "image_data");
                mutableList.add(new k47(new n57(m(image_data, z), p(feedHeadComponent.main_data, feedHeadComponent.schema, c), p(feedHeadComponent.extra_data, feedHeadComponent.schema, c)), c67Var, dc7Var, cc7Var, feedHeadComponent.schema, mutableListOf, null, null, null, FileUtils.S_IRWXU, null));
            }
        }
    }

    public static final void i(FeedHeadFigureComponent feedHeadFigureComponent, List<u97<?>> mutableList, c77 c77Var, c77 c77Var2, c67 c67Var, Map<String, String> headLocalStatInfo) {
        VirtualImageCustomState virtualImageCustomState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{feedHeadFigureComponent, mutableList, c77Var, c77Var2, c67Var, headLocalStatInfo}) == null) {
            Intrinsics.checkNotNullParameter(feedHeadFigureComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            Intrinsics.checkNotNullParameter(headLocalStatInfo, "headLocalStatInfo");
            FeedHeadFigure image_data = feedHeadFigureComponent.image_data;
            if (image_data != null) {
                Intrinsics.checkNotNullExpressionValue(image_data, "image_data");
                r57 n = n(image_data);
                List<v57> p = p(feedHeadFigureComponent.main_data, feedHeadFigureComponent.schema, headLocalStatInfo);
                List<v57> p2 = p(feedHeadFigureComponent.extra_data, feedHeadFigureComponent.schema, headLocalStatInfo);
                CustomState customState = feedHeadFigureComponent.custom_state;
                if (customState != null) {
                    virtualImageCustomState = u(customState);
                } else {
                    virtualImageCustomState = null;
                }
                mutableList.add(new x47(new q57(n, p, p2, virtualImageCustomState, c77Var, c77Var2), c67Var, feedHeadFigureComponent.schema, d(feedHeadFigureComponent.business_info), null, null, null, null, 240, null));
            }
        }
    }

    public static final void j(final dc7 dc7Var, final TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, dc7Var, tbPageContext) == null) {
            w45 w45Var = new w45(tbPageContext.getPageActivity());
            w45Var.t(tbPageContext.getString(R.string.confirm_unlike));
            ArrayList arrayList = new ArrayList();
            final u45 u45Var = new u45(tbPageContext, w45Var);
            s45 s45Var = new s45(tbPageContext.getString(R.string.obfuscated_res_0x7f0f04c1), w45Var);
            s45Var.m(new w45.e() { // from class: com.baidu.tieba.n77
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.w45.e
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FeedHeadExtensionKt.k(dc7.this, tbPageContext, u45Var);
                    }
                }
            });
            arrayList.add(s45Var);
            w45Var.o(new w45.c() { // from class: com.baidu.tieba.m77
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.w45.c
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        FeedHeadExtensionKt.l(u45.this, tbPageContext);
                    }
                }
            });
            w45Var.l(arrayList);
            u45Var.k(0.7f);
            jg.i(u45Var, tbPageContext.getPageActivity());
        }
    }

    public static final void k(dc7 state, TbPageContext pageContext, u45 dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, state, pageContext, dialog) == null) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(pageContext, "$pageContext");
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            f(state, pageContext);
            jg.a(dialog, pageContext.getPageActivity());
        }
    }

    public static final v57 o(FeedHeadSymbol feedHeadSymbol, String str, Map<String, String> headLocalStatInfo) {
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
            List<c77> b = s77.b(list);
            for (c77 c77Var : b) {
                Map<String, String> b2 = c77Var.b();
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
        return (v57) invokeLLL.objValue;
    }

    public static final cc7 s(FeedHeadButton feedHeadButton, a67 feedExtraData, boolean z) {
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
                String str5 = (list == null || (str5 = s77.a(list, "forum_id")) == null) ? "" : "";
                i67 a2 = g67.a.a("tb.feed_home_reco_user_state");
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
            String str6 = (list2 == null || (str6 = s77.a(list2, "forum_name")) == null) ? "" : "";
            List<FeedKV> list3 = feedHeadButton.business_info;
            if (list3 != null) {
                str = s77.a(list3, "forum_id");
            } else {
                str = null;
            }
            h67 h67Var = new h67(false, str6, JavaTypesHelper.toLong(str, 0L));
            String str7 = feedExtraData.a().a().get("thread_id");
            if (str7 == null) {
                str2 = "";
            } else {
                str2 = str7;
            }
            List<FeedKV> list4 = feedHeadButton.business_info;
            if (list4 != null) {
                str4 = s77.a(list4, "forum_id");
            }
            return new cc7(h67Var, str2, JavaTypesHelper.toLong(str4, 0L), null, 8, null);
        }
        return (cc7) invokeLLZ.objValue;
    }

    public static final List<v57> p(List<FeedHeadSymbol> list, String str, Map<String, String> headLocalStatInfo) {
        InterceptResult invokeLLL;
        v57 o;
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

    public static final w57 q(FeedHeadIcon feedHeadIcon, String str, List<c77> clickStatList) {
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
            return new w57(url, str, intValue, intValue2, intValue3, z, feedHeadIcon.degrade_url, feedHeadIcon.degrade_width, feedHeadIcon.degrade_height, feedHeadIcon.degrade_priority, clickStatList);
        }
        return (w57) invokeLLL.objValue;
    }

    public static final x57 r(FeedHeadText feedHeadText, String str, List<c77> clickStatList) {
        InterceptResult invokeLLL;
        String str2;
        s57 s57Var;
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
                s57Var = p77.a(color);
            } else {
                s57Var = null;
            }
            s57 s57Var2 = s57Var;
            Integer priority = feedHeadText.priority;
            Intrinsics.checkNotNullExpressionValue(priority, "priority");
            int intValue = priority.intValue();
            Integer num2 = feedHeadText.can_degrade;
            if (num2 != null && num2.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            return new x57(str3, s57Var2, str, intValue, z, feedHeadText.degrade_len, feedHeadText.suffix, feedHeadText.degrade_priority, clickStatList);
        }
        return (x57) invokeLLL.objValue;
    }

    public static final dc7 t(FeedHeadButton feedHeadButton, boolean z, c77 followStatData, c77 unfollowStatData) {
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
                        str = s77.a(list3, "is_like");
                    } else {
                        str = null;
                    }
                    boolean areEqual = Intrinsics.areEqual(str, "1");
                    List<FeedKV> list4 = feedHeadButton.business_info;
                    if (list4 != null && (a4 = s77.a(list4, "like_status")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(a4)) != null) {
                        i = intOrNull.intValue();
                    } else {
                        i = 0;
                    }
                    if (z) {
                        List<FeedKV> list5 = feedHeadButton.business_info;
                        String str6 = (list5 == null || (str6 = s77.a(list5, "user_id")) == null) ? "" : "";
                        i67 a5 = g67.a.a("tb.feed_home_reco_user_state");
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
                        i67 a6 = g67.a.a("tb.feed_home_reco_user_state");
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
                            if (list != null || (a3 = s77.a(list, "user_id")) == null) {
                                str2 = "";
                            } else {
                                str2 = a3;
                            }
                            list2 = feedHeadButton.business_info;
                            if (list2 != null || (a2 = s77.a(list2, "portrait")) == null) {
                                str3 = "";
                            } else {
                                str3 = a2;
                            }
                            return new dc7(new w67(z2, i2, str2, str3, followStatData, unfollowStatData), null, new FeedHeadExtensionKt$toPersonAttentionUiState$1(aa7.a), a, null, 16, null);
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
                    return new dc7(new w67(z2, i2, str2, str3, followStatData, unfollowStatData), null, new FeedHeadExtensionKt$toPersonAttentionUiState$1(aa7.a), a, null, 16, null);
                }
            }
            return null;
        }
        return (dc7) invokeCommon.objValue;
    }
}
