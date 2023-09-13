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
public final class ia7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final a77 a(SpannableStringBuilder titleBuilder, List<FeedContentResource> contentList, u87 feedExtraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, titleBuilder, contentList, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(contentList, "contentList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            a77 a77Var = new a77(new c87(titleBuilder, spannableStringBuilder));
            ta7.a(contentList, spannableStringBuilder, feedExtraData, a77Var);
            return a77Var;
        }
        return (a77) invokeLLL.objValue;
    }

    public static final void b(AbstractComponent abstractComponent, List<pc7<?>> dataList, SpannableStringBuilder titleBuilder, u87 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, abstractComponent, dataList, titleBuilder, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(abstractComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            List<FeedContentResource> data = abstractComponent.data;
            Intrinsics.checkNotNullExpressionValue(data, "data");
            a77 a = a(titleBuilder, data, feedExtraData);
            if (a.i()) {
                dataList.add(new qc7(a, "abstract"));
            }
        }
    }
}
