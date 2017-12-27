package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class t {
    private static String mThreadId;

    public static void gZ(String str) {
        mThreadId = str;
    }

    public static String OS() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void OT() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
