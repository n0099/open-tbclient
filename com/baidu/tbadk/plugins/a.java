package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    public static boolean Fa() {
        return PluginPackageManager.hF().bi("com.baidu.tieba.pluginHotTopic") && TbadkCoreApplication.m11getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
    }

    public static boolean Fb() {
        return PluginPackageManager.hF().bo("com.baidu.tieba.pluginHotTopic");
    }

    public static boolean f(TbPageContext<?> tbPageContext) {
        if (PluginPackageManager.hF().getPluginConfig("com.baidu.tieba.pluginHotTopic") == null) {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(t.j.plugin_hottopic_not_install), null);
            return true;
        } else if (!Fa()) {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(t.j.plugin_hottopic_install_tips), tbPageContext.getResources().getString(t.j.plugin_go_install));
            return true;
        } else if (Fb()) {
            showGoPluginDetailDialog(tbPageContext, tbPageContext.getResources().getString(t.j.plugin_hottopic_not_active), tbPageContext.getResources().getString(t.j.setup));
            return true;
        } else {
            return false;
        }
    }

    public static void showGoPluginDetailDialog(TbPageContext<?> tbPageContext, String str, String str2) {
        Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.cA(str);
            if (TextUtils.isEmpty(str2)) {
                aVar.b(t.j.know, new b());
            } else {
                aVar.a(str2, new c(pageActivity, tbPageContext));
                aVar.b(t.j.cancel, new d());
            }
            aVar.b(tbPageContext).rV();
        }
    }
}
