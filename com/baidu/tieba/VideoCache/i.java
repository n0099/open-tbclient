package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class i {
    public static final String cLN = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String cLO = cLN + "/.tieba_video_cache";
    public static final String yL = cLO + "/v2";
    public static final String cLP = yL + "/";
    public static final String cLQ = yL + "/files";
    public static final String cLR = cLQ + "/";
    public static final String cLS = cLP + "server_port";
    public static final int cLT = "?segment_postion=".length();
}
