package com.baidu.tieba.face;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.imageManager.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class a {
    public static final Pattern djK = Pattern.compile("#\\([a-zA-Z0-9_~！\\u4E00-\\u9FA5]+\\)");
    public static final Pattern djL = Pattern.compile("#\\([^#\\)\\(]+\\)$");

    public static String kv(String str) {
        String replaceAll = str.replaceAll(d.bul, "meme,");
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

    public static int kw(String str) {
        int i;
        CustomResponsedMessage runTask;
        int i2 = 0;
        if (str == null || str.length() == 0) {
            return 0;
        }
        Matcher matcher = djK.matcher(str);
        while (true) {
            i = i2;
            if (!matcher.find()) {
                break;
            }
            String group = matcher.group();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.EMOTION_IS_VALID) != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_IS_VALID, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                i++;
            }
            i2 = i;
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(str);
        while (matcher2.find()) {
            String[] split = matcher2.group().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length == 5) {
                i++;
            }
        }
        Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(str);
        while (matcher3.find()) {
            String[] split2 = matcher3.group().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split2 != null && split2.length == 6) {
                i++;
            }
        }
        return i;
    }
}
