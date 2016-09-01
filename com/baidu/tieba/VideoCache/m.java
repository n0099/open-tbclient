package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class m {
    private static long mStartTime = 0;

    public static void log(String str, String str2) {
        if (System.currentTimeMillis() - mStartTime > TbConfig.NOTIFY_SOUND_INTERVAL) {
            mStartTime = System.currentTimeMillis();
        }
    }
}
