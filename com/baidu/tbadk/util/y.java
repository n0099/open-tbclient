package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class y {
    private static String mThreadId;

    public static void rm(String str) {
        mThreadId = str;
    }

    public static String awA() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void awB() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
