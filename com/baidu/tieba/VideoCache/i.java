package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class i {
    public static final String bwt = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bwu = bwt + "/.tieba_video_cache";
    public static final String yP = bwu + "/v2";
    public static final String bwv = yP + "/";
    public static final String bww = yP + "/files";
    public static final String bwx = bww + "/";
    public static final String bwy = bwv + "server_port";
    public static final int bwz = "?segment_postion=".length();
}
