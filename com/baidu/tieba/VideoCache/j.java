package com.baidu.tieba.VideoCache;
/* loaded from: classes9.dex */
public class j {
    private static long mStartTime = 0;

    public static void D(String str, String str2) {
        if (System.currentTimeMillis() - mStartTime > 5000) {
            mStartTime = System.currentTimeMillis();
        }
    }
}
