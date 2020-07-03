package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class ab {
    private static String mThreadId;

    public static void zm(String str) {
        mThreadId = str;
    }

    public static String bjb() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void bjc() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
