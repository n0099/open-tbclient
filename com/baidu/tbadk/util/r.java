package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class r {
    private static String mThreadId;

    public static void gu(String str) {
        mThreadId = str;
    }

    public static String Gu() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void Gv() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
