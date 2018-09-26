package com.baidu.tieba.VideoCache;
/* loaded from: classes2.dex */
public class j {
    private static long mStartTime = 0;

    public static void aF(String str, String str2) {
        if (System.currentTimeMillis() - mStartTime > 5000) {
            mStartTime = System.currentTimeMillis();
        }
    }
}
