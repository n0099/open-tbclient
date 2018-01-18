package com.baidu.tieba.VideoCache;

import android.os.Environment;
/* loaded from: classes2.dex */
public class i {
    public static final String bPm = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String bPn = bPm + "/.tieba_video_cache";
    public static final String bPo = bPn + "/v2";
    public static final String bPp = bPo + "/";
    public static final String bPq = bPo + "/files";
    public static final String bPr = bPq + "/";
    public static final String bPs = bPp + "server_port";
    public static final int bPt = "?segment_postion=".length();
}
