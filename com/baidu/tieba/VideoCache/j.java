package com.baidu.tieba.VideoCache;

import android.os.Environment;
/* loaded from: classes.dex */
public class j {
    public static final String aPN = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String aPO = String.valueOf(aPN) + "/.tieba_video_cache";
    public static final String aPP = String.valueOf(aPO) + "/v2";
    public static final String aPQ = String.valueOf(aPP) + "/";
    public static final String aPR = String.valueOf(aPP) + "/files";
    public static final String aPS = String.valueOf(aPR) + "/";
    public static final String aPT = String.valueOf(aPQ) + "server_port";
}
