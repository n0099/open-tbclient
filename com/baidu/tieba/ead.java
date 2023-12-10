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
public class ead extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tiebaPlusInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "title", tiebaPlusInfo.title);
            ltc.a(jSONObject, "desc", tiebaPlusInfo.desc);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, tiebaPlusInfo.jump_url);
            ltc.a(jSONObject, "download_url", tiebaPlusInfo.download_url);
            ltc.a(jSONObject, "app_id", tiebaPlusInfo.app_id);
            ltc.a(jSONObject, "app_icon", tiebaPlusInfo.app_icon);
            ltc.a(jSONObject, "app_package", tiebaPlusInfo.app_package);
            ltc.a(jSONObject, "app_version", tiebaPlusInfo.app_version);
            ltc.a(jSONObject, "app_privacy", tiebaPlusInfo.app_privacy);
            ltc.a(jSONObject, "app_power", tiebaPlusInfo.app_power);
            ltc.a(jSONObject, "app_company", tiebaPlusInfo.app_company);
            ltc.a(jSONObject, GameGuideConfigInfo.KEY_TARGET_TYPE, tiebaPlusInfo.target_type);
            ltc.a(jSONObject, "h5_jump_type", tiebaPlusInfo.h5_jump_type);
            ltc.a(jSONObject, "h5_jump_number", tiebaPlusInfo.h5_jump_number);
            ltc.a(jSONObject, "h5_jump_param", tiebaPlusInfo.h5_jump_param);
            ltc.a(jSONObject, "jump_type", tiebaPlusInfo.jump_type);
            ltc.a(jSONObject, "item_id", tiebaPlusInfo.item_id);
            ltc.a(jSONObject, "is_appoint", tiebaPlusInfo.is_appoint);
            PluginUser pluginUser = tiebaPlusInfo.plugin_user;
            if (pluginUser != null) {
                ltc.a(jSONObject, "plugin_user", m6d.b(pluginUser));
            }
            ltc.a(jSONObject, "forum_name", tiebaPlusInfo.forum_name);
            ltc.a(jSONObject, "jump_setting", tiebaPlusInfo.jump_setting);
            ltc.a(jSONObject, "wx_thumbnail", tiebaPlusInfo.wx_thumbnail);
            ltc.a(jSONObject, "button_desc", tiebaPlusInfo.button_desc);
            ltc.a(jSONObject, "app_effect", tiebaPlusInfo.app_effect);
            ltc.a(jSONObject, "plugin_id", tiebaPlusInfo.plugin_id);
            ltc.a(jSONObject, "token", tiebaPlusInfo.token);
            ltc.a(jSONObject, "extra_param", tiebaPlusInfo.extra_param);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
