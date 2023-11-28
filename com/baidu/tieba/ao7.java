package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ComponentFactory;
import tbclient.FeedAuthorSocial;
import tbclient.FeedContentResource;
import tbclient.FeedVideoComponent;
import tbclient.LayoutFactory;
import tbclient.TitleComponent;
import tbclient.VideoDoubleRowLayout;
import tbclient.VideoField;
/* loaded from: classes5.dex */
public final class ao7 implements w87<LayoutFactory> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ao7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w87
    /* renamed from: a */
    public nb7<?> b(LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        VideoDoubleRowLayout videoDoubleRowLayout;
        boolean z;
        String str;
        VideoField videoField;
        boolean z2;
        List<FeedContentResource> list;
        wi7 b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, layoutFactory)) == null) {
            if (layoutFactory != null) {
                videoDoubleRowLayout = layoutFactory.double_row_video;
            } else {
                videoDoubleRowLayout = null;
            }
            if (videoDoubleRowLayout != null) {
                List<ComponentFactory> list2 = layoutFactory.double_row_video.components;
                if (list2 != null && !list2.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    n67 n67Var = new n67();
                    VideoDoubleRowLayout videoDoubleRowLayout2 = layoutFactory.double_row_video;
                    Intrinsics.checkNotNullExpressionValue(videoDoubleRowLayout2, "originData.double_row_video");
                    o67.c(n67Var, videoDoubleRowLayout2);
                    i87 i87Var = new i87();
                    x47 x47Var = null;
                    u47 u47Var = null;
                    wi7 wi7Var = null;
                    for (ComponentFactory componentFactory : layoutFactory.double_row_video.components) {
                        String str2 = componentFactory.component;
                        if (str2 != null) {
                            int hashCode = str2.hashCode();
                            if (hashCode != -1611940928) {
                                if (hashCode != 582564983) {
                                    if (hashCode == 584396442 && str2.equals("feed_video")) {
                                        FeedVideoComponent feedVideoComponent = componentFactory.feed_video;
                                        if (feedVideoComponent != null) {
                                            str = feedVideoComponent.schema;
                                        } else {
                                            str = null;
                                        }
                                        if (str == null) {
                                            str = "";
                                        }
                                        i87Var.j(o97.a(str, n67Var));
                                        FeedVideoComponent feedVideoComponent2 = componentFactory.feed_video;
                                        if (feedVideoComponent2 != null && (videoField = feedVideoComponent2.video_info) != null) {
                                            x47Var = o97.b(videoField, i87Var, n67Var);
                                        }
                                    }
                                } else if (str2.equals("feed_title")) {
                                    List<ComponentFactory> list3 = layoutFactory.double_row_video.components;
                                    Intrinsics.checkNotNullExpressionValue(list3, "originData.double_row_video.components");
                                    u47 u47Var2 = new u47(spannableStringBuilder, sa7.a(list3), m97.a(n67Var.a()));
                                    TitleComponent titleComponent = componentFactory.feed_title;
                                    if (titleComponent != null && (list = titleComponent.data) != null) {
                                        l97.a(list, spannableStringBuilder, n67Var, u47Var2);
                                    }
                                    if (spannableStringBuilder.length() > 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        u47Var = u47Var2;
                                    }
                                }
                            } else if (str2.equals("feed_author_social")) {
                                FeedAuthorSocial feedAuthorSocial = componentFactory.feed_author_social;
                                if (feedAuthorSocial != null) {
                                    b = bo7.b(feedAuthorSocial, i87Var);
                                    wi7Var = b;
                                } else {
                                    wi7Var = null;
                                }
                            }
                        }
                    }
                    if (x47Var != null && wi7Var != null) {
                        ob7 ob7Var = new ob7(new xf7(x47Var, u47Var, wi7Var, Intrinsics.areEqual(n67Var.a().a().get("is_grey_mode"), "1"), Intrinsics.areEqual(n67Var.a().a().get("can_multi_manage"), "1"), n67Var.a().a().get("thread_id"), n67Var.a().a().get("user_id"), null, null, n67Var.a().a(), n67Var.c().a(), null, null, 6528, null), "staggered_video");
                        ob7Var.b = n67Var.a();
                        ob7Var.a = n67Var.c();
                        return ob7Var;
                    }
                    do7.a("瀑布流视频item数据，缺少必须数据：视频数据和人信息数据");
                }
            }
            return null;
        }
        return (nb7) invokeL.objValue;
    }
}
