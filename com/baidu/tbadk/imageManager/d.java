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
    public static String bdc = "add_user_collect_emotoin";
    public static String bdd = ARResourceKey.THUMBNAIL;
    public static String bde = "package_id";
    public static String bdf = "#(meme,setting)";
    public static String bdg = "#(meme,collect_";
    public static String bdh = "meme,collect_";

    /* loaded from: classes.dex */
    public static class a {
        public String pkgId;
        public String url;
    }

    public static String NQ() {
        return "collect_" + (TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount());
    }

    public static String NR() {
        return Math.abs(NQ().hashCode()) + "";
    }

    public static void ix(String str) {
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
                amVar.y("obj_param1", i2);
                TiebaStatic.log(amVar);
            }
            if (i > 0) {
                am amVar2 = new am("c12231");
                amVar2.y("obj_param1", i);
                TiebaStatic.log(amVar2);
            }
        }
    }
}
