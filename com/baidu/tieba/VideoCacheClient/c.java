package com.baidu.tieba.VideoCacheClient;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class c {
    public static final String dSM = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String dSN = dSM + "/.tieba_video_cache";
    public static final String oB = dSN + "/v2";
    public static final String dSO = oB + "/";
    public static final String dSP = oB + "/files";
    public static final String dSQ = dSP + "/";
    public static final String dSR = dSO + "server_port";
}
