package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class i {
    public static final String bjC = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bjD = bjC + "/.tieba_video_cache";
    public static final String vQ = bjD + "/v2";
    public static final String bjE = vQ + "/";
    public static final String bjF = vQ + "/files";
    public static final String bjG = bjF + "/";
    public static final String bjH = bjE + "server_port";
    public static final int bjI = "?segment_postion=".length();
}
