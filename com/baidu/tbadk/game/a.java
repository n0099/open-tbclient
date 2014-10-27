package com.baidu.tbadk.game;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.b.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.GameWebViewActivityConfig;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.LightAppPlugin;
/* loaded from: classes.dex */
public class a {
    public static int dl(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("game:detail")) {
                return 1;
            }
            if (str.startsWith("http")) {
                return 2;
            }
        }
        return 0;
    }

    public static String dm(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(":")) == null) {
            return null;
        }
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2) && str2.contains("TBCGameID=")) {
                int indexOf = str2.indexOf("=");
                return indexOf + 1 < str2.length() ? str2.substring(indexOf + 1, str2.length()) : null;
            }
        }
        return null;
    }

    public static void a(Context context, String str, String str2, String str3) {
        Plugin pluginByName;
        LightAppPlugin lightAppPlugin;
        b.rS().W(str3, str2);
        if (f.db().U("t5core") == 0 && (pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_LIGHT_APP)) != null && (lightAppPlugin = (LightAppPlugin) pluginByName.getClassInstance(LightAppPlugin.class)) != null) {
            lightAppPlugin.launchLightApp(context, TbConfig.api_key, str2);
            return;
        }
        d.rV().q(str3, 2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameWebViewActivityConfig(context, str, str2, str3, true)));
    }
}
