package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fvO = File.separator;
        public static final String bRt = Environment.getExternalStorageDirectory() + fvO + "tieba";
        public static final String fvV = bRt + fvO + ".tieba_post_monitor";
        public static final String fvW = fvV + fvO + "v1";
        public static final String fvX = fvW + fvO;
    }
}
