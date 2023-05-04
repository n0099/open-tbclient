package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedFeedback;
/* loaded from: classes4.dex */
public final class h07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final wy6 a(FeedFeedback feedFeedback, uy6 feedExtraData) {
        InterceptResult invokeLL;
        xy6 xy6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, feedFeedback, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(feedFeedback, "<this>");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            String type = feedFeedback.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            String str = feedFeedback.title;
            String str2 = feedFeedback.button_text;
            String str3 = feedFeedback.common_id;
            if (Intrinsics.areEqual(feedFeedback.type, ImageViewerConfig.FROM_CONCERN)) {
                xy6Var = new xy6(feedExtraData.a().a().get("user_id"), feedExtraData.a().a().get("portrait"));
            } else {
                xy6Var = null;
            }
            return new wy6(type, str, str2, str3, xy6Var);
        }
        return (wy6) invokeLL.objValue;
    }
}
