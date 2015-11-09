package com.baidu.tbadk.game;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.GameWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.plugins.LightAppPlugin;
/* loaded from: classes.dex */
public class a extends o {
    public static void c(Context context, String str, String str2, String str3) {
        LightAppPlugin lightAppPlugin;
        b.BJ().al(str3, str2);
        if (com.baidu.adp.lib.b.e.gv().af("t5core") == 0 && (lightAppPlugin = (LightAppPlugin) PluginCenter.getInstance().getLightAppClassInstance()) != null) {
            lightAppPlugin.launchLightApp(context, TbConfig.api_key, TbWebViewActivityConfig.addTiebaParams(str2));
            return;
        }
        e.BM().u(str3, 2);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameWebViewActivityConfig(context, str, str2, str3, true)));
    }
}
