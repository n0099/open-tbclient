package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class s {
    private static String mThreadId;

    public static void gy(String str) {
        mThreadId = str;
    }

    public static String He() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void Hf() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
