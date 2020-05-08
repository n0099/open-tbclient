package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class aa {
    private static String mThreadId;

    public static void xn(String str) {
        mThreadId = str;
    }

    public static String baC() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void baD() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
