package com.baidu.tieba.VideoCache;

import android.os.Environment;
/* loaded from: classes.dex */
public class j {
    public static final String aOQ = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String aOR = String.valueOf(aOQ) + "/.tieba_video_cache";
    public static final String aOS = String.valueOf(aOR) + "/v2";
    public static final String aOT = String.valueOf(aOS) + "/";
    public static final String aOU = String.valueOf(aOS) + "/files";
    public static final String aOV = String.valueOf(aOU) + "/";
    public static final String aOW = String.valueOf(aOT) + "server_port";
}
