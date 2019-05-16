package com.baidu.tbadk.imageManager;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static String cuN = "add_user_collect_emotoin";
    public static String cuO = "image_url";
    public static String cuP = "package_id";
    public static String cuQ = "#(meme,setting)";
    public static String cuR = "#(meme,collect_";
    public static String cuS = "meme,collect_";

    /* loaded from: classes.dex */
    public static class a {
        public String pkgId;
        public String url;
    }

    public static String ast() {
        return "collect_" + (TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount());
    }

    public static String asu() {
        return Math.abs(ast().hashCode()) + "";
    }

    public static void qs(String str) {
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
                am amVar = new am("c12223");
                amVar.P("obj_param1", i2);
                TiebaStatic.log(amVar);
            }
            if (i > 0) {
                am amVar2 = new am("c12231");
                amVar2.P("obj_param1", i);
                TiebaStatic.log(amVar2);
            }
        }
    }
}
