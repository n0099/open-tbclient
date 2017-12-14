package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String eEk = File.separator;
        public static final String bbq = Environment.getExternalStorageDirectory() + eEk + "tieba";
        public static final String eEl = bbq + eEk + ".tieba_video_monitor";
        public static final String eEm = eEl + eEk + "v1";
        public static final String eEn = eEm + eEk;
        public static final String eEo = bbq + eEk + ".tieba_video_monitor_log";
        public static final String eEp = eEo + eEk + "v1";
        public static final String eEq = eEp + eEk;
    }
}
