package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a {
    public static boolean Fi() {
        return PluginPackageManager.hG().bj("com.baidu.tieba.pluginHotTopic") && TbadkCoreApplication.m10getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
    }

    public static boolean Fj() {
        return PluginPackageManager.hG().bp("com.baidu.tieba.pluginHotTopic");
    }

    public static boolean f(TbPageContext<?> tbPageContext) {
        if (PluginPackageManager.hG().getPluginConfig("com.baidu.tieba.pluginHotTopic") == null) {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(u.j.plugin_hottopic_not_install), null);
            return true;
        } else if (!Fi()) {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(u.j.plugin_hottopic_install_tips), tbPageContext.getResources().getString(u.j.plugin_go_install));
            return true;
        } else if (Fj()) {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(u.j.plugin_hottopic_not_active), tbPageContext.getResources().getString(u.j.setup));
            return true;
        } else {
            return false;
        }
    }

    public static void showGoPluginDetailDialog(TbPageContext<?> tbPageContext, String str, String str2) {
        Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.cz(str);
            if (TextUtils.isEmpty(str2)) {
                aVar.b(u.j.know, new b());
            } else {
                aVar.a(str2, new c(pageActivity, tbPageContext));
                aVar.b(u.j.cancel, new d());
            }
            aVar.b(tbPageContext).rS();
        }
    }
}
