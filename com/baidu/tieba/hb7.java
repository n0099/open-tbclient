package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedFeedback;
import tbclient.FeedbackReason;
/* loaded from: classes6.dex */
public final class hb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final d97 a(FeedFeedback feedFeedback, b97 feedExtraData) {
        InterceptResult invokeLL;
        f97 f97Var;
        int i;
        Object e97Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, feedFeedback, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(feedFeedback, "<this>");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            String type = feedFeedback.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            String str = feedFeedback.title;
            String str2 = feedFeedback.button_text;
            String str3 = feedFeedback.common_id;
            String str4 = feedFeedback.type;
            if (Intrinsics.areEqual(str4, ImageViewerConfig.FROM_CONCERN)) {
                f97Var = new f97(feedExtraData.a().a().get("user_id"), feedExtraData.a().a().get("portrait"));
            } else if (Intrinsics.areEqual(str4, "recommend_post")) {
                String str5 = feedExtraData.a().a().get("thread_id");
                String str6 = feedExtraData.a().a().get("forum_id");
                List<FeedbackReason> list = feedFeedback.dislike;
                SparseArray sparseArray = new SparseArray();
                for (FeedbackReason feedbackReason : list) {
                    Integer num = feedbackReason.id;
                    Intrinsics.checkNotNullExpressionValue(num, "reason.id");
                    sparseArray.put(num.intValue(), feedbackReason.reason);
                }
                List<FeedbackReason> list2 = feedFeedback.dislike;
                SparseArray sparseArray2 = new SparseArray();
                for (FeedbackReason feedbackReason2 : list2) {
                    Integer num2 = feedbackReason2.id;
                    Intrinsics.checkNotNullExpressionValue(num2, "reason.id");
                    sparseArray2.put(num2.intValue(), feedbackReason2.extra);
                }
                String str7 = feedExtraData.a().a().get("weight");
                String str8 = feedExtraData.a().a().get("source");
                String str9 = feedExtraData.a().a().get("threadType");
                if (str9 != null) {
                    i = Integer.parseInt(str9);
                } else {
                    i = 0;
                }
                e97Var = new e97(str5, str6, null, sparseArray, sparseArray2, str7, str8, feedExtraData.a().a().get("extra"), i, 4, null);
                return new d97(type, str, str2, str3, e97Var);
            } else {
                f97Var = null;
            }
            e97Var = f97Var;
            return new d97(type, str, str2, str3, e97Var);
        }
        return (d97) invokeLL.objValue;
    }
}
