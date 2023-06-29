package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a87;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedContentColor;
import tbclient.FeedContentEmoji;
import tbclient.FeedContentIcon;
import tbclient.FeedContentResource;
import tbclient.FeedContentText;
import tbclient.FeedKV;
/* loaded from: classes5.dex */
public final class b87 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947598920, "Lcom/baidu/tieba/b87;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947598920, "Lcom/baidu/tieba/b87;");
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

        public final String b(i57 i57Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i57Var)) == null) {
                String str = i57Var.a().get("rich_text_type");
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

        public final k67 c(FeedContentResource content, i57 outerBusinessInfo, e67 logInfo, Map<String, ? extends w87> statStrategyMap) {
            InterceptResult invokeLLLL;
            String str;
            String str2;
            p57 p57Var;
            p57 p57Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, content, outerBusinessInfo, logInfo, statStrategyMap)) == null) {
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter(outerBusinessInfo, "outerBusinessInfo");
                Intrinsics.checkNotNullParameter(logInfo, "logInfo");
                Intrinsics.checkNotNullParameter(statStrategyMap, "statStrategyMap");
                m67 m67Var = null;
                n67 n67Var = new n67("", null, null);
                FeedContentText feedContentText = content.text_info;
                if (feedContentText != null) {
                    FeedContentColor feedContentColor = feedContentText.color;
                    if (feedContentColor != null) {
                        Integer num = feedContentColor.type;
                        Intrinsics.checkNotNullExpressionValue(num, "it.type");
                        p57Var = new p57(num.intValue(), feedContentColor.day, feedContentColor.night);
                    } else {
                        p57Var = null;
                    }
                    FeedContentColor feedContentColor2 = content.text_info.bg_color;
                    if (feedContentColor2 != null) {
                        Integer num2 = feedContentColor2.type;
                        Intrinsics.checkNotNullExpressionValue(num2, "it.type");
                        p57Var2 = new p57(num2.intValue(), feedContentColor2.day, feedContentColor2.night);
                    } else {
                        p57Var2 = null;
                    }
                    String str3 = content.text_info.text;
                    Intrinsics.checkNotNullExpressionValue(str3, "content.text_info.text");
                    n67Var = new n67(str3, p57Var, p57Var2);
                }
                n67 n67Var2 = n67Var;
                z57 z57Var = new z57(null, null, 0, 0, 15, null);
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
                    z57Var = new z57(str4, str5, intValue, num4.intValue());
                }
                z57 z57Var2 = z57Var;
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
                i57 i57Var = new i57();
                a87.a aVar = a87.a;
                List<FeedKV> list = content.business_info;
                Intrinsics.checkNotNullExpressionValue(list, "content.business_info");
                i57Var.b(aVar.a(list));
                i57 i57Var2 = new i57();
                i57Var2.a().putAll(i57Var.a());
                i57Var2.a().putAll(outerBusinessInfo.a());
                e67 e67Var = new e67();
                a87.a aVar2 = a87.a;
                List<FeedKV> list2 = content.log_info;
                Intrinsics.checkNotNullExpressionValue(list2, "content.log_info");
                e67Var.b(aVar2.a(list2));
                String b = b(i57Var2);
                if (Intrinsics.areEqual("rich_text_common_stat", b)) {
                    String str6 = e67Var.a().get("key");
                    if (str6 != null) {
                        m67Var = new m67(str6, new HashMap(), e67Var.a());
                    }
                } else {
                    w87 w87Var = statStrategyMap.get(b);
                    if (w87Var != null) {
                        m67Var = new m67(w87Var.getKey(), w87Var.a(i57Var2), logInfo.a());
                    }
                }
                Integer num5 = content.type;
                Intrinsics.checkNotNullExpressionValue(num5, "content.type");
                int intValue2 = num5.intValue();
                String str7 = content.schema;
                Intrinsics.checkNotNullExpressionValue(str7, "content.schema");
                return new k67(intValue2, n67Var2, z57Var2, str2, i57Var2, str7, m67Var);
            }
            return (k67) invokeLLLL.objValue;
        }
    }
}
