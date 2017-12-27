package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fqn = File.separator;
        public static final String bPf = Environment.getExternalStorageDirectory() + fqn + "tieba";
        public static final String fqo = bPf + fqn + ".tieba_video_monitor";
        public static final String fqp = fqo + fqn + "v1";
        public static final String fqq = fqp + fqn;
        public static final String fqr = bPf + fqn + ".tieba_video_monitor_log";
        public static final String fqs = fqr + fqn + "v1";
        public static final String fqt = fqs + fqn;
    }
}
