package com.baidu.tieba.i;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fvO = File.separator;
        public static final String bRt = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fvP = bRt + fvO + ".tieba_video_monitor";
        public static final String fvQ = fvP + fvO + "v1";
        public static final String fvR = fvQ + fvO;
        public static final String fvS = bRt + fvO + ".tieba_video_monitor_log";
        public static final String fvT = fvS + fvO + "v1";
        public static final String fvU = fvT + fvO;
    }
}
