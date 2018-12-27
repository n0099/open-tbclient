package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class v {
    private static String mThreadId;

    public static void iL(String str) {
        mThreadId = str;
    }

    public static String Qh() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void Qi() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
