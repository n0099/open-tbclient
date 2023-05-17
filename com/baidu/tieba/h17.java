package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedEntrybarComponent;
/* loaded from: classes5.dex */
public final class h17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedEntrybarComponent feedEntrybarComponent, List<f37<? extends Object>> mutableList, y07 y07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedEntrybarComponent, mutableList, y07Var) == null) {
            Intrinsics.checkNotNullParameter(feedEntrybarComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            mutableList.add(b(feedEntrybarComponent, y07Var));
        }
    }

    public static final az6 b(FeedEntrybarComponent feedEntrybarComponent, y07 y07Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, feedEntrybarComponent, y07Var)) == null) {
            Intrinsics.checkNotNullParameter(feedEntrybarComponent, "<this>");
            String text = feedEntrybarComponent.text;
            Intrinsics.checkNotNullExpressionValue(text, "text");
            String schema = feedEntrybarComponent.schema;
            Intrinsics.checkNotNullExpressionValue(schema, "schema");
            return new az6(text, schema, null, y07Var, 4, null);
        }
        return (az6) invokeLL.objValue;
    }
}
