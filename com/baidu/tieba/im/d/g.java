package com.baidu.tieba.im.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class g {
    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("tieba.baidu.com/group/index?id=")) {
            int length = "tieba.baidu.com/group/index?id=".length() + lowerCase.indexOf("tieba.baidu.com/group/index?id=");
            int lastIndexOf = lowerCase.lastIndexOf(38);
            if (lastIndexOf == -1) {
                lastIndexOf = lowerCase.length();
            }
            String substring = lowerCase.substring(length, lastIndexOf);
            if (TextUtils.isEmpty(substring)) {
                return false;
            }
            try {
                GroupInfoActivity.a(context, Long.parseLong(substring), 0);
            } catch (Exception e) {
                com.baidu.adp.lib.h.d.a("transform error " + e.getMessage());
                return false;
            }
        } else if (lowerCase.contains("tieba.baidu.com/p/")) {
            String substring2 = lowerCase.substring(lowerCase.indexOf("tieba.baidu.com/p/") + "tieba.baidu.com/p/".length());
            if (TextUtils.isEmpty(substring2)) {
                return false;
            }
            NewPbActivity.a(context, substring2, null, "allthread");
        } else {
            UtilHelper.c(context, lowerCase);
        }
        return true;
    }
}
