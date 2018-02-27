package com.baidu.tieba.i;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fvy = File.separator;
        public static final String bRq = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fvz = bRq + fvy + ".tieba_video_monitor";
        public static final String fvA = fvz + fvy + "v1";
        public static final String fvB = fvA + fvy;
        public static final String fvC = bRq + fvy + ".tieba_video_monitor_log";
        public static final String fvD = fvC + fvy + "v1";
        public static final String fvE = fvD + fvy;
    }
}
