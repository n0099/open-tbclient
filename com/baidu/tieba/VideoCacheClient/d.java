package com.baidu.tieba.VideoCacheClient;

import android.os.Environment;
/* loaded from: classes.dex */
public class d {
    public static final String aNg = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String aNh = String.valueOf(aNg) + "/.tieba_video_cache";
    public static final String aNi = String.valueOf(aNh) + "/v2";
    public static final String aNj = String.valueOf(aNi) + "/";
    public static final String aNk = String.valueOf(aNi) + "/files";
    public static final String aNl = String.valueOf(aNk) + "/";
    public static final String aNm = String.valueOf(aNj) + "server_port";
}
