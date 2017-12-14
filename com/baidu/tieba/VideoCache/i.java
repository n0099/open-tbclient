package com.baidu.tieba.VideoCache;

import android.os.Environment;
/* loaded from: classes2.dex */
public class i {
    public static final String bbq = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String bbr = bbq + "/.tieba_video_cache";
    public static final String bbs = bbr + "/v2";
    public static final String bbt = bbs + "/";
    public static final String bbu = bbs + "/files";
    public static final String bbv = bbu + "/";
    public static final String bbw = bbt + "server_port";
    public static final int bbx = "?segment_postion=".length();
}
