package com.baidu.tbadk.imageManager;

import android.text.TextUtils;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static String aYR = "add_user_collect_emotoin";
    public static String aYS = ARResourceKey.THUMBNAIL;
    public static String aYT = "package_id";
    public static String aYU = "#(meme,setting)";
    public static String aYV = "#(meme,collect_";
    public static String aYW = "meme,collect_";

    /* loaded from: classes.dex */
    public static class a {
        public String pkgId;
        public String url;
    }

    public static String Mu() {
        return "collect_" + (TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount());
    }

    public static String Mv() {
        return Math.abs(Mu().hashCode()) + "";
    }

    public static void hQ(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("#\\(meme,collect_[a-zA-Z0-9_,]+\\)").matcher(str);
            int i2 = 0;
            while (matcher.find()) {
                String[] split = matcher.group().split(",");
                if (split != null && split.length == 5 && split[1] != null && split[1].startsWith("#\\(meme,collect_[a-zA-Z0-9_,]+\\)")) {
                    i2++;
                }
            }
            Matcher matcher2 = Pattern.compile("#\\(meme,[a-zA-Z0-9_,]+\\)").matcher(str);
            while (matcher2.find()) {
                String[] split2 = matcher2.group().split(",");
                if (split2 != null && split2.length == 5 && split2[1] != null && !split2[1].startsWith("#\\(meme,collect_[a-zA-Z0-9_,]+\\)") && split2[1].contains(BaseRequestAction.SPLITE)) {
                    i++;
                }
            }
            if (i2 > 0) {
                am amVar = new am("c12223");
                amVar.x("obj_param1", i2);
                TiebaStatic.log(amVar);
            }
            if (i > 0) {
                am amVar2 = new am("c12231");
                amVar2.x("obj_param1", i);
                TiebaStatic.log(amVar2);
            }
        }
    }
}
