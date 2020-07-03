package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class i {
    public static final String eWD = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String eWE = eWD + "/.tieba_video_cache";
    public static final String Iv = eWE + "/v2";
    public static final String eWF = Iv + "/";
    public static final String eWG = Iv + "/files";
    public static final String eWH = eWG + "/";
    public static final String eWI = eWF + "server_port";
    public static final int eWJ = "?segment_postion=".length();
}
