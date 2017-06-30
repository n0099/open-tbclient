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
import com.baidu.tieba.w;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class a {
    private static final Pattern aJl = Pattern.compile("#.+?#", 2);

    public static boolean ca(boolean z) {
        boolean appResponseToIntentClass;
        if (PluginPackageManager.jw().bd("com.baidu.tieba.pluginHotTopic")) {
            if (z) {
                appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            } else {
                appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(HotSelectActivityConfig.class);
            }
            return appResponseToIntentClass;
        }
        return false;
    }

    public static boolean Go() {
        return PluginPackageManager.jw().bj("com.baidu.tieba.pluginHotTopic");
    }

    public static boolean a(TbPageContext<?> tbPageContext, boolean z, boolean z2) {
        if (PluginPackageManager.jw().getPluginConfig("com.baidu.tieba.pluginHotTopic") == null) {
            String string = tbPageContext.getResources().getString(w.l.plugin_hottopic_not_install);
            if (z) {
                showGoPluginDetailDialog(tbPageContext, string, null);
                return true;
            }
            return true;
        } else if (!ca(z2)) {
            String string2 = tbPageContext.getResources().getString(w.l.plugin_hottopic_install_tips);
            String string3 = tbPageContext.getResources().getString(w.l.plugin_go_install);
            if (z) {
                showGoPluginDetailDialog(tbPageContext, string2, string3);
                return true;
            }
            return true;
        } else if (Go()) {
            String string4 = tbPageContext.getResources().getString(w.l.plugin_hottopic_not_active);
            String string5 = tbPageContext.getResources().getString(w.l.setup);
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
            aVar.cI(str);
            if (TextUtils.isEmpty(str2)) {
                aVar.b(w.l.know, new b());
            } else {
                aVar.a(str2, new c(pageActivity, tbPageContext));
                aVar.b(w.l.cancel, new d());
            }
            aVar.b(tbPageContext).ta();
        }
    }

    public static SpannableString gs(String str) {
        if (StringUtils.isNull(str)) {
            return new SpannableString("");
        }
        Matcher matcher = aJl.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            spannableString.setSpan(new e(18, ""), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }
}
