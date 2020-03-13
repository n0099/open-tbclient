package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class i {
    public static final String dXo = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String dXp = dXo + "/.tieba_video_cache";
    public static final String oC = dXp + "/v2";
    public static final String dXq = oC + "/";
    public static final String dXr = oC + "/files";
    public static final String dXs = dXr + "/";
    public static final String dXt = dXq + "server_port";
    public static final int dXu = "?segment_postion=".length();
}
