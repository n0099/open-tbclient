package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class ac {
    private static String mThreadId;

    public static void Dh(String str) {
        mThreadId = str;
    }

    public static String bwS() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void bwT() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
