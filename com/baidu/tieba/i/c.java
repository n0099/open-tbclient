package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String frO = File.separator;
        public static final String bPm = Environment.getExternalStorageDirectory() + frO + "tieba";
        public static final String frP = bPm + frO + ".tieba_video_monitor";
        public static final String frQ = frP + frO + "v1";
        public static final String frR = frQ + frO;
        public static final String frS = bPm + frO + ".tieba_video_monitor_log";
        public static final String frT = frS + frO + "v1";
        public static final String frU = frT + frO;
    }
}
