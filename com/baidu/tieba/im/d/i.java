package com.baidu.tieba.im.d;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.UtilHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class i {
    private static final Pattern a = Pattern.compile("(((ht|f)tp(s{0,1}))://)?([\\w-]+\\.)+[a-zA-Z_-]{2,}(/[\\w-./?%&+=#]*)?", 2);

    public static SpannableString a(Context context, String str) {
        int start;
        Matcher matcher = a.matcher(str);
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            String group = matcher.group();
            String group2 = matcher.group();
            if (!group2.endsWith(" ")) {
                group2 = group2 + " ";
            }
            int length = group2.length();
            spannableString.setSpan(new com.baidu.tbadk.widget.richText.h(context, 2, group), matcher.start(), (length + start) - 1, 33);
        }
        return spannableString;
    }

    public static void a(Context context, String str, boolean z) {
        String str2;
        String str3;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.startsWith(com.baidu.loginshare.e.f) || lowerCase.startsWith(com.baidu.loginshare.e.g) || lowerCase.startsWith("ftp://") || lowerCase.startsWith("mailto:")) {
                str2 = lowerCase;
                str3 = str;
            } else {
                str2 = com.baidu.loginshare.e.f + lowerCase;
                str3 = com.baidu.loginshare.e.f + str;
            }
            if (!z || a(str2)) {
                b(context, str2, str3);
            } else {
                b.a(context, new j(context, str2, str3), new k(), str);
            }
        }
    }

    public static void b(Context context, String str) {
        a(context, str, false);
    }

    public static boolean a(String str) {
        return str.startsWith("http://tieba.baidu.com/group/index?id=") || str.startsWith("http://tieba.baidu.com/p/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, String str, String str2) {
        if (str.startsWith("http://tieba.baidu.com/group/index?id=")) {
            int length = "http://tieba.baidu.com/group/index?id=".length() + str2.indexOf("http://tieba.baidu.com/group/index?id=");
            int lastIndexOf = str2.lastIndexOf(38);
            if (lastIndexOf == -1 || lastIndexOf < length) {
                lastIndexOf = str2.length();
            }
            long a2 = com.baidu.adp.lib.f.b.a(str2.substring(length, lastIndexOf), 0L);
            if (a2 <= 0) {
                return false;
            }
            GroupInfoActivity.a(context, a2, 0);
        } else if (str.startsWith("http://tieba.baidu.com/p/")) {
            String substring = str2.substring(str2.indexOf("http://tieba.baidu.com/p/") + "http://tieba.baidu.com/p/".length());
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            NewPbActivity.a(context, substring, (String) null, "allthread");
        } else {
            UtilHelper.c(context, str2);
        }
        return true;
    }
}
