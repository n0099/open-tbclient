package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedEntrybarComponent;
/* loaded from: classes4.dex */
public final class ey6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedEntrybarComponent feedEntrybarComponent, List<c07<? extends Object>> mutableList, vx6 vx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedEntrybarComponent, mutableList, vx6Var) == null) {
            Intrinsics.checkNotNullParameter(feedEntrybarComponent, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            mutableList.add(b(feedEntrybarComponent, vx6Var));
        }
    }

    public static final xv6 b(FeedEntrybarComponent feedEntrybarComponent, vx6 vx6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, feedEntrybarComponent, vx6Var)) == null) {
            Intrinsics.checkNotNullParameter(feedEntrybarComponent, "<this>");
            String text = feedEntrybarComponent.text;
            Intrinsics.checkNotNullExpressionValue(text, "text");
            String schema = feedEntrybarComponent.schema;
            Intrinsics.checkNotNullExpressionValue(schema, "schema");
            return new xv6(text, schema, null, vx6Var, 4, null);
        }
        return (xv6) invokeLL.objValue;
    }
}
