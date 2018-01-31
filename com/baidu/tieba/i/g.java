package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fsj = File.separator;
        public static final String bPv = Environment.getExternalStorageDirectory() + fsj + "tieba";
        public static final String fsq = bPv + fsj + ".tieba_post_monitor";
        public static final String fsr = fsq + fsj + "v1";
        public static final String fss = fsr + fsj;
    }
}
