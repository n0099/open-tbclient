package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.widget.richText.b;
import com.baidu.tieba.d;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class a {
    private static final Pattern aKz = Pattern.compile("#.+?#", 2);

    public static boolean cb(boolean z) {
        boolean appResponseToIntentClass;
        if (PluginPackageManager.jv().bi("com.baidu.tieba.pluginHotTopic")) {
            if (z) {
                appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            } else {
                appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotSelectActivityConfig.class);
            }
            return appResponseToIntentClass;
        }
        return false;
    }

    public static boolean Gj() {
        return PluginPackageManager.jv().bo("com.baidu.tieba.pluginHotTopic");
    }

    public static boolean a(TbPageContext<?> tbPageContext, boolean z, boolean z2) {
        if (PluginPackageManager.jv().getPluginConfig("com.baidu.tieba.pluginHotTopic") == null) {
            String string = tbPageContext.getResources().getString(d.l.plugin_hottopic_not_install);
            if (z) {
                showGoPluginDetailDialog(tbPageContext, string, null);
                return true;
            }
            return true;
        } else if (!cb(z2)) {
            String string2 = tbPageContext.getResources().getString(d.l.plugin_hottopic_install_tips);
            String string3 = tbPageContext.getResources().getString(d.l.plugin_go_install);
            if (z) {
                showGoPluginDetailDialog(tbPageContext, string2, string3);
                return true;
            }
            return true;
        } else if (Gj()) {
            String string4 = tbPageContext.getResources().getString(d.l.plugin_hottopic_not_active);
            String string5 = tbPageContext.getResources().getString(d.l.setup);
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
        return a(tbPageContext, true, true);
    }

    public static void showGoPluginDetailDialog(final TbPageContext<?> tbPageContext, String str, String str2) {
        final Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.cL(str);
            if (TextUtils.isEmpty(str2)) {
                aVar.b(d.l.know, new a.b() { // from class: com.baidu.tbadk.plugins.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
            } else {
                aVar.a(str2, new a.b() { // from class: com.baidu.tbadk.plugins.a.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(pageActivity, "com.baidu.tieba.pluginHotTopic")));
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tbadk.plugins.a.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
            }
            aVar.b(tbPageContext).tb();
        }
    }

    public static SpannableString gy(String str) {
        if (StringUtils.isNull(str)) {
            return new SpannableString("");
        }
        Matcher matcher = aKz.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            spannableString.setSpan(new b(18, "") { // from class: com.baidu.tbadk.plugins.a.4
                @Override // com.baidu.tbadk.widget.richText.b, android.text.style.ClickableSpan
                public void onClick(View view) {
                }
            }, matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }
}
