package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class i {
    public static final String dSV = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String dSW = dSV + "/.tieba_video_cache";
    public static final String ow = dSW + "/v2";
    public static final String dSX = ow + "/";
    public static final String dSY = ow + "/files";
    public static final String dSZ = dSY + "/";
    public static final String dTa = dSX + "server_port";
    public static final int dTb = "?segment_postion=".length();
}
