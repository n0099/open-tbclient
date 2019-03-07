package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class j {
    private static long mStartTime = 0;

    public static void as(String str, String str2) {
        if (System.currentTimeMillis() - mStartTime > TbConfig.NOTIFY_SOUND_INTERVAL) {
            mStartTime = System.currentTimeMillis();
        }
    }
}
