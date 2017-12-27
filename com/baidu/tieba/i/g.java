package com.baidu.tieba.i;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        public static final String fqn = File.separator;
        public static final String bPf = Environment.getExternalStorageDirectory() + fqn + "tieba";
        public static final String fqu = bPf + fqn + ".tieba_post_monitor";
        public static final String fqv = fqu + fqn + "v1";
        public static final String fqw = fqv + fqn;
    }
}
