package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class r {
    private static String mThreadId;

    public static void gj(String str) {
        mThreadId = str;
    }

    public static String GT() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void GU() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
