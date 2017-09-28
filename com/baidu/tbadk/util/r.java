package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class r {
    private static String mThreadId;

    public static void gO(String str) {
        mThreadId = str;
    }

    public static String GU() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void GV() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
