package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class b {
    public static String bin = "#";
    public static String bio = "＃";
    private static final Pattern akP = Pattern.compile("#([^#(]+)#", 2);

    public static boolean iG(String str) {
        return bin.equals(str);
    }

    public static boolean cS(boolean z) {
        boolean appResponseToIntentClass;
        if (PluginPackageManager.nd().bT("com.baidu.tieba.pluginHotTopic")) {
            if (z) {
                appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            } else {
                appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotSelectActivityConfig.class);
            }
            return appResponseToIntentClass;
        }
        return false;
    }

    public static boolean PR() {
        return PluginPackageManager.nd().bZ("com.baidu.tieba.pluginHotTopic");
    }

    public static boolean a(TbPageContext<?> tbPageContext, boolean z, boolean z2) {
        if (!cS(z2)) {
            tbPageContext.getResources().getString(e.j.plugin_hottopic_install_tips);
            tbPageContext.getResources().getString(e.j.plugin_go_install);
            return true;
        } else if (PR()) {
            tbPageContext.getResources().getString(e.j.plugin_hottopic_not_active);
            tbPageContext.getResources().getString(e.j.setup);
            return true;
        } else {
            return false;
        }
    }

    public static boolean e(TbPageContext<?> tbPageContext) {
        return a(tbPageContext, true, true);
    }

    public static void showGoPluginDetailDialog(final TbPageContext<?> tbPageContext, String str, String str2) {
        final Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.eK(str);
            if (TextUtils.isEmpty(str2)) {
                aVar.b(e.j.know, new a.b() { // from class: com.baidu.tbadk.plugins.b.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
            } else {
                aVar.a(str2, new a.b() { // from class: com.baidu.tbadk.plugins.b.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        tbPageContext.sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(pageActivity, "com.baidu.tieba.pluginHotTopic")));
                        aVar2.dismiss();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tbadk.plugins.b.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
            }
            aVar.b(tbPageContext).BS();
        }
    }

    public static SpannableString iH(String str) {
        if (StringUtils.isNull(str)) {
            return new SpannableString("");
        }
        Matcher matcher = akP.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!iJ(str.substring(start, end))) {
                spannableString.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), start, end, 18);
            }
        }
        return spannableString;
    }

    public static void a(Spannable spannable) {
        ImageSpan[] imageSpanArr;
        if (spannable != null) {
            String obj = spannable.toString();
            if (!StringUtils.isNull(obj)) {
                Matcher matcher = akP.matcher(obj);
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    if (!iJ(obj.substring(start, end)) && ((imageSpanArr = (ImageSpan[]) spannable.getSpans(start, end, ImageSpan.class)) == null || imageSpanArr.length <= 0)) {
                        spannable.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), start, end, 18);
                    }
                }
            }
        }
    }

    public static String iI(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.charAt(0) != '#' || str.charAt(str.length() - 1) != '#') {
            StringBuilder sb = new StringBuilder(str.length() + 2);
            sb.append(bin).append(str).append(bin);
            return sb.toString();
        }
        return str;
    }

    public static boolean iJ(String str) {
        String substring;
        return str != null && str.startsWith(bin) && str.endsWith(bin) && (substring = str.substring(1, str.length() + (-1))) != null && "".equals(substring.trim());
    }

    public static void a(k kVar) {
        String str = "";
        switch (kVar.type) {
            case 1:
                str = "index";
                break;
            case 2:
                str = "frs";
                break;
            case 3:
                str = "pb";
                break;
            case 4:
                str = "pb_bottom";
                break;
            case 5:
                str = "1";
                break;
        }
        TiebaStatic.log(new am("c11455").aB("obj_locate", str));
    }
}
