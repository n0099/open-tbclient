package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes5.dex */
public class a5d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tiebaPlusInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "title", tiebaPlusInfo.title);
            poc.a(jSONObject, "desc", tiebaPlusInfo.desc);
            poc.a(jSONObject, BigdayActivityConfig.JUMP_URL, tiebaPlusInfo.jump_url);
            poc.a(jSONObject, "download_url", tiebaPlusInfo.download_url);
            poc.a(jSONObject, "app_id", tiebaPlusInfo.app_id);
            poc.a(jSONObject, "app_icon", tiebaPlusInfo.app_icon);
            poc.a(jSONObject, "app_package", tiebaPlusInfo.app_package);
            poc.a(jSONObject, "app_version", tiebaPlusInfo.app_version);
            poc.a(jSONObject, "app_privacy", tiebaPlusInfo.app_privacy);
            poc.a(jSONObject, "app_power", tiebaPlusInfo.app_power);
            poc.a(jSONObject, "app_company", tiebaPlusInfo.app_company);
            poc.a(jSONObject, GameGuideConfigInfo.KEY_TARGET_TYPE, tiebaPlusInfo.target_type);
            poc.a(jSONObject, "h5_jump_type", tiebaPlusInfo.h5_jump_type);
            poc.a(jSONObject, "h5_jump_number", tiebaPlusInfo.h5_jump_number);
            poc.a(jSONObject, "h5_jump_param", tiebaPlusInfo.h5_jump_param);
            poc.a(jSONObject, "jump_type", tiebaPlusInfo.jump_type);
            poc.a(jSONObject, "item_id", tiebaPlusInfo.item_id);
            poc.a(jSONObject, "is_appoint", tiebaPlusInfo.is_appoint);
            PluginUser pluginUser = tiebaPlusInfo.plugin_user;
            if (pluginUser != null) {
                poc.a(jSONObject, "plugin_user", i1d.b(pluginUser));
            }
            poc.a(jSONObject, "forum_name", tiebaPlusInfo.forum_name);
            poc.a(jSONObject, "jump_setting", tiebaPlusInfo.jump_setting);
            poc.a(jSONObject, "wx_thumbnail", tiebaPlusInfo.wx_thumbnail);
            poc.a(jSONObject, "button_desc", tiebaPlusInfo.button_desc);
            poc.a(jSONObject, "app_effect", tiebaPlusInfo.app_effect);
            poc.a(jSONObject, "plugin_id", tiebaPlusInfo.plugin_id);
            poc.a(jSONObject, "token", tiebaPlusInfo.token);
            poc.a(jSONObject, "extra_param", tiebaPlusInfo.extra_param);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
