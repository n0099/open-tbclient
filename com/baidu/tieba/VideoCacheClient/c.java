package com.baidu.tieba.VideoCacheClient;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes9.dex */
public class c {
    public static final String eMg = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
    public static final String eMh = eMg + "/.tieba_video_cache";
    public static final String HV = eMh + "/v2";
    public static final String eMi = HV + "/";
    public static final String eMj = HV + "/files";
    public static final String eMk = eMj + "/";
    public static final String eMl = eMi + "server_port";
}
