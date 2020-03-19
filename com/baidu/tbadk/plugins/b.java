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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class b {
    public static String dGc = "#";
    public static String dGd = "＃";
    private static final Pattern cIb = Pattern.compile("#([^#(]+)#", 2);

    public static boolean vJ(String str) {
        return dGc.equals(str);
    }

    public static boolean gY(boolean z) {
        boolean appResponseToIntentClass;
        if (PluginPackageManager.js().ba("com.baidu.tieba.pluginHotTopic")) {
            if (z) {
                appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            } else {
                appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotSelectActivityConfig.class);
            }
            return appResponseToIntentClass;
        }
        return false;
    }

    public static boolean aRI() {
        return PluginPackageManager.js().bg("com.baidu.tieba.pluginHotTopic");
    }

    public static boolean a(TbPageContext<?> tbPageContext, boolean z, boolean z2) {
        if (PluginPackageManager.js().getPluginConfig("com.baidu.tieba.pluginHotTopic") == null) {
            String string = tbPageContext.getResources().getString(R.string.plugin_hottopic_not_install);
            if (z) {
                showGoPluginDetailDialog(tbPageContext, string, null);
                return true;
            }
            return true;
        } else if (!gY(z2)) {
            String string2 = tbPageContext.getResources().getString(R.string.plugin_hottopic_install_tips);
            String string3 = tbPageContext.getResources().getString(R.string.plugin_go_install);
            if (z) {
                showGoPluginDetailDialog(tbPageContext, string2, string3);
                return true;
            }
            return true;
        } else if (aRI()) {
            String string4 = tbPageContext.getResources().getString(R.string.plugin_hottopic_not_active);
            String string5 = tbPageContext.getResources().getString(R.string.setup);
            if (z) {
                showGoPluginDetailDialog(tbPageContext, string4, string5);
                return true;
            }
            return true;
        } else {
            return false;
        }
    }

    public static boolean h(TbPageContext<?> tbPageContext) {
        return a(tbPageContext, true, true);
    }

    public static void showGoPluginDetailDialog(final TbPageContext<?> tbPageContext, String str, String str2) {
        final Activity pageActivity;
        if (tbPageContext != null && (pageActivity = tbPageContext.getPageActivity()) != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
            aVar.sS(str);
            if (TextUtils.isEmpty(str2)) {
                aVar.b(R.string.know, new a.b() { // from class: com.baidu.tbadk.plugins.b.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
            } else {
                aVar.a(str2, new a.b() { // from class: com.baidu.tbadk.plugins.b.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(pageActivity, "com.baidu.tieba.pluginHotTopic")));
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tbadk.plugins.b.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
            }
            aVar.b(tbPageContext).aEG();
        }
    }

    public static SpannableString vK(String str) {
        if (StringUtils.isNull(str)) {
            return new SpannableString("");
        }
        Matcher matcher = cIb.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!vM(str.substring(start, end))) {
                spannableString.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), start, end, 18);
            }
        }
        return spannableString;
    }

    public static void a(Spannable spannable) {
        ImageSpan[] imageSpanArr;
        if (spannable != null) {
            String obj = spannable.toString();
            if (!StringUtils.isNull(obj)) {
                Matcher matcher = cIb.matcher(obj);
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    if (!vM(obj.substring(start, end)) && ((imageSpanArr = (ImageSpan[]) spannable.getSpans(start, end, ImageSpan.class)) == null || imageSpanArr.length <= 0)) {
                        spannable.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), start, end, 18);
                    }
                }
            }
        }
    }

    public static String vL(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.charAt(0) != '#' || str.charAt(str.length() - 1) != '#') {
            StringBuilder sb = new StringBuilder(str.length() + 2);
            sb.append(dGc).append(str).append(dGc);
            return sb.toString();
        }
        return str;
    }

    public static boolean vM(String str) {
        String substring;
        return str != null && str.startsWith(dGc) && str.endsWith(dGc) && (substring = str.substring(1, str.length() + (-1))) != null && "".equals(substring.trim());
    }

    public static void a(l lVar) {
        String str = "";
        switch (lVar.type) {
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
        TiebaStatic.log(new an(TbadkCoreStatisticKey.HOT_TOPIC_CLICK).cx("obj_locate", str));
    }

    public static String vN(String str) {
        StringBuffer stringBuffer = new StringBuffer("http://tieba.baidu.com/n/video/opersquare?tab=hot&topic_name=");
        int length = str.length();
        String str2 = null;
        if (length > 2 && str.charAt(0) == '#' && str.charAt(length - 1) == '#') {
            str2 = str.substring(1, length - 1);
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }
}
