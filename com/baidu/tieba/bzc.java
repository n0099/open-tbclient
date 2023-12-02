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
public class bzc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AiChatroomGuide aiChatroomGuide) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aiChatroomGuide)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "guide_text", aiChatroomGuide.guide_text);
            ktc.a(jSONObject, "new_bot_guide_text", aiChatroomGuide.new_bot_guide_text);
            AiChatBotInfo aiChatBotInfo = aiChatroomGuide.new_bot_info;
            if (aiChatBotInfo != null) {
                ktc.a(jSONObject, "new_bot_info", cuc.b(aiChatBotInfo));
            }
            ktc.a(jSONObject, "title_img", aiChatroomGuide.title_img);
            ktc.a(jSONObject, "button_url", aiChatroomGuide.button_url);
            ktc.a(jSONObject, "bg_top_animation_url", aiChatroomGuide.bg_top_animation_url);
            if (aiChatroomGuide.bot_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (AiChatBotInfo aiChatBotInfo2 : aiChatroomGuide.bot_list) {
                    jSONArray.put(cuc.b(aiChatBotInfo2));
                }
                ktc.a(jSONObject, "bot_list", jSONArray);
            }
            ktc.a(jSONObject, "h5_url", aiChatroomGuide.h5_url);
            AiChatBotInfo aiChatBotInfo3 = aiChatroomGuide.default_bot_info;
            if (aiChatBotInfo3 != null) {
                ktc.a(jSONObject, "default_bot_info", cuc.b(aiChatBotInfo3));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
