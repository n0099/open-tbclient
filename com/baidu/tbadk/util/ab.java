package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class ab {
    private static String mThreadId;

    public static void yT(String str) {
        mThreadId = str;
    }

    public static String bgN() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void bgO() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
