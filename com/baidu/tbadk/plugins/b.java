package com.baidu.tbadk.plugins;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class b {
    public static String eTO = "#";
    public static String eTP = "＃";
    private static final Pattern dOJ = Pattern.compile("#([^#(]+)#", 2);

    public static boolean Cx(String str) {
        return eTO.equals(str);
    }

    public static boolean jE(boolean z) {
        boolean appResponseToIntentClass;
        if (PluginPackageManager.pO().cu("com.baidu.tieba.pluginHotTopic")) {
            if (z) {
                appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            } else {
                appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotSelectActivityConfig.class);
            }
            return appResponseToIntentClass;
        }
        return false;
    }

    public static boolean buF() {
        return PluginPackageManager.pO().cA("com.baidu.tieba.pluginHotTopic");
    }

    public static boolean a(TbPageContext<?> tbPageContext, boolean z, boolean z2) {
        return false;
    }

    public static boolean k(TbPageContext<?> tbPageContext) {
        return a(tbPageContext, true, true);
    }

    public static SpannableString Cy(String str) {
        if (StringUtils.isNull(str)) {
            return new SpannableString("");
        }
        Matcher matcher = dOJ.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!CA(str.substring(start, end))) {
                spannableString.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), start, end, 18);
            }
        }
        return spannableString;
    }

    public static void a(Spannable spannable) {
        ImageSpan[] imageSpanArr;
        if (spannable != null) {
            String obj = spannable.toString();
            if (!StringUtils.isNull(obj)) {
                Matcher matcher = dOJ.matcher(obj);
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    if (!CA(obj.substring(start, end)) && ((imageSpanArr = (ImageSpan[]) spannable.getSpans(start, end, ImageSpan.class)) == null || imageSpanArr.length <= 0)) {
                        spannable.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), start, end, 18);
                    }
                }
            }
        }
    }

    public static String Cz(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.charAt(0) != '#' || str.charAt(str.length() - 1) != '#') {
            StringBuilder sb = new StringBuilder(str.length() + 2);
            sb.append(eTO).append(str).append(eTO);
            return sb.toString();
        }
        return str;
    }

    public static boolean CA(String str) {
        return str != null && str.startsWith(eTO) && str.endsWith(eTO) && "".equals(str.substring(1, str.length() + (-1)).trim());
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
        TiebaStatic.log(new aq(TbadkCoreStatisticKey.HOT_TOPIC_CLICK).dD("obj_locate", str));
    }

    public static String CB(String str) {
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
