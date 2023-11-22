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
/* loaded from: classes6.dex */
public final class ga7 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947787276, "Lcom/baidu/tieba/ga7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947787276, "Lcom/baidu/tieba/ga7;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes6.dex */
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
                switch (i) {
                    case 0:
                    case 1:
                        return "common_text";
                    case 2:
                        return "common_icon";
                    case 3:
                        return "emoji";
                    case 4:
                        return "tie_plus";
                    case 5:
                        return "text_with_bg";
                    case 6:
                        return "text_with_hollow_bg";
                    default:
                        return null;
                }
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

        public final String b(e57 e57Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e57Var)) == null) {
                String str = e57Var.a().get("rich_text_type");
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

        public final k77 c(FeedContentResource content, e57 outerBusinessInfo, w67 logInfo, Map<String, ? extends hb7> statStrategyMap) {
            InterceptResult invokeLLLL;
            String str;
            String str2;
            n57 n57Var;
            n57 n57Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, content, outerBusinessInfo, logInfo, statStrategyMap)) == null) {
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter(outerBusinessInfo, "outerBusinessInfo");
                Intrinsics.checkNotNullParameter(logInfo, "logInfo");
                Intrinsics.checkNotNullParameter(statStrategyMap, "statStrategyMap");
                n77 n77Var = null;
                p77 p77Var = new p77("", null, null);
                FeedContentText feedContentText = content.text_info;
                if (feedContentText != null) {
                    FeedContentColor feedContentColor = feedContentText.color;
                    if (feedContentColor != null) {
                        Integer num = feedContentColor.type;
                        Intrinsics.checkNotNullExpressionValue(num, "it.type");
                        n57Var = new n57(num.intValue(), feedContentColor.day, feedContentColor.night);
                    } else {
                        n57Var = null;
                    }
                    FeedContentColor feedContentColor2 = content.text_info.bg_color;
                    if (feedContentColor2 != null) {
                        Integer num2 = feedContentColor2.type;
                        Intrinsics.checkNotNullExpressionValue(num2, "it.type");
                        n57Var2 = new n57(num2.intValue(), feedContentColor2.day, feedContentColor2.night);
                    } else {
                        n57Var2 = null;
                    }
                    String str3 = content.text_info.text;
                    Intrinsics.checkNotNullExpressionValue(str3, "content.text_info.text");
                    p77Var = new p77(str3, n57Var, n57Var2);
                }
                p77 p77Var2 = p77Var;
                r67 r67Var = new r67(null, null, 0, 0, 15, null);
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
                    r67Var = new r67(str4, str5, intValue, num4.intValue());
                }
                r67 r67Var2 = r67Var;
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
                e57 e57Var = new e57();
                e57Var.b(ea7.a.a(content.business_info));
                e57 e57Var2 = new e57();
                e57Var2.a().putAll(outerBusinessInfo.a());
                e57Var2.a().putAll(e57Var.a());
                w67 w67Var = new w67();
                w67Var.b(ea7.a.a(content.log_info));
                String b = b(e57Var2);
                if (Intrinsics.areEqual("rich_text_common_stat", b)) {
                    String str6 = w67Var.a().get("key");
                    if (str6 != null) {
                        n77Var = new n77(str6, new HashMap(), w67Var.a(), null, null, 24, null);
                    }
                } else {
                    hb7 hb7Var = statStrategyMap.get(b);
                    if (hb7Var != null) {
                        n77Var = new n77(hb7Var.getKey(), hb7Var.a(e57Var2), logInfo.a(), null, null, 24, null);
                    }
                }
                Integer num5 = content.type;
                Intrinsics.checkNotNullExpressionValue(num5, "content.type");
                int intValue2 = num5.intValue();
                String str7 = content.schema;
                Intrinsics.checkNotNullExpressionValue(str7, "content.schema");
                return new k77(intValue2, p77Var2, r67Var2, str2, e57Var2, str7, n77Var, ea7.a.a(content.log_info));
            }
            return (k77) invokeLLLL.objValue;
        }
    }
}
