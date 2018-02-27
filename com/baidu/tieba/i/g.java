package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fvy = File.separator;
        public static final String bRq = Environment.getExternalStorageDirectory() + fvy + "tieba";
        public static final String fvF = bRq + fvy + ".tieba_post_monitor";
        public static final String fvG = fvF + fvy + "v1";
        public static final String fvH = fvG + fvy;
    }
}
