package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class aa {
    private static String mThreadId;

    public static void vW(String str) {
        mThreadId = str;
    }

    public static String aSq() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void aSr() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
