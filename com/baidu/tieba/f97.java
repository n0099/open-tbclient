package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.BaseTextColor;
import tbclient.FeedContentColor;
import tbclient.FeedContentText;
/* loaded from: classes5.dex */
public final class f97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final e67 a(BaseTextColor baseTextColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, baseTextColor)) == null) {
            Intrinsics.checkNotNullParameter(baseTextColor, "<this>");
            Integer type = baseTextColor.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            return new e67(type.intValue(), baseTextColor.day, baseTextColor.night);
        }
        return (e67) invokeL.objValue;
    }

    public static final e67 b(FeedContentColor feedContentColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, feedContentColor)) == null) {
            Intrinsics.checkNotNullParameter(feedContentColor, "<this>");
            Integer type = feedContentColor.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            return new e67(type.intValue(), feedContentColor.day, feedContentColor.night);
        }
        return (e67) invokeL.objValue;
    }

    public static final g87 c(FeedContentText feedContentText) {
        InterceptResult invokeL;
        e67 e67Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, feedContentText)) == null) {
            Intrinsics.checkNotNullParameter(feedContentText, "<this>");
            String str = feedContentText.text;
            if (str == null) {
                str = "";
            }
            FeedContentColor feedContentColor = feedContentText.color;
            e67 e67Var2 = null;
            if (feedContentColor != null) {
                e67Var = b(feedContentColor);
            } else {
                e67Var = null;
            }
            FeedContentColor feedContentColor2 = feedContentText.bg_color;
            if (feedContentColor2 != null) {
                e67Var2 = b(feedContentColor2);
            }
            return new g87(str, e67Var, e67Var2);
        }
        return (g87) invokeL.objValue;
    }
}
