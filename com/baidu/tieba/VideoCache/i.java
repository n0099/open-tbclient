package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class i {
    public static final String bzT = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bzU = bzT + "/.tieba_video_cache";
    public static final String yP = bzU + "/v2";
    public static final String bzV = yP + "/";
    public static final String bzW = yP + "/files";
    public static final String bzX = bzW + "/";
    public static final String bzY = bzV + "server_port";
    public static final int bzZ = "?segment_postion=".length();
}
