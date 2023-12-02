package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AiChatBotInfo;
/* loaded from: classes5.dex */
public class cuc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AiChatBotInfo aiChatBotInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aiChatBotInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "uk", aiChatBotInfo.uk);
            ktc.a(jSONObject, "pa", aiChatBotInfo.pa);
            ktc.a(jSONObject, "name", aiChatBotInfo.name);
            ktc.a(jSONObject, "portrait", aiChatBotInfo.portrait);
            ktc.a(jSONObject, "background_url", aiChatBotInfo.background_url);
            ktc.a(jSONObject, "prologue", aiChatBotInfo.prologue);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
