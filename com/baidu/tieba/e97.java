package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.BaseTextColor;
import tbclient.FeedContentColor;
import tbclient.FeedContentText;
/* loaded from: classes5.dex */
public final class e97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final h77 a(BaseTextColor baseTextColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, baseTextColor)) == null) {
            Intrinsics.checkNotNullParameter(baseTextColor, "<this>");
            Integer type = baseTextColor.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            return new h77(type.intValue(), baseTextColor.day, baseTextColor.night);
        }
        return (h77) invokeL.objValue;
    }

    public static final h77 b(FeedContentColor feedContentColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, feedContentColor)) == null) {
            Intrinsics.checkNotNullParameter(feedContentColor, "<this>");
            Integer type = feedContentColor.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            return new h77(type.intValue(), feedContentColor.day, feedContentColor.night);
        }
        return (h77) invokeL.objValue;
    }

    public static final t87 c(FeedContentText feedContentText) {
        InterceptResult invokeL;
        h77 h77Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, feedContentText)) == null) {
            Intrinsics.checkNotNullParameter(feedContentText, "<this>");
            String str = feedContentText.text;
            if (str == null) {
                str = "";
            }
            FeedContentColor feedContentColor = feedContentText.color;
            h77 h77Var2 = null;
            if (feedContentColor != null) {
                h77Var = b(feedContentColor);
            } else {
                h77Var = null;
            }
            FeedContentColor feedContentColor2 = feedContentText.bg_color;
            if (feedContentColor2 != null) {
                h77Var2 = b(feedContentColor2);
            }
            return new t87(str, h77Var, h77Var2);
        }
        return (t87) invokeL.objValue;
    }
}
