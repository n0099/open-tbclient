package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class w {
    private static String mThreadId;

    public static void jb(String str) {
        mThreadId = str;
    }

    public static String QC() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void QD() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
