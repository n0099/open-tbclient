package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class t {
    private static String mThreadId;

    public static void gY(String str) {
        mThreadId = str;
    }

    public static String Hs() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void Ht() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
