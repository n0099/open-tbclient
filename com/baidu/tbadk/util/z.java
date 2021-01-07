package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class z {
    private static String mThreadId;

    public static void EJ(String str) {
        mThreadId = str;
    }

    public static String bJg() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void bJh() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
