package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class aa {
    private static String mThreadId;

    public static void vY(String str) {
        mThreadId = str;
    }

    public static String aSv() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void aSw() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
