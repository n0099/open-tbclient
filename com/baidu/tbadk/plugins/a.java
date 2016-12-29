package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.text.SpannableString;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tieba.r;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class a {
    private static final Pattern aDF = Pattern.compile("#.+?#", 2);

    public static boolean bZ(boolean z) {
        boolean appResponseToIntentClass;
        if (PluginPackageManager.iB().bk("com.baidu.tieba.pluginHotTopic")) {
            if (z) {
                appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            } else {
                appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(HotSelectActivityConfig.class);
            }
            return appResponseToIntentClass;
        }
        return false;
    }

    public static boolean Gh() {
        return PluginPackageManager.iB().bq("com.baidu.tieba.pluginHotTopic");
    }

    public static boolean a(TbPageContext<?> tbPageContext, boolean z, boolean z2) {
        if (PluginPackageManager.iB().getPluginConfig("com.baidu.tieba.pluginHotTopic") == null) {
            String string = tbPageContext.getResources().getString(r.j.plugin_hottopic_not_install);
            if (z) {
                showGoPluginDetailDialog(tbPageContext, string, null);
                return true;
            }
            return true;
        } else if (!bZ(z2)) {
            String string2 = tbPageContext.getResources().getString(r.j.plugin_hottopic_install_tips);
            String string3 = tbPageContext.getResources().getString(r.j.plugin_go_install);
            if (z) {
                showGoPluginDetailDialog(tbPageContext, string2, string3);
                return true;
            }
            return true;
        } else if (Gh()) {
            String string4 = tbPageContext.getResources().getString(r.j.plugin_hottopic_not_active);
            String string5 = tbPageContext.getResources().getString(r.j.setup);
            if (z) {
                showGoPluginDetailDialog(tbPageContext, string4, string5);
                return true;
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean g(TbPageContext<?> tbPageContext) {
        return a(tbPageContext, true, true);
    }

    public static void showGoPluginDetailDialog(TbPageContext<?> tbPageContext, String str, String str2) {
        Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.cG(str);
            if (TextUtils.isEmpty(str2)) {
                aVar.b(r.j.know, new b());
            } else {
                aVar.a(str2, new c(pageActivity, tbPageContext));
                aVar.b(r.j.cancel, new d());
            }
            aVar.b(tbPageContext).tb();
        }
    }

    public static SpannableString gj(String str) {
        if (StringUtils.isNull(str)) {
            return new SpannableString("");
        }
        Matcher matcher = aDF.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            spannableString.setSpan(new e(18, ""), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }
}
