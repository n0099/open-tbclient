package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fvK = File.separator;
        public static final String bRD = Environment.getExternalStorageDirectory() + fvK + "tieba";
        public static final String fvR = bRD + fvK + ".tieba_post_monitor";
        public static final String fvS = fvR + fvK + "v1";
        public static final String fvT = fvS + fvK;
    }
}
