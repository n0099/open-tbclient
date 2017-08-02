package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class s {
    private static String mThreadId;

    public static void gN(String str) {
        mThreadId = str;
    }

    public static String Hj() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void Hk() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
