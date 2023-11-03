package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PluginUser;
/* loaded from: classes6.dex */
public class i1d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PluginUser pluginUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pluginUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "user_id", pluginUser.user_id);
            poc.a(jSONObject, "user_name_show", pluginUser.user_name_show);
            poc.a(jSONObject, "user_type", pluginUser.user_type);
            poc.a(jSONObject, "user_photo", pluginUser.user_photo);
            poc.a(jSONObject, "is_download_card_whiteuser", pluginUser.is_download_card_whiteuser);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
