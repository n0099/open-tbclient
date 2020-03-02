package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class i {
    public static final String dXb = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String dXc = dXb + "/.tieba_video_cache";
    public static final String oC = dXc + "/v2";
    public static final String dXd = oC + "/";
    public static final String dXe = oC + "/files";
    public static final String dXf = dXe + "/";
    public static final String dXg = dXd + "server_port";
    public static final int dXh = "?segment_postion=".length();
}
