package com.baidu.tieba.i;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fvK = File.separator;
        public static final String bRD = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fvL = bRD + fvK + ".tieba_video_monitor";
        public static final String fvM = fvL + fvK + "v1";
        public static final String fvN = fvM + fvK;
        public static final String fvO = bRD + fvK + ".tieba_video_monitor_log";
        public static final String fvP = fvO + fvK + "v1";
        public static final String fvQ = fvP + fvK;
    }
}
