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
public class dad extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tiebaPlusInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "title", tiebaPlusInfo.title);
            ktc.a(jSONObject, "desc", tiebaPlusInfo.desc);
            ktc.a(jSONObject, BigdayActivityConfig.JUMP_URL, tiebaPlusInfo.jump_url);
            ktc.a(jSONObject, "download_url", tiebaPlusInfo.download_url);
            ktc.a(jSONObject, "app_id", tiebaPlusInfo.app_id);
            ktc.a(jSONObject, "app_icon", tiebaPlusInfo.app_icon);
            ktc.a(jSONObject, "app_package", tiebaPlusInfo.app_package);
            ktc.a(jSONObject, "app_version", tiebaPlusInfo.app_version);
            ktc.a(jSONObject, "app_privacy", tiebaPlusInfo.app_privacy);
            ktc.a(jSONObject, "app_power", tiebaPlusInfo.app_power);
            ktc.a(jSONObject, "app_company", tiebaPlusInfo.app_company);
            ktc.a(jSONObject, GameGuideConfigInfo.KEY_TARGET_TYPE, tiebaPlusInfo.target_type);
            ktc.a(jSONObject, "h5_jump_type", tiebaPlusInfo.h5_jump_type);
            ktc.a(jSONObject, "h5_jump_number", tiebaPlusInfo.h5_jump_number);
            ktc.a(jSONObject, "h5_jump_param", tiebaPlusInfo.h5_jump_param);
            ktc.a(jSONObject, "jump_type", tiebaPlusInfo.jump_type);
            ktc.a(jSONObject, "item_id", tiebaPlusInfo.item_id);
            ktc.a(jSONObject, "is_appoint", tiebaPlusInfo.is_appoint);
            PluginUser pluginUser = tiebaPlusInfo.plugin_user;
            if (pluginUser != null) {
                ktc.a(jSONObject, "plugin_user", l6d.b(pluginUser));
            }
            ktc.a(jSONObject, "forum_name", tiebaPlusInfo.forum_name);
            ktc.a(jSONObject, "jump_setting", tiebaPlusInfo.jump_setting);
            ktc.a(jSONObject, "wx_thumbnail", tiebaPlusInfo.wx_thumbnail);
            ktc.a(jSONObject, "button_desc", tiebaPlusInfo.button_desc);
            ktc.a(jSONObject, "app_effect", tiebaPlusInfo.app_effect);
            ktc.a(jSONObject, "plugin_id", tiebaPlusInfo.plugin_id);
            ktc.a(jSONObject, "token", tiebaPlusInfo.token);
            ktc.a(jSONObject, "extra_param", tiebaPlusInfo.extra_param);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
