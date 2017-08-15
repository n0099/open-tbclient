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
    public static String aGo = "add_user_collect_emotoin";
    public static String aGp = "image_url";
    public static String aGq = "package_id";
    public static String aGr = "#(meme,setting)";
    public static String aGs = "#(meme,collect_";
    public static String aGt = "meme,collect_";

    /* loaded from: classes.dex */
    public static class a {
        public String pkgId;
        public String url;
    }

    public static String EB() {
        return "collect_" + (TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount());
    }

    public static String EC() {
        return Math.abs(EB().hashCode()) + "";
    }

    public static void gq(String str) {
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
