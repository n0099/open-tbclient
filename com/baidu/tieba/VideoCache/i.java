package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class i {
    public static final String dXa = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String dXb = dXa + "/.tieba_video_cache";
    public static final String oC = dXb + "/v2";
    public static final String dXc = oC + "/";
    public static final String dXd = oC + "/files";
    public static final String dXe = dXd + "/";
    public static final String dXf = dXc + "server_port";
    public static final int dXg = "?segment_postion=".length();
}
