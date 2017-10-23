package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class r {
    private static String mThreadId;

    public static void gN(String str) {
        mThreadId = str;
    }

    public static String GO() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void GP() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
