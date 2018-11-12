package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class v {
    private static String mThreadId;

    public static void is(String str) {
        mThreadId = str;
    }

    public static String OZ() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void Pa() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
