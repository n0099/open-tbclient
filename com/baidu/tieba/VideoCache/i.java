package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class i {
    public static final String exE = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String exF = exE + "/.tieba_video_cache";
    public static final String HJ = exF + "/v2";
    public static final String exG = HJ + "/";
    public static final String exH = HJ + "/files";
    public static final String exI = exH + "/";
    public static final String exJ = exG + "server_port";
    public static final int exK = "?segment_postion=".length();
}
