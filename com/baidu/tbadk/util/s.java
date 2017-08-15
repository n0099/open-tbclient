package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class s {
    private static String mThreadId;

    public static void gS(String str) {
        mThreadId = str;
    }

    public static String Hr() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void Hs() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
