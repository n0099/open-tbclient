package com.baidu.tieba.i;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fsj = File.separator;
        public static final String bPv = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        public static final String fsk = bPv + fsj + ".tieba_video_monitor";
        public static final String fsl = fsk + fsj + "v1";
        public static final String fsm = fsl + fsj;
        public static final String fsn = bPv + fsj + ".tieba_video_monitor_log";
        public static final String fso = fsn + fsj + "v1";
        public static final String fsp = fso + fsj;
    }
}
