package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.data.protobuf.FeedHeadExtensionKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AbstractComponent;
import tbclient.ComponentFactory;
import tbclient.FeedEntrybarComponent;
import tbclient.FeedFeedback;
import tbclient.FeedHeadComponent;
import tbclient.FeedHeadFigureComponent;
import tbclient.FeedItem;
import tbclient.FeedKV;
import tbclient.FeedLayout;
import tbclient.FeedLinkComponent;
import tbclient.FeedLiveComponent;
import tbclient.FeedOriginComponent;
import tbclient.FeedPicComponent;
import tbclient.FeedPostExpose;
import tbclient.FeedRoomComponent;
import tbclient.FeedSocialComponent;
import tbclient.FeedVideoAdComponent;
import tbclient.FeedVideoComponent;
import tbclient.LayoutFactory;
import tbclient.ThreadRecommendInfo;
import tbclient.TitleComponent;
import tbclient.Voice;
/* loaded from: classes5.dex */
public abstract class da7 implements ea7<LayoutFactory>, sc7, tb7, g97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends tc7> a;
    public Map<String, String> b;
    public boolean c;

    public Object e(String key, String value) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, key, value)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return null;
        }
        return invokeLL.objValue;
    }

    public abstract pc7<?> h(g87<?> g87Var, u87 u87Var);

    public da7() {
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
        this.b = new HashMap();
    }

    @Override // com.baidu.tieba.tb7
    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.b = map;
        }
    }

    @Override // com.baidu.tieba.g97
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.c = z;
        }
    }

    @Override // com.baidu.tieba.sc7
    public void d(Map<String, ? extends tc7> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }
    }

    public final Map<String, Object> f(List<FeedKV> list) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (FeedKV feedKV : list) {
                String str = feedKV.key;
                if (str != null && str.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    String str2 = feedKV.value;
                    if (str2 != null && str2.length() != 0) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        String str3 = feedKV.key;
                        Intrinsics.checkNotNullExpressionValue(str3, "info.key");
                        String str4 = feedKV.value;
                        Intrinsics.checkNotNullExpressionValue(str4, "info.value");
                        Object e = e(str3, str4);
                        if (e != null) {
                            String str5 = feedKV.key;
                            Intrinsics.checkNotNullExpressionValue(str5, "info.key");
                            linkedHashMap.put(str5, e);
                        }
                    }
                }
            }
            return linkedHashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ea7
    /* renamed from: g */
    public pc7<?> b(LayoutFactory originData) {
        InterceptResult invokeL;
        w87 w87Var;
        ThreadRecommendInfo threadRecommendInfo;
        w87 w87Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, originData)) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            u87 u87Var = new u87();
            u87Var.h(this.a);
            FeedLayout feedLayout = originData.feed;
            Intrinsics.checkNotNullExpressionValue(feedLayout, "originData.feed");
            v87.a(u87Var, feedLayout);
            u87Var.g(this.b);
            u87Var.f(this.c);
            aa7 aa7Var = new aa7();
            for (ComponentFactory componentFactory : originData.feed.components) {
                String str = componentFactory.component;
                if (str != null) {
                    String str2 = "";
                    String str3 = null;
                    switch (str.hashCode()) {
                        case -1644137503:
                            if (str.equals("feed_head")) {
                                FeedHeadComponent feedHeadComponent = componentFactory.feed_head;
                                if (feedHeadComponent == null) {
                                    break;
                                } else {
                                    FeedFeedback feedFeedback = originData.feed.feedback;
                                    if (feedFeedback != null) {
                                        w87Var = za7.a(feedFeedback, u87Var);
                                    } else {
                                        w87Var = null;
                                    }
                                    boolean c = FeedHeadExtensionKt.c(originData.feed.business_info);
                                    List<ComponentFactory> list = originData.feed.components;
                                    Intrinsics.checkNotNullExpressionValue(list, "originData.feed.components");
                                    FeedHeadExtensionKt.h(feedHeadComponent, arrayList, w87Var, c, u87Var, list);
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -1644093164:
                            if (str.equals("feed_item")) {
                                FeedItem feedItem = componentFactory.feed_item;
                                if (feedItem != null) {
                                    la7.c(feedItem, arrayList, u87Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -1644014085:
                            if (str.equals("feed_link")) {
                                FeedLinkComponent feedLinkComponent = componentFactory.feed_link;
                                if (feedLinkComponent != null) {
                                    na7.a(feedLinkComponent, arrayList);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -1644013843:
                            if (str.equals("feed_live")) {
                                FeedLiveComponent feedLiveComponent = componentFactory.feed_live;
                                if (feedLiveComponent != null) {
                                    oa7.a(feedLiveComponent, arrayList, u87Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -1643829540:
                            if (str.equals("feed_room")) {
                                FeedRoomComponent feedRoomComponent = componentFactory.feed_room;
                                if (feedRoomComponent != null) {
                                    qa7.a(feedRoomComponent, arrayList, u87Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -1461408349:
                            if (str.equals("feed_abstract")) {
                                AbstractComponent abstractComponent = componentFactory.feed_abstract;
                                if (abstractComponent != null) {
                                    ia7.b(abstractComponent, arrayList, spannableStringBuilder, u87Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -1035731907:
                            if (str.equals("feed_videoad")) {
                                FeedVideoComponent feedVideoComponent = componentFactory.feed_video;
                                if (feedVideoComponent != null) {
                                    str3 = feedVideoComponent.schema;
                                }
                                if (str3 != null) {
                                    str2 = str3;
                                }
                                aa7Var.j(xa7.a(str2, u87Var));
                                FeedVideoAdComponent feedVideoAdComponent = componentFactory.feed_videoad;
                                if (feedVideoAdComponent != null) {
                                    wa7.b(feedVideoAdComponent, arrayList, aa7Var, u87Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -993000478:
                            if (str.equals("feed_entrybar")) {
                                FeedEntrybarComponent feedEntrybarComponent = componentFactory.feed_entrybar;
                                if (feedEntrybarComponent != null) {
                                    ka7.a(feedEntrybarComponent, arrayList, v87.b(u87Var, "enter_forum_btn_click"));
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -984476251:
                            if (str.equals("feed_postexpose")) {
                                FeedPostExpose feedPostExpose = componentFactory.feed_postexpose;
                                if (feedPostExpose != null) {
                                    sa7.a(feedPostExpose, arrayList, u87Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -191576215:
                            if (str.equals("feed_pic")) {
                                FeedPicComponent feedPicComponent = componentFactory.feed_pic;
                                if (feedPicComponent != null) {
                                    ra7.b(feedPicComponent, arrayList, u87Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 301292525:
                            if (str.equals("feed_recomtag")) {
                                List<ThreadRecommendInfo> list2 = componentFactory.feed_recomtag;
                                if (list2 != null && (threadRecommendInfo = (ThreadRecommendInfo) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2)) != null) {
                                    ab7.a(threadRecommendInfo, arrayList);
                                    break;
                                }
                            } else {
                                continue;
                            }
                            break;
                        case 582564983:
                            if (str.equals("feed_title")) {
                                List<ComponentFactory> list3 = originData.feed.components;
                                Intrinsics.checkNotNullExpressionValue(list3, "originData.feed.components");
                                boolean a = vb7.a(list3);
                                TitleComponent titleComponent = componentFactory.feed_title;
                                if (titleComponent != null) {
                                    va7.a(titleComponent, arrayList, spannableStringBuilder, u87Var, a);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 584396442:
                            if (str.equals("feed_video")) {
                                FeedVideoComponent feedVideoComponent2 = componentFactory.feed_video;
                                if (feedVideoComponent2 != null) {
                                    str3 = feedVideoComponent2.schema;
                                }
                                if (str3 != null) {
                                    str2 = str3;
                                }
                                aa7Var.j(xa7.a(str2, u87Var));
                                FeedVideoComponent feedVideoComponent3 = componentFactory.feed_video;
                                if (feedVideoComponent3 != null) {
                                    xa7.c(feedVideoComponent3, arrayList, aa7Var, u87Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 584579921:
                            if (str.equals("feed_voice")) {
                                Voice voice = componentFactory.feed_voice;
                                if (voice != null) {
                                    ya7.a(voice, arrayList, u87Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 744478951:
                            if (str.equals("feed_origin")) {
                                FeedOriginComponent feedOriginComponent = componentFactory.feed_origin;
                                if (feedOriginComponent != null) {
                                    pa7.a(feedOriginComponent, arrayList, u87Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 856047918:
                            if (str.equals("feed_social")) {
                                FeedSocialComponent feedSocialComponent = componentFactory.feed_social;
                                if (feedSocialComponent != null) {
                                    ua7.a(feedSocialComponent, arrayList, u87Var, aa7Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 1804018946:
                            if (str.equals("feed_head_figure")) {
                                FeedHeadFigureComponent feedHeadFigureComponent = componentFactory.feed_head_figure;
                                if (feedHeadFigureComponent != null) {
                                    w97 b = v87.b(u87Var, "virtual_head_show");
                                    w97 b2 = v87.b(u87Var, "virtual_head_click");
                                    FeedFeedback feedFeedback2 = originData.feed.feedback;
                                    if (feedFeedback2 != null) {
                                        w87Var2 = za7.a(feedFeedback2, u87Var);
                                    } else {
                                        w87Var2 = null;
                                    }
                                    FeedHeadExtensionKt.i(feedHeadFigureComponent, arrayList, b, b2, w87Var2, v87.c(u87Var, "head_local_stat_info"));
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                    }
                }
            }
            String str4 = originData.feed.schema;
            Intrinsics.checkNotNullExpressionValue(str4, "originData.feed.schema");
            return h(new g87<>(arrayList, str4, Intrinsics.areEqual(u87Var.a().a().get("is_grey_mode"), "1"), u87Var.a().a().get("thread_id"), u87Var.a().a().get("user_id"), f(originData.feed.appendix), null, 64, null), u87Var);
        }
        return (pc7) invokeL.objValue;
    }
}
