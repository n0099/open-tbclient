package com.baidu.tbadk.imageManager;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static String ADD_USER_COLLECT_EMOTION_ACTION = "add_user_collect_emotoin";
    public static String IMAGE_URL = "image_url";
    public static String PACKAGE_ID = "package_id";
    public static String SETTING_SHARP_TEXT = "#(meme,setting)";
    public static String SHARP_TEXT_PREFIX = "#(meme,collect_";
    public static String SHARP_TEXT_PREFIX_SHORT = "meme,collect_";

    /* loaded from: classes.dex */
    public static class a {
        public String pkgId;
        public String url;
    }

    public static String getCollectGroupId() {
        return "collect_" + (TbadkCoreApplication.getCurrentAccount() == null ? "" : TbadkCoreApplication.getCurrentAccount());
    }

    public static String getSaveDir() {
        return Math.abs(getCollectGroupId().hashCode()) + "";
    }

    public static void statisticsNum(String str) {
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
                if (split2 != null && split2.length == 5 && split2[1] != null && !split2[1].startsWith("#\\(meme,collect_[a-zA-Z0-9_,]+\\)") && split2[1].contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
                    i++;
                }
            }
            if (i2 > 0) {
                an anVar = new an("c12223");
                anVar.Z("obj_param1", i2);
                TiebaStatic.log(anVar);
            }
            if (i > 0) {
                an anVar2 = new an(TbadkCoreStatisticKey.FACESHOP_USE_EMOTION);
                anVar2.Z("obj_param1", i);
                TiebaStatic.log(anVar2);
            }
        }
    }
}
