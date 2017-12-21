package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String eEo = File.separator;
        public static final String bbu = Environment.getExternalStorageDirectory() + eEo + "tieba";
        public static final String eEp = bbu + eEo + ".tieba_video_monitor";
        public static final String eEq = eEp + eEo + "v1";
        public static final String eEr = eEq + eEo;
        public static final String eEs = bbu + eEo + ".tieba_video_monitor_log";
        public static final String eEt = eEs + eEo + "v1";
        public static final String eEu = eEt + eEo;
    }
}
