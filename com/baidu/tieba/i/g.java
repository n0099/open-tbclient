package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String eEk = File.separator;
        public static final String bbq = Environment.getExternalStorageDirectory() + eEk + "tieba";
        public static final String eEr = bbq + eEk + ".tieba_post_monitor";
        public static final String eEs = eEr + eEk + "v1";
        public static final String eEt = eEs + eEk;
    }
}
