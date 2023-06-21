package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedFeedback;
/* loaded from: classes5.dex */
public final class d77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final s57 a(FeedFeedback feedFeedback, q57 feedExtraData) {
        InterceptResult invokeLL;
        t57 t57Var;
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
                t57Var = new t57(feedExtraData.a().a().get("user_id"), feedExtraData.a().a().get("portrait"));
            } else {
                t57Var = null;
            }
            return new s57(type, str, str2, str3, t57Var);
        }
        return (s57) invokeLL.objValue;
    }
}
