package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class u {
    private static String mThreadId;

    public static void hJ(String str) {
        mThreadId = str;
    }

    public static String LB() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void LC() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
