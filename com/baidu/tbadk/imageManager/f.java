package com.baidu.tbadk.imageManager;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class f {
    public static String aDR = "add_user_collect_emotoin";
    public static String aDS = "image_url";
    public static String aDT = "package_id";
    public static String aDU = "#(meme,setting)";
    public static String aDV = "#(meme,collect_";
    public static String aDW = "meme,collect_";

    /* loaded from: classes.dex */
    public static class a {
        public String aDX;
        public String url;
    }

    public static String Ee() {
        return "collect_" + (TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount());
    }

    public static String Ef() {
        return new StringBuilder(String.valueOf(Math.abs(Ee().hashCode()))).toString();
    }

    public static void gf(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(str);
            int i2 = 0;
            while (matcher.find()) {
                String[] split = matcher.group().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5) {
                    if (split[1].contains("_")) {
                        i++;
                    } else {
                        i2++;
                    }
                }
            }
            if (i2 > 0) {
                au auVar = new au("c12223");
                auVar.r("obj_param1", i2);
                TiebaStatic.log(auVar);
            }
            if (i > 0) {
                au auVar2 = new au("c12231");
                auVar2.r("obj_param1", i);
                TiebaStatic.log(auVar2);
            }
        }
    }
}
