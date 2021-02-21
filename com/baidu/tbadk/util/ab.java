package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class ab {
    private static String mThreadId;

    public static void DO(String str) {
        mThreadId = str;
    }

    public static String bFH() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void bFI() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
