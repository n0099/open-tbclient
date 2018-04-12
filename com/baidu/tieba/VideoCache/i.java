package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class i {
    public static final String bbq = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bbr = bbq + "/.tieba_video_cache";
    public static final String pC = bbr + "/v2";
    public static final String bbs = pC + "/";
    public static final String bbt = pC + "/files";
    public static final String bbu = bbt + "/";
    public static final String bbv = bbs + "server_port";
    public static final int bbw = "?segment_postion=".length();
}
