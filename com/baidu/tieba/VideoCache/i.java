package com.baidu.tieba.VideoCache;

import android.os.Environment;
/* loaded from: classes2.dex */
public class i {
    public static final String bbu = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String bbv = bbu + "/.tieba_video_cache";
    public static final String bbw = bbv + "/v2";
    public static final String bbx = bbw + "/";
    public static final String bby = bbw + "/files";
    public static final String bbz = bby + "/";
    public static final String bbA = bbx + "server_port";
    public static final int bbB = "?segment_postion=".length();
}
