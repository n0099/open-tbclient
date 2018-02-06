package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class i {
    public static final String bRD = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bRE = bRD + "/.tieba_video_cache";
    public static final String afj = bRE + "/v2";
    public static final String bRF = afj + "/";
    public static final String bRG = afj + "/files";
    public static final String bRH = bRG + "/";
    public static final String bRI = bRF + "server_port";
    public static final int bRJ = "?segment_postion=".length();
}
