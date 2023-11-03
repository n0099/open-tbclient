package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.CardUiStateKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import tbclient.ComponentFactory;
import tbclient.FeedContentText;
import tbclient.FeedFeedback;
import tbclient.FeedKV;
import tbclient.LayoutFactory;
import tbclient.SidewayLayout;
import tbclient.SidewayRecomComponent;
/* loaded from: classes6.dex */
public final class h87 implements i87<LayoutFactory>, fb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends gb7> a;

    public h87() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i87
    /* renamed from: a */
    public za7<?> b(LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        SidewayLayout sidewayLayout;
        boolean z;
        String str;
        String str2;
        SidewayRecomComponent sidewayRecomComponent;
        Integer num;
        o77 o77Var;
        o77 o77Var2;
        String str3;
        int i;
        String str4;
        String str5;
        String a;
        String a2;
        String a3;
        Integer intOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, layoutFactory)) == null) {
            b67 b67Var = null;
            if (layoutFactory != null) {
                sidewayLayout = layoutFactory.sideway;
            } else {
                sidewayLayout = null;
            }
            if (sidewayLayout != null) {
                List<ComponentFactory> list = layoutFactory.sideway.components;
                int i2 = 1;
                if (list != null && !list.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    d57 d57Var = new d57();
                    d57Var.b(da7.a.a(layoutFactory.sideway.business_info));
                    m77 c = c("concern_reco_show", d57Var);
                    b77 b77Var = new b77();
                    for (ComponentFactory componentFactory : layoutFactory.sideway.components) {
                        if (Intrinsics.areEqual("sideway_recom", componentFactory.component) && (sidewayRecomComponent = componentFactory.sideway_recom) != null && (num = sidewayRecomComponent.type) != null && num.intValue() == i2) {
                            d57 d57Var2 = new d57();
                            d57Var2.b(da7.a.a(componentFactory.sideway_recom.business_info));
                            m77 c2 = c("concern_reco_click_head", d57Var2);
                            m77 c3 = c("concern_reco_follow_btn", d57Var2);
                            m77 c4 = c("concern_reco_unfollow_btn", d57Var2);
                            List<za7<?>> list2 = b77Var.a;
                            String str6 = componentFactory.sideway_recom.img_url;
                            Intrinsics.checkNotNullExpressionValue(str6, "data.sideway_recom.img_url");
                            h57 h57Var = new h57(str6, 1, null, null, componentFactory.sideway_recom.corner_url, false, null);
                            FeedContentText feedContentText = componentFactory.sideway_recom.title;
                            if (feedContentText != null) {
                                o77Var = n87.c(feedContentText);
                            } else {
                                o77Var = null;
                            }
                            FeedContentText feedContentText2 = componentFactory.sideway_recom.desc;
                            if (feedContentText2 != null) {
                                o77Var2 = n87.c(feedContentText2);
                            } else {
                                o77Var2 = null;
                            }
                            SidewayRecomComponent sidewayRecomComponent2 = componentFactory.sideway_recom;
                            String str7 = sidewayRecomComponent2.schema;
                            List<FeedKV> list3 = sidewayRecomComponent2.business_info;
                            if (list3 != null) {
                                str3 = q87.a(list3, "is_like");
                            } else {
                                str3 = null;
                            }
                            boolean areEqual = Intrinsics.areEqual("1", str3);
                            List<FeedKV> list4 = componentFactory.sideway_recom.business_info;
                            if (list4 != null && (a3 = q87.a(list4, "like_status")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(a3)) != null) {
                                i = intOrNull.intValue();
                            } else {
                                i = 0;
                            }
                            List<FeedKV> list5 = componentFactory.sideway_recom.business_info;
                            if (list5 == null || (a2 = q87.a(list5, "user_id")) == null) {
                                str4 = "";
                            } else {
                                str4 = a2;
                            }
                            List<FeedKV> list6 = componentFactory.sideway_recom.business_info;
                            if (list6 == null || (a = q87.a(list6, "portrait")) == null) {
                                str5 = "";
                            } else {
                                str5 = a;
                            }
                            list2.add(new ab7(new q47(h57Var, o77Var, o77Var2, str7, new pd7(new d77(areEqual, i, str4, str5, c3, c4), null, CardUiStateKt.b(), null, null, 24, null), c2, null, null, 192, null), "recommend_card_person_attention"));
                            i2 = 1;
                        }
                    }
                    b77Var.b = c;
                    ComponentFactory componentFactory2 = layoutFactory.sideway.title;
                    if (componentFactory2 != null) {
                        str = componentFactory2.base_text;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    FeedFeedback feedFeedback = layoutFactory.sideway.feedback;
                    if (feedFeedback != null) {
                        b67Var = c97.a(feedFeedback, new z57());
                    }
                    return new ab7(new p47(str2, R.color.CAM_X0105, b77Var, b67Var, null, 16, null), "sideway_card");
                }
            }
            return null;
        }
        return (za7) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fb7
    public void d(Map<String, ? extends gb7> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }
    }

    public final m77 c(String str, d57 d57Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, d57Var)) == null) {
            gb7 gb7Var = this.a.get(str);
            if (gb7Var != null) {
                return new m77(gb7Var.getKey(), gb7Var.a(d57Var), new HashMap(), null, null, 24, null);
            }
            return null;
        }
        return (m77) invokeLL.objValue;
    }
}
