package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class r {
    private static String mThreadId;

    public static void gC(String str) {
        mThreadId = str;
    }

    public static String Hg() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void Hh() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
