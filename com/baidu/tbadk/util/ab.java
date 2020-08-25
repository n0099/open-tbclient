package com.baidu.tbadk.util;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes2.dex */
public class ab {
    private static String mThreadId;

    public static void CK(String str) {
        mThreadId = str;
    }

    public static String bvI() {
        if (StringUtils.isNull(mThreadId)) {
            return null;
        }
        return mThreadId;
    }

    public static void bvJ() {
        if (mThreadId != null) {
            mThreadId = null;
        }
    }
}
