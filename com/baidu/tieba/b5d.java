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
public class b5d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tiebaPlusInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "title", tiebaPlusInfo.title);
            qoc.a(jSONObject, "desc", tiebaPlusInfo.desc);
            qoc.a(jSONObject, BigdayActivityConfig.JUMP_URL, tiebaPlusInfo.jump_url);
            qoc.a(jSONObject, "download_url", tiebaPlusInfo.download_url);
            qoc.a(jSONObject, "app_id", tiebaPlusInfo.app_id);
            qoc.a(jSONObject, "app_icon", tiebaPlusInfo.app_icon);
            qoc.a(jSONObject, "app_package", tiebaPlusInfo.app_package);
            qoc.a(jSONObject, "app_version", tiebaPlusInfo.app_version);
            qoc.a(jSONObject, "app_privacy", tiebaPlusInfo.app_privacy);
            qoc.a(jSONObject, "app_power", tiebaPlusInfo.app_power);
            qoc.a(jSONObject, "app_company", tiebaPlusInfo.app_company);
            qoc.a(jSONObject, GameGuideConfigInfo.KEY_TARGET_TYPE, tiebaPlusInfo.target_type);
            qoc.a(jSONObject, "h5_jump_type", tiebaPlusInfo.h5_jump_type);
            qoc.a(jSONObject, "h5_jump_number", tiebaPlusInfo.h5_jump_number);
            qoc.a(jSONObject, "h5_jump_param", tiebaPlusInfo.h5_jump_param);
            qoc.a(jSONObject, "jump_type", tiebaPlusInfo.jump_type);
            qoc.a(jSONObject, "item_id", tiebaPlusInfo.item_id);
            qoc.a(jSONObject, "is_appoint", tiebaPlusInfo.is_appoint);
            PluginUser pluginUser = tiebaPlusInfo.plugin_user;
            if (pluginUser != null) {
                qoc.a(jSONObject, "plugin_user", j1d.b(pluginUser));
            }
            qoc.a(jSONObject, "forum_name", tiebaPlusInfo.forum_name);
            qoc.a(jSONObject, "jump_setting", tiebaPlusInfo.jump_setting);
            qoc.a(jSONObject, "wx_thumbnail", tiebaPlusInfo.wx_thumbnail);
            qoc.a(jSONObject, "button_desc", tiebaPlusInfo.button_desc);
            qoc.a(jSONObject, "app_effect", tiebaPlusInfo.app_effect);
            qoc.a(jSONObject, "plugin_id", tiebaPlusInfo.plugin_id);
            qoc.a(jSONObject, "token", tiebaPlusInfo.token);
            qoc.a(jSONObject, "extra_param", tiebaPlusInfo.extra_param);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
