package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class i {
    public static final String brA = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String brB = brA + "/.tieba_video_cache";
    public static final String ya = brB + "/v2";
    public static final String brC = ya + "/";
    public static final String brD = ya + "/files";
    public static final String brE = brD + "/";
    public static final String brF = brC + "server_port";
    public static final int brG = "?segment_postion=".length();
}
