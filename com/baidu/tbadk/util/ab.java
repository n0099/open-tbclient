package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class ab {
    private static String mThreadId;

    public static void Au(String str) {
        mThreadId = str;
    }

    public static String bmV() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void bmW() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
