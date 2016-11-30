package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ThCreateAllActivityConfig;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h {
    public static boolean GI() {
        return GJ() && TbadkCoreApplication.m9getInst().appResponseToIntentClass(ThCreateAllActivityConfig.class);
    }

    public static boolean GJ() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        PluginSetting findPluginSetting;
        if (1 == com.baidu.adp.lib.c.e.dN().ac("switch_togetherhi") && TbadkCoreApplication.m9getInst().isTogetherHiAvaliable() && Build.VERSION.SDK_INT >= 14 && GK() && (pluginConfig = PluginPackageManager.iB().getPluginConfig("com.baidu.tieba.pluginTogetherHi")) != null && !TextUtils.isEmpty(pluginConfig.display_name) && pluginConfig.forbidden != 1 && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.je().findPluginSetting("com.baidu.tieba.pluginTogetherHi")) != null) {
            return pluginConfig.newest == null || findPluginSetting.versionCode <= pluginConfig.newest.version_code;
        }
        return false;
    }

    public static void showGoPluginDetailDialog(TbPageContext<?> tbPageContext, String str, String str2) {
        Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.cF(str);
            if (TextUtils.isEmpty(str2)) {
                aVar.b(r.j.know, new i());
            } else {
                aVar.a(str2, new j(pageActivity, tbPageContext));
                aVar.b(r.j.cancel, new k());
            }
            aVar.b(tbPageContext).tq();
        }
    }

    public static boolean GK() {
        return PluginPackageManager.iB().bk("com.baidu.tieba.pluginTogetherHi");
    }

    public static boolean GL() {
        return PluginPackageManager.iB().bq("com.baidu.tieba.pluginTogetherHi");
    }

    public static boolean f(TbPageContext<?> tbPageContext) {
        if (GJ()) {
            return true;
        }
        if (GK() && GL()) {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(r.j.plugin_togetherhi_not_active), tbPageContext.getResources().getString(r.j.setup));
        } else if (PluginPackageManager.iB().getPluginConfig("com.baidu.tieba.pluginTogetherHi") != null && !GK()) {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(r.j.plugin_togetherhi_install_tips), tbPageContext.getResources().getString(r.j.plugin_go_install));
        } else {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(r.j.plugin_togetherhi_not_install), null);
        }
        return false;
    }
}
