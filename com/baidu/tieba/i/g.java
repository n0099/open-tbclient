package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String frO = File.separator;
        public static final String bPm = Environment.getExternalStorageDirectory() + frO + "tieba";
        public static final String frV = bPm + frO + ".tieba_post_monitor";
        public static final String frW = frV + frO + "v1";
        public static final String frX = frW + frO;
    }
}
