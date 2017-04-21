package com.baidu.tieba.VideoCache;

import android.os.Environment;
/* loaded from: classes.dex */
public class j {
    public static final String aUR = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String aUS = String.valueOf(aUR) + "/.tieba_video_cache";
    public static final String aUT = String.valueOf(aUS) + "/v2";
    public static final String aUU = String.valueOf(aUT) + "/";
    public static final String aUV = String.valueOf(aUT) + "/files";
    public static final String aUW = String.valueOf(aUV) + "/";
    public static final String aUX = String.valueOf(aUU) + "server_port";
}
