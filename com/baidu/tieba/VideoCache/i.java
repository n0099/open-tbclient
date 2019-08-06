package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class i {
    public static final String cVD = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String cVE = cVD + "/.tieba_video_cache";
    public static final String wy = cVE + "/v2";
    public static final String cVF = wy + "/";
    public static final String cVG = wy + "/files";
    public static final String cVH = cVG + "/";
    public static final String cVI = cVF + "server_port";
    public static final int cVJ = "?segment_postion=".length();
}
