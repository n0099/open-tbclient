package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedContentColor;
import tbclient.FeedContentEmoji;
import tbclient.FeedContentIcon;
import tbclient.FeedContentResource;
import tbclient.FeedContentText;
/* loaded from: classes5.dex */
public final class c97 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947629672, "Lcom/baidu/tieba/c97;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947629672, "Lcom/baidu/tieba/c97;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (i == 0 || i == 1) {
                    return "common_text";
                }
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return "text_with_bg";
                        }
                        return "tie_plus";
                    }
                    return "emoji";
                }
                return "common_icon";
            }
            return (String) invokeI.objValue;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final String b(m57 m57Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m57Var)) == null) {
                String str = m57Var.a().get("rich_text_type");
                if (str != null) {
                    int hashCode = str.hashCode();
                    if (hashCode != 3123) {
                        if (hashCode != 3242771) {
                            if (hashCode != 110546223) {
                                if (hashCode == 1386396779 && str.equals("video_topic")) {
                                    return "rich_text_video_topic_click";
                                }
                            } else if (str.equals("topic")) {
                                return "rich_text_topic_click";
                            }
                        } else if (str.equals("item")) {
                            return "rich_text_item_click";
                        }
                    } else if (str.equals("at")) {
                        return "rich_text_at_click";
                    }
                }
                return "rich_text_common_stat";
            }
            return (String) invokeL.objValue;
        }

        public final a77 c(FeedContentResource content, m57 outerBusinessInfo, t67 logInfo, Map<String, ? extends z97> statStrategyMap) {
            InterceptResult invokeLLLL;
            String str;
            String str2;
            t57 t57Var;
            t57 t57Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, content, outerBusinessInfo, logInfo, statStrategyMap)) == null) {
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter(outerBusinessInfo, "outerBusinessInfo");
                Intrinsics.checkNotNullParameter(logInfo, "logInfo");
                Intrinsics.checkNotNullParameter(statStrategyMap, "statStrategyMap");
                d77 d77Var = null;
                f77 f77Var = new f77("", null, null);
                FeedContentText feedContentText = content.text_info;
                if (feedContentText != null) {
                    FeedContentColor feedContentColor = feedContentText.color;
                    if (feedContentColor != null) {
                        Integer num = feedContentColor.type;
                        Intrinsics.checkNotNullExpressionValue(num, "it.type");
                        t57Var = new t57(num.intValue(), feedContentColor.day, feedContentColor.night);
                    } else {
                        t57Var = null;
                    }
                    FeedContentColor feedContentColor2 = content.text_info.bg_color;
                    if (feedContentColor2 != null) {
                        Integer num2 = feedContentColor2.type;
                        Intrinsics.checkNotNullExpressionValue(num2, "it.type");
                        t57Var2 = new t57(num2.intValue(), feedContentColor2.day, feedContentColor2.night);
                    } else {
                        t57Var2 = null;
                    }
                    String str3 = content.text_info.text;
                    Intrinsics.checkNotNullExpressionValue(str3, "content.text_info.text");
                    f77Var = new f77(str3, t57Var, t57Var2);
                }
                f77 f77Var2 = f77Var;
                o67 o67Var = new o67(null, null, 0, 0, 15, null);
                FeedContentIcon feedContentIcon = content.icon_info;
                if (feedContentIcon != null) {
                    String str4 = feedContentIcon.day_url;
                    Intrinsics.checkNotNullExpressionValue(str4, "iconInfo.day_url");
                    String str5 = feedContentIcon.night_url;
                    Intrinsics.checkNotNullExpressionValue(str5, "iconInfo.night_url");
                    Integer num3 = feedContentIcon.width;
                    Intrinsics.checkNotNullExpressionValue(num3, "iconInfo.width");
                    int intValue = num3.intValue();
                    Integer num4 = feedContentIcon.height;
                    Intrinsics.checkNotNullExpressionValue(num4, "iconInfo.height");
                    o67Var = new o67(str4, str5, intValue, num4.intValue());
                }
                o67 o67Var2 = o67Var;
                FeedContentEmoji feedContentEmoji = content.emoji_info;
                if (feedContentEmoji != null) {
                    str = feedContentEmoji.name;
                } else {
                    str = null;
                }
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                m57 m57Var = new m57();
                m57Var.b(a97.a.a(content.business_info));
                m57 m57Var2 = new m57();
                m57Var2.a().putAll(outerBusinessInfo.a());
                m57Var2.a().putAll(m57Var.a());
                t67 t67Var = new t67();
                t67Var.b(a97.a.a(content.log_info));
                String b = b(m57Var2);
                if (Intrinsics.areEqual("rich_text_common_stat", b)) {
                    String str6 = t67Var.a().get("key");
                    if (str6 != null) {
                        d77Var = new d77(str6, new HashMap(), t67Var.a(), null, null, 24, null);
                    }
                } else {
                    z97 z97Var = statStrategyMap.get(b);
                    if (z97Var != null) {
                        d77Var = new d77(z97Var.getKey(), z97Var.a(m57Var2), logInfo.a(), null, null, 24, null);
                    }
                }
                Integer num5 = content.type;
                Intrinsics.checkNotNullExpressionValue(num5, "content.type");
                int intValue2 = num5.intValue();
                String str7 = content.schema;
                Intrinsics.checkNotNullExpressionValue(str7, "content.schema");
                return new a77(intValue2, f77Var2, o67Var2, str2, m57Var2, str7, d77Var);
            }
            return (a77) invokeLLLL.objValue;
        }
    }
}
