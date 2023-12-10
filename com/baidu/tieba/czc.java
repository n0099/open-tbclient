package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AiChatBotInfo;
import tbclient.FrsPage.AiChatroomGuide;
/* loaded from: classes5.dex */
public class czc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AiChatroomGuide aiChatroomGuide) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aiChatroomGuide)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "guide_text", aiChatroomGuide.guide_text);
            ltc.a(jSONObject, "new_bot_guide_text", aiChatroomGuide.new_bot_guide_text);
            AiChatBotInfo aiChatBotInfo = aiChatroomGuide.new_bot_info;
            if (aiChatBotInfo != null) {
                ltc.a(jSONObject, "new_bot_info", duc.b(aiChatBotInfo));
            }
            ltc.a(jSONObject, "title_img", aiChatroomGuide.title_img);
            ltc.a(jSONObject, "button_url", aiChatroomGuide.button_url);
            ltc.a(jSONObject, "bg_top_animation_url", aiChatroomGuide.bg_top_animation_url);
            if (aiChatroomGuide.bot_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (AiChatBotInfo aiChatBotInfo2 : aiChatroomGuide.bot_list) {
                    jSONArray.put(duc.b(aiChatBotInfo2));
                }
                ltc.a(jSONObject, "bot_list", jSONArray);
            }
            ltc.a(jSONObject, "h5_url", aiChatroomGuide.h5_url);
            AiChatBotInfo aiChatBotInfo3 = aiChatroomGuide.default_bot_info;
            if (aiChatBotInfo3 != null) {
                ltc.a(jSONObject, "default_bot_info", duc.b(aiChatBotInfo3));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
