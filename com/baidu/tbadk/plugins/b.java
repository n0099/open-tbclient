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
import com.baidu.tbadk.data.l;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class b {
    public static String eWI = "#";
    public static String eWJ = "＃";
    private static final Pattern dQR = Pattern.compile("#([^#(]+)#", 2);

    public static boolean CU(String str) {
        return eWI.equals(str);
    }

    public static boolean jH(boolean z) {
        boolean appResponseToIntentClass;
        if (PluginPackageManager.pT().cx("com.baidu.tieba.pluginHotTopic")) {
            if (z) {
                appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
            } else {
                appResponseToIntentClass = TbadkCoreApplication.getInst().appResponseToIntentClass(HotSelectActivityConfig.class);
            }
            return appResponseToIntentClass;
        }
        return false;
    }

    public static boolean bvK() {
        return PluginPackageManager.pT().cD("com.baidu.tieba.pluginHotTopic");
    }

    public static boolean a(TbPageContext<?> tbPageContext, boolean z, boolean z2) {
        return false;
    }

    public static boolean k(TbPageContext<?> tbPageContext) {
        return a(tbPageContext, true, true);
    }

    public static SpannableString CV(String str) {
        if (StringUtils.isNull(str)) {
            return new SpannableString("");
        }
        Matcher matcher = dQR.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!CX(str.substring(start, end))) {
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
                Matcher matcher = dQR.matcher(obj);
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    if (!CX(obj.substring(start, end)) && ((imageSpanArr = (ImageSpan[]) spannable.getSpans(start, end, ImageSpan.class)) == null || imageSpanArr.length <= 0)) {
                        spannable.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_c)), start, end, 18);
                    }
                }
            }
        }
    }

    public static String CW(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.charAt(0) != '#' || str.charAt(str.length() - 1) != '#') {
            StringBuilder sb = new StringBuilder(str.length() + 2);
            sb.append(eWI).append(str).append(eWI);
            return sb.toString();
        }
        return str;
    }

    public static boolean CX(String str) {
        return str != null && str.startsWith(eWI) && str.endsWith(eWI) && "".equals(str.substring(1, str.length() + (-1)).trim());
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
        TiebaStatic.log(new aq(TbadkCoreStatisticKey.HOT_TOPIC_CLICK).dF("obj_locate", str));
    }

    public static String CY(String str) {
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
