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
    public static boolean GC() {
        return PluginPackageManager.iB().bk("com.baidu.tieba.pluginHotTopic") && TbadkCoreApplication.m9getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
    }

    public static boolean GD() {
        return PluginPackageManager.iB().bq("com.baidu.tieba.pluginHotTopic");
    }

    public static boolean a(TbPageContext<?> tbPageContext, boolean z) {
        if (PluginPackageManager.iB().getPluginConfig("com.baidu.tieba.pluginHotTopic") == null) {
            String string = tbPageContext.getResources().getString(t.j.plugin_hottopic_not_install);
            if (z) {
                showGoPluginDetailDialog(tbPageContext, string, null);
                return true;
            }
            return true;
        } else if (!GC()) {
            String string2 = tbPageContext.getResources().getString(t.j.plugin_hottopic_install_tips);
            String string3 = tbPageContext.getResources().getString(t.j.plugin_go_install);
            if (z) {
                showGoPluginDetailDialog(tbPageContext, string2, string3);
                return true;
            }
            return true;
        } else if (GD()) {
            String string4 = tbPageContext.getResources().getString(t.j.plugin_hottopic_not_active);
            String string5 = tbPageContext.getResources().getString(t.j.setup);
            if (z) {
                showGoPluginDetailDialog(tbPageContext, string4, string5);
                return true;
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean f(TbPageContext<?> tbPageContext) {
        return a(tbPageContext, true);
    }

    public static void showGoPluginDetailDialog(TbPageContext<?> tbPageContext, String str, String str2) {
        Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.cB(str);
            if (TextUtils.isEmpty(str2)) {
                aVar.b(t.j.know, new b());
            } else {
                aVar.a(str2, new c(pageActivity, tbPageContext));
                aVar.b(t.j.cancel, new d());
            }
            aVar.b(tbPageContext).sX();
        }
    }
}
