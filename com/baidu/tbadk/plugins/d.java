package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ThCreateAllActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d {
    public static boolean Fa() {
        return Fb() && TbadkCoreApplication.m11getInst().appResponseToIntentClass(ThCreateAllActivityConfig.class);
    }

    public static boolean Fb() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        PluginSetting findPluginSetting;
        if (1 == com.baidu.adp.lib.c.e.cS().Z("switch_togetherhi") && TbadkCoreApplication.m11getInst().isTogetherHiAvaliable() && Build.VERSION.SDK_INT >= 14 && Fc() && (pluginConfig = PluginPackageManager.hF().getPluginConfig("com.baidu.tieba.pluginTogetherHi")) != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().findPluginSetting("com.baidu.tieba.pluginTogetherHi")) != null) {
            return pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code;
        }
        return false;
    }

    public static void showGoPluginDetailDialog(TbPageContext<?> tbPageContext, String str, String str2) {
        Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.cA(str);
            if (TextUtils.isEmpty(str2)) {
                aVar.b(t.j.know, new e());
            } else {
                aVar.a(str2, new f(pageActivity, tbPageContext));
                aVar.b(t.j.cancel, new g());
            }
            aVar.b(tbPageContext).rU();
        }
    }

    public static boolean Fc() {
        return PluginPackageManager.hF().bi("com.baidu.tieba.pluginTogetherHi");
    }

    public static boolean Fd() {
        return PluginPackageManager.hF().bo("com.baidu.tieba.pluginTogetherHi");
    }

    public static void g(Context context, int i) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ThCreateAllActivityConfig(context, i)));
        }
    }

    public static boolean f(TbPageContext<?> tbPageContext) {
        if (Fb()) {
            return true;
        }
        if (Fc() && Fd()) {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(t.j.plugin_togetherhi_not_active), tbPageContext.getResources().getString(t.j.setup));
        } else if (PluginPackageManager.hF().getPluginConfig("com.baidu.tieba.pluginTogetherHi") != null && !Fc()) {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(t.j.plugin_togetherhi_install_tips), tbPageContext.getResources().getString(t.j.plugin_go_install));
        } else {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(t.j.plugin_togetherhi_not_install), null);
        }
        return false;
    }
}
