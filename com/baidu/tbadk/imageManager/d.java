package com.baidu.tbadk.imageManager;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static String aEX = "add_user_collect_emotoin";
    public static String aEY = "image_url";
    public static String aEZ = "package_id";
    public static String aFa = "#(meme,setting)";
    public static String aFb = "#(meme,collect_";
    public static String aFc = "meme,collect_";

    /* loaded from: classes.dex */
    public static class a {
        public String pkgId;
        public String url;
    }

    public static String Et() {
        return "collect_" + (TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount());
    }

    public static String Eu() {
        return Math.abs(Et().hashCode()) + "";
    }

    public static void gl(String str) {
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
                aj ajVar = new aj("c12223");
                ajVar.r("obj_param1", i2);
                TiebaStatic.log(ajVar);
            }
            if (i > 0) {
                aj ajVar2 = new aj("c12231");
                ajVar2.r("obj_param1", i);
                TiebaStatic.log(ajVar2);
            }
        }
    }
}
