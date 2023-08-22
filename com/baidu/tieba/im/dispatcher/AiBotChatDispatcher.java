package com.baidu.tieba.im.dispatcher;

import android.content.Context;
import com.baidu.tieba.so5;
import com.baidu.tieba.y5a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AiBotChatDispatcher implements y5a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AI_SINGLE_CHAT_PAID = "paid";
    public static final String AI_SINGLE_CHAT_PIC_URL = "picUrl";
    public static final String AI_SINGLE_CHAT_ROBOT_TOPIC = "robotTopic";
    public static final String AI_SINGLE_CHAT_UK = "uk";
    public static final String AI_SINGLE_CHAT_USER_SUG = "userSug";
    public static final String AI_SINGLE_H5_URL = "h5Url";
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

    @Override // com.baidu.tieba.y5a
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            so5.a().a(context, jSONObject.optString("paid"), jSONObject.optString("uk"), jSONObject.optString(AI_SINGLE_CHAT_ROBOT_TOPIC), jSONObject.optString(AI_SINGLE_CHAT_USER_SUG), jSONObject.optString(AI_SINGLE_CHAT_PIC_URL), jSONObject.optString(AI_SINGLE_H5_URL));
        }
    }
}
