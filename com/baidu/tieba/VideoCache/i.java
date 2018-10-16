package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class i {
    public static final String bvI = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bvJ = bvI + "/.tieba_video_cache";
    public static final String yM = bvJ + "/v2";
    public static final String bvK = yM + "/";
    public static final String bvL = yM + "/files";
    public static final String bvM = bvL + "/";
    public static final String bvN = bvK + "server_port";
    public static final int bvO = "?segment_postion=".length();
}
