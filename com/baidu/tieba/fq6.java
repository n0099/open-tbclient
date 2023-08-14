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
/* loaded from: classes5.dex */
public final class fq6 implements l77<LayoutFactory>, y97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends z97> a;

    public fq6() {
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
    @Override // com.baidu.tieba.l77
    /* renamed from: a */
    public v97<?> b(LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        SidewayLayout sidewayLayout;
        boolean z;
        String str;
        String str2;
        SidewayRecomComponent sidewayRecomComponent;
        Integer num;
        f77 f77Var;
        f77 f77Var2;
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
            d67 d67Var = null;
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
                    m57 m57Var = new m57();
                    m57Var.b(a97.a.a(layoutFactory.sideway.business_info));
                    d77 c = c("concern_reco_show", m57Var);
                    v67 v67Var = new v67();
                    for (ComponentFactory componentFactory : layoutFactory.sideway.components) {
                        if (Intrinsics.areEqual("sideway_recom", componentFactory.component) && (sidewayRecomComponent = componentFactory.sideway_recom) != null && (num = sidewayRecomComponent.type) != null && num.intValue() == i2) {
                            m57 m57Var2 = new m57();
                            m57Var2.b(a97.a.a(componentFactory.sideway_recom.business_info));
                            d77 c2 = c("concern_reco_click_head", m57Var2);
                            d77 c3 = c("concern_reco_follow_btn", m57Var2);
                            d77 c4 = c("concern_reco_unfollow_btn", m57Var2);
                            List<v97<?>> list2 = v67Var.a;
                            String str6 = componentFactory.sideway_recom.img_url;
                            Intrinsics.checkNotNullExpressionValue(str6, "data.sideway_recom.img_url");
                            p57 p57Var = new p57(str6, 1, null, null, componentFactory.sideway_recom.corner_url, false, null);
                            FeedContentText feedContentText = componentFactory.sideway_recom.title;
                            if (feedContentText != null) {
                                f77Var = q77.c(feedContentText);
                            } else {
                                f77Var = null;
                            }
                            FeedContentText feedContentText2 = componentFactory.sideway_recom.desc;
                            if (feedContentText2 != null) {
                                f77Var2 = q77.c(feedContentText2);
                            } else {
                                f77Var2 = null;
                            }
                            SidewayRecomComponent sidewayRecomComponent2 = componentFactory.sideway_recom;
                            String str7 = sidewayRecomComponent2.schema;
                            List<FeedKV> list3 = sidewayRecomComponent2.business_info;
                            if (list3 != null) {
                                str3 = t77.a(list3, "is_like");
                            } else {
                                str3 = null;
                            }
                            boolean areEqual = Intrinsics.areEqual("1", str3);
                            List<FeedKV> list4 = componentFactory.sideway_recom.business_info;
                            if (list4 != null && (a3 = t77.a(list4, "like_status")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(a3)) != null) {
                                i = intOrNull.intValue();
                            } else {
                                i = 0;
                            }
                            List<FeedKV> list5 = componentFactory.sideway_recom.business_info;
                            if (list5 == null || (a2 = t77.a(list5, "user_id")) == null) {
                                str4 = "";
                            } else {
                                str4 = a2;
                            }
                            List<FeedKV> list6 = componentFactory.sideway_recom.business_info;
                            if (list6 == null || (a = t77.a(list6, "portrait")) == null) {
                                str5 = "";
                            } else {
                                str5 = a;
                            }
                            list2.add(new w97(new e57(p57Var, f77Var, f77Var2, str7, new ec7(new x67(areEqual, i, str4, str5, c3, c4), null, CardUiStateKt.b(), null, null, 24, null), c2, null, null, 192, null), "recommend_card_person_attention"));
                            i2 = 1;
                        }
                    }
                    v67Var.b = c;
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
                        d67Var = f87.a(feedFeedback, new b67());
                    }
                    return new w97(new d57(str2, R.color.CAM_X0105, v67Var, d67Var, null, 16, null), "sideway_card");
                }
            }
            return null;
        }
        return (v97) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y97
    public void d(Map<String, ? extends z97> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }
    }

    public final d77 c(String str, m57 m57Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, m57Var)) == null) {
            z97 z97Var = this.a.get(str);
            if (z97Var != null) {
                return new d77(z97Var.getKey(), z97Var.a(m57Var), new HashMap(), null, null, 24, null);
            }
            return null;
        }
        return (d77) invokeLL.objValue;
    }
}
