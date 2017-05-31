package com.baidu.tieba.VideoCache;

import android.os.Environment;
/* loaded from: classes2.dex */
public class j {
    public static final String aSO = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String aSP = String.valueOf(aSO) + "/.tieba_video_cache";
    public static final String aSQ = String.valueOf(aSP) + "/v2";
    public static final String aSR = String.valueOf(aSQ) + "/";
    public static final String aSS = String.valueOf(aSQ) + "/files";
    public static final String aST = String.valueOf(aSS) + "/";
    public static final String aSU = String.valueOf(aSR) + "server_port";
}
