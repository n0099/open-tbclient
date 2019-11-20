package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class x {
    private static String mThreadId;

    public static void qr(String str) {
        mThreadId = str;
    }

    public static String axN() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void axO() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
