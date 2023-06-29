package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedFeedback;
/* loaded from: classes6.dex */
public final class i77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final x57 a(FeedFeedback feedFeedback, v57 feedExtraData) {
        InterceptResult invokeLL;
        y57 y57Var;
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
                y57Var = new y57(feedExtraData.a().a().get("user_id"), feedExtraData.a().a().get("portrait"));
            } else {
                y57Var = null;
            }
            return new x57(type, str, str2, str3, y57Var);
        }
        return (x57) invokeLL.objValue;
    }
}
