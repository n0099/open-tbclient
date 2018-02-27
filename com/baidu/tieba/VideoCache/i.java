package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class i {
    public static final String bRq = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bRr = bRq + "/.tieba_video_cache";
    public static final String afd = bRr + "/v2";
    public static final String bRs = afd + "/";
    public static final String bRt = afd + "/files";
    public static final String bRu = bRt + "/";
    public static final String bRv = bRs + "server_port";
    public static final int bRw = "?segment_postion=".length();
}
