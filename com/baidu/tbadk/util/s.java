package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class s {
    private static String mThreadId;

    public static void gv(String str) {
        mThreadId = str;
    }

    public static String FK() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void FL() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
