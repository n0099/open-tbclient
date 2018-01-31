package com.baidu.tieba.VideoCacheClient;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class c {
    public static final String bPv = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String bPw = bPv + "/.tieba_video_cache";
    public static final String afl = bPw + "/v2";
    public static final String bPx = afl + "/";
    public static final String bPy = afl + "/files";
    public static final String bPz = bPy + "/";
    public static final String bPA = bPx + "server_port";
}
