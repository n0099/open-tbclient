package com.baidu.tieba.VideoCache;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class i {
    public static final String bRt = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bRu = bRt + "/.tieba_video_cache";
    public static final String afd = bRu + "/v2";
    public static final String bRv = afd + "/";
    public static final String bRw = afd + "/files";
    public static final String bRx = bRw + "/";
    public static final String bRy = bRv + "server_port";
    public static final int bRz = "?segment_postion=".length();
}
