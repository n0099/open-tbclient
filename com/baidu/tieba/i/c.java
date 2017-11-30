package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String eDg = File.separator;
        public static final String bbp = Environment.getExternalStorageDirectory() + eDg + "tieba";
        public static final String eDh = bbp + eDg + ".tieba_video_monitor";
        public static final String eDi = eDh + eDg + "v1";
        public static final String eDj = eDi + eDg;
        public static final String eDk = bbp + eDg + ".tieba_video_monitor_log";
        public static final String eDl = eDk + eDg + "v1";
        public static final String eDm = eDl + eDg;
    }
}
