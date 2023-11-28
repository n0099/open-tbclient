package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AiChatBotInfo;
/* loaded from: classes5.dex */
public class duc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AiChatBotInfo aiChatBotInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aiChatBotInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "uk", aiChatBotInfo.uk);
            ltc.a(jSONObject, "pa", aiChatBotInfo.pa);
            ltc.a(jSONObject, "name", aiChatBotInfo.name);
            ltc.a(jSONObject, "portrait", aiChatBotInfo.portrait);
            ltc.a(jSONObject, "background_url", aiChatBotInfo.background_url);
            ltc.a(jSONObject, "prologue", aiChatBotInfo.prologue);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
