package com.baidu.tbadk.game;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.b.f;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.GameWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.plugins.LightAppPlugin;
/* loaded from: classes.dex */
public class a extends u {
    public static void c(Context context, String str, String str2, String str3) {
        LightAppPlugin lightAppPlugin;
        b.vv().ah(str3, str2);
        if (f.dc().Z("t5core") == 0 && (lightAppPlugin = (LightAppPlugin) PluginCenter.gX().he()) != null) {
            lightAppPlugin.launchLightApp(context, TbConfig.api_key, TbWebViewActivityConfig.addTiebaParams(str2));
            return;
        }
        e.vy().s(str3, 2);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameWebViewActivityConfig(context, str, str2, str3, true)));
    }
}
