package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String eEo = File.separator;
        public static final String bbu = Environment.getExternalStorageDirectory() + eEo + "tieba";
        public static final String eEv = bbu + eEo + ".tieba_post_monitor";
        public static final String eEw = eEv + eEo + "v1";
        public static final String eEx = eEw + eEo;
    }
}
