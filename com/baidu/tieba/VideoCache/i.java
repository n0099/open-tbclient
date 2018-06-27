package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class i {
    public static final String blb = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String blc = blb + "/.tieba_video_cache";
    public static final String vO = blc + "/v2";
    public static final String bld = vO + "/";
    public static final String ble = vO + "/files";
    public static final String blf = ble + "/";
    public static final String blg = bld + "server_port";
    public static final int blh = "?segment_postion=".length();
}
