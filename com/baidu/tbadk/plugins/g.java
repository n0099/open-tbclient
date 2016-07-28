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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class g {
    public static boolean Fk() {
        return Fl() && TbadkCoreApplication.m10getInst().appResponseToIntentClass(ThCreateAllActivityConfig.class);
    }

    public static boolean Fl() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        PluginSetting findPluginSetting;
        if (1 == com.baidu.adp.lib.c.e.cS().ab("switch_togetherhi") && TbadkCoreApplication.m10getInst().isTogetherHiAvaliable() && Build.VERSION.SDK_INT >= 14 && Fm() && (pluginConfig = PluginPackageManager.hG().getPluginConfig("com.baidu.tieba.pluginTogetherHi")) != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.ij().findPluginSetting("com.baidu.tieba.pluginTogetherHi")) != null) {
            return pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code;
        }
        return false;
    }

    public static void showGoPluginDetailDialog(TbPageContext<?> tbPageContext, String str, String str2) {
        Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.cz(str);
            if (TextUtils.isEmpty(str2)) {
                aVar.b(u.j.know, new h());
            } else {
                aVar.a(str2, new i(pageActivity, tbPageContext));
                aVar.b(u.j.cancel, new j());
            }
            aVar.b(tbPageContext).rS();
        }
    }

    public static boolean Fm() {
        return PluginPackageManager.hG().bj("com.baidu.tieba.pluginTogetherHi");
    }

    public static boolean Fn() {
        return PluginPackageManager.hG().bp("com.baidu.tieba.pluginTogetherHi");
    }

    public static void g(Context context, int i) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ThCreateAllActivityConfig(context, i)));
        }
    }

    public static boolean f(TbPageContext<?> tbPageContext) {
        if (Fl()) {
            return true;
        }
        if (Fm() && Fn()) {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(u.j.plugin_togetherhi_not_active), tbPageContext.getResources().getString(u.j.setup));
        } else if (PluginPackageManager.hG().getPluginConfig("com.baidu.tieba.pluginTogetherHi") != null && !Fm()) {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(u.j.plugin_togetherhi_install_tips), tbPageContext.getResources().getString(u.j.plugin_go_install));
        } else {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(u.j.plugin_togetherhi_not_install), null);
        }
        return false;
    }
}
