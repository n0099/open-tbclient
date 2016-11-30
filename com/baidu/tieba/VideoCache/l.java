package com.baidu.tieba.VideoCache;

import android.os.Environment;
/* loaded from: classes.dex */
public class l {
    public static final String aQw = Environment.getExternalStorageDirectory() + "/tieba";
    public static final String aQx = String.valueOf(aQw) + "/.tieba_video_cache";
    public static final String aQy = String.valueOf(aQx) + "/v2";
    public static final String aQz = String.valueOf(aQy) + "/";
    public static final String aQA = String.valueOf(aQy) + "/files";
    public static final String aQB = String.valueOf(aQA) + "/";
    public static final String aQC = String.valueOf(aQz) + "server_port";
}
