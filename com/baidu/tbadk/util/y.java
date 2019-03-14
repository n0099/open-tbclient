package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class y {
    private static String mThreadId;

    public static void pL(String str) {
        mThreadId = str;
    }

    public static String aqn() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void aqo() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
