package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class i {
    public static final String bzQ = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bzR = bzQ + "/.tieba_video_cache";
    public static final String yP = bzR + "/v2";
    public static final String bzS = yP + "/";
    public static final String bzT = yP + "/files";
    public static final String bzU = bzT + "/";
    public static final String bzV = bzS + "server_port";
    public static final int bzW = "?segment_postion=".length();
}
