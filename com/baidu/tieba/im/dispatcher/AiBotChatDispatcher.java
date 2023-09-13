package com.baidu.tieba.im.dispatcher;

import android.content.Context;
import com.baidu.tieba.lp5;
import com.baidu.tieba.mp5;
import com.baidu.tieba.s7a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AiBotChatDispatcher implements s7a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AI_SINGLE_CHAT_PAID = "paid";
    public static final String AI_SINGLE_CHAT_PIC_URL = "picUrl";
    public static final String AI_SINGLE_CHAT_ROBOT_TOPIC = "robotTopic";
    public static final String AI_SINGLE_CHAT_UK = "uk";
    public static final String AI_SINGLE_CHAT_USER_SUG = "userSug";
    public static final String AI_SINGLE_H5_URL = "h5Url";
    public static final String AI_SINGLE_IS_ANIMATION = "isAnimation";
    public static final String AI_SINGLE_PAGE_STATE = "pageState";
    public static final String AI_SINGLE_THEME_COLOR = "themeColor";
    public transient /* synthetic */ FieldHolder $fh;

    public AiBotChatDispatcher() {
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

    @Override // com.baidu.tieba.s7a
    public void dispatch(JSONObject jSONObject, Context context) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            String optString = jSONObject.optString("paid");
            String optString2 = jSONObject.optString("uk");
            String optString3 = jSONObject.optString(AI_SINGLE_CHAT_ROBOT_TOPIC);
            String optString4 = jSONObject.optString(AI_SINGLE_CHAT_USER_SUG);
            String optString5 = jSONObject.optString(AI_SINGLE_CHAT_PIC_URL);
            String optString6 = jSONObject.optString(AI_SINGLE_H5_URL);
            String optString7 = jSONObject.optString(AI_SINGLE_IS_ANIMATION);
            String optString8 = jSONObject.optString(AI_SINGLE_THEME_COLOR);
            int optInt = jSONObject.optInt(AI_SINGLE_PAGE_STATE);
            mp5 a = lp5.a();
            if (optInt == 1) {
                i = 1;
            } else {
                i = 2;
            }
            a.a(context, optString, optString2, optString3, optString4, optString5, optString6, optString7, optString8, i);
        }
    }
}
