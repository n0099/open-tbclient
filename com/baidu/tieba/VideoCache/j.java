package com.baidu.tieba.VideoCache;

import android.os.Environment;
/* loaded from: classes2.dex */
public class j {
    public static final String aVm = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String aVn = String.valueOf(aVm) + "/.tieba_video_cache";
    public static final String aVo = String.valueOf(aVn) + "/v2";
    public static final String aVp = String.valueOf(aVo) + "/";
    public static final String aVq = String.valueOf(aVo) + "/files";
    public static final String aVr = String.valueOf(aVq) + "/";
    public static final String aVs = String.valueOf(aVp) + "server_port";
}
