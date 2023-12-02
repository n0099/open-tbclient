package com.baidu.tieba.im.dispatcher;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.module.imaibot.AibotArgs;
import com.baidu.tieba.oma;
import com.baidu.tieba.yl5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AiBotChatDispatcher implements oma {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AI_SINGLE_CAN_SLIDE_BACK = "canSlideBack";
    public static final String AI_SINGLE_CHAT_PAID = "paid";
    public static final String AI_SINGLE_CHAT_PIC_URL = "picUrl";
    public static final String AI_SINGLE_CHAT_ROBOT_TOPIC = "robotTopic";
    public static final String AI_SINGLE_CHAT_UK = "uk";
    public static final String AI_SINGLE_CHAT_USER_SUG = "userSug";
    public static final String AI_SINGLE_FORUM_ID = "fid";
    public static final String AI_SINGLE_FORUM_NAME = "fName";
    public static final String AI_SINGLE_FORUM_PORTRAIT = "fPortrait";
    public static final String AI_SINGLE_FROM = "pageSource";
    public static final String AI_SINGLE_H5_URL = "h5Url";
    public static final String AI_SINGLE_IS_ANIMATION = "isAnimation";
    public static final String AI_SINGLE_PAGE_STATE = "pageState";
    public static final String AI_SINGLE_REQUEST_CODE = "requestCode";
    public static final String AI_SINGLE_SHOW_BOT_LIST = "showBotList";
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

    @Override // com.baidu.tieba.oma
    public void dispatch(JSONObject jSONObject, Context context) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            int i = 1;
            if (!TbadkCoreApplication.isLogin()) {
                LoginActivityConfig loginActivityConfig = new LoginActivityConfig(context);
                loginActivityConfig.setJumpToAfterDestroy(1);
                TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
                return;
            }
            String optString = jSONObject.optString("paid");
            String optString2 = jSONObject.optString("uk");
            String optString3 = jSONObject.optString(AI_SINGLE_CHAT_ROBOT_TOPIC);
            String optString4 = jSONObject.optString(AI_SINGLE_CHAT_USER_SUG);
            String optString5 = jSONObject.optString(AI_SINGLE_CHAT_PIC_URL);
            String optString6 = jSONObject.optString(AI_SINGLE_H5_URL);
            String optString7 = jSONObject.optString(AI_SINGLE_IS_ANIMATION);
            String optString8 = jSONObject.optString(AI_SINGLE_THEME_COLOR);
            int optInt = jSONObject.optInt(AI_SINGLE_PAGE_STATE);
            int optInt2 = jSONObject.optInt(AI_SINGLE_REQUEST_CODE);
            int optInt3 = jSONObject.optInt(AI_SINGLE_FROM);
            long optLong = jSONObject.optLong("fid");
            String optString9 = jSONObject.optString(AI_SINGLE_FORUM_NAME);
            String optString10 = jSONObject.optString(AI_SINGLE_FORUM_PORTRAIT);
            if (jSONObject.optInt(AI_SINGLE_SHOW_BOT_LIST) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (jSONObject.optInt(AI_SINGLE_CAN_SLIDE_BACK, 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (optInt != 1) {
                i = 2;
            }
            yl5.a().a(context, optString, optString2, new AibotArgs(optString3, optString4, optString5, optString6, optString8, i, optString7, optInt2, Integer.valueOf(optInt3), Long.valueOf(optLong), optString9, optString10, z, z2));
        }
    }
}
