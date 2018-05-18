package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class i {
    public static final String bbr = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bbs = bbr + "/.tieba_video_cache";
    public static final String pB = bbs + "/v2";
    public static final String bbt = pB + "/";
    public static final String bbu = pB + "/files";
    public static final String bbv = bbu + "/";
    public static final String bbw = bbt + "server_port";
    public static final int bbx = "?segment_postion=".length();
}
