package com.baidu.tieba.VideoCache;

import android.os.Environment;
/* loaded from: classes2.dex */
public class i {
    public static final String bbp = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String bbq = bbp + "/.tieba_video_cache";
    public static final String bbr = bbq + "/v2";
    public static final String bbs = bbr + "/";
    public static final String bbt = bbr + "/files";
    public static final String bbu = bbt + "/";
    public static final String bbv = bbs + "server_port";
    public static final int bbw = "?segment_postion=".length();
}
