package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AbstractComponent;
import tbclient.FeedContentResource;
/* loaded from: classes5.dex */
public final class d97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final w57 a(SpannableStringBuilder titleBuilder, List<FeedContentResource> contentList, p77 feedExtraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, titleBuilder, contentList, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(contentList, "contentList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            w57 w57Var = new w57(new x67(titleBuilder, spannableStringBuilder));
            n97.a(contentList, spannableStringBuilder, feedExtraData, w57Var);
            return w57Var;
        }
        return (w57) invokeLLL.objValue;
    }

    public static final void b(AbstractComponent abstractComponent, List<jb7<?>> dataList, SpannableStringBuilder titleBuilder, p77 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, abstractComponent, dataList, titleBuilder, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(abstractComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            List<FeedContentResource> data = abstractComponent.data;
            Intrinsics.checkNotNullExpressionValue(data, "data");
            w57 a = a(titleBuilder, data, feedExtraData);
            if (a.i()) {
                dataList.add(new kb7(a, "abstract"));
            }
        }
    }
}
