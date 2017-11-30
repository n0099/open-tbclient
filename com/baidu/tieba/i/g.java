package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String eDg = File.separator;
        public static final String bbp = Environment.getExternalStorageDirectory() + eDg + "tieba";
        public static final String eDn = bbp + eDg + ".tieba_post_monitor";
        public static final String eDo = eDn + eDg + "v1";
        public static final String eDp = eDo + eDg;
    }
}
