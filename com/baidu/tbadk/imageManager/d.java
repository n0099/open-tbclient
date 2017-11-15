package com.baidu.tbadk.imageManager;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static String aFE = "add_user_collect_emotoin";
    public static String aFF = "image_url";
    public static String aFG = "package_id";
    public static String aFH = "#(meme,setting)";
    public static String aFI = "#(meme,collect_";
    public static String aFJ = "meme,collect_";

    /* loaded from: classes.dex */
    public static class a {
        public String pkgId;
        public String url;
    }

    public static String Ex() {
        return "collect_" + (TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount());
    }

    public static String Ey() {
        return Math.abs(Ex().hashCode()) + "";
    }

    public static void gq(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("#\\(meme,collect_[a-zA-Z0-9_,]+\\)").matcher(str);
            int i2 = 0;
            while (matcher.find()) {
                String[] split = matcher.group().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && split[1] != null && split[1].startsWith("#\\(meme,collect_[a-zA-Z0-9_,]+\\)")) {
                    i2++;
                }
            }
            Matcher matcher2 = Pattern.compile("#\\(meme,[a-zA-Z0-9_,]+\\)").matcher(str);
            while (matcher2.find()) {
                String[] split2 = matcher2.group().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split2 != null && split2.length == 5 && split2[1] != null && !split2[1].startsWith("#\\(meme,collect_[a-zA-Z0-9_,]+\\)") && split2[1].contains("_")) {
                    i++;
                }
            }
            if (i2 > 0) {
                ak akVar = new ak("c12223");
                akVar.r("obj_param1", i2);
                TiebaStatic.log(akVar);
            }
            if (i > 0) {
                ak akVar2 = new ak("c12231");
                akVar2.r("obj_param1", i);
                TiebaStatic.log(akVar2);
            }
        }
    }
}
