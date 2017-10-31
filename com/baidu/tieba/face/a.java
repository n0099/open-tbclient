package com.baidu.tieba.face;

import com.baidu.tbadk.imageManager.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class a {
    public static final Pattern cme = Pattern.compile("#\\([a-zA-Z0-9_~！\\u4E00-\\u9FA5]+\\)");
    public static final Pattern cmf = Pattern.compile("#\\([^#\\)\\(]+\\)$");

    public static String ki(String str) {
        String replaceAll = str.replaceAll(d.aFB, "meme,");
        Matcher matcher = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(replaceAll);
        StringBuilder sb = new StringBuilder(replaceAll);
        int i = 0;
        while (matcher.find()) {
            String[] split = matcher.group().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length == 6) {
                StringBuilder sb2 = new StringBuilder();
                int start = matcher.start() - i;
                int end = matcher.end() - i;
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (i2 != 1) {
                        sb2.append(split[i2]);
                        if (i2 < split.length - 1) {
                            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                }
                i += (end - start) - sb2.toString().length();
                if (start >= 0 && end <= sb.length()) {
                    sb.replace(start, end, sb2.toString());
                }
            }
        }
        return sb.toString();
    }
}
