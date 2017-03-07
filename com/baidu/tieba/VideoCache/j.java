package com.baidu.tieba.VideoCache;

import android.os.Environment;
/* loaded from: classes.dex */
public class j {
    public static final String aUC = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String aUD = String.valueOf(aUC) + "/.tieba_video_cache";
    public static final String aUE = String.valueOf(aUD) + "/v2";
    public static final String aUF = String.valueOf(aUE) + "/";
    public static final String aUG = String.valueOf(aUE) + "/files";
    public static final String aUH = String.valueOf(aUG) + "/";
    public static final String aUI = String.valueOf(aUF) + "server_port";
}
