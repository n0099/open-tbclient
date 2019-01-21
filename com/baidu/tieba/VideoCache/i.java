package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class i {
    public static final String bAH = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bAI = bAH + "/.tieba_video_cache";
    public static final String yP = bAI + "/v2";
    public static final String bAJ = yP + "/";
    public static final String bAK = yP + "/files";
    public static final String bAL = bAK + "/";
    public static final String bAM = bAJ + "server_port";
    public static final int bAN = "?segment_postion=".length();
}
