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
public final class fo7 implements a97<LayoutFactory> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fo7() {
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
    @Override // com.baidu.tieba.a97
    /* renamed from: a */
    public sb7<?> b(LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        VideoDoubleRowLayout videoDoubleRowLayout;
        boolean z;
        String str;
        VideoField videoField;
        boolean z2;
        List<FeedContentResource> list;
        bj7 b;
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
                    r67 r67Var = new r67();
                    VideoDoubleRowLayout videoDoubleRowLayout2 = layoutFactory.double_row_video;
                    Intrinsics.checkNotNullExpressionValue(videoDoubleRowLayout2, "originData.double_row_video");
                    s67.c(r67Var, videoDoubleRowLayout2);
                    m87 m87Var = new m87();
                    b57 b57Var = null;
                    y47 y47Var = null;
                    bj7 bj7Var = null;
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
                                        m87Var.j(s97.a(str, r67Var));
                                        FeedVideoComponent feedVideoComponent2 = componentFactory.feed_video;
                                        if (feedVideoComponent2 != null && (videoField = feedVideoComponent2.video_info) != null) {
                                            b57Var = s97.b(videoField, m87Var, r67Var);
                                        }
                                    }
                                } else if (str2.equals("feed_title")) {
                                    List<ComponentFactory> list3 = layoutFactory.double_row_video.components;
                                    Intrinsics.checkNotNullExpressionValue(list3, "originData.double_row_video.components");
                                    y47 y47Var2 = new y47(spannableStringBuilder, xa7.a(list3), q97.a(r67Var.a()));
                                    TitleComponent titleComponent = componentFactory.feed_title;
                                    if (titleComponent != null && (list = titleComponent.data) != null) {
                                        p97.a(list, spannableStringBuilder, r67Var, y47Var2);
                                    }
                                    if (spannableStringBuilder.length() > 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        y47Var = y47Var2;
                                    }
                                }
                            } else if (str2.equals("feed_author_social")) {
                                FeedAuthorSocial feedAuthorSocial = componentFactory.feed_author_social;
                                if (feedAuthorSocial != null) {
                                    b = go7.b(feedAuthorSocial, m87Var);
                                    bj7Var = b;
                                } else {
                                    bj7Var = null;
                                }
                            }
                        }
                    }
                    if (b57Var != null && bj7Var != null) {
                        tb7 tb7Var = new tb7(new cg7(b57Var, y47Var, bj7Var, Intrinsics.areEqual(r67Var.a().a().get("is_grey_mode"), "1"), Intrinsics.areEqual(r67Var.a().a().get("can_multi_manage"), "1"), r67Var.a().a().get("thread_id"), r67Var.a().a().get("user_id"), null, null, r67Var.a().a(), r67Var.c().a(), null, null, 6528, null), "staggered_video");
                        tb7Var.b = r67Var.a();
                        tb7Var.a = r67Var.c();
                        return tb7Var;
                    }
                    io7.a("瀑布流视频item数据，缺少必须数据：视频数据和人信息数据");
                }
            }
            return null;
        }
        return (sb7) invokeL.objValue;
    }
}
