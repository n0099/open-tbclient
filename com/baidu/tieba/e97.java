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
public final class e97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final l47 a(SpannableStringBuilder titleBuilder, List<FeedContentResource> contentList, r67 feedExtraData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, titleBuilder, contentList, feedExtraData)) == null) {
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(contentList, "contentList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            l47 l47Var = new l47(new o57(titleBuilder, spannableStringBuilder), q97.a(feedExtraData.a()));
            p97.a(contentList, spannableStringBuilder, feedExtraData, l47Var);
            return l47Var;
        }
        return (l47) invokeLLL.objValue;
    }

    public static final void b(AbstractComponent abstractComponent, List<sb7<?>> dataList, SpannableStringBuilder titleBuilder, r67 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, abstractComponent, dataList, titleBuilder, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(abstractComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(titleBuilder, "titleBuilder");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            List<FeedContentResource> data = abstractComponent.data;
            Intrinsics.checkNotNullExpressionValue(data, "data");
            l47 a = a(titleBuilder, data, feedExtraData);
            if (a.k()) {
                dataList.add(new tb7(a, "abstract"));
            }
        }
    }
}
