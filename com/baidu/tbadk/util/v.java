package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class v {
    private static String mThreadId;

    public static void ir(String str) {
        mThreadId = str;
    }

    public static String OQ() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void OR() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
