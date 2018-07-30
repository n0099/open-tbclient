package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class i {
    public static final String blH = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String blI = blH + "/.tieba_video_cache";
    public static final String vG = blI + "/v2";
    public static final String blJ = vG + "/";
    public static final String blK = vG + "/files";
    public static final String blL = blK + "/";
    public static final String blM = blJ + "server_port";
    public static final int blN = "?segment_postion=".length();
}
