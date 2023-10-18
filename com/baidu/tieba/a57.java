package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.BaseTextColor;
import tbclient.FeedContentColor;
import tbclient.FeedContentText;
/* loaded from: classes5.dex */
public final class a57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final c37 a(BaseTextColor baseTextColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, baseTextColor)) == null) {
            Intrinsics.checkNotNullParameter(baseTextColor, "<this>");
            Integer type = baseTextColor.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            return new c37(type.intValue(), baseTextColor.day, baseTextColor.night);
        }
        return (c37) invokeL.objValue;
    }

    public static final c37 b(FeedContentColor feedContentColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, feedContentColor)) == null) {
            Intrinsics.checkNotNullParameter(feedContentColor, "<this>");
            Integer type = feedContentColor.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            return new c37(type.intValue(), feedContentColor.day, feedContentColor.night);
        }
        return (c37) invokeL.objValue;
    }

    public static final p47 c(FeedContentText feedContentText) {
        InterceptResult invokeL;
        c37 c37Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, feedContentText)) == null) {
            Intrinsics.checkNotNullParameter(feedContentText, "<this>");
            String str = feedContentText.text;
            if (str == null) {
                str = "";
            }
            FeedContentColor feedContentColor = feedContentText.color;
            c37 c37Var2 = null;
            if (feedContentColor != null) {
                c37Var = b(feedContentColor);
            } else {
                c37Var = null;
            }
            FeedContentColor feedContentColor2 = feedContentText.bg_color;
            if (feedContentColor2 != null) {
                c37Var2 = b(feedContentColor2);
            }
            return new p47(str, c37Var, c37Var2);
        }
        return (p47) invokeL.objValue;
    }
}
