package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import tbclient.BaseTextColor;
import tbclient.FeedContentColor;
import tbclient.FeedContentText;
/* loaded from: classes6.dex */
public final class ha7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final k87 a(BaseTextColor baseTextColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, baseTextColor)) == null) {
            Intrinsics.checkNotNullParameter(baseTextColor, "<this>");
            Integer type = baseTextColor.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            return new k87(type.intValue(), baseTextColor.day, baseTextColor.night);
        }
        return (k87) invokeL.objValue;
    }

    public static final k87 b(FeedContentColor feedContentColor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, feedContentColor)) == null) {
            Intrinsics.checkNotNullParameter(feedContentColor, "<this>");
            Integer type = feedContentColor.type;
            Intrinsics.checkNotNullExpressionValue(type, "type");
            return new k87(type.intValue(), feedContentColor.day, feedContentColor.night);
        }
        return (k87) invokeL.objValue;
    }

    public static final w97 c(FeedContentText feedContentText) {
        InterceptResult invokeL;
        k87 k87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, feedContentText)) == null) {
            Intrinsics.checkNotNullParameter(feedContentText, "<this>");
            String str = feedContentText.text;
            if (str == null) {
                str = "";
            }
            FeedContentColor feedContentColor = feedContentText.color;
            k87 k87Var2 = null;
            if (feedContentColor != null) {
                k87Var = b(feedContentColor);
            } else {
                k87Var = null;
            }
            FeedContentColor feedContentColor2 = feedContentText.bg_color;
            if (feedContentColor2 != null) {
                k87Var2 = b(feedContentColor2);
            }
            return new w97(str, k87Var, k87Var2);
        }
        return (w97) invokeL.objValue;
    }
}
