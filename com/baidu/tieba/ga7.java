package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AbstractComponent;
import tbclient.FeedContentResource;
/* loaded from: classes6.dex */
public final class ga7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final z67 a(SpannableStringBuilder titleBuilder, List<FeedContentResource> contentList, s87 feedExtraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, titleBuilder, contentList, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(contentList, "contentList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            z67 z67Var = new z67(new a87(titleBuilder, spannableStringBuilder));
            qa7.a(contentList, spannableStringBuilder, feedExtraData, z67Var);
            return z67Var;
        }
        return (z67) invokeLLL.objValue;
    }

    public static final void b(AbstractComponent abstractComponent, List<mc7<?>> dataList, SpannableStringBuilder titleBuilder, s87 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, abstractComponent, dataList, titleBuilder, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(abstractComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            List<FeedContentResource> data = abstractComponent.data;
            Intrinsics.checkNotNullExpressionValue(data, "data");
            z67 a = a(titleBuilder, data, feedExtraData);
            if (a.i()) {
                dataList.add(new nc7(a, "abstract"));
            }
        }
    }
}
