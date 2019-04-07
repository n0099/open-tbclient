package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class i {
    public static final String cLM = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String cLN = cLM + "/.tieba_video_cache";
    public static final String yL = cLN + "/v2";
    public static final String cLO = yL + "/";
    public static final String cLP = yL + "/files";
    public static final String cLQ = cLP + "/";
    public static final String cLR = cLO + "server_port";
    public static final int cLS = "?segment_postion=".length();
}
