package com.baidu.tieba.VideoCache;

import android.os.Environment;
/* loaded from: classes.dex */
public class j {
    public static final String aUP = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String aUQ = String.valueOf(aUP) + "/.tieba_video_cache";
    public static final String aUR = String.valueOf(aUQ) + "/v2";
    public static final String aUS = String.valueOf(aUR) + "/";
    public static final String aUT = String.valueOf(aUR) + "/files";
    public static final String aUU = String.valueOf(aUT) + "/";
    public static final String aUV = String.valueOf(aUS) + "server_port";
}
