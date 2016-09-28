package com.baidu.tieba.VideoCacheClient;

import android.os.Environment;
/* loaded from: classes.dex */
public class d {
    public static final String aOq = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String aOr = String.valueOf(aOq) + "/.tieba_video_cache";
    public static final String aOs = String.valueOf(aOr) + "/v2";
    public static final String aOt = String.valueOf(aOs) + "/";
    public static final String aOu = String.valueOf(aOs) + "/files";
    public static final String aOv = String.valueOf(aOu) + "/";
    public static final String aOw = String.valueOf(aOt) + "server_port";
}
